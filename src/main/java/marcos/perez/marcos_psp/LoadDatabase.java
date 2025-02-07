package marcos.perez.marcos_psp;

import marcos.perez.marcos_psp.entities.Cliente;
import marcos.perez.marcos_psp.repositories.IClienteRepository;
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
    CommandLineRunner initDatabase(IClienteRepository clienteRepository) {
        Cliente cliente1 = new Cliente("Juan Pérez", "juan.perez@example.com", new Date());
        Cliente cliente2 = new Cliente("Ana Gómez", "ana.gomez@example.com", new Date());
        Cliente cliente3 = new Cliente("Carlos Ruiz", "carlos.ruiz@example.com", new Date());
        return args ->{
            log.info("Cliente 1: {}", clienteRepository.save(cliente1));
            log.info("Cliente 2: {}", clienteRepository.save(cliente2));
            log.info("Cliente 3: {}", clienteRepository.save(cliente3));
        };
    }
}
