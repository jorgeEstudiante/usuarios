package es.jorge.usuarios.dto;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class UsuarioDTO {
    private Integer id;
    private String nombre;
    private Integer edad;
    private String fechaNacimiento;
    private double peso;
}
