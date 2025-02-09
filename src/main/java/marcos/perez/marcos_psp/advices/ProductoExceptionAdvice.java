package marcos.perez.marcos_psp.advices;

import marcos.perez.marcos_psp.exceptions.ClienteNotFoundException;
import marcos.perez.marcos_psp.exceptions.ProductoNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductoExceptionAdvice {
    @ExceptionHandler(ProductoNotFoundException.class)
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    String productoNoFoundExceptionMessage(ProductoNotFoundException ex) {
        return ex.getMessage();
    }
}
