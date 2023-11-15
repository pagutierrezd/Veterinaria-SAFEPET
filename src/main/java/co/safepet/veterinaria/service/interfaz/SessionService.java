package co.safepet.veterinaria.service.interfaz;

import co.safepet.veterinaria.dto.DetalleClienteDTO;
import co.safepet.veterinaria.dto.LoginDto;
import co.safepet.veterinaria.dto.RegistroClienteDTO;

public interface SessionService {

    DetalleClienteDTO login(LoginDto loginDto) throws Exception;
}
