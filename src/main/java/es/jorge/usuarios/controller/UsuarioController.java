package es.jorge.usuarios.controller;

import es.jorge.usuarios.dto.UsuarioDTO;
import es.jorge.usuarios.dto.UsuarioRequest;
import es.jorge.usuarios.model.UsuarioModel;
import es.jorge.usuarios.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/vehiculos")
public class UsuarioController {
    @Autowired
    private UsuarioService vService;

    //crud
    @PostMapping
    public ResponseEntity<UsuarioDTO> pUsuario(@Valid @RequestBody UsuarioRequest v){
        try{
            return ResponseEntity.status(201).body(vService.pUsuario(v));
        }catch(Exception e){
            return new ResponseEntity("errorr al agregar usuario", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public ResponseEntity<List<UsuarioModel>> gUsuario(){
        try{
            return ResponseEntity.status(200).body(vService.gUsuario());
        }catch(Exception e){
            return new ResponseEntity("errorr al listar usuarios", HttpStatus.BAD_REQUEST);
        }
    }


    @GetMapping("{id}")
    public ResponseEntity<UsuarioDTO> gxUsuario(@PathVariable Integer id){
        try{
            return ResponseEntity.status(200).body(vService.gxUsuario(id));
        }catch(Exception e){
            return new ResponseEntity("errorr al encontrar el usuario", HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<String> puUsuario(@PathVariable Integer id, @Valid @RequestBody UsuarioModel v){
        try{
            return ResponseEntity.status(200).body(vService.puUsuario(v));
        }catch(Exception e){
            return new ResponseEntity("errorr al actualizar el vehiculo", HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> dUsuario(@PathVariable Integer id){
        try{
            return ResponseEntity.status(200).body(vService.dUsuario(id));
        }catch(Exception e){
            return new ResponseEntity("errorr al eliminar el vehiculo", HttpStatus.BAD_REQUEST);
        }
    }

    // la que faltaba
    /*@GetMapping("libres")
    public ResponseEntity<List<UsuarioDTO>> libreVehiculos(){
        try{
            return ResponseEntity.status(200).body(vService.libreVehiculos());
        }catch(Exception e){
            return new ResponseEntity("errorr al listar los vehiculos", HttpStatus.BAD_REQUEST);
        }
    }*/

}
