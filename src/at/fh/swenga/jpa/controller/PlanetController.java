package at.fh.swenga.jpa.controller;
 
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import at.fh.swenga.jpa.dao.GalaxyDao;
import at.fh.swenga.jpa.dao.PlanetDao;
import at.fh.swenga.jpa.dao.UniverseDao;
import at.fh.swenga.jpa.model.Galaxy;
import at.fh.swenga.jpa.model.Moon;
import at.fh.swenga.jpa.model.PlanetModel;
import at.fh.swenga.jpa.model.Universe;
 
@Controller
public class PlanetController {
 
	@Autowired
	PlanetDao planetDao;
	
	@Autowired
	GalaxyDao galaxyDao;
	
	@Autowired
	UniverseDao universeDao;
 
	@RequestMapping(value = { "/", "list" })
	public String index(Model model) {
 
		List<PlanetModel> planets = planetDao.getPlanets();
		List<Galaxy> galaxys = galaxyDao.getGalaxys();
		List<Universe> universes = universeDao.getUniverses();
		model.addAttribute("planets", planets);
		model.addAttribute("galaxys", galaxys);
		model.addAttribute("universe", universes);
		model.addAttribute("galaxys", galaxyDao.getGalaxys());
		return "index";
	}
 
	@RequestMapping("/fillPlanetList")
	@Transactional
	public String fillData(Model model) {
 
		Moon moon = new Moon("Moon",3);
		
		Galaxy galaxy1 = galaxyDao.getGalaxy("Milkyway");
		if (galaxy1==null) galaxy1 = new Galaxy("Milkyway");
		
		Galaxy galaxy2 = galaxyDao.getGalaxy("Andromeda");
		if (galaxy2==null) galaxy2 = new Galaxy("Andromeda");
		
		Universe universe = universeDao.getUniverse("11");
		if (universe==null) universe = new Universe("11");
		
		PlanetModel p1 = new PlanetModel("Earth","blue",40000);
		p1.setGalaxy(galaxy1);
		p1.setMoon(moon);
		p1.addUniverse(universe);
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