package marcos.perez.marcos_psp.exceptions;

public class ProductoNotFoundException extends RuntimeException {
    public ProductoNotFoundException(Long id) {
        super("Producto con ID <" + id+ "> no encontrado");
    }
}
