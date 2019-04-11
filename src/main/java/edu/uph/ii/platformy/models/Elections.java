package edu.uph.ii.platformy.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Past;
import java.util.Date;


@Getter @Setter
@AllArgsConstructor
public class Elections {


    private boolean isActive=false;

    @Past
    private Date date;





    public Elections()
    {
    date= new Date();

    }

    public void setisActive(boolean x)
    {
        this.isActive=x;

    }

    public boolean getisActive()
    {
        return this.isActive;
    }

}
