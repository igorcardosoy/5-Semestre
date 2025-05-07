insert into departamentos (codigo, nome) values
(1, 'Recursos Humanos'),
(2, 'Financeiro'),
(3, 'TI'),
(4, 'Marketing'),
(5, 'Vendas');

insert into funcionarios (data_cadastro, matricula, nome, cargo, altura, departamento_id) values
('2023-01-01 10:00:00', 1234567890, 'João Silva', 'Analista', 1.75, 1),
('2023-01-02 11:00:00', 2345678901, 'Maria Oliveira', 'Gerente', 1.65, 2),
('2023-01-03 12:00:00', 3456789012, 'Pedro Santos', 'Desenvolvedor', 1.80, 3),
('2023-01-04 13:00:00', 4567890123, 'Ana Costa', 'Coordenador', 1.70, 4),
('2023-01-05 14:00:00', 5678901234, 'Lucas Almeida', 'Assistente', 1.78, 5);