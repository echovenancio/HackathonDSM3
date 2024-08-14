-- Arquivo push, insira as alterações que você deseja realizar no banco.
BEGIN;
CREATE TABLE pedido(
    numero INTEGER,
    mesa INTEGER
);

CREATE TABLE item(
    nome VARCHAR(255) NOT NULL,
    preco REAL,
    quantidade INTEGER,
    pedido_rowid INTEGER,
    FOREIGN KEY(pedido_rowid) REFERENCES pedido(ROWID)
);
COMMIT;
