package co.safepet.veterinaria.service.interfaz;

import co.safepet.veterinaria.dto.*;

import java.util.List;

public interface VeterinarioService {

    Boolean registrarVeterinario(RegistroVeterinarioDTO registroVeterinarioDTO) throws Exception ;
    Boolean actualizarVeterinario(DetalleVeterinarioDTO detalleVeterinarioDTO) throws Exception ;
    List<DetalleVeterinarioDTO> listarVeterinarioDtos();
    DetalleVeterinarioDTO buscarVeterinario(String cedula) throws Exception ;
    Boolean eliminarVeterinario(String cedula) throws Exception ;



}
