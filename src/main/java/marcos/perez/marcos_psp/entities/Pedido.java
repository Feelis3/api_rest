package marcos.perez.marcos_psp.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.Date;
import java.util.UUID;

@Entity
@Data
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @NotNull(message = "unidades es obligatorio")
    private Integer numUnidades;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    @Temporal(TemporalType.DATE)
    @NotNull(message = "fecha nacimiento es obligatorio")
    private Date fechaHoraPedido;

    @ManyToOne(optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Cliente cliente;

    @ManyToOne(optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Producto producto;

    public Pedido() {}
    public Pedido(int numUnidades, Date fechaHoraPedido, Cliente cliente, Producto producto) {

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

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "id=" + id +
                ", numUnidades=" + numUnidades +
                ", fechaHoraPedido=" + fechaHoraPedido +
                ", cliente=" + cliente +
                ", producto=" + producto +
                '}';
    }
}