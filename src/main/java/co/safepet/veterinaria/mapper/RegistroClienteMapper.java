package co.safepet.veterinaria.mapper;

import co.safepet.veterinaria.dto.RegistroClienteDTO;
import co.safepet.veterinaria.modelo.entidades.Cliente;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface RegistroClienteMapper {


   @Mappings({
           @Mapping(target = "cedula", source = "cedula"),
           @Mapping(target = "nombre", source = "nombre"),
           @Mapping(target = "telefono", source = "telefono"),
           @Mapping(target = "correo", source = "correo"),
           @Mapping(target = "direccion", source = "direccion"),
           @Mapping(target = "password", source = "password")
   })
   RegistroClienteDTO toRegistroClienteDto(Cliente cliente);

    @InheritInverseConfiguration
    @Mappings({

            @Mapping(target = "citas", ignore = true),
            @Mapping(target = "mascotas", ignore = true),

    })
    Cliente toCliente(RegistroClienteDTO registroClienteDTO);



}
