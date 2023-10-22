package co.safepet.veterinaria.modelo.enums;

public enum EstadoCita {

    PROGRAMADA("Programada"),
    COMPLETADA("Completada"),
    CANCELADA("Cancelada");

    private String nombre;

    EstadoCita(String nombre) {this.nombre = nombre;}
}
