package edu.uph.ii.platformy.controllers;


import edu.uph.ii.platformy.models.Candidate;
import edu.uph.ii.platformy.models.Voters;
import edu.uph.ii.platformy.repositories.VotersRepository;
import edu.uph.ii.platformy.services.CandidateService;
import edu.uph.ii.platformy.services.VotersService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.validation.Valid;

@Controller
@SessionAttributes("")
@Log4j2
public class VotingController {

    @Autowired
    private VotersRepository votersRepository;
    @Autowired
    private CandidateService candidateService;
    @Autowired
    private VotersService votersService;

    @RequestMapping(value="/kontakt.html", method = RequestMethod.GET)
    public String showKontakt(Model model, Long id){
        return "kontakt";
    }

    @RequestMapping(value="/home.html", method = RequestMethod.GET)
    public String showHome(Model model, Long id){
        return "home";
    }
    @RequestMapping(value="/home.html", method = RequestMethod.POST)
    public String showHome2(Model model, Long id){
        return "home";
    }

    @RequestMapping(value="/info.html", method = RequestMethod.GET)
    public String showInfo(Model model, Long id){
        return "info";
    }

    @RequestMapping(value="/photos.html", method = RequestMethod.GET)
    public String showPhotos(Model model, Long id){
        return "photos";
    }

    @RequestMapping(value="/css/style.css", method = RequestMethod.GET)
    public String showLogin22(Model model, Long id){
        return "home";
    }

    @RequestMapping(value="/css/style-desktop.css", method = RequestMethod.GET)
    public String showLogin2(Model model, Long id){
        return "home";
    }

    @RequestMapping(value="/zaglosuj.html", params = "id", method = RequestMethod.GET)
    public String showTravelDetails(Model model, Long id){
        model.addAttribute("candidates", candidateService.getCandidate(id));
        model.addAttribute("voters", new Voters());
        Candidate candidate = candidateService.getCandidate(id);
        candidate.setWynik(candidate.getWynik()+1);
        candidateService.saveCandidate(candidate);
        return "zaglosuj";


    }

    @RequestMapping(value="/doubleError.html", method = RequestMethod.GET)
    public String doubleError(Model model, Long id){
        return "doubleError";
    }

    @RequestMapping(value="/votError.html", method = RequestMethod.GET)
    public String voterror(Model model, Long id){
        return "votError";
    }

    @RequestMapping(value="/votIsGood.html", method = RequestMethod.GET)
    public String votIsGood(Model model, Long id){
        return "votIsGood";
    }

    @RequestMapping(value="/zaglosuj.html", method= RequestMethod.POST)
    public String processForm(@Valid @ModelAttribute("voters") Voters v, BindingResult errors){

        if(errors.hasErrors()){
            return "zaglosuj";
        }

        if(isUniqueIsvotets(v.isvotets)==false){
            return"doubleError";
        }
        if(isUniquePesel(v.pesel) ==false ){
            v.isvotets=false;


        }
        if(isUniquePesel(v.pesel) ==true) {
            return " votError ";
        }

        if(isUniqueSurename(v.surename)==true){
            return "votError";
        }  if(isUniqueName(v.name)==true){
            return "votError";
        }if(isUniqueIdnumber(v.idnumber)==true){
            return "votError";
        }


        votersService.saveVoters(v);

        return "redirect:votIsGood.html";
    }
    public boolean isUniquePesel(String pesel) {
        return votersRepository.findByPesel(pesel) == null;
    }
    public boolean isUniqueSurename(String surename) {
        return votersRepository.findBySurename(surename) == null;
    }    public boolean isUniqueName(String name) {
        return votersRepository.findByName(name) == null;
    }      public boolean isUniqueIdnumber(String idnumber) {
        return votersRepository.findByIdnumber(idnumber) == null;
    }
    public boolean isUniqueIsvotets(boolean isvotets) {
        return votersRepository.findByIsvotets(isvotets) == null;
    }


}

