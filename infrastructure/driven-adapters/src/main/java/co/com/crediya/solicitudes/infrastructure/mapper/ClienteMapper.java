package co.com.crediya.solicitudes.infrastructure.mapper;

import co.com.crediya.solicitudes.domain.model.Cliente;
import co.com.crediya.solicitudes.infrastructure.entity.ClienteEntity;

import java.util.UUID;

public class ClienteMapper {
    public static Cliente toDomain(ClienteEntity e) {
        if (e == null) return null;
        return new Cliente(e.getId(), e.getNombres(), e.getApellidos(), e.getCorreoElectronico(), e.getTelefono(), e.getDocumento());
    }

    public static ClienteEntity toEntity(Cliente c) {
        if (c == null) return null;
        ClienteEntity e = new ClienteEntity();
        e.setId(c.getId() == null ? UUID.randomUUID() : c.getId());
        e.setNombres(c.getNombres());
        e.setApellidos(c.getApellidos());
        e.setCorreoElectronico(c.getCorreoElectronico());
        e.setTelefono(c.getTelefono());
        e.setDocumento(c.getDocumento());
        return e;
    }
}
