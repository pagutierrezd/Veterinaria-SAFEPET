package co.safepet.veterinaria.service.impl;

import co.safepet.veterinaria.dto.DetalleClienteDTO;
import co.safepet.veterinaria.dto.InformacionDetalladaClienteDTO;
import co.safepet.veterinaria.dto.RegistroClienteDTO;
import co.safepet.veterinaria.mapper.ActualizacionClienteMapper;
import co.safepet.veterinaria.mapper.InformacionDetalladaClienteMapper;
import co.safepet.veterinaria.mapper.RegistroClienteMapper;
import co.safepet.veterinaria.modelo.entidades.Cliente;
import co.safepet.veterinaria.modelo.enums.EstadoPerfil;
import co.safepet.veterinaria.repositorio.ClienteRepo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ClienteServiceImplTest {


    @Mock
    private ClienteRepo clienteRepo;
    @Mock
    private RegistroClienteMapper registroClienteMapper;
    @Mock
    private ActualizacionClienteMapper actualizacionClienteMapper;
    @Mock
    private InformacionDetalladaClienteMapper informacionDetalladaClienteMapper;

    @InjectMocks
    private ClienteServiceImpl clienteService;

    @Test
    void registrarCliente() throws Exception {
        /* Datos de prueba */
        RegistroClienteDTO registroClienteDTO = new RegistroClienteDTO(
                "123456789",
                "contraseña",
                "Nombre",
                "123456789",
                "correo@ejemplo.com",
                "Dirección"
        );
        // Configuración del mock del repositorio
        when(clienteRepo.findById(anyString())).thenReturn(java.util.Optional.empty());
        // Configuración del mock del mapper
        when(registroClienteMapper.toCliente(registroClienteDTO)).thenReturn(new Cliente(/*...*/));
        // Llamada al método que se está probando
        boolean resultado = clienteService.registrarCliente(registroClienteDTO);
         // Verificación del resultado
        assertTrue(resultado);
    }

    @Test
    void actualizarCliente() throws Exception {
        // Datos de prueba
        DetalleClienteDTO detalleClienteDTO = new DetalleClienteDTO(
                "123456789",
                "Nuevo Nombre",
                "123456789",
                "correo@ejemplo.com",
                "Nueva Dirección"
        );

        // Configuración del mock del repositorio
        when(clienteRepo.findById(anyString())).thenReturn(Optional.of(new Cliente(/*...*/)));

        // Configuración del mock del mapper
        when(actualizacionClienteMapper.toCliente(detalleClienteDTO)).thenReturn(new Cliente(/*...*/));

        // Llamada al método que se está probando
        boolean resultado = clienteService.actualizarCliente(detalleClienteDTO);

        // Verificación del resultado
        assertTrue(resultado);
    }


    @Test
    void listarClientesTest() {
        // Configura el mock de clienteRepo para devolver una lista de clientes cuando se llama a findAllByEstado
        when(clienteRepo.findAllByEstado(EstadoPerfil.ACTIVO)).thenReturn(Arrays.asList(new Cliente(/*...*/), new Cliente(/*...*/)));

        // Configura el mock de informacionDetalladaClienteMapper para devolver una lista de InformacionDetalladaClienteDTO
        when(informacionDetalladaClienteMapper.toInformacionDetalladaClienteMappers(anyList()))
                .thenReturn(Arrays.asList(new InformacionDetalladaClienteDTO("123","paula","12345678","nueva"), new InformacionDetalladaClienteDTO("123","paula","12345678","nueva")));

        // Llama al método que deseas probar
        List<InformacionDetalladaClienteDTO> resultado = clienteService.listarClientes();

        // Por ejemplo, si esperas una lista de dos elementos, podrías hacer algo como esto:
        assertEquals(2, resultado.size());
    }

    @Test
    void buscarClienteTest() throws Exception {
        // Define una cédula para la prueba
        String cedula = "123456789";

        when(clienteRepo.findById(anyString())).thenReturn(Optional.of(new Cliente(/*...*/)));

        // Configura el mock de clienteRepo para devolver un cliente cuando se llama a findByCedulaAndEstado
        when(clienteRepo.findByCedulaAndEstado(eq(cedula), eq(EstadoPerfil.ACTIVO)))
                .thenReturn(new Cliente(/*...*/));

        // Configura el mock de actualizacionClienteMapper para devolver un DetalleClienteDTO
        when(actualizacionClienteMapper.toDetalleClienteDto(any(Cliente.class)))
                .thenReturn(new DetalleClienteDTO("123456789","paula","123456","paula@gmail.com","nueva"));

        // Llama al método que deseas probar
        DetalleClienteDTO resultado = clienteService.buscarCliente(cedula);

        // Por ejemplo, puedes verificar que el resultado no sea nulo
        assertNotNull(resultado);
    }

    @Test
    void eliminarClienteTest() throws Exception {
        // Configura un cliente existente
        Cliente clienteExistente = new Cliente(/* ... */);
        when(clienteRepo.findById(eq(clienteExistente.getCedula()))).thenReturn(Optional.of(clienteExistente));

        // Llama al método para eliminar el cliente
        boolean eliminacionExitosa = clienteService.eliminarCliente(clienteExistente.getCedula());

        // Verifica que la eliminación fue exitosa
        assertTrue(eliminacionExitosa);

        // Verifica que el estado del cliente ha cambiado a INACTIVO
        assertEquals(EstadoPerfil.INACTIVO, clienteExistente.getEstado());

    }

    @Test
    void validarExistenciaCedulaTest() {
        // Configura un cliente existente
        Cliente clienteExistente = new Cliente(/* ... */);
        when(clienteRepo.findById(eq(clienteExistente.getCedula()))).thenReturn(Optional.of(clienteExistente));

        // Llama al método para validar la existencia de la cédula
        boolean cedulaExiste = clienteService.validarExistenciaCedula(clienteExistente.getCedula());

        // Verifica que la cédula existe
        assertTrue(cedulaExiste);
    }

    @Test
    void validarNoExistenciaCedulaTest() {
        // Configura que no hay cliente con la cédula dada
        when(clienteRepo.findById(eq("123456789"))).thenReturn(Optional.empty());

        // Llama al método para validar la existencia de la cédula
        boolean cedulaExiste = clienteService.validarExistenciaCedula("123456789");

        // Verifica que la cédula no existe
        assertFalse(cedulaExiste);
    }
}