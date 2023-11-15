/**
* Rachel Schulz - rsschulz
* CIS175 - Fall 2023
* Nov 15, 2023
*/
package raaz.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import raaz.beans.Product;

/**
 * @author Rachel Schulz - rsschulz
 * CIS175 - Fall 2023
 * Nov 15, 2023
 */
@Configuration
public class BeanConfiguration {
	
	@Bean
    public Product product() {
        Product bean = new Product();
        return bean;
    }
	
}
