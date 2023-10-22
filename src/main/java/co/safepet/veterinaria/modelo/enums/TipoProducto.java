package co.safepet.veterinaria.modelo.enums;

public enum TipoProducto {
    MEDICAMENTOS("Medicamentos"),
    ALIMENTOS("Alimentos"),
    ROPA_Y_ACCESORIOS("Ropa y Accesorios"),
    JUGUETES("Juguetes"),
    HIGIENE("Higiene");


    private String nombre;

    TipoProducto(String nombre) {this.nombre = nombre;}
}
