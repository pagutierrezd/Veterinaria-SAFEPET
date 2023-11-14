package co.safepet.veterinaria.controlador;

import co.safepet.veterinaria.dto.DetalleClienteDTO;
import co.safepet.veterinaria.dto.InformacionDetalladaClienteDTO;
import co.safepet.veterinaria.dto.RegistroCitaDTO;
import co.safepet.veterinaria.dto.RegistroClienteDTO;
import co.safepet.veterinaria.service.interfaz.CitaService;
import co.safepet.veterinaria.service.interfaz.ClienteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/citas")
@Validated
public class CitaController {

    private final CitaService citaService;

    @GetMapping()
    public ResponseEntity<List<RegistroCitaDTO>> findAll() {
        return ResponseEntity.ok(citaService.listarCitas());
    }


    @PostMapping()
    public ResponseEntity<Boolean> registrarCita(@Valid @RequestBody RegistroCitaDTO registroCitaDTO) throws Exception {
        return ResponseEntity.ok(citaService.registrarCita(registroCitaDTO));
    }


    @DeleteMapping("/{codigo}")
    public ResponseEntity<Boolean> eliminarCita(@PathVariable Integer codigo) throws Exception {
        return ResponseEntity.ok(citaService.eliminarCita(codigo));
    }
}
