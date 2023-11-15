package co.safepet.veterinaria.mapper;

import co.safepet.veterinaria.dto.RegistroMascotaDTO;
import co.safepet.veterinaria.modelo.entidades.Cliente;
import co.safepet.veterinaria.modelo.entidades.Mascota;
import co.safepet.veterinaria.modelo.enums.Especie;
import co.safepet.veterinaria.modelo.enums.Raza;
import co.safepet.veterinaria.modelo.enums.Sexo;
import java.time.LocalDate;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-11-14T23:44:50-0500",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.6 (Oracle Corporation)"
)
@Component
public class RegistroMascotaMapperImpl implements RegistroMascotaMapper {

    @Override
    public RegistroMascotaDTO toRegistroMascotaDto(Mascota mascota) {
        if ( mascota == null ) {
            return null;
        }

        String nombre = null;
        LocalDate fechaNacimiento = null;
        String observacion = null;
        String sexo = null;
        String especie = null;
        String raza = null;
        String edad = null;
        String identificacionCliente = null;

        nombre = mascota.getNombre();
        fechaNacimiento = mascota.getFechaNacimiento();
        observacion = mascota.getObservacion();
        if ( mascota.getSexo() != null ) {
            sexo = mascota.getSexo().name();
        }
        if ( mascota.getEspecie() != null ) {
            especie = mascota.getEspecie().name();
        }
        if ( mascota.getRaza() != null ) {
            raza = mascota.getRaza().name();
        }
        edad = mascota.getEdad();
        identificacionCliente = mascotaClienteCedula( mascota );

        RegistroMascotaDTO registroMascotaDTO = new RegistroMascotaDTO( nombre, fechaNacimiento, observacion, sexo, especie, raza, edad, identificacionCliente );

        return registroMascotaDTO;
    }

    @Override
    public Mascota toMascota(RegistroMascotaDTO registroMascotaDTO) {
        if ( registroMascotaDTO == null ) {
            return null;
        }

        Mascota mascota = new Mascota();

        mascota.setCliente( registroMascotaDTOToCliente( registroMascotaDTO ) );
        mascota.setNombre( registroMascotaDTO.nombre() );
        mascota.setFechaNacimiento( registroMascotaDTO.fechaNacimiento() );
        mascota.setObservacion( registroMascotaDTO.observacion() );
        if ( registroMascotaDTO.sexo() != null ) {
            mascota.setSexo( Enum.valueOf( Sexo.class, registroMascotaDTO.sexo() ) );
        }
        if ( registroMascotaDTO.especie() != null ) {
            mascota.setEspecie( Enum.valueOf( Especie.class, registroMascotaDTO.especie() ) );
        }
        if ( registroMascotaDTO.raza() != null ) {
            mascota.setRaza( Enum.valueOf( Raza.class, registroMascotaDTO.raza() ) );
        }
        mascota.setEdad( registroMascotaDTO.edad() );

        return mascota;
    }

    private String mascotaClienteCedula(Mascota mascota) {
        if ( mascota == null ) {
            return null;
        }
        Cliente cliente = mascota.getCliente();
        if ( cliente == null ) {
            return null;
        }
        String cedula = cliente.getCedula();
        if ( cedula == null ) {
            return null;
        }
        return cedula;
    }

    protected Cliente registroMascotaDTOToCliente(RegistroMascotaDTO registroMascotaDTO) {
        if ( registroMascotaDTO == null ) {
            return null;
        }

        Cliente cliente = new Cliente();

        cliente.setCedula( registroMascotaDTO.identificacionCliente() );

        return cliente;
    }
}
