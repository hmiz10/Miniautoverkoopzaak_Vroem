package be.intecbrussel.entities;

import be.intecbrussel.model.Product;
import be.intecbrussel.model.ProductLine;

public interface ProductLineDao {
    void createProductLine(ProductLine productLine);
    ProductLine readProductLine(int productLine);
    void updateProductLine(ProductLine productLine);
    void deleteProductLine(ProductLine productLine);
}
