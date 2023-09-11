--Popula a tabela de especialidades
INSERT 
  INTO TbEspecialidade(COD_ESPECIALIDADE, NM_ESPECIALIDADE)
VALUES (1,'Clínica Geral');
INSERT 
  INTO TbEspecialidade(COD_ESPECIALIDADE, NM_ESPECIALIDADE)
VALUES (2,'Oftalmologista');
INSERT 
  INTO TbEspecialidade(COD_ESPECIALIDADE, NM_ESPECIALIDADE)
VALUES (3,'Ginicologista');
INSERT 
  INTO TbEspecialidade(COD_ESPECIALIDADE, NM_ESPECIALIDADE)
VALUES (4,'Urologista');

-- Popula a tabela de beneficiarios
INSERT 
  INTO TbBeneficiario(CPF, NM_BENEFICIARIO, DT_NASCIMENTO)
VALUES ('12345678901','ANA DAS QUANTAS', '1980-05-29');

INSERT 
  INTO TbBeneficiario(CPF, NM_BENEFICIARIO, DT_NASCIMENTO)
VALUES ('23456789011','JOSE DAS NEVES', '1990-12-15');


SELECT *
  FROM TbBeneficiario;

SELECT *
  FROM TbConsulta;

SELECT *
  FROM TbEspecialidade;


