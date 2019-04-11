package edu.uph.ii.platformy.models;

import edu.uph.ii.platformy.validators.annotations.InvalidValues;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@Entity
@Table(name = "voters")
@NamedQuery(name = "Voters.findAllVotersUsingNamedQuery",
        query = "SELECT v FROM Voters v WHERE upper(v.name) LIKE upper(:phrase) or upper(v.surename) LIKE upper(:phrase)  ")
@Getter @Setter
@AllArgsConstructor
public class Voters {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank
    @Length(min = 2, max = 30)// lub @Size(min = 2, max = 30)
    @InvalidValues(ignoreCase = true, values = {"XXX", "YYY"})
    public String name;

    @NotBlank
    @Size(min = 2, max = 50)
    public String surename;


    @NotBlank
    @Size(min = 11, max = 11)
    public String pesel;

    @NotBlank
    @Size(min = 9, max = 9)

    public String idnumber;



    public boolean isvotets  ;






    public Voters() {


    }

    public Voters(String name, String surename, String pesel, String idnumber,boolean isvotets ) {
        this.name = name;
        this.surename = surename;
        this.pesel = pesel;
        this.isvotets = isvotets;
        this.idnumber = idnumber;

    }
}
