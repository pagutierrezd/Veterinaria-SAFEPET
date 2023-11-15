package co.safepet.veterinaria.mapper;

import co.safepet.veterinaria.dto.DetalleClienteDTO;
import co.safepet.veterinaria.modelo.entidades.Cliente;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface ActualizacionClienteMapper {


   @Mappings({
           @Mapping(target = "cedula", source = "cedula"),
           @Mapping(target = "telefono", source = "telefono"),
           @Mapping(target = "correo", source = "correo"),
           @Mapping(target = "direccion", source = "direccion"),
           @Mapping(target = "nombre", source = "nombre"),
   })
   DetalleClienteDTO toDetalleClienteDto(Cliente cliente);

    @InheritInverseConfiguration
    @Mappings({

            @Mapping(target = "citas", ignore = true),
            @Mapping(target = "mascotas", ignore = true),
            @Mapping(target = "nombre", ignore = true)

    })
    Cliente toCliente(DetalleClienteDTO detalleClienteDTO);



}
