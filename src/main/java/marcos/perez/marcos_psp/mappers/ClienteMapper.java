package marcos.perez.marcos_psp.mappers;

import io.micrometer.common.lang.NonNull;
import marcos.perez.marcos_psp.dtos.CreateClienteDto;
import marcos.perez.marcos_psp.entities.Cliente;
import org.springframework.stereotype.Component;

@Component
public class ClienteMapper {
    public Cliente toCliente(@NonNull CreateClienteDto createClienteDto) {
        return new Cliente(
                createClienteDto.getNombre(),
                createClienteDto.getEmail(),
                createClienteDto.getFechaNacimiento()
        );
    }
}

