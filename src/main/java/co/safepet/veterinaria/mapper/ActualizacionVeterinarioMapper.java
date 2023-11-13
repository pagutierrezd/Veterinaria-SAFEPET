package co.safepet.veterinaria.mapper;

import co.safepet.veterinaria.dto.DetalleClienteDTO;
import co.safepet.veterinaria.dto.DetalleMascotaDTO;
import co.safepet.veterinaria.dto.DetalleVeterinarioDTO;
import co.safepet.veterinaria.modelo.entidades.Cliente;
import co.safepet.veterinaria.modelo.entidades.Mascota;
import co.safepet.veterinaria.modelo.entidades.Veterinario;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ActualizacionVeterinarioMapper {


   @Mappings({
           @Mapping(target = "cedula", source = "cedula"),
           @Mapping(target = "nombre", source = "nombre"),
           @Mapping(target = "telefono", source = "telefono"),
           @Mapping(target = "correo", source = "correo"),
           @Mapping(target = "direccion", source = "direccion"),
   })
   DetalleVeterinarioDTO toDetalleVeterinarioDto(Veterinario veterinario);

    @InheritInverseConfiguration
    @Mappings({

            @Mapping(target = "citas", ignore = true),

    })
    Veterinario toVeterinario(DetalleVeterinarioDTO DetalleVeterinarioDTO);

    List<DetalleVeterinarioDTO> toDetalleVeterinarioDtos(List<Veterinario> veterinarios);


}
