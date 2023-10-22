package lucas.soft.sistemavendas.service;

import lucas.soft.sistemavendas.model.Product;

import java.util.List;

public interface ProductService{

    List<Product> findAllProducts();
    Product findById(Long id);

    Product create(Product productToCreate);

    Product delete(Long id);

}
