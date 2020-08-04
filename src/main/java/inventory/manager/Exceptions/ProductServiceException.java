package inventory.manager.Exceptions;

public class ProductServiceException extends RuntimeException{
    private static final long serialVersionUID = 1143685194597858350L;

    public ProductServiceException(String errorMessage){
        super(errorMessage);
    }

}
