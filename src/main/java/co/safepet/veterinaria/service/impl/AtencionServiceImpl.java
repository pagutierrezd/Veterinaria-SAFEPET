package co.safepet.veterinaria.service.impl;

import co.safepet.veterinaria.dto.RegistroAtencionDTO;
import co.safepet.veterinaria.mapper.RegistroAtencionMapper;
import co.safepet.veterinaria.modelo.entidades.Atencion;
import co.safepet.veterinaria.modelo.entidades.Cita;
import co.safepet.veterinaria.modelo.enums.EstadoCita;
import co.safepet.veterinaria.repositorio.AtencionRepo;
import co.safepet.veterinaria.repositorio.CitaRepo;
import co.safepet.veterinaria.service.interfaz.AtencionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class AtencionServiceImpl implements AtencionService {

    private final AtencionRepo atencionRepo;
    private final CitaRepo citaRepo;
    private final RegistroAtencionMapper registroAtencionMapper;

    @Override
    public Boolean registrarAtencion(RegistroAtencionDTO registroAtencionDTO) throws Exception {
        Cita  citaExistente =  citaRepo.findById(registroAtencionDTO.codigoCita()).get();
        Atencion atencion = atencionRepo.save(registroAtencionMapper.toAtencion(registroAtencionDTO));
        citaExistente.setAtencion(atencion);
        citaExistente.setEstadoCita(EstadoCita.COMPLETADA);
        citaRepo.save(citaExistente);
        return true;
    }

    @Override
    public Boolean actualizarAtencion(RegistroAtencionDTO registroAtencionDTO) throws Exception {

        Atencion atencion= atencionRepo.findById(registroAtencionDTO.codigo()).get();
        atencion.setDiagnostico(registroAtencionDTO.diagnostico());
        atencion.setTratamiento(registroAtencionDTO.tratamiento());
        atencion.setNotasMedicas(registroAtencionDTO.notasMedicas());
        atencionRepo.save(atencion);
        return true;
    }

    @Override
    public List<RegistroAtencionDTO> listarAtencionDtosPorCliente(String cedula) {
        return registroAtencionMapper.toRegistroAtencionDtos(atencionRepo.listaAtencionCliente(cedula));
    }
}
