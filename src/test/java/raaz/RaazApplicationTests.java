package raaz;

import static org.hamcrest.CoreMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import raaz.beans.Product;
import raaz.repository.RAAZRepository;
import raaz.service.InventoryService;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(MockitoExtension.class)
class RaazApplicationTests {

    @Autowired
    private MockMvc mockMvc;
    
    @InjectMocks
    private InventoryService inventoryService;
    
    @Mock
    private RAAZRepository repo;
	
	@Test
	void contextLoads() {
	}	

    @Test
    public void testInputManForm() throws Exception {
        mockMvc.perform(get("/manufacturer/inputMan"))
               .andExpect(status().isOk())
               .andExpect(view().name("inputMan"))
               .andExpect(model().attributeExists("newMan"));
    }
    
    @Test
    void testPickProduct() {
        // Arrange
        long productId = 1L;
        int pickAmount = 5;

        // Create a product with initial stock
        Product product = new Product();
        product.setStock(10);

        // Set up the mock repository behavior
        when(repo.findById(productId)).thenReturn(Optional.of(product));
        when(repo.save(any())).thenReturn(product);

        // Act
        boolean success = inventoryService.pickProduct(productId, pickAmount);

        // Assert
        // Verify that the repository methods were called with the correct parameters
        verify(repo, times(1)).findById(productId);
        verify(repo, times(1)).save(product);

        // Verify that the method returns the expected boolean value
        assertTrue(success);

        // Verify that the stock has been updated correctly
        assertEquals(5, product.getStock());
    }
    

    @Test
    void testRestockProduct() {
    	//Arrange
        // Mocked product and repository
        Product mockedProduct = new Product();
        mockedProduct.setProductId(1L);
        mockedProduct.setStock(10);

        // Set up the mock repository behavior
        when(repo.findById(1L)).thenReturn(Optional.of(mockedProduct));
        
        //Act
        // Call the restockProduct method
        inventoryService.restockProduct(1L, 5);
        
        //Verify
        // Verify that the product was fetched from the repository
        verify(repo, times(1)).findById(1L);

        // Verify that the product stock was updated correctly
        assertEquals(15, mockedProduct.getStock(), "Stock should be updated to 15");

        // Verify that the product was saved back to the repository
        verify(repo, times(1)).save(mockedProduct);
    }


}
