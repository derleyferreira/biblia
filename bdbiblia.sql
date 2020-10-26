BEGIN TRANSACTION;
CREATE TABLE IF NOT EXISTS `VERSOS` (
	`PK_VERSO`	INTEGER NOT NULL,
	`LIVRO_FK`	INTEGER NOT NULL,
	`CAPITULO`	INTEGER NOT NULL,
	`NRO_VERSO`	INTEGER NOT NULL,
	`TEXTO`	TEXT,
	PRIMARY KEY(`PK_VERSO`)
);
CREATE TABLE IF NOT EXISTS `PERFIL` (
	`PK_PERFIL`	INTEGER NOT NULL,
	`FOTO`	BLOB,
	`NOME`	TEXT NOT NULL,
	`IGREJA`	TEXT,
	`NOME_PASTOR`	TEXT,
	`DATA_BATISMO`	TEXT,
	PRIMARY KEY(`PK_PERFIL`)
);
CREATE TABLE IF NOT EXISTS `LIVRO` (
	`PK`	INTEGER NOT NULL,
	`TESTAMENTO`	INTEGER NOT NULL,
	`NUMERO`	INTEGER NOT NULL,
	`NOME`	TEXT NOT NULL,
	PRIMARY KEY(`PK`)
);
COMMIT;