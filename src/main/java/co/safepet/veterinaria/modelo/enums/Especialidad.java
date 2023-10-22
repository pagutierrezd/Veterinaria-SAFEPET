package co.safepet.veterinaria.modelo.enums;

public enum Especialidad {
    MEDICINA_INTERNA("Medicina Interna"),
    CIRUGIA("Cirugía"),
    DERMATOLOGIA("Dermatología"),
    RADIOLOGIA("Radiología"),
    MEDICINA_GENERAL("Medicina General"),
    ANESTESIOLOGIA("Anestesiología");


    private String nombre;

    Especialidad(String nombre) {this.nombre = nombre;}

}
