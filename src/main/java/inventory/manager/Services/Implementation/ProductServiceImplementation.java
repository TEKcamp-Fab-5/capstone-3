package inventory.manager.Services.Implementation;


import inventory.manager.DAO.IProductRepository;
import inventory.manager.DTO.ProductDTO;
import inventory.manager.Entity.Product;
import inventory.manager.Request.ProductRequest;
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

    @Override
    public Product getProductBySerial(Long productSerial) {
        Product returnValue = productRepository.findByProductSerial(productSerial);
        return returnValue;
    }

    @Override
    public ProductDTO updateProduct(ProductRequest productRequest, ProductDTO queriedProductDTO) {
        if(productRequest.getName()!=null) {
            queriedProductDTO.setName(productRequest.getName());
        }

        if(productRequest.getManufacturer()!=null) {
            queriedProductDTO.setManufacturer(productRequest.getManufacturer());
        }

        if(productRequest.getCategory()!=null) {
            queriedProductDTO.setCategory(productRequest.getCategory());
        }

        if(productRequest.getPrice()!=0) {
            queriedProductDTO.setPrice(productRequest.getPrice());
        }
        if(productRequest.getQuantityInInventory()!=0) {
            queriedProductDTO.setQuantityInInventory(productRequest.getQuantityInInventory());
        }
        if (productRequest.getImage()!=null) {
            queriedProductDTO.setImage(productRequest.getImage());
        }

        Product productToSave = new Product();
        BeanUtils.copyProperties(queriedProductDTO, productToSave);

        Product savedProduct = productRepository.save(productToSave);
        ProductDTO updatedProduct = new ProductDTO();
        BeanUtils.copyProperties(savedProduct, updatedProduct);

        return updatedProduct;
    }
}
