package edu.uph.ii.platformy.controllers;


import edu.uph.ii.platformy.models.Elections;
import edu.uph.ii.platformy.repositories.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@SessionAttributes("election")

@Controller
public class ElectionController {

   static Elections elect = new Elections();

    @Autowired
    private CandidateRepository candidateRepository;

    @Secured("ROLE_ADMIN")
    @GetMapping(value="/electionstart.html")
    public String GetElectionForm(Model model)
    {

        if (candidateRepository.count()>2)
        {
            model.addAttribute("election",elect);
            return "electionForm";



        } else
        {
            return "electionError";



        }

    }

    @Secured("ROLE_ADMIN")
    @RequestMapping(value="/electionstart.html", method= RequestMethod.POST)
    public String Successelection(Model model)
    {
        elect.setisActive(true);
        model.addAttribute("elections",elect);
        return "home";

    }

    @Secured("ROLE_ADMIN")
    @GetMapping(value="electionstop.html")
    public String ElectionStop(Model model)
    {
        if (elect.getisActive())
        {
            elect.setisActive(false);

        }
        model.addAttribute("election",elect);

        return "home";


    }








}