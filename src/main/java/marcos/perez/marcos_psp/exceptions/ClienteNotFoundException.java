package marcos.perez.marcos_psp.exceptions;

public class ClienteNotFoundException extends RuntimeException {

  public ClienteNotFoundException(Long id) {
    super("Cliente con ID <" + id+ "> no encontrado");
  }
}
