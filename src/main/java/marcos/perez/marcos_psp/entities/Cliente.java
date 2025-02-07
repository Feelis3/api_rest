package marcos.perez.marcos_psp.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class Cliente {
    @Id
    @GeneratedValue
    private Long id;

    @NotNull(message = "nombre es obligatorio")
    private String nombre;

    @NotNull(message = "email es obligatorio")
    private String email;

    @JsonFormat(pattern = "dd/MM/yyyy")
    @Temporal(TemporalType.DATE)
    @NotNull(message = "fecha nacimiento es obligatorio")
    private Date fechaNacimiento;

    public Cliente() {}

    public Cliente(String nombre, String email, Date fechaNacimiento) {
        this.nombre = nombre;
        this.email = email;
        this.fechaNacimiento = fechaNacimiento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotNull(message = "nombre es obligatorio") String getNombre() {
        return nombre;
    }

    public void setNombre(@NotNull(message = "nombre es obligatorio") String nombre) {
        this.nombre = nombre;
    }

    public @NotNull(message = "email es obligatorio") String getEmail() {
        return email;
    }

    public void setEmail(@NotNull(message = "email es obligatorio") String email) {
        this.email = email;
    }

    public @NotNull(message = "fecha nacimiento es obligatorio") Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(@NotNull(message = "fecha nacimiento es obligatorio") Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", email='" + email + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                '}';
    }
}

