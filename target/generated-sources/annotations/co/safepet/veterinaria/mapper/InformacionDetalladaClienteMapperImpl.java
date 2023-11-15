package co.safepet.veterinaria.mapper;

import co.safepet.veterinaria.dto.InformacionDetalladaClienteDTO;
import co.safepet.veterinaria.modelo.entidades.Cliente;
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
public class InformacionDetalladaClienteMapperImpl implements InformacionDetalladaClienteMapper {

    @Override
    public List<InformacionDetalladaClienteDTO> toInformacionDetalladaClienteMappers(List<Cliente> clientes) {
        if ( clientes == null ) {
            return null;
        }

        List<InformacionDetalladaClienteDTO> list = new ArrayList<InformacionDetalladaClienteDTO>( clientes.size() );
        for ( Cliente cliente : clientes ) {
            list.add( clienteToInformacionDetalladaClienteDTO( cliente ) );
        }

        return list;
    }

    @Override
    public List<Cliente> toClientes(List<InformacionDetalladaClienteDTO> informacionDetalladaClienteDTOS) {
        if ( informacionDetalladaClienteDTOS == null ) {
            return null;
        }

        List<Cliente> list = new ArrayList<Cliente>( informacionDetalladaClienteDTOS.size() );
        for ( InformacionDetalladaClienteDTO informacionDetalladaClienteDTO : informacionDetalladaClienteDTOS ) {
            list.add( informacionDetalladaClienteDTOToCliente( informacionDetalladaClienteDTO ) );
        }

        return list;
    }

    protected InformacionDetalladaClienteDTO clienteToInformacionDetalladaClienteDTO(Cliente cliente) {
        if ( cliente == null ) {
            return null;
        }

        String cedula = null;
        String nombre = null;
        String telefono = null;
        String direccion = null;

        cedula = cliente.getCedula();
        nombre = cliente.getNombre();
        telefono = cliente.getTelefono();
        direccion = cliente.getDireccion();

        InformacionDetalladaClienteDTO informacionDetalladaClienteDTO = new InformacionDetalladaClienteDTO( cedula, nombre, telefono, direccion );

        return informacionDetalladaClienteDTO;
    }

    protected Cliente informacionDetalladaClienteDTOToCliente(InformacionDetalladaClienteDTO informacionDetalladaClienteDTO) {
        if ( informacionDetalladaClienteDTO == null ) {
            return null;
        }

        Cliente cliente = new Cliente();

        cliente.setCedula( informacionDetalladaClienteDTO.cedula() );
        cliente.setNombre( informacionDetalladaClienteDTO.nombre() );
        cliente.setTelefono( informacionDetalladaClienteDTO.telefono() );
        cliente.setDireccion( informacionDetalladaClienteDTO.direccion() );

        return cliente;
    }
}
