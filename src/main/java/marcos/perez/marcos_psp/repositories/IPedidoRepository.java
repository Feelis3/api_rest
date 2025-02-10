package marcos.perez.marcos_psp.repositories;

import marcos.perez.marcos_psp.entities.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IPedidoRepository
        extends JpaRepository<Pedido, Long> {
    List<Pedido> findByCliente_Id(Long id);
}
