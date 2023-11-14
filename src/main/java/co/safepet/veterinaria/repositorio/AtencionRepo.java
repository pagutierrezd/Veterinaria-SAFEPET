package co.safepet.veterinaria.repositorio;

import co.safepet.veterinaria.modelo.entidades.Atencion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface AtencionRepo extends JpaRepository<Atencion, Integer> {

    @Query("SELECT a FROM Atencion a JOIN a.cita c JOIN c.cliente cli WHERE cli.cedula = :cedula")
    List<Atencion> listaAtencionCliente(@Param("cedula") String cedula);

}
