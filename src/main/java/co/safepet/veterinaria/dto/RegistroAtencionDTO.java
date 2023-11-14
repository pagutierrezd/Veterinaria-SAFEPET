package co.safepet.veterinaria.dto;

import jakarta.validation.constraints.NotNull;

public record RegistroAtencionDTO(

        Integer codigo,

        String diagnostico,

        String tratamiento,


        String notasMedicas,


        @NotNull
        Integer codigoCita


) {
}
