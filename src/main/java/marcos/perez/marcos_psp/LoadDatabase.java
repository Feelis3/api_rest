package marcos.perez.marcos_psp;

import marcos.perez.marcos_psp.entities.Cliente;
import marcos.perez.marcos_psp.entities.Producto;
import marcos.perez.marcos_psp.repositories.IClienteRepository;
import marcos.perez.marcos_psp.repositories.IProductoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Date;

@Configuration
public class LoadDatabase {
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(IClienteRepository clienteRepository, IProductoRepository productoRepository) {
        Cliente cliente1 = new Cliente("Juan Pérez", "juan.perez@example.com", new Date());
        Cliente cliente2 = new Cliente("Ana Gómez", "ana.gomez@example.com", new Date());
        Cliente cliente3 = new Cliente("Carlos Ruiz", "carlos.ruiz@example.com", new Date());
        Producto producto1 = new Producto("Papel", 5.00f,true);
        Producto producto2 = new Producto("Sofa", 500.00f,false);
        Producto producto3 = new Producto("Pantalla", 150.00f,true);
        return args ->{
            log.info("Cliente 1: {}", clienteRepository.save(cliente1));
            log.info("Cliente 2: {}", clienteRepository.save(cliente2));
            log.info("Cliente 3: {}", clienteRepository.save(cliente3));
            log.info("Producto 1: {}",productoRepository.save(producto1));
            log.info("Producto 2: {}",productoRepository.save(producto2));
            log.info("Producto 3: {}",productoRepository.save(producto3));
        };
    }
}
