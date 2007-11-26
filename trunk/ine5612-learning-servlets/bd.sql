-- phpMyAdmin SQL Dump
-- version 2.10.3deb1
-- http://www.phpmyadmin.net
-- 
-- Servidor: localhost
-- Tempo de Geração: Nov 26, 2007 as 01:52 AM
-- Versão do Servidor: 5.0.45
-- Versão do PHP: 5.2.3-1ubuntu6

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";

-- 
-- Banco de Dados: `ine5612`
-- 

-- --------------------------------------------------------

-- 
-- Estrutura da tabela `Fornecedor`
-- 

CREATE TABLE IF NOT EXISTS `Fornecedor` (
  `idFornecedor` int(10) unsigned NOT NULL auto_increment,
  `idProduto` int(10) unsigned NOT NULL,
  `nome_fantasia` varchar(80) NOT NULL,
  `endereco` varchar(100) NOT NULL,
  `cidade` varchar(50) NOT NULL,
  `estado` varchar(50) NOT NULL,
  `pais` varchar(80) NOT NULL,
  `telefone` varchar(20) default NULL,
  `email` varchar(100) default NULL,
  `contato` varchar(50) default NULL,
  PRIMARY KEY  (`idFornecedor`),
  KEY `Fornecedor_FKIndex1` (`idProduto`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;



-- --------------------------------------------------------

-- 
-- Estrutura da tabela `Produto`
-- 

CREATE TABLE IF NOT EXISTS `Produto` (
  `idProduto` int(10) unsigned NOT NULL auto_increment,
  `nome` varchar(80) NOT NULL,
  `preco` decimal(5,2) NOT NULL,
  PRIMARY KEY  (`idProduto`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=7 ;

-- 
-- Extraindo dados da tabela `Produto`
-- 

INSERT INTO `Produto` (`idProduto`, `nome`, `preco`) VALUES 
(1, 'Tenis', 20.00),
(2, 'Sapato', 30.00),
(3, 'Calça', 14.00),
(4, 'Camiseta', 10.00),
(5, 'Acessórios', 50.00),
(6, 'Chapeu', 23.50);

-- 
-- Restrições para as tabelas dumpadas
-- 

-- 
-- Restrições para a tabela `Fornecedor`
-- 
ALTER TABLE `Fornecedor`
  ADD CONSTRAINT `Fornecedor_ibfk_1` FOREIGN KEY (`idProduto`) REFERENCES `Produto` (`idProduto`) ON DELETE NO ACTION ON UPDATE NO ACTION;
