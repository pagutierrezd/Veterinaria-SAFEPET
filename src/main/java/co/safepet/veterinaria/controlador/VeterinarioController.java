package co.safepet.veterinaria.controlador;

import co.safepet.veterinaria.dto.*;
import co.safepet.veterinaria.service.interfaz.ClienteService;
import co.safepet.veterinaria.service.interfaz.VeterinarioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/veterinarios")
@Validated
@CrossOrigin(origins = "http://localhost:4200")
public class VeterinarioController {

    private final VeterinarioService veterinarioService;

   @GetMapping()
    public ResponseEntity<List<DetalleVeterinarioDTO>> findAll() {
        return ResponseEntity.ok(veterinarioService.listarVeterinarioDtos());
    }


 @GetMapping("/{cedula}")
    public ResponseEntity<DetalleVeterinarioDTO> buscarVeterinario(@PathVariable String cedula) throws Exception {
        return ResponseEntity.ok(veterinarioService.buscarVeterinario(cedula));
    }

    @PostMapping()
    public ResponseEntity<Boolean> registrarVeterinario(@Valid @RequestBody RegistroVeterinarioDTO registroVeterinarioDTO) throws Exception {
        return ResponseEntity.ok(veterinarioService.registrarVeterinario(registroVeterinarioDTO));
    }

    @PutMapping()
    public ResponseEntity<Boolean> update(@Valid @RequestBody DetalleVeterinarioDTO detalleVeterinarioDTO) throws Exception {
        return ResponseEntity.ok(veterinarioService.actualizarVeterinario(detalleVeterinarioDTO));
    }

    @DeleteMapping("/{cedula}")
    public ResponseEntity<Boolean> eliminarVeterinario(@PathVariable String cedula) throws Exception {
        return ResponseEntity.ok(veterinarioService.eliminarVeterinario(cedula));
    }
}
