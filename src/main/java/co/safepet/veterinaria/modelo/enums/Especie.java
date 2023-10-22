package co.safepet.veterinaria.modelo.enums;

public enum Especie {
    PERRO("Perro"),
    GATO("Gato"),
    AVE("Ave"),
    ROEDORE("Roedor");


    private String nombre;

    Especie(String nombre) {this.nombre = nombre;}

}
