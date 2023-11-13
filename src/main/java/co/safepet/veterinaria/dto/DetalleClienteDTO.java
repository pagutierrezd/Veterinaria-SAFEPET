package co.safepet.veterinaria.dto;


import jakarta.validation.constraints.NotNull;

public record DetalleClienteDTO(

        @NotNull
        String cedula,

        @NotNull
        String telefono,
        @NotNull
        String correo,
        @NotNull
        String direccion

) {
}
