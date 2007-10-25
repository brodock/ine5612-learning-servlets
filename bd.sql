-- phpMyAdmin SQL Dump
-- version 2.10.3deb1
-- http://www.phpmyadmin.net
-- 
-- Servidor: localhost
-- Tempo de Geração: Out 18, 2007 as 07:26 PM
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
  `nome_fantasia` int(10) unsigned default NULL,
  `endereco` varchar(100) default NULL,
  `cidade` varchar(50) default NULL,
  `estado` varchar(50) default NULL,
  `pais` varchar(80) default NULL,
  `telefone` varchar(20) default NULL,
  `email` varchar(100) default NULL,
  `contato` varchar(50) default NULL,
  PRIMARY KEY  (`idFornecedor`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- 
-- Extraindo dados da tabela `Fornecedor`
-- 


-- --------------------------------------------------------

-- 
-- Estrutura da tabela `Produto`
-- 

CREATE TABLE IF NOT EXISTS `Produto` (
  `idProduto` int(10) unsigned NOT NULL auto_increment,
  `idFornecedor` int(10) unsigned NOT NULL,
  `nome` varchar(80) default NULL,
  `preco` decimal(5,2) default NULL,
  PRIMARY KEY  (`idProduto`),
  KEY `Produto_FKIndex1` (`idFornecedor`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- 
-- Extraindo dados da tabela `Produto`
-- 


-- 
-- Restrições para as tabelas dumpadas
-- 

-- 
-- Restrições para a tabela `Produto`
-- 
ALTER TABLE `Produto`
  ADD CONSTRAINT `Produto_ibfk_1` FOREIGN KEY (`idFornecedor`) REFERENCES `Fornecedor` (`idFornecedor`) ON UPDATE CASCADE;

