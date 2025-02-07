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
    @GeneratedValue
    private UUID id;

    @NotNull(message = "unidades es obligatorio")
    private int numUnidades;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    @Temporal(TemporalType.DATE)
    @NotBlank(message = "fecha nacimiento es obligatorio")
    private Date fechaHoraPedido;

    @ManyToOne(optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Cliente cliente;

    @ManyToOne(optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Pedido pedido;

    public Pedido() {}
    public Pedido(int numUnidades, Date fechaHoraPedido, Cliente cliente, Pedido pedido) {
        this.numUnidades = numUnidades;
        this.fechaHoraPedido = fechaHoraPedido;
        this.cliente = cliente;
        this.pedido = pedido;
    }

}