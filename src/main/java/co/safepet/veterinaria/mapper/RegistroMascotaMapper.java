package co.safepet.veterinaria.mapper;

import co.safepet.veterinaria.dto.RegistroClienteDTO;
import co.safepet.veterinaria.dto.RegistroMascotaDTO;
import co.safepet.veterinaria.modelo.entidades.Cliente;
import co.safepet.veterinaria.modelo.entidades.Mascota;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface RegistroMascotaMapper {


   @Mappings({
           @Mapping(target = "nombre", source = "nombre"),
           @Mapping(target = "fechaNacimiento", source = "fechaNacimiento"),
           @Mapping(target = "observacion", source = "observacion"),
           @Mapping(target = "sexo", source = "sexo"),
           @Mapping(target = "especie", source = "especie"),
           @Mapping(target = "raza", source = "raza"),
           @Mapping(target = "edad", source = "edad"),
           @Mapping(target = "identificacionCliente", source = "cliente.cedula")
   })
   RegistroMascotaDTO toRegistroMascotaDto(Mascota mascota);

    @InheritInverseConfiguration

    Mascota toMascota(RegistroMascotaDTO registroMascotaDTO);



}
