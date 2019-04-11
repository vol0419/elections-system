package edu.uph.ii.platformy.models;

import edu.uph.ii.platformy.validators.annotations.InvalidValues;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "candidates")
@NamedQuery(name = "Candidate.findAllCandidatesUsingNamedQuery",
        query = "SELECT v FROM Candidate v WHERE upper(v.imie) LIKE upper(:phrase) or upper(v.nazwisko) LIKE upper(:phrase) or upper(v.partia) LIKE upper(:phrase)")
@Getter @Setter
@AllArgsConstructor
public class Candidate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank
    @Length(min = 2, max = 30)
    private String imie;

    @NotBlank
    @Size(min = 2, max = 50)
    private String nazwisko;

    @NotBlank
    @Size(min = 2, max = 50)
    private String miasto;

    @NotBlank
    @Size(min = 2, max = 50)
    private String partia;

    private int wynik;

    @Column(name="created_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    public Candidate() {
        this.createdDate = new Date();
    }

    public Candidate(String imie, String nazwisko, String miasto, String partia) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.miasto = miasto;
        this.partia = partia;
        wynik = 0;
    }
}
