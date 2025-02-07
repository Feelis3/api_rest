package marcos.perez.marcos_psp.repositories;

import marcos.perez.marcos_psp.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IClienteRepository
        extends JpaRepository<Cliente, Long> {

}
