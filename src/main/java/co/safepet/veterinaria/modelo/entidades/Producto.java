package co.safepet.veterinaria.modelo.entidades;

import co.safepet.veterinaria.modelo.enums.TipoProducto;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Producto implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "descripción", nullable = false, length = 200)
    private String descripcion;

    @Column(name = "precio", nullable = false)
    private double precio;

    @Column(name = "caracteristicas", nullable = false, length = 200)
    private String caracteristicas;

    @Column(name = "disponibilidad", nullable = false, length = 50)
    private String disponibilidad;

    @Lob
    @Column(name = "urlFoto", nullable = false, length = 100)
    private String urlFoto;

    private TipoProducto tipoProducto;
}
