package marcos.perez.marcos_psp.entities;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.Date;

@Data // Genera automáticamente getters, setters, toString, equals, y hashCode
@NoArgsConstructor // Genera un constructor sin argumentos
public class Prueba {
    @NonNull
    private String nombre;

    @NonNull
    private String email;

    @NonNull
    private Date fechaNacimiento;
}