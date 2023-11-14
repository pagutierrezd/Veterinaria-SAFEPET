package co.safepet.veterinaria.repositorio;

import co.safepet.veterinaria.modelo.entidades.Cliente;
import co.safepet.veterinaria.modelo.entidades.Veterinario;
import co.safepet.veterinaria.modelo.enums.EstadoPerfil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VeterinarioRepo extends JpaRepository<Veterinario, String> {

    List<Veterinario> findAllByEstado(EstadoPerfil estadoPerfil);
    Veterinario findByCedulaAndEstado(String cedula, EstadoPerfil estadoPerfil);
}
