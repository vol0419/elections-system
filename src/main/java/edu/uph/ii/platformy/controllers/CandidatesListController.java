package edu.uph.ii.platformy.controllers;

import edu.uph.ii.platformy.controllers.commands.CandidateFilter;
import edu.uph.ii.platformy.models.Candidate;
import edu.uph.ii.platformy.services.CandidateService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomNumberEditor;
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
public class CandidatesListController {

	@Autowired
	private CandidateService candidateService;

	String viewChange = "candidateList";

	@RequestMapping(value="/candidateList.html", params = "id", method = RequestMethod.GET)
	public String showcandidateDetails(Model model, Long id){
		if (ElectionController.elect.getisActive()) {
			log.info("Pokazywanie szczegółów");
			model.addAttribute("book", new Candidate());
			model.addAttribute("candidate", candidateService.getCandidate(id));

			return "candidateDetails";
		}
		else

		{
			return "electionError";
		}
	}

	@GetMapping(value="/errorr")
	public String resetvehicleList(){
		return "redirect:candidateList.html";
	}


	@ModelAttribute("searchCommand")
	public CandidateFilter getSimpleSearch(){
		return new CandidateFilter();
	}

	@GetMapping(value="/candidateList.html", params = {"all"})
	public String resetvehicleList(@ModelAttribute("searchCommand") CandidateFilter search){
		search.clear();
		return "redirect:" + viewChange + ".html";
	}

	@GetMapping(value="/candidateList.html", params = {"end"})
	public String chagneView(Model model){
		if (ElectionController.elect.getisActive()) {
			return "votingActiveError";
		}else{
			viewChange = "candidateListOver";
			return "redirect:" + viewChange + ".html";
		}
	}

	@GetMapping(value="/candidateListOver.html", params = {"back"})
	public String chagneViewBack(Model model){
		viewChange = "candidateList";
		return "redirect:" + viewChange + ".html";
	}

	@GetMapping(value="/candidateList.html", params = {"delete"})
	public String deleteTheListTable(Model model){
		candidateService.deleteAll();
		return "redirect:" + viewChange + ".html";
	}

	@RequestMapping(value="/candidateList.html", method = {RequestMethod.GET, RequestMethod.POST})
	public String showCandidateList(Model model, @Valid @ModelAttribute("searchCommand") CandidateFilter search, BindingResult result, Pageable pageable){
		model.addAttribute("candidateListPage", candidateService.getAllCandidates(search, pageable));
		return viewChange;
	}

	@RequestMapping(value="/candidateListOver.html", method = {RequestMethod.GET, RequestMethod.POST})
	public String showCandidateListOver(Model model, @Valid @ModelAttribute("searchCommand") CandidateFilter search, BindingResult result, Pageable pageable){
		model.addAttribute("candidateListPage", candidateService.getAllCandidates(search, pageable));
		return viewChange;
	}

	@Secured("ROLE_ADMIN")
	@GetMapping(path="/candidateList.html", params={"did"})
	public String deleteCandidate(long did, HttpServletRequest request){
		candidateService.deleteCandidate(did);
		String queryString = prepareQueryString(request.getQueryString());
		return String.format("redirect:" + viewChange + ".html%s", queryString);//robimy przekierowanie, ale zachowując parametry pageingu
	}

	private String prepareQueryString(String queryString) {//np., did=20&page=2&size=20
		if (queryString.contains("&")) {
			return "?"+queryString.substring(queryString.indexOf("&") + 1);//obcinamy parametr did, bo inaczej po przekierowaniu znowu będzie wywołana metoda deleteVihicle
		}else{
			return "";
		}
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {//Rejestrujemy edytory właściwości
		DecimalFormat numberFormat = new DecimalFormat("#0.00");
		numberFormat.setMaximumFractionDigits(2);
		numberFormat.setMinimumFractionDigits(2);
		numberFormat.setGroupingUsed(false);
		CustomNumberEditor priceEditor = new CustomNumberEditor(Float.class, numberFormat, true);
		binder.registerCustomEditor(Float.class, "minPrice", priceEditor);
		binder.registerCustomEditor(Float.class, "maxPrice", priceEditor);

	}



}




