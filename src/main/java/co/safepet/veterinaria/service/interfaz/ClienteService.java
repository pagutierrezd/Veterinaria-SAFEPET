package co.safepet.veterinaria.service.interfaz;

import co.safepet.veterinaria.dto.DetalleClienteDTO;
import co.safepet.veterinaria.dto.InformacionDetalladaClienteDTO;
import co.safepet.veterinaria.dto.RegistroClienteDTO;
import co.safepet.veterinaria.modelo.entidades.Cliente;

import java.util.List;

public interface ClienteService {

    Boolean registrarCliente(RegistroClienteDTO registroClienteDTO) throws Exception ;
    Boolean actualizarCliente(DetalleClienteDTO detalleClienteDTO) throws Exception ;
    List<InformacionDetalladaClienteDTO> listarClientes();
    DetalleClienteDTO buscarCliente(String cedula) throws Exception ;
    Boolean eliminarCliente(String cedula) throws Exception ;



}
