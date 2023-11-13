package co.safepet.veterinaria.service.impl;

import co.safepet.veterinaria.dto.DetalleClienteDTO;
import co.safepet.veterinaria.dto.InformacionDetalladaClienteDTO;
import co.safepet.veterinaria.dto.RegistroClienteDTO;
import co.safepet.veterinaria.excepciones.ExcepcionCliente;
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
            throw new ExcepcionCliente("El cliente ya existe");
        }
        Cliente cliente = registroClienteMapper.toCliente(registroClienteDTO);
        cliente.setEstado(EstadoPerfil.ACTIVO);
        clienteRepo.save(cliente);
        return true;

    }

    @Override
    public Boolean actualizarCliente(DetalleClienteDTO detalleClienteDTO) throws Exception {
        if(!validarExistenciaCedula(detalleClienteDTO.cedula()))
            throw new ExcepcionCliente("El cliente no existe");

        Cliente cliente = actualizacionClienteMapper.toCliente(detalleClienteDTO);
        cliente.setNombre(buscarCliente(detalleClienteDTO.cedula()).getNombre());
        clienteRepo.save(cliente);
        return true;
    }

    @Override
    public List<InformacionDetalladaClienteDTO> listarClientes() {
        return informacionDetalladaClienteMapper.toInformacionDetalladaClienteMappers(clienteRepo.findAll());
    }

    @Override
    public Cliente buscarCliente(String cedula) throws Exception {
        if(!validarExistenciaCedula(cedula))
            throw new ExcepcionCliente("El cliente buscado existe");

         return clienteRepo.findById(cedula).get();
    }

    @Override
    public Boolean eliminarCliente(String cedula) throws Exception {
        if(!validarExistenciaCedula(cedula))
            throw new ExcepcionCliente("El cliente a eliminar existe");

        Cliente cliente = buscarCliente(cedula);
        cliente.setEstado(EstadoPerfil.INACTIVO);
        clienteRepo.save(cliente);
        return true;
    }



    public boolean validarExistenciaCedula(String cedula){

        boolean isPresent = clienteRepo.findById(cedula).isPresent();
        return isPresent ? true: false;
    }
}
