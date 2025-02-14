package marcos.perez.marcos_psp.dtos;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CreateProductoDto {
    @NotBlank(message = "nombre es obligatorio")
    private String nombre;

    @NotNull(message = "precio es obligatorio")
    @DecimalMin(value = "0.0", inclusive = true, message = "El precio debe ser un valor mayor o igual a 0")
    private float precio;

    @NotNull(message = "stock es obligatorio")
    private boolean enStock;

    public CreateProductoDto() {}

    public CreateProductoDto(String nombre, float precio, boolean enStock) {
        this.nombre = nombre;
        this.precio = precio;
        this.enStock = enStock;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public boolean isEnStock() {
        return enStock;
    }

    public void setEnStock(boolean enStock) {
        this.enStock = enStock;
    }
}
