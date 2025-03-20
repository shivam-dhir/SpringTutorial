package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
	
	@Autowired
	private GameDao gameDao; 
	
	// ModelAttribute is used to assign variables/ objects beforehand
	@ModelAttribute
	public void assignName(ModelMap mm) {
		mm.addAttribute("name", "Shivam"); // addAttribute: add a variable to the ModelMap, according to the MVC design pattern.
	}
	
	@RequestMapping("/")
	public String home() {
		System.out.println("Home page invoked");
		return "index";
	}
	
	@RequestMapping("add") 
	// request mapping allows to fetch parameters from HttpServletRequest object
	public String add(@RequestParam("gameId") int gameId, @RequestParam("gameName") String gameName, @RequestParam("metascore") int metascore, ModelMap mm) {
		
		// ModelAndView is an MVC concept to reduce configurations. It is used instead of HttpSession in this case.
		// ModelAndView mv = new ModelAndView();
		// mv.setViewName("add");
		//mv.addObject("res", res);
		
		gameDao.addGame();
		
		return "thankyou";  
	}
	
	@RequestMapping("getGames")
	public String getGames(ModelMap mm){
		mm.addAttribute("games", gameDao.getGames()); // dao.getGames returns list of all games in mysql DB
		return "showGames";
	}
	
	
	
}
