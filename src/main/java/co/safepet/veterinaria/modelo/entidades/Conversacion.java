package co.safepet.veterinaria.modelo.entidades;

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
public class Conversacion implements Serializable {

        @Id
        @EqualsAndHashCode.Include
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int codigo;

        @ManyToOne
        private Cliente cliente;  // El usuario que inicia la conversación

        @ManyToOne
        private Administrador administrador;  // El administrador asignado a la conversación

        @OneToMany(mappedBy = "conversacion")
        private List<Mensaje> mensajes;
}
