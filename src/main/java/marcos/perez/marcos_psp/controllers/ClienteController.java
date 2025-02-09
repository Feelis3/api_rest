package marcos.perez.marcos_psp.controllers;

import jakarta.validation.Valid;
import marcos.perez.marcos_psp.dtos.CreateClienteDto;
import marcos.perez.marcos_psp.entities.Cliente;
import marcos.perez.marcos_psp.exceptions.ClienteNotFoundException;
import marcos.perez.marcos_psp.mappers.ClienteMapper;
import marcos.perez.marcos_psp.repositories.IClienteRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
public class ClienteController {

    //Repositorio Cliente
    private final IClienteRepository repository;
    //Mapper Cliente
    private final ClienteMapper mapper;
    public ClienteController(IClienteRepository repository, ClienteMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @GetMapping("/clientes")
    List<Cliente> getClientes() {
        List<Cliente> clientes = repository.findAll();
        return clientes;
    }


    // Obtener un empleado por su ID (si existe)
    @GetMapping("/clientes/{id}")
    Cliente getClienteById(@NonNull @PathVariable Long id) {
        return repository
                .findById(id)
                .orElseThrow(() -> new ClienteNotFoundException(id));
    }

    //Crea cliente
    @PostMapping("/clientes")
    @ResponseStatus(code = HttpStatus.CREATED)
    Cliente postCliente(@NonNull @Valid @RequestBody CreateClienteDto createClienteDto) {
        Cliente cliente = mapper.toCliente(createClienteDto);
        return repository.save(Objects.requireNonNull(cliente));
    }

    //Actualiza cliente
    @PutMapping("/clientes/{id}")
    ResponseEntity<Cliente> putClienteId(
            @NonNull @Valid @RequestBody CreateClienteDto createClienteDto,
            @NonNull @PathVariable Long id) {
        return repository
                .findById(id)
                .map(cliente -> {
                    cliente.setNombre(createClienteDto.getNombre());
                    cliente.setEmail(createClienteDto.getEmail());
                    cliente.setFechaNacimiento(createClienteDto.getFechaNacimiento());

                    return new ResponseEntity<Cliente>(repository.save(cliente), HttpStatus.OK);
                })
                .orElseGet(() -> {
                    Cliente nuevoCliente = mapper.toCliente(createClienteDto);
                    return new ResponseEntity<Cliente>(repository.save(Objects.requireNonNull(nuevoCliente)),
                            HttpStatus.CREATED);
                });
    }

}
