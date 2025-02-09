package marcos.perez.marcos_psp.repositories;

import marcos.perez.marcos_psp.entities.Cliente;
import marcos.perez.marcos_psp.entities.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductoRepository
        extends JpaRepository<Producto, Long> {
}
