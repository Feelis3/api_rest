package marcos.perez.marcos_psp.controllers;

import jakarta.validation.Valid;
import marcos.perez.marcos_psp.dtos.GetPedidoDto;
import marcos.perez.marcos_psp.entities.Pedido;
import marcos.perez.marcos_psp.mappers.PedidoMapper;
import marcos.perez.marcos_psp.repositories.IClienteRepository;
import marcos.perez.marcos_psp.repositories.IPedidoRepository;
import marcos.perez.marcos_psp.repositories.IProductoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    private final IPedidoRepository pedidoRepository;
    private final IClienteRepository clienteRepository;
    private final IProductoRepository productoRepository;
    private final PedidoMapper pedidoMapper;

    public PedidoController(
            IPedidoRepository pedidoRepository,
            IClienteRepository clienteRepository,
            IProductoRepository productoRepository,
            PedidoMapper pedidoMapper) {
        this.pedidoRepository = pedidoRepository;
        this.clienteRepository = clienteRepository;
        this.productoRepository = productoRepository;
        this.pedidoMapper = pedidoMapper;
    }

    @GetMapping
    public List<GetPedidoDto> getPedidosByID(@RequestParam("idCliente") Long idCliente) {
        if (!clienteRepository.existsById(idCliente)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente no encontrado");
        }

        List<Pedido> listaPedidos = pedidoRepository.findByCliente_Id(idCliente);

        return listaPedidos.stream()
                .map(pedidoMapper::toGetPedidoDto)
                .collect(Collectors.toList());
    }

}

