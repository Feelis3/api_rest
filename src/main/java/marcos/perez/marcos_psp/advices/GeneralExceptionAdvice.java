package marcos.perez.marcos_psp.advices;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.transaction.TransactionSystemException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GeneralExceptionAdvice {
  
  @ResponseStatus(code = HttpStatus.BAD_REQUEST)
  @ExceptionHandler(HttpMessageNotReadableException.class)
  public String handleRequestBodyTypeMismatchExceptions(HttpMessageNotReadableException ex) {
    return ex.getMessage();
  }

  @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
  @ExceptionHandler(Exception.class)
  public String handleExceptions(Exception ex) {
    return ex.getMessage();
  }

  // Captura errores de violación de integridad de datos (ej. clave duplicada)
  @ResponseStatus(code = HttpStatus.BAD_REQUEST)
  @ExceptionHandler(DataIntegrityViolationException.class)
  public void handleDataIntegrityViolationException(DataIntegrityViolationException ex) {
    // No se devuelve ningún mensaje, solo el 400 Bad Request
  }

  // Captura errores relacionados con las transacciones de JPA
  @ResponseStatus(code = HttpStatus.BAD_REQUEST)  // Aquí ajustamos el código de estado a 400
  @ExceptionHandler(TransactionSystemException.class)
  public void handleTransactionSystemException(TransactionSystemException ex) {
    // No se devuelve ningún mensaje, solo el 400 Bad Request
  }

}