package at.fh.swenga.jpa.model;
 
import javax.persistence.Column;
import javax.persistence.Embeddable;
 
@Embeddable
public class Moon {
	
	@Column(name = "moon_name")
	private String name;
	
	@Column(name = "moon_amount")
	private int amount;
	
	public Moon() {
		
	}
	
	public Moon(String name, int amount) {
		super();
		this.name = name;
		this.amount = amount;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
	
}