package co.safepet.veterinaria.modelo.entidades;
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
public class Mensaje implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;

    @Column(name = "contenido", nullable = false, length = 200)
    private String contenido;

    @Column(name = "fechaEnvio", nullable = false)
    private LocalDateTime fechaEnvio;

    @ManyToOne
    private Conversacion conversacion;
}
