package co.safepet.veterinaria.dto;

import jakarta.validation.constraints.NotNull;

public record RegistroClienteDTO (

    @NotNull
    String cedula,

    @NotNull
    String password,
    @NotNull
    String nombre,
    @NotNull
    String telefono,
    String correo,
    @NotNull
    String direccion

){}
