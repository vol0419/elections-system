package edu.uph.ii.platformy.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "No items found")
public class CandidateNotFoundException extends RuntimeException{

    public CandidateNotFoundException(){
        super(String.format("Wycieczka nie istnieje"));
    }

    public CandidateNotFoundException(Long id){
        super(String.format("Wycieczka o id %d nie istnieje", id));
    }
}
