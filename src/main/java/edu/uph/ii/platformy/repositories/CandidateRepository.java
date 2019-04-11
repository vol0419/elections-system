package edu.uph.ii.platformy.repositories;

import edu.uph.ii.platformy.models.Candidate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CandidateRepository extends JpaRepository<Candidate, Long>, JpaSpecificationExecutor<Candidate> {

    //nazwa metody jest jednocześnie zapytaniem
    Page<Candidate> findByImieContaining(String phrase, Pageable pageable);
    

    //nad klasą Candidate znajduje się definicja zapytania (@NamedQuery) powiązana z tą metodą
    Page<Candidate> findAllCandidatesUsingNamedQuery(String phrase, Pageable pageable);

    @Query("SELECT v FROM Candidate v WHERE " +
            "(" +
            ":phrase is null OR :phrase = '' OR "+
            "upper(v.imie) LIKE upper(:phrase) OR " +
            "upper(v.nazwisko) LIKE upper(:phrase) OR " +
            "upper(v.partia) LIKE upper(:phrase)" +
            ") ")
    Page<Candidate> findAllCandidatesUsingFilter(@Param("phrase") String p, Pageable pageable);

    @Query("DELETE FROM Candidate e")
    void deleteTheTable();

}