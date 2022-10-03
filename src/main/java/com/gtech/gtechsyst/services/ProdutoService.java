package com.gtech.gtechsyst.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gtech.gtechsyst.model.Produto;
import com.gtech.gtechsyst.model.exception.ResourceNotFoundException;
import com.gtech.gtechsyst.repository.ProdutoRepository;
import com.gtech.gtechsyst.shared.ProdutoDTO;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;

	/**
	 * Método para retornar uma lista de produtos
	 * 
	 * @return
	 */
	public List<ProdutoDTO> obterTodos() {
		// Poderiam haver regras de negocio aqui

		List<Produto> produtos = produtoRepository.findAll();
		return produtos.stream().map(produto -> new ModelMapper().map(produtos, ProdutoDTO.class))
				.collect(Collectors.toList());
	}

	/**
	 * Método para retornar um produto de acordo com o ID passado
	 * 
	 * @param id do produto que sera localizado.
	 * @return Retorna um produto caso seja encontrado
	 */
	public Optional<ProdutoDTO> obterPorId(Integer id) {
		// Poderiam haver regras de negocio aqui

		Optional<Produto> produto = produtoRepository.findById(id);

		if (produto.isEmpty()) {
			throw new ResourceNotFoundException("Produto com id: " + id + " não foi encontrado");
		}
		ProdutoDTO dto = new ModelMapper().map(produto.get(), ProdutoDTO.class);
		return Optional.of(dto);

	}

	/**
	 * Método para adiconar um na lista
	 * 
	 * @param produto que sera adicionado.
	 * @return Retorna o produto que foi adicionado
	 */
	public ProdutoDTO adicionar(ProdutoDTO produtoDto) {
		// Poderiam haver regras de negocio aqui

		produtoDto.setId(null);

		ModelMapper mapper = new ModelMapper();

		// Converte DTO para Model
		Produto produto = mapper.map(produtoDto, Produto.class);

		// Salva o produto
		produto = produtoRepository.save(produto);

		produtoDto.setId(produto.getId());

		return produtoDto;
	}

	/**
	 * Método para deletar um produto por id
	 * 
	 * @param id do produto que sera deletado
	 */
	public void deletar(Integer id) {

		Optional<Produto> produto = produtoRepository.findById(id);

		if (produto.isEmpty()) {
			throw new ResourceNotFoundException("Não foi possivel deletar o produto com id: " + id);
		}

		produtoRepository.deleteById(id);
	}

	/**
	 * Método para atualizar um produto da lista
	 * 
	 * @param produto que sera atualizado
	 * @param id      do produto
	 * @return retorna o produto após atualizar na lista
	 */
	public ProdutoDTO atualizar(Integer id, ProdutoDTO produtoDto) {

		produtoDto.setId(id);

		ModelMapper mapper = new ModelMapper();

		Produto produto = mapper.map(produtoDto, Produto.class);
		
		produtoRepository.save(produto);

		return produtoDto;
	}
}
