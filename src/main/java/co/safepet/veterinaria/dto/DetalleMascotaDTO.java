package co.safepet.veterinaria.dto;


import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record DetalleMascotaDTO(

       @NotNull
       Integer codigo,
        @NotNull
        String nombre,
        @NotNull
        LocalDate fechaNacimiento,
        String observacion,
        @NotNull
        String sexo,
        String especie,
        @NotNull
        String raza,
        @NotNull
        String edad

) {
}
