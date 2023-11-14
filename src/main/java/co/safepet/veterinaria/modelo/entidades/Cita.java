package co.safepet.veterinaria.modelo.entidades;

import co.safepet.veterinaria.modelo.enums.Especialidad;
import co.safepet.veterinaria.modelo.enums.EstadoCita;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Cita implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo;

    @Column(name = "fechaCreacion", nullable = false)
    private LocalDateTime fechaCreacion;

    @Column(name = "fechaFinalizacion", nullable = false)
    private LocalDateTime fechaFinalizacion;

    @Column(name = "observación", nullable = false, length = 100)
    private String observacion;

    @Enumerated(EnumType.STRING)
    private EstadoCita estadoCita;

    @Column(name = "especialidad", nullable = false)
    @Enumerated(EnumType.STRING)
    private Especialidad especialidad;

    @ManyToOne
    private Cliente cliente;

    @ManyToOne
    private Veterinario veterinario;

    @OneToOne(mappedBy = "cita")
    private Atencion atencion;


}
