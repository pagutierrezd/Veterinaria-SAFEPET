package co.safepet.veterinaria.repositorio;

import co.safepet.veterinaria.modelo.entidades.Cliente;
import co.safepet.veterinaria.modelo.enums.EstadoPerfil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepo extends JpaRepository<Cliente, String> {

    List<Cliente> findAllByEstado(EstadoPerfil estadoPerfil);
    Cliente findByCedulaAndEstado(String cedula, EstadoPerfil estadoPerfil);
}
