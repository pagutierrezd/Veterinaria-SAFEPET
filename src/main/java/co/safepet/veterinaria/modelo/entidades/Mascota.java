package co.safepet.veterinaria.modelo.entidades;

import co.safepet.veterinaria.modelo.enums.Especie;
import co.safepet.veterinaria.modelo.enums.Raza;
import co.safepet.veterinaria.modelo.enums.Sexo;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Mascota implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo", nullable = false)
    private int codigo;

    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;

    @Column(name = "fechaNacimiento", nullable = false)
    private LocalDate fechaNacimiento;

    @Column(name = "observación", nullable = false, length = 250)
    private String observacion;

    @Column(name = "edad", nullable = false, length = 10)
    private String edad;

    @Column(name = "sexo", nullable = false)
    private Sexo sexo;

    @Column(name = "especie", nullable = false)
    private Especie especie;

    @Column(name = "raza", nullable = false)
    private Raza raza;

    @ManyToOne
    private Cliente cliente;
}
