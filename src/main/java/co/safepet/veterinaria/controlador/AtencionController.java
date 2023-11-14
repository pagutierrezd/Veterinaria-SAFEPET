package co.safepet.veterinaria.controlador;

import co.safepet.veterinaria.dto.DetalleClienteDTO;
import co.safepet.veterinaria.dto.RegistroAtencionDTO;
import co.safepet.veterinaria.dto.RegistroCitaDTO;
import co.safepet.veterinaria.service.interfaz.AtencionService;
import co.safepet.veterinaria.service.interfaz.CitaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/atencion")
@Validated
public class AtencionController {

    private final AtencionService atencionService;

    @GetMapping("/{cedula}")
    public ResponseEntity<List<RegistroAtencionDTO>> findAll(@PathVariable String cedula) {
        return ResponseEntity.ok(atencionService.listarAtencionDtosPorCliente(cedula));
    }

    @PostMapping()
    public ResponseEntity<Boolean> registrarAtencion(@Valid @RequestBody RegistroAtencionDTO registroAtencionDTO) throws Exception {
        return ResponseEntity.ok(atencionService.registrarAtencion(registroAtencionDTO));
    }

    @PutMapping()
    public ResponseEntity<Boolean> update(@Valid @RequestBody RegistroAtencionDTO registroAtencionDTO) throws Exception {
        return ResponseEntity.ok(atencionService.actualizarAtencion(registroAtencionDTO));
    }
}
