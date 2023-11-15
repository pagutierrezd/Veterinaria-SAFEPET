package co.safepet.veterinaria.service.impl;

import co.safepet.veterinaria.dto.DetalleClienteDTO;
import co.safepet.veterinaria.dto.InformacionDetalladaClienteDTO;
import co.safepet.veterinaria.dto.RegistroClienteDTO;
import co.safepet.veterinaria.excepciones.ExcepcionPersonalizada;
import co.safepet.veterinaria.mapper.ActualizacionClienteMapper;
import co.safepet.veterinaria.mapper.InformacionDetalladaClienteMapper;
import co.safepet.veterinaria.mapper.RegistroClienteMapper;
import co.safepet.veterinaria.modelo.entidades.Cliente;
import co.safepet.veterinaria.modelo.enums.EstadoPerfil;
import co.safepet.veterinaria.repositorio.ClienteRepo;
import co.safepet.veterinaria.service.interfaz.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClienteServiceImpl implements ClienteService {


    private final ClienteRepo clienteRepo;
    private final RegistroClienteMapper registroClienteMapper;
    private final ActualizacionClienteMapper actualizacionClienteMapper;
    private final InformacionDetalladaClienteMapper informacionDetalladaClienteMapper;

    @Override
    public Boolean registrarCliente(RegistroClienteDTO registroClienteDTO) throws Exception {
        if(validarExistenciaCedula(registroClienteDTO.cedula())){
            throw new ExcepcionPersonalizada("El cliente ya existe");
        }
        Cliente cliente = registroClienteMapper.toCliente(registroClienteDTO);
        cliente.setEstado(EstadoPerfil.ACTIVO);
        clienteRepo.save(cliente);
        return true;

    }

    @Override
    public Boolean actualizarCliente(DetalleClienteDTO detalleClienteDTO) throws Exception {
        if(!validarExistenciaCedula(detalleClienteDTO.cedula()))
            throw new ExcepcionPersonalizada("El cliente no existe");

        Cliente cliente = actualizacionClienteMapper.toCliente(detalleClienteDTO);
        Cliente clienteBuscado= clienteRepo.findById(detalleClienteDTO.cedula()).get();
        cliente.setNombre(clienteBuscado.getNombre());
        cliente.setEstado(clienteBuscado.getEstado());
        cliente.setPassword(clienteBuscado.getPassword());
        cliente.setNombre(clienteBuscado.getNombre());
        clienteRepo.save(cliente);
        return true;
    }

    @Override
    public List<InformacionDetalladaClienteDTO> listarClientes() {
        return informacionDetalladaClienteMapper.toInformacionDetalladaClienteMappers(clienteRepo.findAllByEstado(EstadoPerfil.ACTIVO));
    }

    @Override
    public DetalleClienteDTO buscarCliente(String cedula) throws Exception {
        if(!validarExistenciaCedula(cedula))
            throw new ExcepcionPersonalizada("El cliente buscado no existe");

         return actualizacionClienteMapper.toDetalleClienteDto(clienteRepo.findByCedulaAndEstado(cedula,EstadoPerfil.ACTIVO));
    }

    @Override
    public Boolean eliminarCliente(String cedula) throws Exception {
        if(!validarExistenciaCedula(cedula))
            throw new ExcepcionPersonalizada("El cliente a eliminar no existe");

        Cliente cliente = clienteRepo.findById(cedula).get();
        cliente.setEstado(EstadoPerfil.INACTIVO);
        clienteRepo.save(cliente);
        return true;
    }



    public boolean validarExistenciaCedula(String cedula){

        boolean isPresent = clienteRepo.findById(cedula).isPresent();
        return isPresent ? true: false;
    }
}
