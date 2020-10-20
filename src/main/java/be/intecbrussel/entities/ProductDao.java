package be.intecbrussel.entities;

import be.intecbrussel.model.OrderDetail;
import be.intecbrussel.model.Product;

public interface ProductDao {

    void createProduct(Product product);
    Product readProduct(int productCode);
    void updateProduct(Product product);
    void deleteProduct(Product product);
}
