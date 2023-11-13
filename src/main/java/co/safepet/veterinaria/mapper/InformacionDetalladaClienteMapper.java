package co.safepet.veterinaria.mapper;

import co.safepet.veterinaria.dto.InformacionDetalladaClienteDTO;
import co.safepet.veterinaria.modelo.entidades.Cliente;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface InformacionDetalladaClienteMapper {

    @Mappings({
            @Mapping(target = "cedula", source = "cedula"),
            @Mapping(target = "nombre", source = "nombre"),
            @Mapping(target = "telefono", source = "telefono")
    })
    List<InformacionDetalladaClienteDTO> toInformacionDetalladaClienteMappers(List<Cliente> clientes);

    @InheritInverseConfiguration
    @Mappings({

            @Mapping(target = "citas", ignore = true),
            @Mapping(target = "mascotas", ignore = true),
            @Mapping(target = "nombre", ignore = true),
            @Mapping(target = "direccion", ignore = true)

    })
    List<Cliente> toClientes(List<InformacionDetalladaClienteDTO> informacionDetalladaClienteDTOS);
}
