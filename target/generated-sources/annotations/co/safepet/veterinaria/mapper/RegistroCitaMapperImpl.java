package co.safepet.veterinaria.mapper;

import co.safepet.veterinaria.dto.RegistroCitaDTO;
import co.safepet.veterinaria.modelo.entidades.Cita;
import co.safepet.veterinaria.modelo.entidades.Cliente;
import co.safepet.veterinaria.modelo.entidades.Veterinario;
import co.safepet.veterinaria.modelo.enums.Especialidad;
import co.safepet.veterinaria.modelo.enums.EstadoCita;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-11-15T09:16:49-0500",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.6 (Oracle Corporation)"
)
@Component
public class RegistroCitaMapperImpl implements RegistroCitaMapper {

    @Override
    public RegistroCitaDTO toRegistroCitaMapper(Cita cita) {
        if ( cita == null ) {
            return null;
        }

        LocalDateTime fechaCreacion = null;
        LocalDateTime fechaFinalizacion = null;
        String especialidad = null;
        String identificacionCliente = null;
        String observacion = null;
        Integer codigo = null;
        String estadoCita = null;
        String identificacionVeterinario = null;

        fechaCreacion = cita.getFechaCreacion();
        fechaFinalizacion = cita.getFechaFinalizacion();
        if ( cita.getEspecialidad() != null ) {
            especialidad = cita.getEspecialidad().name();
        }
        identificacionCliente = citaClienteCedula( cita );
        observacion = cita.getObservacion();
        codigo = cita.getCodigo();
        if ( cita.getEstadoCita() != null ) {
            estadoCita = cita.getEstadoCita().name();
        }
        identificacionVeterinario = citaVeterinarioCedula( cita );

        RegistroCitaDTO registroCitaDTO = new RegistroCitaDTO( codigo, estadoCita, fechaCreacion, fechaFinalizacion, especialidad, identificacionCliente, identificacionVeterinario, observacion );

        return registroCitaDTO;
    }

    @Override
    public Cita toCita(RegistroCitaDTO registroCitaDTO) {
        if ( registroCitaDTO == null ) {
            return null;
        }

        Cita cita = new Cita();

        cita.setCliente( registroCitaDTOToCliente( registroCitaDTO ) );
        cita.setVeterinario( registroCitaDTOToVeterinario( registroCitaDTO ) );
        cita.setFechaCreacion( registroCitaDTO.fechaCreacion() );
        cita.setFechaFinalizacion( registroCitaDTO.fechaFinalizacion() );
        if ( registroCitaDTO.especialidad() != null ) {
            cita.setEspecialidad( Enum.valueOf( Especialidad.class, registroCitaDTO.especialidad() ) );
        }
        cita.setObservacion( registroCitaDTO.observacion() );
        cita.setCodigo( registroCitaDTO.codigo() );
        if ( registroCitaDTO.estadoCita() != null ) {
            cita.setEstadoCita( Enum.valueOf( EstadoCita.class, registroCitaDTO.estadoCita() ) );
        }

        return cita;
    }

    @Override
    public List<RegistroCitaDTO> toRegistroCitaDtos(List<Cita> citas) {
        if ( citas == null ) {
            return null;
        }

        List<RegistroCitaDTO> list = new ArrayList<RegistroCitaDTO>( citas.size() );
        for ( Cita cita : citas ) {
            list.add( toRegistroCitaMapper( cita ) );
        }

        return list;
    }

    private String citaClienteCedula(Cita cita) {
        if ( cita == null ) {
            return null;
        }
        Cliente cliente = cita.getCliente();
        if ( cliente == null ) {
            return null;
        }
        String cedula = cliente.getCedula();
        if ( cedula == null ) {
            return null;
        }
        return cedula;
    }

    private String citaVeterinarioCedula(Cita cita) {
        if ( cita == null ) {
            return null;
        }
        Veterinario veterinario = cita.getVeterinario();
        if ( veterinario == null ) {
            return null;
        }
        String cedula = veterinario.getCedula();
        if ( cedula == null ) {
            return null;
        }
        return cedula;
    }

    protected Cliente registroCitaDTOToCliente(RegistroCitaDTO registroCitaDTO) {
        if ( registroCitaDTO == null ) {
            return null;
        }

        Cliente cliente = new Cliente();

        cliente.setCedula( registroCitaDTO.identificacionCliente() );

        return cliente;
    }

    protected Veterinario registroCitaDTOToVeterinario(RegistroCitaDTO registroCitaDTO) {
        if ( registroCitaDTO == null ) {
            return null;
        }

        Veterinario veterinario = new Veterinario();

        veterinario.setCedula( registroCitaDTO.identificacionVeterinario() );

        return veterinario;
    }
}
