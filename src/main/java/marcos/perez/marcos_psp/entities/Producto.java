package marcos.perez.marcos_psp.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Data
public class Producto {
    @Id
    @GeneratedValue
    private Long id;

    @NotNull(message = "nombre es obligatorio")
    private String nombre;

    @NotNull(message = "precio es obligatorio")
    private float precio;

    @NotNull(message = "stock es obligatorio")
    private boolean enStock;

    public Producto() {}
    public Producto(String nombre, float precio, boolean enStock) {
        this.nombre = nombre;
        this.precio = precio;
        this.enStock = enStock;
    }
}
