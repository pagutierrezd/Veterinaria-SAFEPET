package co.safepet.veterinaria.dto;

import jakarta.validation.constraints.NotNull;

public record InformacionDetalladaClienteDTO (

        @NotNull
        String cedula,
        @NotNull
        String nombre,
        @NotNull
        String telefono

) {
}