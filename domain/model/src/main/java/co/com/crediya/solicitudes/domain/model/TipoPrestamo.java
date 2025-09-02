package co.com.crediya.solicitudes.domain.model;

import java.util.Arrays;

public enum TipoPrestamo {
    PERSONAL,
    HIPOTECARIO,
    VEHICULO,
    EDUCATIVO;

    public static boolean isValid(String value) {
        return Arrays.stream(values())
                .anyMatch(tipo -> tipo.name().equalsIgnoreCase(value));
    }
}
