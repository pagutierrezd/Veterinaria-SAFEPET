package co.safepet.veterinaria.mapper;

import co.safepet.veterinaria.dto.DetalleClienteDTO;
import co.safepet.veterinaria.modelo.entidades.Cliente;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-11-14T23:44:50-0500",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.6 (Oracle Corporation)"
)
@Component
public class ActualizacionClienteMapperImpl implements ActualizacionClienteMapper {

    @Override
    public DetalleClienteDTO toDetalleClienteDto(Cliente cliente) {
        if ( cliente == null ) {
            return null;
        }

        String cedula = null;
        String telefono = null;
        String correo = null;
        String direccion = null;
        String nombre = null;

        cedula = cliente.getCedula();
        telefono = cliente.getTelefono();
        correo = cliente.getCorreo();
        direccion = cliente.getDireccion();
        nombre = cliente.getNombre();

        DetalleClienteDTO detalleClienteDTO = new DetalleClienteDTO( cedula, nombre, telefono, correo, direccion );

        return detalleClienteDTO;
    }

    @Override
    public Cliente toCliente(DetalleClienteDTO detalleClienteDTO) {
        if ( detalleClienteDTO == null ) {
            return null;
        }

        Cliente cliente = new Cliente();

        cliente.setCedula( detalleClienteDTO.cedula() );
        cliente.setTelefono( detalleClienteDTO.telefono() );
        cliente.setCorreo( detalleClienteDTO.correo() );
        cliente.setDireccion( detalleClienteDTO.direccion() );

        return cliente;
    }
}
