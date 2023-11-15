package co.safepet.veterinaria.controlador;

import co.safepet.veterinaria.dto.DetalleClienteDTO;
import co.safepet.veterinaria.dto.InformacionDetalladaClienteDTO;
import co.safepet.veterinaria.dto.LoginDto;
import co.safepet.veterinaria.dto.RegistroClienteDTO;
import co.safepet.veterinaria.modelo.entidades.Cliente;
import co.safepet.veterinaria.service.interfaz.ClienteService;
import co.safepet.veterinaria.service.interfaz.SessionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/clientes")
@Validated
@CrossOrigin(origins = "http://localhost:4200")

public class ClienteController {

    private final ClienteService clienteService;
    private final SessionService sessionService;

    @GetMapping()
    public ResponseEntity<List<InformacionDetalladaClienteDTO>> findAll() {
        return ResponseEntity.ok(clienteService.listarClientes());
    }


    @GetMapping("/{cedula}")
    public ResponseEntity<DetalleClienteDTO> buscarCliente(@PathVariable String cedula) throws Exception {
        return ResponseEntity.ok(clienteService.buscarCliente(cedula));
    }

    @PostMapping()
    public ResponseEntity<Boolean> registrarCliente(@Valid @RequestBody RegistroClienteDTO registroClienteDTO) throws Exception {
        return ResponseEntity.ok(clienteService.registrarCliente(registroClienteDTO));
    }

    @PutMapping()
    public ResponseEntity<Boolean> update(@Valid @RequestBody DetalleClienteDTO detalleClienteDTO) throws Exception {
        return ResponseEntity.ok(clienteService.actualizarCliente(detalleClienteDTO));
    }

    @DeleteMapping("/{cedula}")
    public ResponseEntity<Boolean> eliminarCliente(@PathVariable String cedula) throws Exception {
        return ResponseEntity.ok(clienteService.eliminarCliente(cedula));
    }

    @PostMapping("/auth")
    public ResponseEntity<DetalleClienteDTO>login(@Validated @RequestBody LoginDto loginDto)throws Exception{
        return ResponseEntity.ok(sessionService.login(loginDto));
    }
}
