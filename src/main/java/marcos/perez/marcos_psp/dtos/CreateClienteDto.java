package marcos.perez.marcos_psp.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

@ToString
@Data
public class CreateClienteDto {
    @NotBlank(message = "nombre es obligatorio")
    private String nombre;

    @NotBlank(message = "email es obligatorio")
    private String email;

    @JsonFormat(pattern = "dd/MM/yyyy")
    @Temporal(TemporalType.DATE)
    @NotBlank(message = "fecha nacimiento es obligatorio")
    private Date fechaNacimiento;

    public CreateClienteDto() {}

    public CreateClienteDto(String nombre, String email, Date fechaNacimiento) {
        this.nombre = nombre;
        this.email = email;
        this.fechaNacimiento = fechaNacimiento;
    }

    public @NotBlank(message = "nombre es obligatorio") String getNombre() {
        return nombre;
    }

    public void setNombre(@NotBlank(message = "nombre es obligatorio") String nombre) {
        this.nombre = nombre;
    }

    public @NotBlank(message = "email es obligatorio") String getEmail() {
        return email;
    }

    public void setEmail(@NotBlank(message = "email es obligatorio") String email) {
        this.email = email;
    }

    public @NotBlank(message = "fecha nacimiento es obligatorio") Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(@NotBlank(message = "fecha nacimiento es obligatorio") Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
}
