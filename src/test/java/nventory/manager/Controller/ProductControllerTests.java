package nventory.manager.Controller;

import inventory.manager.Controller.ProductController;
import inventory.manager.DAO.IProductRepository;
import inventory.manager.Entity.Product;
import inventory.manager.Request.ProductRequest;
import inventory.manager.Response.ProductResponse;
import inventory.manager.Services.IProductService;
import inventory.manager.Services.Implementation.ProductServiceImplementation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class ProductControllerTests {
    @Test
    public void testUpdateProduct() {
        long productSerial = 999L;
        IProductRepository repository = Mockito.mock(IProductRepository.class);
        when(repository.findByProductSerial(any(Long.class))).thenReturn(new Product());
        when(repository.save(any(Product.class))).thenReturn(new Product());
        ProductRequest request = new ProductRequest();
        request.setProductSerial(productSerial);
        IProductService service = new ProductServiceImplementation(repository);
        ProductResponse expected = new ProductResponse();
        expected.setProductSerial(productSerial);
        ProductResponse actual = new ProductController(service, repository).updateProduct(request);
        Assertions.assertEquals(expected, actual);
    }
}
