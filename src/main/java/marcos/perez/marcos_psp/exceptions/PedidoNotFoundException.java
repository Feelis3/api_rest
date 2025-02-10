package marcos.perez.marcos_psp.exceptions;

import java.util.UUID;

public class PedidoNotFoundException extends RuntimeException {
    public PedidoNotFoundException(UUID uuid) {
        super("Pedido con ID <" + uuid+ "> no encontrado");
    }
}
