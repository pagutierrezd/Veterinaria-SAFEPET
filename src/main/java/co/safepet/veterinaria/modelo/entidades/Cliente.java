package co.safepet.veterinaria.modelo.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Cliente extends Usuario implements Serializable {

    @Column(name = "dirección", nullable = false, length = 100)
    private String direccion;

    @OneToMany(mappedBy = "cliente")
    private List<Mascota> mascotas;

    @OneToMany(mappedBy = "cliente")
    private List<Cita> citas;

    @OneToMany(mappedBy = "cliente")
    private List<Conversacion> conversaciones;
}
