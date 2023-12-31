package co.safepet.veterinaria.modelo.entidades;

import co.safepet.veterinaria.modelo.enums.Especialidad;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Veterinario extends Usuario implements Serializable {

    @Column(name = "especialidad", nullable = false)
    @Enumerated(EnumType.STRING)
    private Especialidad especialidad;

    @Column(name = "direccion", nullable = false, length = 100)
    private String direccion;

    @OneToMany(mappedBy = "veterinario")
    private List<Cita> citas;
}
