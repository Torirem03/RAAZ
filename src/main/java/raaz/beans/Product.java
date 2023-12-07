/**
* Rachel Schulz - rsschulz
* CIS175 - Fall 2023
* Nov 14, 2023
*/
package raaz.beans;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Rachel Schulz - rsschulz
 * CIS175 - Fall 2023
 * Nov 14, 2023
 */
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Product {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long productId;
	private String productName;
	private String description;
	private double cost;
	private int stock;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="man_id")
	private Manufacturer manufacturer;
	
}
