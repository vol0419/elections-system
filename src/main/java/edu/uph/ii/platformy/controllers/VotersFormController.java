package edu.uph.ii.platformy.controllers;

import edu.uph.ii.platformy.models.Voters;
import edu.uph.ii.platformy.repositories.VotersRepository;
import edu.uph.ii.platformy.services.VotersService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@SessionAttributes(names={  "accessoryList", "voters"})
@Log4j2
public class VotersFormController {
	@Autowired
	private VotersRepository votersRepository;

	private VotersService votersService;

	//Wstrzyknięcie zależności przez konstruktor. Od wersji 4.3 Springa nie trzeba używać adnontacji @Autowired, gdy mamy jeden konstruktor
	//@Autowired
	public VotersFormController(VotersService votersService)
	{
		this.votersService = votersService;
	}

	@Secured("ROLE_ADMIN")
	@RequestMapping(value="/menuForm.html", method= RequestMethod.GET)
	public String showForm(Model model, Optional<Long> id){

		model.addAttribute("voters",
				id.isPresent()?
						votersService.getVoters(id.get()):
				new Voters());

		return "menuForm";
	}


	@GetMapping(value="/menuform.html", params = {"delete"})
	public String deleteTheListTable(Model model){
		votersService.deleteAll();
		return "menuform.html";
	}

	@Secured("ROLE_ADMIN")
	@RequestMapping(value="/menuForm.html", method= RequestMethod.POST)
	//@ResponseStatus(HttpStatus.CREATED)
	public String processForm(@Valid @ModelAttribute("voters") Voters d, BindingResult errors){

		if(errors.hasErrors()){
			return "menuForm";
		}
		if((Wlidacja(d.pesel)) == false ){
			return "redirect:peselNotGood.html";


		}

		if(isUniquePesel(d.pesel) ==false ){

			return "redirect:peselNotGood.html";

		}
		if(isUniqueIdnumber(d.idnumber) ==false ){

			return "redirect:idnumberNotGood.html";

		}



		d.isvotets=true;
		votersService.saveVoters(d);

		return "redirect:menuList.html";
	}
	public boolean isUniquePesel(String pesel) {
		return votersRepository.findByPesel(pesel) == null;
	}
	public boolean isUniqueIdnumber(String idnumber) {
		return votersRepository.findByIdnumber(idnumber) == null;
	}

	@RequestMapping(value="/idnumberNotGood.html", method= RequestMethod.GET)
	public String badnumber(Model model){
		return "idnumberNotGood";
	}
	@RequestMapping(value="/peselNotGood.html", method= RequestMethod.GET)
	public String badpesel(Model model){
		return "peselNotGood";
	}




	 public static boolean Wlidacja(String pesel){


		int[] wagi = {1, 3, 7, 9, 1, 3, 7 ,9 ,1 ,3};




		int suma = 0;




		for (int i = 0; i < 10; i++)

		suma += Integer.parseInt(pesel.substring(i, i+1)) * wagi[i];



		int cyfraKontrolna = Integer.parseInt(pesel.substring(10, 11));




		suma %= 10;

		suma = 10 - suma;

		suma %= 10;





		return (suma == cyfraKontrolna);


}






}








