package at.fh.swenga.jpa.model;
 
import java.util.HashSet;
import java.util.Set;
 
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Version;
 
@Entity
public class Galaxy {
 
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
 
	private String name;
 
    @OneToMany(mappedBy="galaxy")
    @OrderBy("name")
    private Set<PlanetModel> planets;
 
	@Version
	long version;
 
 
    public Galaxy() {
		// TODO Auto-generated constructor stub
    }
 
	public Galaxy(String name) {
		super();
		this.name = name;
	}
 
	public String getName() {
		return name;
	}
 
	public void setName(String name) {
		this.name = name;
	}
 
	public Set<PlanetModel> getPlanets() {
		return planets;
	}
 
	public void setPlanets(Set<PlanetModel> planets) {
		this.planets = planets;
	}
 
	public void addPlanet(PlanetModel planet) {
		if (planets==null) {
			planets= new HashSet<PlanetModel>();
		}
		planets.add(planet);
	}
 
 
}