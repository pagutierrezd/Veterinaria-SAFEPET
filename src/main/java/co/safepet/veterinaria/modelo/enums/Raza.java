package co.safepet.veterinaria.modelo.enums;

public enum Raza {

    LABRADOR("Labrador"),
    PASTOR_ALEMAN("Pastor Alemán"),
    BULLDOG("Bulldog"),
    CHIHUAHUA("Chihuahua"),
    CRIOLLO("Criollo"),
    PERSA("Persa"),
    SIAMES("Siames"),
    RAGDOLL("Ragdoll"),
    CANARIO("Canario"),
    LORO("Loro"),
    CACATUA("Cacatúa"),

    HAMSTER("Loro"),
    CONEJILLO_DE_INDIA("Conejillo de india");

    private String nombre;

    Raza(String nombre) {this.nombre = nombre;}
}
