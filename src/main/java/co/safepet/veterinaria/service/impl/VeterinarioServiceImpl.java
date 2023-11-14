package co.safepet.veterinaria.service.impl;

import co.safepet.veterinaria.dto.*;
import co.safepet.veterinaria.excepciones.ExcepcionPersonalizada;
import co.safepet.veterinaria.mapper.*;
import co.safepet.veterinaria.modelo.entidades.Cliente;
import co.safepet.veterinaria.modelo.entidades.Veterinario;
import co.safepet.veterinaria.modelo.enums.EstadoPerfil;
import co.safepet.veterinaria.repositorio.ClienteRepo;
import co.safepet.veterinaria.repositorio.VeterinarioRepo;
import co.safepet.veterinaria.service.interfaz.ClienteService;
import co.safepet.veterinaria.service.interfaz.VeterinarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VeterinarioServiceImpl implements VeterinarioService {


    private final VeterinarioRepo veterinarioRepo;
    private final RegistroVeterinarioMapper registroVeterinarioMapper;
    private final ActualizacionVeterinarioMapper actualizacionVeterinarioMapper;

    @Override
    public Boolean registrarVeterinario (RegistroVeterinarioDTO registroVeterinarioDTO) throws Exception {
        if(validarExistenciaCedula(registroVeterinarioDTO.cedula())){
            throw new ExcepcionPersonalizada("El veterinario ya existe");
        }
        Veterinario veterinario = registroVeterinarioMapper.toVeterinario(registroVeterinarioDTO);
        veterinario.setEstado(EstadoPerfil.ACTIVO);
        veterinarioRepo.save(veterinario);
        return true;

    }

    @Override
    public Boolean actualizarVeterinario(DetalleVeterinarioDTO detalleVeterinarioDTO) throws Exception {
        if(!validarExistenciaCedula(detalleVeterinarioDTO.cedula()))
            throw new ExcepcionPersonalizada("El veterinario no existe");

        Veterinario veterinario = actualizacionVeterinarioMapper.toVeterinario(detalleVeterinarioDTO);
        Veterinario veterinarioBuscado= veterinarioRepo.findById(detalleVeterinarioDTO.cedula()).get();
        veterinario.setEstado(veterinarioBuscado.getEstado());
        veterinario.setPassword(veterinarioBuscado.getPassword());
        veterinario.setEspecialidad(veterinarioBuscado.getEspecialidad());
        veterinarioRepo.save(veterinario);
        return true;
    }

    @Override
    public List<DetalleVeterinarioDTO> listarVeterinarioDtos() {
        return actualizacionVeterinarioMapper.toDetalleVeterinarioDtos(veterinarioRepo.findAllByEstado(EstadoPerfil.ACTIVO));
    }

    @Override
    public DetalleVeterinarioDTO buscarVeterinario(String cedula) throws Exception {
        if(!validarExistenciaCedula(cedula))
            throw new ExcepcionPersonalizada("El veterinario buscado no existe");

         return actualizacionVeterinarioMapper.toDetalleVeterinarioDto(veterinarioRepo.findByCedulaAndEstado(cedula,EstadoPerfil.ACTIVO));
    }

    @Override
    public Boolean eliminarVeterinario(String cedula) throws Exception {
        if(!validarExistenciaCedula(cedula))
            throw new ExcepcionPersonalizada("El Veterinario a eliminar no existe");

        Veterinario veterinario =  veterinarioRepo.findById(cedula).get();
        veterinario.setEstado(EstadoPerfil.INACTIVO);
        veterinarioRepo.save(veterinario);
        return true;
    }



    public boolean validarExistenciaCedula(String cedula){

        boolean isPresent = veterinarioRepo.findById(cedula).isPresent();
        return isPresent ? true: false;
    }
}
