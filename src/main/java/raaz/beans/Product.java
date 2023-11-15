/**
* Rachel Schulz - rsschulz
* CIS175 - Fall 2023
* Nov 14, 2023
*/
package raaz.beans;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
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
	@GeneratedValue
	private long productId;
	private String productName;
	private String description;
	private double cost;
	private int stock;
	
}
