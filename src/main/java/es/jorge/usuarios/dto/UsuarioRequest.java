package es.jorge.usuarios.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import lombok.NonNull;

@Data
public class UsuarioRequest {


    @NotBlank
    private String nombre;

    @Positive
    private Integer edad;

    @NotBlank
    private String fechaNacimiento;

    @Positive
    private double peso;

    @NotBlank
    private String contrasenna;
}
