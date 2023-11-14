package co.safepet.veterinaria.service.impl;

import co.safepet.veterinaria.dto.RegistroCitaDTO;
import co.safepet.veterinaria.excepciones.ExcepcionPersonalizada;
import co.safepet.veterinaria.mapper.RegistroCitaMapper;
import co.safepet.veterinaria.modelo.entidades.Cita;
import co.safepet.veterinaria.modelo.enums.EstadoCita;
import co.safepet.veterinaria.repositorio.CitaRepo;
import co.safepet.veterinaria.service.interfaz.CitaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CitaServiceImpl implements CitaService {

    private final CitaRepo citaRepo;
    private final RegistroCitaMapper registroCitaMapper;
    @Override
    public Boolean registrarCita(RegistroCitaDTO registroCitaDTO) throws Exception {
        // Verificar si hay solapamiento con citas existentes
        if (haySolapamiento(registroCitaMapper.toCita(registroCitaDTO))) {
            throw new ExcepcionPersonalizada( "Ya existe una cita programada en ese horario");
        }
        Cita cita = registroCitaMapper.toCita(registroCitaDTO);
        cita.setEstadoCita(EstadoCita.PROGRAMADA);
        citaRepo.save(cita);
        return true;
    }

    @Override
    public List<RegistroCitaDTO> listarCitas() {
        return registroCitaMapper.toRegistroCitaDtos(citaRepo.findAll());
    }

    @Override
    public Boolean eliminarCita(Integer codigo) throws Exception {
        Cita cita = citaRepo.findById(codigo).get();
        cita.setEstadoCita(EstadoCita.CANCELADA);
        citaRepo.save(cita);
        return true;
    }

    private boolean haySolapamiento(Cita nuevaCita) {
        List<Cita> citasEnHorario = citaRepo.findByFechaCreacionBetweenAndEstadoCitaNot(
                nuevaCita.getFechaCreacion(),
                nuevaCita.getFechaFinalizacion(),
                EstadoCita.CANCELADA);

        // Verificar si hay solapamiento
        return !citasEnHorario.isEmpty();
    }
}
