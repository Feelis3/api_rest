package marcos.perez.marcos_psp.entities;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.Date;

@Data // Genera automáticamente getters, setters, toString, equals, y hashCode
public class Prueba {
    @NonNull
    private String nombre;

    @NonNull
    private String email;

    @NonNull
    private Date fechaNacimiento;
}