package raaz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import raaz.beans.Product;
import raaz.repository.RAAZRepository;

@Service
public class InventoryService {

    @Autowired
    private RAAZRepository repo;

    public void restockProduct(long productId, int restockAmount) {
        Product product = repo.findById(productId).orElse(null);

        if (product != null) {
            product.setStock(product.getStock() + restockAmount);
            repo.save(product);
        }
    }

    public boolean pickProduct(long productId, int pickAmount) {
        Product product = repo.findById(productId).orElse(null);

        if (product != null && product.getStock() >= pickAmount) {
            product.setStock(product.getStock() - pickAmount);
            repo.save(product);
            return true; // Indicates successful picking
        }

        return false; // Indicates insufficient stock
    }
}

