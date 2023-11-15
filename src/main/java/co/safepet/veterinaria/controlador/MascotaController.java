package co.safepet.veterinaria.controlador;

import co.safepet.veterinaria.dto.*;
import co.safepet.veterinaria.modelo.entidades.Cliente;
import co.safepet.veterinaria.service.interfaz.ClienteService;
import co.safepet.veterinaria.service.interfaz.MascotaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/mascotas")
@Validated
@CrossOrigin(origins = "http://localhost:4200")
public class MascotaController {

    private final MascotaService mascotaService;

    @GetMapping()
    public ResponseEntity<List<DetalleMascotaDTO>> findAll() {
        return ResponseEntity.ok(mascotaService.listarMascotas());
    }


   @GetMapping("/{codigo}")
    public ResponseEntity<DetalleMascotaDTO> buscarCliente(@PathVariable Integer codigo) throws Exception {
        return ResponseEntity.ok(mascotaService.buscarMascota(codigo));
    }

    @PostMapping()
    public ResponseEntity<Boolean> registrarMascota(@Valid @RequestBody RegistroMascotaDTO registroMascotaDTO) throws Exception {
        return ResponseEntity.ok(mascotaService.registrarMascota(registroMascotaDTO));
    }

    @PutMapping()
    public ResponseEntity<Boolean> update(@Valid @RequestBody DetalleMascotaDTO detalleMascotaDTO) throws Exception {
        return ResponseEntity.ok(mascotaService.actualizarMascota(detalleMascotaDTO));
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity<Boolean> eliminarCliente(@PathVariable Integer codigo) throws Exception {
        return ResponseEntity.ok(mascotaService.eliminarMascota(codigo));
    }
}
