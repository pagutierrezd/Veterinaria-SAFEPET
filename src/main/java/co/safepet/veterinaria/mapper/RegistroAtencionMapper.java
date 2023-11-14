package co.safepet.veterinaria.mapper;

import co.safepet.veterinaria.dto.RegistroAtencionDTO;
import co.safepet.veterinaria.dto.RegistroCitaDTO;
import co.safepet.veterinaria.modelo.entidades.Atencion;
import co.safepet.veterinaria.modelo.entidades.Cita;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RegistroAtencionMapper {


   @Mappings({
           @Mapping(target = "diagnostico", source = "diagnostico"),
           @Mapping(target = "tratamiento", source = "tratamiento"),
           @Mapping(target = "notasMedicas", source = "notasMedicas"),
           @Mapping(target = "codigo", source = "codigo"),
           @Mapping(target = "codigoCita", source = "cita.codigo"),
   })
   RegistroAtencionDTO toRegistroAtencionDto(Atencion atencion);

    @InheritInverseConfiguration
    Atencion toAtencion(RegistroAtencionDTO registroAtencionDTO);

    List<RegistroAtencionDTO> toRegistroAtencionDtos(List<Atencion> atencions);


}
