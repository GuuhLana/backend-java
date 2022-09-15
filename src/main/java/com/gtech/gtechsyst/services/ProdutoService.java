package com.gtech.gtechsyst.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gtech.gtechsyst.model.Produto;
import com.gtech.gtechsyst.repository.ProdutoRepository_old;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository_old produtoRepository;

	/**
	 * Método para retornar uma lista de produtos
	 * 
	 * @return
	 */
	public List<Produto> obterTodos() {
		// Poderiam haver regras de negocio aqui
		return produtoRepository.obterTodos();
	}

	/**
	 * Método para retornar um produto de acordo com o ID passado
	 * 
	 * @param id do produto que sera localizado.
	 * @return Retorna um produto caso seja encontrado
	 */
	public Optional<Produto> obterPorId(Integer id) {
		// Poderiam haver regras de negocio aqui
		return produtoRepository.obterPorId(id);
	}

	/**
	 * Método para adiconar um na lista
	 * 
	 * @param produto que sera adicionado.
	 * @return Retorna o produto que foi adicionado
	 */
	public Produto adicionar(Produto produto) {
		// Poderiam haver regras de negocio aqui
		return produtoRepository.adicionar(produto);
	}

	/**
	 * Método para deletar um produto por id
	 * 
	 * @param id do produto que sera deletado
	 */
	public void deletar(Integer id) {
		// Poderiam haver regras de negocio aqui
		produtoRepository.deletar(id);
	}

	/**
	 * Método para atualizar um produto da lista
	 * 
	 * @param produto que sera atualizado
	 * @param id do produto
	 * @return retorna o produto após atualizar na lista
	 */
	public Produto atualizar(Integer id, Produto produto) {
		// Poderiam haver validações aqui
		produto.setId(id);

		return produtoRepository.atualizar(produto);
	}
}
