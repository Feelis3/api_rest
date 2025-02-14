package marcos.perez.marcos_psp.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Date;

@Data
public class CreatePedidoDto {
    private Long idCliente;
    private Long idProducto;
    @Min(value = 1, message = "El número de unidades debe ser un valor mayor o igual a 1")
    private int numUnidades;

    public CreatePedidoDto() {}

    public CreatePedidoDto(Long idCliente, Long idProducto, int numUnidades) {
        this.idCliente = idCliente;
        this.idProducto = idProducto;
        this.numUnidades = numUnidades;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public Long getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Long idProducto) {
        this.idProducto = idProducto;
    }

    public int getNumUnidades() {
        return numUnidades;
    }

    public void setNumUnidades(int numUnidades) {
        this.numUnidades = numUnidades;
    }
}
