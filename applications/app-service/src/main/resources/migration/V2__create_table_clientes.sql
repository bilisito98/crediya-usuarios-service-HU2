CREATE TABLE IF NOT EXISTS clientes (
                                        id uuid PRIMARY KEY DEFAULT gen_random_uuid(),
    nombres varchar(120) NOT NULL,
    apellidos varchar(120) NOT NULL,
    fecha_nacimiento date,
    direccion text,
    telefono varchar(40),
    correo_electronico varchar(150) NOT NULL,
    documento varchar(60),
    salario_base numeric(15,2) CHECK (salario_base >= 0 AND salario_base <= 15000000),
    created_at timestamptz NOT NULL DEFAULT now(),
    updated_at timestamptz NOT NULL DEFAULT now()
    );


CREATE UNIQUE INDEX IF NOT EXISTS ux_clientes_correo ON clientes(correo_electronico);
