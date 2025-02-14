package marcos.perez.marcos_psp.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import marcos.perez.marcos_psp.entities.Cliente;
import marcos.perez.marcos_psp.entities.Pedido;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.Date;
import java.util.UUID;

@Data
public class GetPedidoDto {
    private UUID id;
    private Integer numUnidades;
    private Date fechaHoraPedido;
    private Long cliente;
    private Long producto;

    public GetPedidoDto() {}
    public GetPedidoDto(UUID id,Integer numUnidades,Date fechaHoraPedido,Long cliente,Long producto) {
        this.id = id;
        this.numUnidades = numUnidades;
        this.fechaHoraPedido = fechaHoraPedido;
        this.cliente = cliente;
        this.producto = producto;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Integer getNumUnidades() {
        return numUnidades;
    }

    public void setNumUnidades(Integer numUnidades) {
        this.numUnidades = numUnidades;
    }

    public Date getFechaHoraPedido() {
        return fechaHoraPedido;
    }

    public void setFechaHoraPedido(Date fechaHoraPedido) {
        this.fechaHoraPedido = fechaHoraPedido;
    }

    public Long getCliente() {
        return cliente;
    }

    public void setCliente(Long cliente) {
        this.cliente = cliente;
    }

    public Long getProducto() {
        return producto;
    }

    public void setProducto(Long producto) {
        this.producto = producto;
    }

    @Override
    public String toString() {
        return "GetPedidoDto{" +
                "id=" + id +
                ", numUnidades=" + numUnidades +
                ", fechaHoraPedido=" + fechaHoraPedido +
                ", cliente=" + cliente +
                ", producto=" + producto +
                '}';
    }
}
