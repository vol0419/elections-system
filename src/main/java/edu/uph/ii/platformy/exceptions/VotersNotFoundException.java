package edu.uph.ii.platformy.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "No such man")
public class VotersNotFoundException extends RuntimeException{

    public VotersNotFoundException(){
        super(String.format("Osoba nie istnieje"));
    }

    public VotersNotFoundException(Long id){
        super(String.format("Osoba o id %d nie istnieje", id));
    }
}
