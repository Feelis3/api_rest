package marcos.perez.marcos_psp.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Date;

@Data
public class CreatePedidoDto {
    @NotNull(message = "unidades es obligatorio")
    private int numUnidades;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    @Temporal(TemporalType.DATE)
    @NotBlank(message = "fecha nacimiento es obligatorio")
    private Date fechaHoraPedido;

    public CreatePedidoDto() {}
    public CreatePedidoDto(int numUnidades, Date fechaHoraPedido) {
        this.numUnidades = numUnidades;
        this.fechaHoraPedido = fechaHoraPedido;
    }

    public int getNumUnidades() {
        return numUnidades;
    }

    public void setNumUnidades(int numUnidades) {
        this.numUnidades = numUnidades;
    }

    public Date getFechaHoraPedido() {
        return fechaHoraPedido;
    }

    public void setFechaHoraPedido(Date fechaHoraPedido) {
        this.fechaHoraPedido = fechaHoraPedido;
    }
}
