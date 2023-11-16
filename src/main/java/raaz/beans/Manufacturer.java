package raaz.beans;

import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="manufacturer")
@Data
@NoArgsConstructor
public class Manufacturer {
	//Test - Zoie
	//AHHHHHHHHHH
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long manId;
	private String manName;
	private String street;
	private String city;
	private String state;
	private String zip;
	private String email;
	private String phone;
	
	@OneToMany(mappedBy="manufacturer", fetch = FetchType.EAGER, cascade=CascadeType.ALL)
	private Set<Product> products;

	
	/**
	 * @param manId
	 * @param manName
	 * @param street
	 * @param city
	 * @param state
	 * @param zip
	 * @param email
	 * @param phone
	 */
	public Manufacturer(long manId, String manName, String street, String city, String state, String zip, String email,
			String phone) {
		super();
		this.manId = manId;
		this.manName = manName;
		this.street = street;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.email = email;
		this.phone = phone;
	}


	/**
	 * @param manName
	 * @param street
	 * @param city
	 * @param state
	 * @param zip
	 * @param email
	 * @param phone
	 */
	public Manufacturer(String manName, String street, String city, String state, String zip, String email,
			String phone) {
		super();
		this.manName = manName;
		this.street = street;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.email = email;
		this.phone = phone;
	}
	
	
	/**
	 * 
	 */
	public void addStockAmountForProduct(int amount, String productName) {
		//interate for product and calculate new stock amount
		
	}
	
}

