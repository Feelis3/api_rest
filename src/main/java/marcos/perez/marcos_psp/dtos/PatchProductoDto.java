package marcos.perez.marcos_psp.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)  // Ignorar campos nulos en la conversión JSON
public class PatchProductoDto {
    private String nombre;
    private Float precio;
    private Boolean enStock;

    public PatchProductoDto() {}

    public PatchProductoDto(String nombre, Float precio, Boolean enStock) {
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

    public Float getPrecio() {
        return precio;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
    }

    public Boolean getEnStock() {
        return enStock;
    }

    public void setEnStock(Boolean enStock) {
        this.enStock = enStock;
    }
}
