package edu.uph.ii.platformy.services;

import edu.uph.ii.platformy.controllers.commands.CandidateFilter;

import edu.uph.ii.platformy.models.Voters;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface VotersService {





    Page<Voters> getAllVoters(CandidateFilter  filter, Pageable pageable);

    Voters getVoters(Long id);

    void deleteVoters(Long id);

    void saveVoters(Voters voters);
    void deleteAll();
}
