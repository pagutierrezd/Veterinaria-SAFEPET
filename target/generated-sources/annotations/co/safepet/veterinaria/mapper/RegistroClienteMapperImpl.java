package co.safepet.veterinaria.mapper;

import co.safepet.veterinaria.dto.RegistroClienteDTO;
import co.safepet.veterinaria.modelo.entidades.Cliente;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-11-14T01:08:59-0500",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.6 (Oracle Corporation)"
)
@Component
public class RegistroClienteMapperImpl implements RegistroClienteMapper {

    @Override
    public RegistroClienteDTO toRegistroClienteDto(Cliente cliente) {
        if ( cliente == null ) {
            return null;
        }

        String cedula = null;
        String nombre = null;
        String telefono = null;
        String correo = null;
        String direccion = null;
        String password = null;

        cedula = cliente.getCedula();
        nombre = cliente.getNombre();
        telefono = cliente.getTelefono();
        correo = cliente.getCorreo();
        direccion = cliente.getDireccion();
        password = cliente.getPassword();

        RegistroClienteDTO registroClienteDTO = new RegistroClienteDTO( cedula, password, nombre, telefono, correo, direccion );

        return registroClienteDTO;
    }

    @Override
    public Cliente toCliente(RegistroClienteDTO registroClienteDTO) {
        if ( registroClienteDTO == null ) {
            return null;
        }

        Cliente cliente = new Cliente();

        cliente.setCedula( registroClienteDTO.cedula() );
        cliente.setNombre( registroClienteDTO.nombre() );
        cliente.setTelefono( registroClienteDTO.telefono() );
        cliente.setCorreo( registroClienteDTO.correo() );
        cliente.setDireccion( registroClienteDTO.direccion() );
        cliente.setPassword( registroClienteDTO.password() );

        return cliente;
    }
}
