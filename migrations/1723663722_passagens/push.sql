-- Arquivo push, insira as alterações que você deseja realizar no banco.
BEGIN TRANSACTION;
-- Codigo começa aqui
CREATE TABLE voos(
    numero VARCHAR(255),
    origem VARCHAR(255),
    destino VARCHAR(255),
    assentos_disp INTEGER
);
-- Codigo termina aqui
COMMIT;
