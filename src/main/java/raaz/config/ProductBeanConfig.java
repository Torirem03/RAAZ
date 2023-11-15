/**
* Rachel Schulz - rsschulz
* CIS175 - Fall 2023
* Nov 15, 2023
*/
package raaz.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Rachel Schulz - rsschulz
 * CIS175 - Fall 2023
 * Nov 15, 2023
 */
@Configuration
public class ProductBeanConfig {
	
	@Bean
	public Product product = new Product();
	return product;
	
}
