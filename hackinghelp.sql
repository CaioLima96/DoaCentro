-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 24-Maio-2020 às 07:29
-- Versão do servidor: 10.4.11-MariaDB
-- versão do PHP: 7.4.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `hackinghelp`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `centro`
--

CREATE TABLE `centro` (
  `id` int(11) NOT NULL,
  `nome_centro` varchar(50) NOT NULL,
  `telefone` varchar(12) NOT NULL,
  `fk_endereco` int(11) NOT NULL,
  `descricao` varchar(255) DEFAULT NULL,
  `fk_usuario` int(11) NOT NULL,
  `desabilitar` tinyint(1) DEFAULT 1,
  `higiene` tinyint(4) DEFAULT 0,
  `alimentos` tinyint(4) DEFAULT 0,
  `limpeza` tinyint(4) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `centro`
--

INSERT INTO `centro` (`id`, `nome_centro`, `telefone`, `fk_endereco`, `descricao`, `fk_usuario`, `desabilitar`, `higiene`, `alimentos`, `limpeza`) VALUES
(1, 'Centro amigos do Jesus', '2158955487', 1, 'Fazemos doação para os pobres fuzileiros da Resilia', 1, 1, 1, 1, 0),
(7, 'Centro de Kuduro Brasil-Angola', '2158955487', 1, 'Dança Kuduro', 1, 1, 1, 1, 0);

-- --------------------------------------------------------

--
-- Estrutura da tabela `endereco`
--

CREATE TABLE `endereco` (
  `id` int(11) NOT NULL,
  `cep` varchar(10) NOT NULL,
  `logradouro` varchar(100) NOT NULL,
  `bairro` varchar(50) NOT NULL,
  `cidade` varchar(50) NOT NULL,
  `fk_estado` int(11) NOT NULL,
  `numero` varchar(4) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `endereco`
--

INSERT INTO `endereco` (`id`, `cep`, `logradouro`, `bairro`, `cidade`, `fk_estado`, `numero`) VALUES
(1, '22260126', 'Rua Mestre Diniz', 'Botafogo', 'Rio de Janeiro', 1, '37'),
(2, '22260126', 'Rua Mestre Diniz', 'Botafogo', 'Rio de Janeiro', 1, '37');

-- --------------------------------------------------------

--
-- Estrutura da tabela `estado`
--

CREATE TABLE `estado` (
  `id` int(11) NOT NULL,
  `nome` varchar(50) NOT NULL,
  `uf` char(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `estado`
--

INSERT INTO `estado` (`id`, `nome`, `uf`) VALUES
(1, 'Rio de Janeiro', 'RJ'),
(2, 'São Paulo', 'SP'),
(3, 'Minas Gerais', 'MG');

-- --------------------------------------------------------

--
-- Estrutura da tabela `usuario`
--

CREATE TABLE `usuario` (
  `id` int(11) NOT NULL,
  `nome_completo` varchar(80) NOT NULL,
  `cpf_cnpj` varchar(18) NOT NULL,
  `telefone` varchar(12) NOT NULL,
  `email` varchar(100) NOT NULL,
  `senha` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `usuario`
--

INSERT INTO `usuario` (`id`, `nome_completo`, `cpf_cnpj`, `telefone`, `email`, `senha`) VALUES
(1, 'Célio Pinto', '17898565741', '2158955487', 'celiho@gmail.com', '1263');

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `centro`
--
ALTER TABLE `centro`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_usuario` (`fk_usuario`),
  ADD KEY `fk_endereco` (`fk_endereco`);

--
-- Índices para tabela `endereco`
--
ALTER TABLE `endereco`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_estado` (`fk_estado`);

--
-- Índices para tabela `estado`
--
ALTER TABLE `estado`
  ADD PRIMARY KEY (`id`);

--
-- Índices para tabela `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `centro`
--
ALTER TABLE `centro`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT de tabela `endereco`
--
ALTER TABLE `endereco`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de tabela `estado`
--
ALTER TABLE `estado`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de tabela `usuario`
--
ALTER TABLE `usuario`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Restrições para despejos de tabelas
--

--
-- Limitadores para a tabela `centro`
--
ALTER TABLE `centro`
  ADD CONSTRAINT `centro_ibfk_1` FOREIGN KEY (`fk_usuario`) REFERENCES `usuario` (`id`),
  ADD CONSTRAINT `centro_ibfk_2` FOREIGN KEY (`fk_endereco`) REFERENCES `endereco` (`id`);

--
-- Limitadores para a tabela `endereco`
--
ALTER TABLE `endereco`
  ADD CONSTRAINT `endereco_ibfk_1` FOREIGN KEY (`fk_estado`) REFERENCES `estado` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
