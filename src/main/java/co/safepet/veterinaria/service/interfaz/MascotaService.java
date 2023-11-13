package co.safepet.veterinaria.service.interfaz;

import co.safepet.veterinaria.dto.*;
import co.safepet.veterinaria.modelo.entidades.Cliente;
import jakarta.persistence.criteria.CriteriaBuilder;

import java.util.List;

public interface MascotaService {

    Boolean registrarMascota(RegistroMascotaDTO registroMascotaDTO) throws Exception ;
    Boolean actualizarMascota(DetalleMascotaDTO detalleMascotaDTO) throws Exception ;
    List<DetalleMascotaDTO> listarMascotas();
    DetalleMascotaDTO buscarMascota(Integer codigo) throws Exception ;
    Boolean eliminarMascota(Integer codigo) throws Exception ;



}
