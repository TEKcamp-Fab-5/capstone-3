package inventory.manager.Services.Implementation;


import inventory.manager.DAO.IProductRepository;
import inventory.manager.DTO.ProductDTO;
import inventory.manager.Entity.Product;
import inventory.manager.Services.IProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImplementation implements IProductService {

    private final IProductRepository productRepository;

    public ProductServiceImplementation(IProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    @Override
    public ProductDTO createProduct(ProductDTO productDTO) {
        Product newProduct = new Product();
        BeanUtils.copyProperties(productDTO, newProduct);
        Product storedProductDetails = productRepository.save(newProduct);
        ProductDTO returnValue = new ProductDTO();
        BeanUtils.copyProperties(storedProductDetails, returnValue);

        return returnValue;
    }

    @Override
    public List<Product> getProducts() {
        List<Product> returnValue;
        returnValue = (List<Product>) productRepository.findAll();

        return returnValue;
    }
}
