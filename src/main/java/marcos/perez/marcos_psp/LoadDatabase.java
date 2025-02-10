package marcos.perez.marcos_psp;

import marcos.perez.marcos_psp.entities.Cliente;
import marcos.perez.marcos_psp.entities.Pedido;
import marcos.perez.marcos_psp.entities.Producto;
import marcos.perez.marcos_psp.repositories.IClienteRepository;
import marcos.perez.marcos_psp.repositories.IPedidoRepository;
import marcos.perez.marcos_psp.repositories.IProductoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Date;
import java.util.List;

@Configuration
public class LoadDatabase {
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(IClienteRepository clienteRepository, IProductoRepository productoRepository, IPedidoRepository pedidoRepository) {
        return args -> {
            Cliente cliente1 = new Cliente("Juan Pérez", "juan.perez@example.com", new Date());
            Cliente cliente2 = new Cliente("Ana Gómez", "ana.gomez@example.com", new Date());
            clienteRepository.saveAll(List.of(cliente1, cliente2));

            Producto producto1 = new Producto("Papel", 5.00f, true);
            Producto producto2 = new Producto("Sofa", 500.00f, false);
            productoRepository.saveAll(List.of(producto1, producto2));

            Pedido pedido1 = new Pedido(2, new Date(), cliente1, producto1);
            Pedido pedido2 = new Pedido(1, new Date(), cliente2, producto2);
            Pedido pedido3 = new Pedido(5, new Date(), cliente1, producto2);
            pedidoRepository.saveAll(List.of(pedido1, pedido2, pedido3));

        };
    }

}
