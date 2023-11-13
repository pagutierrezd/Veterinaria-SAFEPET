package co.safepet.veterinaria.mapper;

import co.safepet.veterinaria.dto.DetalleMascotaDTO;
import co.safepet.veterinaria.dto.InformacionDetalladaClienteDTO;
import co.safepet.veterinaria.dto.RegistroMascotaDTO;
import co.safepet.veterinaria.modelo.entidades.Cliente;
import co.safepet.veterinaria.modelo.entidades.Mascota;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ActualizarMascotaMapper {


   @Mappings({
           @Mapping(target = "codigo", source = "codigo"),
           @Mapping(target = "nombre", source = "nombre"),
           @Mapping(target = "fechaNacimiento", source = "fechaNacimiento"),
           @Mapping(target = "observacion", source = "observacion"),
           @Mapping(target = "sexo", source = "sexo"),
           @Mapping(target = "especie", source = "especie"),
           @Mapping(target = "raza", source = "raza"),
           @Mapping(target = "edad", source = "edad"),
   })
   DetalleMascotaDTO toDetalleMascotaDto(Mascota mascota);

    @InheritInverseConfiguration
    Mascota toMascota(DetalleMascotaDTO detalleMascotaDTO);

    List<DetalleMascotaDTO> toDetalleMascotaDtos(List<Mascota> mascotas);


}
