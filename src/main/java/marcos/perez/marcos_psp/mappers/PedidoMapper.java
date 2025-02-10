package marcos.perez.marcos_psp.mappers;

import marcos.perez.marcos_psp.dtos.CreatePedidoDto;
import marcos.perez.marcos_psp.dtos.GetPedidoDto;
import marcos.perez.marcos_psp.entities.Cliente;
import marcos.perez.marcos_psp.entities.Pedido;
import marcos.perez.marcos_psp.entities.Producto;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

@Component
public class PedidoMapper {
    public Pedido toPedido(@NonNull CreatePedidoDto createPedidoDto, Cliente cliente, Producto producto) {
        return new Pedido(
                createPedidoDto.getNumUnidades(),
                createPedidoDto.getFechaHoraPedido(),
                cliente,
                producto
        );
    }
    public GetPedidoDto toGetPedidoDto(Pedido pedido) {
        return new GetPedidoDto(
                pedido.getId(),
                pedido.getNumUnidades(),
                pedido.getFechaHoraPedido(),
                pedido.getCliente().getId(),
                pedido.getProducto().getId()
        );
    }
}
