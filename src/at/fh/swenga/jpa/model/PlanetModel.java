package at.fh.swenga.jpa.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;

@Entity
@Table (name = "Planet")
public class PlanetModel implements java.io.Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
 	
	@Column(nullable = false, length = 30)
	private String name;
	
	@Column(nullable = false, length = 30)
	private String surface;
	
	@Column(nullable = false, length = 30)
	private float size;
	
	@Version
	long version;
	
	@Embedded
	Moon moon;
	
	@ManyToOne (cascade = CascadeType.PERSIST,fetch=FetchType.EAGER)
	Galaxy galaxy;
	
	@ManyToMany(cascade=CascadeType.PERSIST)  
	private List<Universe> universes;
	
	public PlanetModel() {
		
	}

	public PlanetModel(String name, String surface, float size) {
		super();
		this.name = name;
		this.surface = surface;
		this.size = size;
	}
	
	public int getId() {
		return id;
	}
	 
	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurface() {
		return surface;
	}

	public void setSurface(String surface) {
		this.surface = surface;
	}

	public float getSize() {
		return size;
	}

	public void setSize(float size) {
		this.size = size;
	}

	public Moon getMoon() {
		return moon;
	}

	public void setMoon(Moon moon) {
		this.moon = moon;
	}

	public Galaxy getGalaxy() {
		return galaxy;
	}

	public void setGalaxy(Galaxy galaxy) {
		this.galaxy = galaxy;
	}

	public List<Universe> getUniverses() {
		return universes;
	}

	public void setUniverses(List<Universe> universes) {
		this.universes = universes;
	}
	
	public void addUniverse(Universe universe) {
		if (universes== null) {
			universes= new ArrayList<Universe>();
		}
		universes.add(universe);
	}
	
}
