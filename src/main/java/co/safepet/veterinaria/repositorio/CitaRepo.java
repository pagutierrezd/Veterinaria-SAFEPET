package co.safepet.veterinaria.repositorio;

import co.safepet.veterinaria.modelo.entidades.Cita;
import co.safepet.veterinaria.modelo.enums.EstadoCita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;


@Repository
public interface CitaRepo extends JpaRepository<Cita, Integer> {

   List<Cita> findByFechaCreacionBetweenAndEstadoCitaNot(LocalDateTime fechaCreacion, LocalDateTime fechaFinalizacion, EstadoCita estadoCita);
}
