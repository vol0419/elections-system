package edu.uph.ii.platformy.services;

import edu.uph.ii.platformy.controllers.commands.CandidateFilter;
import edu.uph.ii.platformy.exceptions.CandidateNotFoundException;
import edu.uph.ii.platformy.models.Candidate;
import edu.uph.ii.platformy.repositories.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class CandidateServiceImpl implements CandidateService {


    @Autowired
    private CandidateRepository candidateRepository;

    @Override
    public Page<Candidate> getAllCandidates(CandidateFilter search, Pageable pageable) {
        Page page;
        if(search.isEmpty()){
            page = candidateRepository.findAll(pageable);
        }else{
            page = candidateRepository.findAllCandidatesUsingFilter(search.getPhraseLIKE(), pageable);
        }

        return page;

    }

    @Transactional
    @Override
    public Candidate getCandidate(Long id) {
        Optional<Candidate> optionalCandidate = candidateRepository.findById(id);
        Candidate candidate = optionalCandidate.orElseThrow(()->new CandidateNotFoundException(id));
        return candidate;
    }

    @Override
    public void deleteCandidate(Long id) {
    // w przypadku usuwania obsługa wyjątku CandidateNotFoundException nie jest niezbędna dla bezpieczeństwa systemu
        if(candidateRepository.existsById(id) == true){
            candidateRepository.deleteById(id);
        }else{
            throw new CandidateNotFoundException(id);
        }
    }

    @Override
    public void saveCandidate(Candidate candidate) {
        candidateRepository.save(candidate);
    }

    @Override
    public void deleteAll() {
        candidateRepository.deleteAll();
    }
}
