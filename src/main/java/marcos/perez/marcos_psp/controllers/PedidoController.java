package marcos.perez.marcos_psp.controllers;

import jakarta.validation.Valid;
import marcos.perez.marcos_psp.dtos.CreatePedidoDto;
import marcos.perez.marcos_psp.dtos.CreateProductoDto;
import marcos.perez.marcos_psp.dtos.GetPedidoDto;
import marcos.perez.marcos_psp.entities.Cliente;
import marcos.perez.marcos_psp.entities.Pedido;
import marcos.perez.marcos_psp.entities.Producto;
import marcos.perez.marcos_psp.exceptions.ClienteNotFoundException;
import marcos.perez.marcos_psp.exceptions.PedidoNotFoundException;
import marcos.perez.marcos_psp.exceptions.ProductoNotFoundException;
import marcos.perez.marcos_psp.mappers.PedidoMapper;
import marcos.perez.marcos_psp.repositories.IClienteRepository;
import marcos.perez.marcos_psp.repositories.IPedidoRepository;
import marcos.perez.marcos_psp.repositories.IProductoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;
import java.util.stream.Collectors;

@RestController
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

    @GetMapping("/pedidos")
    public List<GetPedidoDto> getPedidosByID(@RequestParam("idCliente") Long idCliente) {
        if (!clienteRepository.existsById(idCliente)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente no encontrado");
        }

        List<Pedido> listaPedidos = pedidoRepository.findByCliente_Id(idCliente);

        return listaPedidos.stream()
                .map(pedidoMapper::toGetPedidoDto)
                .collect(Collectors.toList());
    }

    @PostMapping("/pedidos")
    @ResponseStatus(code = HttpStatus.CREATED)
    GetPedidoDto postPedido(
            @NonNull @Valid @RequestBody CreatePedidoDto nuevoPedido) {
        Cliente cliente = clienteRepository
                .findById(nuevoPedido.getIdCliente())
                .orElseThrow(() -> new ClienteNotFoundException(nuevoPedido.getIdCliente()));
       Producto producto = productoRepository
                .findById(nuevoPedido.getIdProducto())
                .orElseThrow(() -> new ProductoNotFoundException(nuevoPedido.getIdProducto()));
        Pedido pedido = pedidoRepository.save(
                Objects.requireNonNull(pedidoMapper.toPedido(nuevoPedido, cliente,producto)));

        GetPedidoDto pedidoGuardado = pedidoMapper.toGetPedidoDto(pedido);

        return pedidoGuardado;
    }

    // Borrar un Pedido por su ID
    @DeleteMapping("/pedidos/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deletePedidoById(@NonNull @PathVariable UUID id) {
        if (!pedidoRepository.existsById(id)) {
            throw new PedidoNotFoundException(id);
        }
        pedidoRepository.deleteById(id);
    }



}

