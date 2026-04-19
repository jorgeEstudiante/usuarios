package es.jorge.usuarios.service;

import es.jorge.usuarios.dto.UsuarioDTO;
import es.jorge.usuarios.dto.UsuarioRequest;
import es.jorge.usuarios.model.UsuarioModel;
import es.jorge.usuarios.repository.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository vRepository;

    public UsuarioDTO pUsuario(@Valid UsuarioRequest v) {
        UsuarioModel u = new UsuarioModel();
        u.setNombre(v.getNombre());
        u.setEdad(v.getEdad());
        u.setFechaNacimiento(v.getFechaNacimiento());
        u.setPeso(v.getPeso());
        u.setContrasenna(v.getContrasenna());
        UsuarioModel guardado = vRepository.save(u);
        return convertirADTO(guardado);
    }

    private UsuarioDTO convertirADTO(UsuarioModel v) {
        UsuarioDTO dto = new UsuarioDTO();
        dto.setNombre(v.getNombre());
        dto.setEdad(v.getEdad());
        dto.setFechaNacimiento(v.getFechaNacimiento());
        dto.setPeso(v.getPeso());
        return dto;
    }

    public List<UsuarioModel> gUsuario() {
        return vRepository.findAll();
    }

    public UsuarioDTO gxUsuario(Integer id) {
        return vRepository.findById(id)
                .map(this::convertirADTO)
                .orElse(null);
    }

    public String puUsuario(@Valid UsuarioModel v) {
        vRepository.save(v);
        return "usuario actualizado";
    }

    public String dUsuario(Integer id) {
        vRepository.deleteById(id);
        return "usuario eliminado";
    }

    /*public List<UsuarioDTO> libreVehiculos() {
        return vRepository.libreVehiculos();

    }*/
}
