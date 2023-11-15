package co.safepet.veterinaria.mapper;

import co.safepet.veterinaria.dto.DetalleVeterinarioDTO;
import co.safepet.veterinaria.modelo.entidades.Veterinario;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-11-15T09:16:48-0500",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.6 (Oracle Corporation)"
)
@Component
public class ActualizacionVeterinarioMapperImpl implements ActualizacionVeterinarioMapper {

    @Override
    public DetalleVeterinarioDTO toDetalleVeterinarioDto(Veterinario veterinario) {
        if ( veterinario == null ) {
            return null;
        }

        String cedula = null;
        String nombre = null;
        String telefono = null;
        String correo = null;
        String direccion = null;

        cedula = veterinario.getCedula();
        nombre = veterinario.getNombre();
        telefono = veterinario.getTelefono();
        correo = veterinario.getCorreo();
        direccion = veterinario.getDireccion();

        DetalleVeterinarioDTO detalleVeterinarioDTO = new DetalleVeterinarioDTO( cedula, nombre, telefono, correo, direccion );

        return detalleVeterinarioDTO;
    }

    @Override
    public Veterinario toVeterinario(DetalleVeterinarioDTO DetalleVeterinarioDTO) {
        if ( DetalleVeterinarioDTO == null ) {
            return null;
        }

        Veterinario veterinario = new Veterinario();

        veterinario.setCedula( DetalleVeterinarioDTO.cedula() );
        veterinario.setNombre( DetalleVeterinarioDTO.nombre() );
        veterinario.setTelefono( DetalleVeterinarioDTO.telefono() );
        veterinario.setCorreo( DetalleVeterinarioDTO.correo() );
        veterinario.setDireccion( DetalleVeterinarioDTO.direccion() );

        return veterinario;
    }

    @Override
    public List<DetalleVeterinarioDTO> toDetalleVeterinarioDtos(List<Veterinario> veterinarios) {
        if ( veterinarios == null ) {
            return null;
        }

        List<DetalleVeterinarioDTO> list = new ArrayList<DetalleVeterinarioDTO>( veterinarios.size() );
        for ( Veterinario veterinario : veterinarios ) {
            list.add( toDetalleVeterinarioDto( veterinario ) );
        }

        return list;
    }
}
