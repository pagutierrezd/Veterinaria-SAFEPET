package co.safepet.veterinaria.service.interfaz;

import co.safepet.veterinaria.dto.RegistroCitaDTO;

import java.util.List;

public interface CitaService {

    Boolean registrarCita(RegistroCitaDTO registroCitaDTO) throws Exception ;
    List<RegistroCitaDTO> listarCitas();
    Boolean eliminarCita(Integer codigo) throws Exception ;


}
