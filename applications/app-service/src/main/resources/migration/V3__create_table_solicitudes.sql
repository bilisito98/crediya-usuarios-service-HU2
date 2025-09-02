CREATE TABLE IF NOT EXISTS solicitudes (
                                           id uuid PRIMARY KEY DEFAULT gen_random_uuid(),
    cliente_id uuid NOT NULL,
    monto numeric(15,2) NOT NULL CHECK (monto > 0),
    plazo_meses integer NOT NULL CHECK (plazo_meses > 0),
    estado varchar(20) NOT NULL DEFAULT 'PENDIENTE',
    fecha_solicitud date NOT NULL DEFAULT CURRENT_DATE,
    created_at timestamptz NOT NULL DEFAULT now(),
    updated_at timestamptz NOT NULL DEFAULT now(),
    CONSTRAINT fk_solicitud_cliente FOREIGN KEY (cliente_id) REFERENCES clientes(id) ON DELETE CASCADE
    );

CREATE INDEX IF NOT EXISTS ix_solicitudes_cliente ON solicitudes(cliente_id);
