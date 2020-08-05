package inventory.manager.Controller;

import inventory.manager.DAO.IProductRepository;
import inventory.manager.DTO.ProductDTO;
import inventory.manager.Entity.Product;
import inventory.manager.Request.ProductRequest;
import inventory.manager.Response.ProductResponse;
import inventory.manager.Services.IProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@CrossOrigin(origins = "https://localhost:4200")
@RequestMapping("/products")
public class ProductController {

    private final IProductService iProductService;
    private final IProductRepository iProductRepository;


    public ProductController(IProductService iProductService, IProductRepository iProductRepository) {
        this.iProductService = iProductService;
        this.iProductRepository = iProductRepository;
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

    @GetMapping(path = "/serial={productSerial}")
    public ProductResponse getProductByProductSerial(@PathVariable Long productSerial) {
        Product queriedProduct = iProductService.getProductBySerial(productSerial);

        ProductResponse returnValue = new ProductResponse();
        BeanUtils.copyProperties(queriedProduct, returnValue);

        return returnValue;
    }

    @PutMapping(path = "/updateProduct")
    public ProductResponse updateProduct(@RequestBody ProductRequest productRequest) {
        //
        //
        Product queriedProduct = iProductService.getProductBySerial(productRequest.getProductSerial());

        ProductDTO queriedProductDTO = new ProductDTO();
        BeanUtils.copyProperties(queriedProduct, queriedProductDTO);

        ProductDTO updatedProduct = iProductService.updateProduct(productRequest, queriedProductDTO);
        BeanUtils.copyProperties(updatedProduct, queriedProduct);

        Product tempProductDetails = iProductRepository.save(queriedProduct);

        ProductResponse returnValue = new ProductResponse();
        BeanUtils.copyProperties(tempProductDetails, returnValue);

        return returnValue;
    }

    @DeleteMapping(path = "/deleteProduct")
    public void deleteProduct(@RequestBody ProductRequest productRequest) {
        //
        //

        Product queriedProduct = iProductService.getProductBySerial(productRequest.getProductSerial());
        //

        iProductRepository.delete(queriedProduct);
        //
    }


}
