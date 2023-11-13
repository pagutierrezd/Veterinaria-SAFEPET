package co.safepet.veterinaria.repositorio;

import co.safepet.veterinaria.modelo.entidades.Mascota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MascotaRepo extends JpaRepository<Mascota, Integer> {
}
