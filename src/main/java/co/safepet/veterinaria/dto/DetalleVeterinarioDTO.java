package co.safepet.veterinaria.dto;


import jakarta.validation.constraints.NotNull;

public record DetalleVeterinarioDTO(

        @NotNull
        String cedula,

        @NotNull
        String nombre,
        @NotNull
        String telefono,
        @NotNull
        String correo,
        @NotNull
        String direccion

) {
}
