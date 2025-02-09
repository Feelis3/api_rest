package marcos.perez.marcos_psp.mappers;


import io.micrometer.common.lang.NonNull;
import marcos.perez.marcos_psp.dtos.CreateClienteDto;
import marcos.perez.marcos_psp.dtos.CreateProductoDto;
import marcos.perez.marcos_psp.entities.Cliente;
import marcos.perez.marcos_psp.entities.Producto;
import org.springframework.stereotype.Component;

@Component
public class ProductoMapper {
    public Producto toProducto(@NonNull CreateProductoDto createProductoDto) {
        return new Producto(
                createProductoDto.getNombre(),
                createProductoDto.getPrecio(),
                createProductoDto.isEnStock()
        );
    }
}
