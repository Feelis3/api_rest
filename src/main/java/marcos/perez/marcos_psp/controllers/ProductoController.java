package marcos.perez.marcos_psp.controllers;

import jakarta.validation.Valid;
import marcos.perez.marcos_psp.dtos.CreateClienteDto;
import marcos.perez.marcos_psp.dtos.CreateProductoDto;
import marcos.perez.marcos_psp.dtos.PatchProductoDto;
import marcos.perez.marcos_psp.entities.Cliente;
import marcos.perez.marcos_psp.entities.Producto;
import marcos.perez.marcos_psp.exceptions.ClienteNotFoundException;
import marcos.perez.marcos_psp.exceptions.ProductoNotFoundException;
import marcos.perez.marcos_psp.mappers.ClienteMapper;
import marcos.perez.marcos_psp.mappers.ProductoMapper;
import marcos.perez.marcos_psp.repositories.IClienteRepository;
import marcos.perez.marcos_psp.repositories.IProductoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
public class ProductoController {
    //Repositorio Cliente
    private final IProductoRepository repository;
    //Mapper Cliente
    private final ProductoMapper mapper;
    public ProductoController(IProductoRepository repository, ProductoMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @GetMapping("/productos")
    List<Producto> getProductos() {
        List<Producto> productos = repository.findAll();
        return productos;
    }

    // Obtener un producto por su ID (si existe)
    @GetMapping("/productos/{id}")
    Producto getProductoId(@NonNull @PathVariable Long id) {
        return repository
                .findById(id)
                .orElseThrow(() -> new ProductoNotFoundException(id));
    }

    //Crea Producto
    @PostMapping("/productos")
    @ResponseStatus(code = HttpStatus.CREATED)
    Producto postProducto(@NonNull @Valid @RequestBody CreateProductoDto createProductoDto) {
        Producto producto = mapper.toProducto(createProductoDto);
        return repository.save(Objects.requireNonNull(producto));
    }

    @PatchMapping("/productos/{id}")
    public ResponseEntity<Producto> patchProducto(@PathVariable Long id, @RequestBody PatchProductoDto dto) {
        return repository.findById(id)
                .map(producto -> {
                    if (dto.getNombre() != null) {
                        producto.setNombre(dto.getNombre());
                    }
                    if (dto.getPrecio() != null) {
                        producto.setPrecio(dto.getPrecio());
                    }
                    if (dto.getEnStock() != null) {
                        producto.setEnStock(dto.getEnStock());
                    }
                    return ResponseEntity.ok(repository.save(producto));
                })
                .orElseThrow(() -> new ProductoNotFoundException(id));
    }

    // Borrar un Producto por su ID
    @DeleteMapping("/productos/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteEmpleadoById(@NonNull @PathVariable Long id) {
        if (!repository.existsById(id)) {
            throw new ProductoNotFoundException(id);
        }
        repository.deleteById(id);
    }


}
