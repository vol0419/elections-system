package edu.uph.ii.platformy.controllers;

import edu.uph.ii.platformy.controllers.commands.CandidateFilter;
import edu.uph.ii.platformy.services.VotersService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.text.DecimalFormat;

@Controller
@SessionAttributes("searchCommand")
@Log4j2
public class VotersListController {

	@Autowired
	private VotersService votersService;

	@Secured("IS_AUTHENTICATED_FULLY")
	@RequestMapping(value="/menuList.html", params = "id", method = RequestMethod.GET)
	public String showvotersDetails(Model model, Long id){
		log.info("Pokazywanie szczegółów");
		model.addAttribute("voters", votersService.getVoters(id));
		return "menuDetails";
	}

	@GetMapping(value="/error")
	public String resetvotersList(){
		return "redirect:menuList.html";
	}


	@ModelAttribute("searchCommand")
	public CandidateFilter getSimpleSearch(){
		return new CandidateFilter();
	}

	@GetMapping(value="/menuList.html", params = {"all"})
	public String resetvotersList(@ModelAttribute("searchCommand") CandidateFilter search){
		search.clear();
		return "redirect:menuList.html";
	}

	@RequestMapping(value="/menuList.html", method = {RequestMethod.GET, RequestMethod.POST})
	public String showVotersList(Model model, @Valid @ModelAttribute("searchCommand") CandidateFilter search, BindingResult result, Pageable pageable){
		model.addAttribute("menuListPage", votersService.getAllVoters(search, pageable));
		return "menuList";
	}


	@Secured("ROLE_ADMIN")
	@GetMapping(path="/menuList.html", params={"did"})
	public String deleteVoters(long did, HttpServletRequest request){
		votersService.deleteVoters(did);
		String queryString = prepareQueryString(request.getQueryString());
		return String.format("redirect:menuList.html%s", queryString);
	}

	private String prepareQueryString(String queryString) {
		if (queryString.contains("&")) {
			return "?"+queryString.substring(queryString.indexOf("&") + 1);
		}else{
			return "";
		}
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {//Rejestrujemy edytory właściwości
		DecimalFormat numberFormat = new DecimalFormat(" ");



	}
}




