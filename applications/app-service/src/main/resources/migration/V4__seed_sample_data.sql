INSERT INTO clientes (id, nombres, apellidos, fecha_nacimiento, direccion, telefono, correo_electronico, documento, salario_base)
VALUES (gen_random_uuid(), 'Juan', 'Pérez', '1990-05-10', 'Cra 10 # 20-30', '3001234567', 'juan.perez@example.com', 'CC123456', 1200000)
    ON CONFLICT (correo_electronico) DO NOTHING;
