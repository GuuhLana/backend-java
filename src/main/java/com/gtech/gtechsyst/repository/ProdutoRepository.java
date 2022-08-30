package com.gtech.gtechsyst.repository;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.gtech.gtechsyst.model.Produto;
import com.gtech.gtechsyst.model.exception.ResourceNotFoundException;

@Repository
public class ProdutoRepository {
	
	//Simulação de banco de dados
	private List<Produto> produtos = new ArrayList<Produto>();
	private Integer ultimoId = 0;
	
	
	//Retorna uma lista com os produtos
	public List<Produto> obterTodos(){
		return produtos;
	}
	
	//Retorna produto encontrado pelo ID
	public Optional<Produto> obterPorId(Integer id) {
		return produtos
				.stream()
				.filter(produto -> produto.getId() == id)
				.findFirst();
	}
	
	//Adiciona  um produto a lista de produtos
	public Produto adicionar(Produto produto) {
		
		ultimoId++ ;
		
		produto.setId(ultimoId);
		produtos.add(produto);
		
		return produto;
	}
	
	//Deleta o produto pelo seu ID
	public void deletar(Integer id) {
		produtos.removeIf(produto -> produto.getId() == id);
	}
	
	//Atualizar o poduto
	public Produto atualizar(Produto produto) {
		
		//Encontra o produto
		Optional<Produto> produtoEncontrado = obterPorId(produto.getId());
		
		if (produtoEncontrado.isEmpty()) {
			throw new ResourceNotFoundException("Produto nao encontrado");
		}
		
		//Remover o produto antigo
		deletar(produto.getId());
		
		//Adicionar o produto novo a lista
		produtos.add(produto);

		return produto;
		
	}
}
