package marcos.perez.marcos_psp.advices;

import marcos.perez.marcos_psp.exceptions.ClienteNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
class ClienteExceptionAdvice {
  
  @ExceptionHandler(ClienteNotFoundException.class)
  @ResponseStatus(code = HttpStatus.NOT_FOUND)
  String empleadoNotFoundHandler(ClienteNotFoundException ex) {
    return ex.getMessage();
  }
}

