package co.safepet.veterinaria.dto;

import jakarta.validation.constraints.NotNull;

public record RegistroVeterinarioDTO(

    @NotNull
    String cedula,

    @NotNull
    String password,
    @NotNull
    String nombre,
    @NotNull
    String telefono,
    @NotNull
    String correo,
    @NotNull
    String direccion,
    @NotNull
    String especialidad

){}
