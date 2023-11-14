package co.safepet.veterinaria.mapper;

import co.safepet.veterinaria.dto.DetalleVeterinarioDTO;
import co.safepet.veterinaria.dto.RegistroCitaDTO;
import co.safepet.veterinaria.dto.RegistroVeterinarioDTO;
import co.safepet.veterinaria.modelo.entidades.Cita;
import co.safepet.veterinaria.modelo.entidades.Veterinario;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RegistroCitaMapper {


   @Mappings({
           @Mapping(target = "fechaCreacion", source = "fechaCreacion"),
           @Mapping(target = "fechaFinalizacion", source = "fechaFinalizacion"),
           @Mapping(target = "especialidad", source = "especialidad"),
           @Mapping(target = "identificacionCliente", source = "cliente.cedula"),
           @Mapping(target = "observacion", source = "observacion"),
           @Mapping(target = "codigo", source = "codigo"),
           @Mapping(target = "estadoCita", source = "estadoCita"),
   })
   RegistroCitaDTO toRegistroCitaMapper(Cita cita);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "veterinario", ignore = true),
            @Mapping(target = "atencion", ignore = true),

    })
    Cita toCita(RegistroCitaDTO registroCitaDTO);

    List<RegistroCitaDTO> toRegistroCitaDtos(List<Cita> citas);


}
