package co.safepet.veterinaria.service.impl;

import co.safepet.veterinaria.dto.DetalleMascotaDTO;
import co.safepet.veterinaria.dto.RegistroMascotaDTO;
import co.safepet.veterinaria.mapper.ActualizarMascotaMapper;
import co.safepet.veterinaria.mapper.RegistroMascotaMapper;
import co.safepet.veterinaria.modelo.entidades.Cliente;
import co.safepet.veterinaria.modelo.entidades.Mascota;
import co.safepet.veterinaria.modelo.enums.EstadoPerfil;
import co.safepet.veterinaria.repositorio.MascotaRepo;
import co.safepet.veterinaria.service.interfaz.MascotaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MascotaServiceImpl implements MascotaService {

    private final MascotaRepo mascotaRepo;
    private final RegistroMascotaMapper registroMascotaMapper;
    private final ActualizarMascotaMapper actualizarMascotaMapper;


    @Override
    public Boolean registrarMascota(RegistroMascotaDTO registroMascotaDTO) throws Exception {

        Mascota mascota = registroMascotaMapper.toMascota(registroMascotaDTO);
        mascotaRepo.save(mascota);
        return true;

    }

    @Override
    public Boolean actualizarMascota(DetalleMascotaDTO detalleMascotaDTO) throws Exception {
       Mascota mascota = actualizarMascotaMapper.toMascota(detalleMascotaDTO);
       mascota.setCliente(mascotaRepo.findById(detalleMascotaDTO.codigo()).get().getCliente());
       mascotaRepo.save(mascota);
        return true;
    }

    @Override
    public List<DetalleMascotaDTO> listarMascotas() {
        return actualizarMascotaMapper.toDetalleMascotaDtos(mascotaRepo.findAll());
    }

    @Override
    public DetalleMascotaDTO buscarMascota(Integer codigo) throws Exception {
        return actualizarMascotaMapper.toDetalleMascotaDto(mascotaRepo.findById(codigo).get());

    }

    @Override
    public Boolean eliminarMascota(Integer codigo) throws Exception {
        mascotaRepo.deleteById(codigo);
        return true;
    }

}
