package co.safepet.veterinaria.mapper;

import co.safepet.veterinaria.dto.RegistroVeterinarioDTO;
import co.safepet.veterinaria.modelo.entidades.Veterinario;
import co.safepet.veterinaria.modelo.enums.Especialidad;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-11-15T00:05:14-0500",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.6 (Oracle Corporation)"
)
@Component
public class RegistroVeterinarioMapperImpl implements RegistroVeterinarioMapper {

    @Override
    public RegistroVeterinarioDTO toRegistroVeterinarioDto(Veterinario veterinario) {
        if ( veterinario == null ) {
            return null;
        }

        String cedula = null;
        String nombre = null;
        String telefono = null;
        String correo = null;
        String direccion = null;
        String password = null;
        String especialidad = null;

        cedula = veterinario.getCedula();
        nombre = veterinario.getNombre();
        telefono = veterinario.getTelefono();
        correo = veterinario.getCorreo();
        direccion = veterinario.getDireccion();
        password = veterinario.getPassword();
        if ( veterinario.getEspecialidad() != null ) {
            especialidad = veterinario.getEspecialidad().name();
        }

        RegistroVeterinarioDTO registroVeterinarioDTO = new RegistroVeterinarioDTO( cedula, password, nombre, telefono, correo, direccion, especialidad );

        return registroVeterinarioDTO;
    }

    @Override
    public Veterinario toVeterinario(RegistroVeterinarioDTO registroVeterinarioDTO) {
        if ( registroVeterinarioDTO == null ) {
            return null;
        }

        Veterinario veterinario = new Veterinario();

        veterinario.setCedula( registroVeterinarioDTO.cedula() );
        veterinario.setNombre( registroVeterinarioDTO.nombre() );
        veterinario.setTelefono( registroVeterinarioDTO.telefono() );
        veterinario.setCorreo( registroVeterinarioDTO.correo() );
        veterinario.setDireccion( registroVeterinarioDTO.direccion() );
        veterinario.setPassword( registroVeterinarioDTO.password() );
        if ( registroVeterinarioDTO.especialidad() != null ) {
            veterinario.setEspecialidad( Enum.valueOf( Especialidad.class, registroVeterinarioDTO.especialidad() ) );
        }

        return veterinario;
    }
}
