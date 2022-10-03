package com.gtech.gtechsyst.view.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gtech.gtechsyst.model.Produto;
import com.gtech.gtechsyst.services.ProdutoService;
import com.gtech.gtechsyst.shared.ProdutoDTO;
import com.gtech.gtechsyst.view.model.ProdutoResponse;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

	@Autowired
	private ProdutoService produtoService;
	
	@GetMapping
	public ResponseEntity<List<ProdutoResponse>> obterTodos(){
		List<ProdutoDTO> produtos = produtoService.obterTodos();
		
		ModelMapper mapper = new ModelMapper();
		
		List<ProdutoResponse> resposta = produtos.stream()
				.map(produtoDto -> mapper.map(produtoDto, ProdutoResponse.class))
				.collect(Collectors.toList());
		
		return new ResponseEntity<>(resposta, HttpStatus.OK);
	}
		
	@GetMapping("/{id}")
	public ResponseEntity<Optional<ProdutoResponse>> obterPorId(@PathVariable Integer id){
//		try {
			Optional<ProdutoDTO> dto = produtoService.obterPorId(id);
			
			ProdutoResponse produto = new ModelMapper().map(dto.get(), ProdutoResponse.class);
			
			return new ResponseEntity<>(Optional.of(produto), HttpStatus.OK);
			
//		} catch (Exception e) {
//			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//		}
	}
	
	@PostMapping
	public Produto adicionar(@RequestBody Produto produto) {
		return produtoService.adicionar(produto);
	}
	
	@DeleteMapping("/{id}")
	public String deletar(@PathVariable Integer id){
		produtoService.deletar(id);
		return "Produto com o ID " + id + " foi deletado com sucesso";
	}
	
	@PutMapping("/{id}")
	public Produto atualizar(@RequestBody Produto produto, @PathVariable Integer id) {
		return produtoService.atualizar(id, produto);
		
	}
	

}