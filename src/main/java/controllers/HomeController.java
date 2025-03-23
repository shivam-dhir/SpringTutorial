package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
	
	@Autowired
	private GameDao gameDao; 
	
	// ModelAttribute is used to assign objects/ variable, i.e. whatever the return value is to the attribute name.
	// In this case, the string puttwhiskey is assigned to the variable name, and can be used by views html/jsp files.
	// If I was returning a Game object, the object would be assigned to the variable name.
	@ModelAttribute("username")
	public String assignName(ModelMap mm) { 
		return "puttWhiskey"; // addAttribute: add a variable to the ModelMap, according to the MVC design pattern.
	}
	
	@RequestMapping("/")
	public String home() {
		System.out.println("Home page invoked");
		return "index";
	}
	
	@RequestMapping("add") 
	// request mapping allows to fetch parameters from HttpServletRequest object
	public String add(@ModelAttribute("gamesList") Game newGame) { //(@RequestParam("gameId") int gameId, @RequestParam("gameName") String gameName, @RequestParam("metascore") int metascore, ModelMap mm) {
		
		// ModelAndView is an MVC concept to reduce configurations. It is used instead of HttpSession in this case.
		// ModelAndView mv = new ModelAndView();
		// mv.setViewName("add");
		//mv.addObject("res", res);
//		
//		Game newGame = new Game();
//		newGame.setId(gameId);
//		newGame.setName(gameName);
//		newGame.setMetascore(metascore);
		
		gameDao.addGame(newGame); 
		return "thankyou";  
	}
	
	@RequestMapping("getGame")
	public String getAlien(@RequestParam("gameId") int gameId, ModelMap mm) {
		Game game = gameDao.getGame(gameId);
		mm.addAttribute("game", game);
		return "getGame";
	}
	
	@RequestMapping("getGames")
	public String getGames(ModelMap mm){
		mm.addAttribute("gamesList", gameDao.getGames()); // dao.getGames returns list of all games in mysql DB
		return "showGames";
	}
	
	
	
}
