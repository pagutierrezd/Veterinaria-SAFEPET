package co.safepet.veterinaria.service.impl;

import co.safepet.veterinaria.dto.DetalleClienteDTO;
import co.safepet.veterinaria.dto.LoginDto;
import co.safepet.veterinaria.mapper.ActualizacionClienteMapper;
import co.safepet.veterinaria.modelo.entidades.Cliente;
import co.safepet.veterinaria.repositorio.ClienteRepo;
import co.safepet.veterinaria.service.interfaz.SessionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SessionServiceImpl implements SessionService {

    private final ClienteRepo clienteRepo;
    private final ActualizacionClienteMapper actualizacionClienteMapper;

    @Override
    public DetalleClienteDTO login(LoginDto loginDto) throws Exception {
        return actualizacionClienteMapper.toDetalleClienteDto(clienteRepo.findClienteByCorreoAndPassword(loginDto.email(),loginDto.password()));

    }
}
