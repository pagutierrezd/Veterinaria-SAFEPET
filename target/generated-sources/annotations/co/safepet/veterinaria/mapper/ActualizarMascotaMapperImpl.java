package co.safepet.veterinaria.mapper;

import co.safepet.veterinaria.dto.DetalleMascotaDTO;
import co.safepet.veterinaria.modelo.entidades.Mascota;
import co.safepet.veterinaria.modelo.enums.Especie;
import co.safepet.veterinaria.modelo.enums.Raza;
import co.safepet.veterinaria.modelo.enums.Sexo;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-11-14T19:23:06-0500",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.7 (Oracle Corporation)"
)
@Component
public class ActualizarMascotaMapperImpl implements ActualizarMascotaMapper {

    @Override
    public DetalleMascotaDTO toDetalleMascotaDto(Mascota mascota) {
        if ( mascota == null ) {
            return null;
        }

        Integer codigo = null;
        String nombre = null;
        LocalDate fechaNacimiento = null;
        String observacion = null;
        String sexo = null;
        String especie = null;
        String raza = null;
        String edad = null;

        codigo = mascota.getCodigo();
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

        DetalleMascotaDTO detalleMascotaDTO = new DetalleMascotaDTO( codigo, nombre, fechaNacimiento, observacion, sexo, especie, raza, edad );

        return detalleMascotaDTO;
    }

    @Override
    public Mascota toMascota(DetalleMascotaDTO detalleMascotaDTO) {
        if ( detalleMascotaDTO == null ) {
            return null;
        }

        Mascota mascota = new Mascota();

        mascota.setCodigo( detalleMascotaDTO.codigo() );
        mascota.setNombre( detalleMascotaDTO.nombre() );
        mascota.setFechaNacimiento( detalleMascotaDTO.fechaNacimiento() );
        mascota.setObservacion( detalleMascotaDTO.observacion() );
        if ( detalleMascotaDTO.sexo() != null ) {
            mascota.setSexo( Enum.valueOf( Sexo.class, detalleMascotaDTO.sexo() ) );
        }
        if ( detalleMascotaDTO.especie() != null ) {
            mascota.setEspecie( Enum.valueOf( Especie.class, detalleMascotaDTO.especie() ) );
        }
        if ( detalleMascotaDTO.raza() != null ) {
            mascota.setRaza( Enum.valueOf( Raza.class, detalleMascotaDTO.raza() ) );
        }
        mascota.setEdad( detalleMascotaDTO.edad() );

        return mascota;
    }

    @Override
    public List<DetalleMascotaDTO> toDetalleMascotaDtos(List<Mascota> mascotas) {
        if ( mascotas == null ) {
            return null;
        }

        List<DetalleMascotaDTO> list = new ArrayList<DetalleMascotaDTO>( mascotas.size() );
        for ( Mascota mascota : mascotas ) {
            list.add( toDetalleMascotaDto( mascota ) );
        }

        return list;
    }
}
