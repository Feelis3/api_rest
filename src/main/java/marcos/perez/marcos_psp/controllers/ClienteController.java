package marcos.perez.marcos_psp.controllers;

import marcos.perez.marcos_psp.entities.Cliente;
import marcos.perez.marcos_psp.exceptions.ClienteNotFoundException;
import marcos.perez.marcos_psp.mappers.ClienteMapper;
import marcos.perez.marcos_psp.repositories.IClienteRepository;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

}
