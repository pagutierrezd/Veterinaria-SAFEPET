package co.safepet.veterinaria.service.interfaz;

import co.safepet.veterinaria.dto.RegistroAtencionDTO;
import co.safepet.veterinaria.dto.RegistroCitaDTO;

import java.util.List;

public interface AtencionService {

    Boolean registrarAtencion(RegistroAtencionDTO registroAtencionDTO) throws Exception ;
    Boolean actualizarAtencion(RegistroAtencionDTO registroAtencionDTO) throws Exception ;

    List<RegistroAtencionDTO> listarAtencionDtosPorCliente(String cedula);



}
