package at.fh.swenga.jpa.controller;
 
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
 
import at.fh.swenga.jpa.dao.PlanetDao;
import at.fh.swenga.jpa.model.Moon;
import at.fh.swenga.jpa.model.PlanetModel;
 
@Controller
public class PlanetController {
 
	@Autowired
	PlanetDao planetDao;
 
	@RequestMapping(value = { "/", "list" })
	public String index(Model model) {
 
		List<PlanetModel> planets = planetDao.getPlanets();
		model.addAttribute("planets", planets);
		return "index";
	}
 
	@RequestMapping("/fillPlanetList")
	@Transactional
	public String fillData(Model model) {
 
		Moon moon = new Moon("Moon",3);
		
		PlanetModel p1 = new PlanetModel("Earth","blue",40000);
		planetDao.persist(p1);
 
		return "forward:list";
	}
 
	@RequestMapping("/searchPlanets")
	public String search(Model model, @RequestParam String searchString) {
		model.addAttribute("planets", planetDao.searchPlanets(searchString));
		return "index";
	}
 
	@RequestMapping("/delete")
	public String deleteData(Model model, @RequestParam int id) {
		planetDao.delete(id);
 
		return "forward:list";
	}
 
	// @ExceptionHandler(Exception.class)
	public String handleAllException(Exception ex) {
 
		return "error";
 
	}
}