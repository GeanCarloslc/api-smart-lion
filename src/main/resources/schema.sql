-- Tabela de Usuários
CREATE TABLE usuario (
    id SERIAL PRIMARY KEY,  -- Identificador único do usuário
    nome VARCHAR(100) NOT NULL,  -- Nome completo do usuário
    email VARCHAR(100) UNIQUE NOT NULL,  -- E-mail único do usuário
    senha VARCHAR(255) NOT NULL,  -- Senha de acesso do usuário
    data_criacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP  -- Data e hora de criação do usuário
);

-- Adicionando comentários para a tabela e colunas
COMMENT ON TABLE usuario IS 'Tabela que armazena os dados dos usuários';
COMMENT ON COLUMN usuario.id IS 'Identificador único do usuário';
COMMENT ON COLUMN usuario.nome IS 'Nome completo do usuário';
COMMENT ON COLUMN usuario.email IS 'E-mail único do usuário';
COMMENT ON COLUMN usuario.senha IS 'Senha de acesso do usuário';
COMMENT ON COLUMN usuario.data_criacao IS 'Data e hora de criação do usuário';

-- Tabela de Categorias de Gasto
CREATE TABLE categoria_gasto (
    id SERIAL PRIMARY KEY,  -- Identificador único da categoria de gasto
    nome VARCHAR(100) NOT NULL,  -- Nome da categoria de gasto (exemplo: Alimentação, Transporte, etc.)
    descricao VARCHAR(255)  -- Descrição detalhada da categoria de gasto
);

-- Adicionando comentários para a tabela e colunas
COMMENT ON TABLE categoria_gasto IS 'Tabela que armazena as categorias de gasto';
COMMENT ON COLUMN categoria_gasto.id IS 'Identificador único da categoria de gasto';
COMMENT ON COLUMN categoria_gasto.nome IS 'Nome da categoria de gasto';
COMMENT ON COLUMN categoria_gasto.descricao IS 'Descrição detalhada da categoria de gasto';

-- Tabela de Recursos do Usuário
CREATE TABLE recursos_usuario (
    id SERIAL PRIMARY KEY,  -- Identificador único do recurso do usuário
    usuario_id INTEGER REFERENCES usuario(id) ON DELETE CASCADE,  -- Chave estrangeira para o usuário
    data DATE NOT NULL,  -- Data que representa o mês e ano do recurso (exemplo: '2024-11-01' para novembro de 2024)
    renda DECIMAL(10, 2) NOT NULL  -- Valor da renda mensal do usuário
);

-- Adicionando comentários para a tabela e colunas
COMMENT ON TABLE recursos_usuario IS 'Tabela que armazena os recursos mensais do usuário';
COMMENT ON COLUMN recursos_usuario.id IS 'Identificador único do recurso do usuário';
COMMENT ON COLUMN recursos_usuario.usuario_id IS 'Chave estrangeira para o usuário';
COMMENT ON COLUMN recursos_usuario.data IS 'Data que representa o mês e ano do recurso';
COMMENT ON COLUMN recursos_usuario.renda IS 'Valor da renda mensal do usuário';

-- Tabela de Meta de Gasto
CREATE TABLE meta_gasto (
    id SERIAL PRIMARY KEY,  -- Identificador único da meta de gasto
    categoria_id INTEGER REFERENCES categoria_gasto(id) ON DELETE CASCADE,  -- Chave estrangeira para a categoria de gasto
    valor_meta DECIMAL(10, 2) NOT NULL,  -- Valor da meta de gasto para a categoria específica
    recursos_usuario_id INTEGER REFERENCES recursos_usuario(id) ON DELETE CASCADE  -- Chave estrangeira para os recursos do usuário
);

-- Adicionando comentários para a tabela e colunas
COMMENT ON TABLE meta_gasto IS 'Tabela que armazena as metas de gasto por categoria para o usuário';
COMMENT ON COLUMN meta_gasto.id IS 'Identificador único da meta de gasto';
COMMENT ON COLUMN meta_gasto.categoria_id IS 'Chave estrangeira para a categoria de gasto';
COMMENT ON COLUMN meta_gasto.valor_meta IS 'Valor da meta de gasto para a categoria específica';
COMMENT ON COLUMN meta_gasto.recursos_usuario_id IS 'Chave estrangeira para os recursos do usuário';

-- Tabela de Gastos
CREATE TABLE gasto (
    id SERIAL PRIMARY KEY,  -- Identificador único do gasto
    usuario_id INTEGER REFERENCES usuario(id) ON DELETE CASCADE,  -- Chave estrangeira para o usuário que fez o gasto
    categoria_id INTEGER REFERENCES categoria_gasto(id) ON DELETE CASCADE,  -- Chave estrangeira para a categoria de gasto
    valor DECIMAL(10, 2) NOT NULL,  -- Valor do gasto
    descricao VARCHAR(255),  -- Descrição detalhada do gasto
    data DATE NOT NULL,  -- Data em que o gasto ocorreu
    recursos_usuario_id INTEGER REFERENCES recursos_usuario(id)  -- Chave estrangeira para os recursos do usuário
);

-- Adicionando comentários para a tabela e colunas
COMMENT ON TABLE gasto IS 'Tabela que armazena os gastos do usuário';
COMMENT ON COLUMN gasto.id IS 'Identificador único do gasto';
COMMENT ON COLUMN gasto.usuario_id IS 'Chave estrangeira para o usuário que realizou o gasto';
COMMENT ON COLUMN gasto.categoria_id IS 'Chave estrangeira para a categoria de gasto';
COMMENT ON COLUMN gasto.valor IS 'Valor do gasto realizado';
COMMENT ON COLUMN gasto.descricao IS 'Descrição detalhada do gasto';
COMMENT ON COLUMN gasto.data IS 'Data em que o gasto ocorreu';
COMMENT ON COLUMN gasto.recursos_usuario_id IS 'Chave estrangeira para os recursos do usuário';