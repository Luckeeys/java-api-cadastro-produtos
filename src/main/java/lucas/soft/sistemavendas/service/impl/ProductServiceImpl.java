package lucas.soft.sistemavendas.service.impl;

import lucas.soft.sistemavendas.model.Product;
import lucas.soft.sistemavendas.repository.ProductRepository;
import lucas.soft.sistemavendas.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> findAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product findById(Long id) {
        return productRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Product create(Product productToCreate) {
        if (productRepository.existsByName(productToCreate.getName())) {
            throw new IllegalArgumentException("This Product Name already exists.");
        }
        return productRepository.save(productToCreate);
    }

    @Override
    public Product delete(Long id) {
        Product productToDelete = productRepository.findById(id).orElseThrow(NoSuchElementException::new);

        productRepository.delete(productToDelete);

        return productToDelete;
    }
}
