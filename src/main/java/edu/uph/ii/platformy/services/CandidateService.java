package edu.uph.ii.platformy.services;

import edu.uph.ii.platformy.controllers.commands.CandidateFilter;
import edu.uph.ii.platformy.models.Candidate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CandidateService {


    Page<Candidate> getAllCandidates(CandidateFilter filter, Pageable pageable);

    Candidate getCandidate(Long id);

    void deleteCandidate(Long id);

    void saveCandidate(Candidate candidate);

    void deleteAll();
}
