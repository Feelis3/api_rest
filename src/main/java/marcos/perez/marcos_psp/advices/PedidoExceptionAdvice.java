package marcos.perez.marcos_psp.advices;

import marcos.perez.marcos_psp.exceptions.ClienteNotFoundException;
import marcos.perez.marcos_psp.exceptions.PedidoNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class PedidoExceptionAdvice {
    @ExceptionHandler(ClienteNotFoundException.class)
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    String pedidoNoEncontrado(PedidoNotFoundException ex) {
        return ex.getMessage();
    }
}
