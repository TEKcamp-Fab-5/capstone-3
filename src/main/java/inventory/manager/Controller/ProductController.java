package inventory.manager.Controller;

import inventory.manager.DTO.ProductDTO;
import inventory.manager.Entity.Product;
import inventory.manager.Request.ProductRequest;
import inventory.manager.Response.ProductResponse;
import inventory.manager.Services.IProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/products")
public class ProductController {

    private final IProductService iProductService;


    public ProductController(IProductService iProductService) {
        this.iProductService = iProductService;
    }

    @PostMapping
    public ProductResponse createProduct(@RequestBody ProductRequest productRequest){
        ProductDTO productDTO = new ProductDTO();
        BeanUtils.copyProperties(productRequest, productDTO);
        ProductDTO createdProduct = iProductService.createProduct(productDTO);
        ProductResponse returnValue = new ProductResponse();
        BeanUtils.copyProperties(createdProduct, returnValue);

        return returnValue;
    }

    @GetMapping
    public List<ProductResponse> getProducts(){
        List<Product> productList = iProductService.getProducts();

        ArrayList<ProductResponse> returnValue = new ArrayList<>();

        for (Product product : productList){
            ProductResponse productResponse = new ProductResponse();
            BeanUtils.copyProperties(product, productResponse);

            returnValue.add(productResponse);
        }

       return returnValue;
    }


}
