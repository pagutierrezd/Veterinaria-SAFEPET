package co.safepet.veterinaria.dto;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record RegistroCitaDTO(

        Integer codigo,

        String estadoCita,

        @NotNull
        LocalDateTime fechaCreacion,

        @NotNull
        LocalDateTime fechaFinalizacion,

        @NotNull
        String especialidad,
        @NotNull
        String identificacionCliente,
        @NotNull
        String observacion


) {
}
