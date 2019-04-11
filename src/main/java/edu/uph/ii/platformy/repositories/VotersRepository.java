package edu.uph.ii.platformy.repositories;

import edu.uph.ii.platformy.models.Voters;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface VotersRepository extends JpaRepository<Voters, Long>, JpaSpecificationExecutor<Voters> {
    Voters findByPesel(String pesel);
    Voters findByIdnumber(String idnumber);
    Voters findByName(String name);
    Voters findBySurename(String surename);
    Voters findByIsvotets(boolean isvotets);
    //nazwa metody jest jednocześnie zapytaniem
    Page<Voters> findByNameContaining(String phrase, Pageable pageable);


    //nad klasą Voters znajduje się definicja zapytania (@NamedQuery) powiązana z tą metodą
    Page<Voters> findAllVotersUsingNamedQuery(String phrase, Pageable pageable);

    @Query("SELECT v FROM Voters v WHERE " +
            "(" +
            ":phrase is null OR :phrase = '' OR "+
            "upper(v.name) LIKE upper(:phrase) OR " +
            "upper(v.surename) LIKE upper(:phrase) " +

            ") " +
            "AND " +
            "(:min is null OR :min <= v.pesel) " +
            "AND (:max is null OR :max >= v.pesel)")
    Page<Voters> findAllVotersUsingFilter(@Param("phrase") String p, Pageable pageable);

}