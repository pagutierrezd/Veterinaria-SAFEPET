package co.safepet.veterinaria.service.impl;

import co.safepet.veterinaria.dto.DetalleVeterinarioDTO;
import co.safepet.veterinaria.dto.RegistroVeterinarioDTO;
import co.safepet.veterinaria.mapper.ActualizacionVeterinarioMapper;
import co.safepet.veterinaria.mapper.RegistroVeterinarioMapper;
import co.safepet.veterinaria.modelo.entidades.Cliente;
import co.safepet.veterinaria.modelo.entidades.Veterinario;
import co.safepet.veterinaria.modelo.enums.EstadoPerfil;
import co.safepet.veterinaria.repositorio.VeterinarioRepo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class VeterinarioServiceImplTest {
    @Mock
    private VeterinarioRepo veterinarioRepo;

    @Mock
    private RegistroVeterinarioMapper registroVeterinarioMapper;

    @Mock
    private ActualizacionVeterinarioMapper actualizacionVeterinarioMapper;

    @InjectMocks
    private VeterinarioServiceImpl veterinarioService;
    @Test
    void registrarVeterinario() throws Exception {
        // Configuración de datos de prueba
        // Arrange
        RegistroVeterinarioDTO registroVeterinarioDTO = new RegistroVeterinarioDTO(
                "123456789",
                "contraseña",
                "Nombre",
                "123456789",
                "correo@ejemplo.com",
                "Dirección",
                "DERMATOLOGIA"
        );        Veterinario veterinario = new Veterinario(/* ... */);

        // Mockear el comportamiento
        when(registroVeterinarioMapper.toVeterinario(registroVeterinarioDTO)).thenReturn(veterinario);
        when(veterinarioRepo.findById(anyString())).thenReturn(Optional.empty());

        // Llama al método para validar
        Boolean resultado = veterinarioService.registrarVeterinario(registroVeterinarioDTO);

        // Assert
        assertTrue(resultado);
    }

    @Test
    void actualizarVeterinario() throws Exception {
        // Arrange
        DetalleVeterinarioDTO detalleDTO = new DetalleVeterinarioDTO(
                "123456789",
                "Nombre",
                "123456789",
                "correo@ejemplo.com",
                "Dirección"
        );
        Veterinario veterinario = new Veterinario(/* Ajusta la creación según tu lógica */);

        // Mockear el comportamiento
        when(actualizacionVeterinarioMapper.toVeterinario(detalleDTO)).thenReturn(veterinario);
        when(veterinarioRepo.findById(anyString())).thenReturn(Optional.of(veterinario)); // Modificado para devolver un Optional con el veterinario

        // Llama al método para validar
        Boolean resultado = veterinarioService.actualizarVeterinario(detalleDTO);

        // Assert
        assertTrue(resultado);
    }

    @Test
    void listarVeterinarioDtosTest() {
        // Arrange
        Veterinario veterinario1 = new Veterinario(/*...*/);
        Veterinario veterinario2 = new Veterinario(/*...*/);
        List<Veterinario> veterinarios = Arrays.asList(veterinario1, veterinario2);

        // Arrange
        DetalleVeterinarioDTO detalleDTO = new DetalleVeterinarioDTO(
                "123456789",
                "Nombre",
                "123456789",
                "correo@ejemplo.com",
                "Dirección"
        );
        List<DetalleVeterinarioDTO> detalleVeterinarioDTOs = Arrays.asList(detalleDTO);

        when(veterinarioRepo.findAllByEstado(EstadoPerfil.ACTIVO)).thenReturn(veterinarios);
        when(actualizacionVeterinarioMapper.toDetalleVeterinarioDtos(anyList())).thenReturn(detalleVeterinarioDTOs);

        // Llama al método para validar
        List<DetalleVeterinarioDTO> result = veterinarioService.listarVeterinarioDtos();

        // Assert
        assertEquals(detalleVeterinarioDTOs, result);
    }

    @Test
    void buscarVeterinarioExistenteTest() throws Exception {
        // Arrange
        String cedula = "123456789";
        Veterinario veterinario = new Veterinario(/*...*/);
        // Arrange
        DetalleVeterinarioDTO detalleVeterinarioDTO = new DetalleVeterinarioDTO(
                "123456789",
                "Nombre",
                "123456789",
                "correo@ejemplo.com",
                "Dirección"
        );
        when(veterinarioRepo.findById(anyString())).thenReturn(Optional.of(new Veterinario(/*...*/)));

        when(veterinarioRepo.findByCedulaAndEstado(cedula, EstadoPerfil.ACTIVO)).thenReturn(veterinario);
        when(actualizacionVeterinarioMapper.toDetalleVeterinarioDto(any(Veterinario.class))).thenReturn(detalleVeterinarioDTO);

        // Llama al método para validar
        DetalleVeterinarioDTO result = veterinarioService.buscarVeterinario(cedula);

        // Assert
        assertEquals(detalleVeterinarioDTO, result);
    }

    @Test
    void eliminarVeterinarioExistenteTest() throws Exception {
        // Arrange
        String cedula = "123456789";
        Veterinario veterinario = new Veterinario(/*...*/);

        when(veterinarioRepo.findById(cedula)).thenReturn(java.util.Optional.of(veterinario));

        // Llama al método para validar
        Boolean result = veterinarioService.eliminarVeterinario(cedula);

        // Assert
        assertTrue(result);
        assertEquals(EstadoPerfil.INACTIVO, veterinario.getEstado());
    }

    @Test
    void validarExistenciaCedulaExistenteTest() {
        //Arranque
        Veterinario veterinario = new Veterinario(/* ... */);
        when(veterinarioRepo.findById(eq(veterinario.getCedula()))).thenReturn(Optional.of(veterinario));

        // Llama al método para validar la existencia de la cédula
        boolean cedulaExiste = veterinarioService.validarExistenciaCedula(veterinario.getCedula());

        // Verifica que la cédula existe
        assertTrue(cedulaExiste);
    }
}