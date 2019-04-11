package edu.uph.ii.platformy.controllers;

import edu.uph.ii.platformy.models.Candidate;
import edu.uph.ii.platformy.services.CandidateService;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.validation.Valid;
import java.util.Date;
import java.util.Optional;

@Controller
@SessionAttributes(names={"candidateTypes", "accessoryList", "candidate"})
@Log4j2
public class CandidateFormController {

	private CandidateService candidateService;

	//Wstrzyknięcie zależności przez konstruktor. Od wersji 4.3 Springa nie trzeba używać adnontacji @Autowired, gdy mamy jeden konstruktor
	//@Autowired
	public CandidateFormController(CandidateService candidateService)
	{
		this.candidateService = candidateService;
	}

	@Secured("ROLE_ADMIN")
	@RequestMapping(value="/candidateForm.html", method= RequestMethod.GET)
	public String showForm(Model model, Optional<Long> id){

		model.addAttribute("candidate",
				id.isPresent()?
				candidateService.getCandidate(id.get()):
				new Candidate());

		return "candidateForm";
	}



	@Secured("ROLE_ADMIN")
	@RequestMapping(value="/candidateForm.html", method= RequestMethod.POST)
	//@ResponseStatus(HttpStatus.CREATED)
	public String processForm(@Valid @ModelAttribute("candidate") Candidate v, BindingResult errors){

		if(errors.hasErrors()){
			return "candidateForm";
		}

		log.info("Data utworzenia komponentu "+v.getCreatedDate());
		log.info("Data edycji komponentu "+new Date());

		candidateService.saveCandidate(v);

		return "redirect:candidateList.html";//po udanym dodaniu/edycji przekierowujemy na listę
	}	


}








