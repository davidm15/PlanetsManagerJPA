package at.fh.swenga.jpa.model;
 
import java.util.List;
 
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
 
@Entity
public class Universe {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
 
	private String name;
 
	@ManyToMany(mappedBy = "universe",fetch=FetchType.EAGER)
	private List<PlanetModel> planets;
 
	public Universe() {
	}
 
	public Universe(String name) {
		super();
		this.name = name;
	}
 
	public String getName() {
		return name;
	}
 
	public void setName(String name) {
		this.name = name;
	}
 
	public List<PlanetModel> getEmployees() {
		return planets;
	}
 
	public void setPlanets(List<PlanetModel> planets) {
		this.planets = planets;
	}
 
}