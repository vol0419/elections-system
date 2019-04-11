package edu.uph.ii.platformy.services;

import edu.uph.ii.platformy.controllers.commands.CandidateFilter;
import edu.uph.ii.platformy.exceptions.VotersNotFoundException;
import edu.uph.ii.platformy.models.Voters;
import edu.uph.ii.platformy.repositories.VotersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class VotersServiceImpl implements VotersService {






    @Autowired
    private VotersRepository votersRepository;





    @Override
    public Page<Voters> getAllVoters(CandidateFilter search, Pageable pageable) {
        Page page;
        if(search.isEmpty()){
            page = votersRepository.findAll(pageable);
        }else{
            page = votersRepository.findAllVotersUsingFilter(search.getPhraseLIKE(),  pageable);
        }

        return page;

    }

    @Transactional
    @Override
    public Voters getVoters(Long id) {
        Optional<Voters> optionalVoters = votersRepository.findById(id);
        Voters voters = optionalVoters.orElseThrow(()->new VotersNotFoundException(id));
           return voters;
    }

    @Override
    public void deleteVoters(Long id) {
    // w przypadku usuwania obsługa wyjątku VotersNotFoundException nie jest niezbędna dla bezpieczeństwa systemu
        if(votersRepository.existsById(id) == true){
            votersRepository.deleteById(id);
        }else{
            throw new VotersNotFoundException(id);
        }
    }

    @Override
    public void saveVoters(Voters voters) {
        votersRepository.save(voters);
    }

    @Override
    public void deleteAll() {
        votersRepository.deleteAll();
    }
}
