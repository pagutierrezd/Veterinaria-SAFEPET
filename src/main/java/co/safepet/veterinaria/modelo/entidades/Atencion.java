package co.safepet.veterinaria.modelo.entidades;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Atencion implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo;

    @Column(name = "diagnostico", nullable = false, length = 200)
    private String diagnostico;

    @Column(name = "tratamiento", nullable = false, length = 200)
    private String tratamiento;

    @Column(name = "notasMedicas", nullable = false, length = 200)
    private String notasMedicas;

    @OneToOne
    private Cita cita;
}
