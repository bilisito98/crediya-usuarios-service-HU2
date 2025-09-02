package co.com.crediya.solicitudes.domain.model;

import java.util.UUID;

public class Cliente {
    private UUID id;
    private String nombres;
    private String apellidos;
    private String correoElectronico;
    private String telefono;
    private String documento;

    public Cliente(UUID id, String nombres, String apellidos, String correoElectronico, String telefono, String documento) {
        this.id = id;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.correoElectronico = correoElectronico;
        this.telefono = telefono;
        this.documento = documento;
    }

    public UUID getId() { return id; }
    public String getNombres() { return nombres; }
    public String getApellidos() { return apellidos; }
    public String getCorreoElectronico() { return correoElectronico; }
    public String getTelefono() { return telefono; }
    public String getDocumento() { return documento; }
}
