package com.gtech.gtechsyst.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

	@Autowired
	private ProdutoService produtoService;
	
	@GetMapping
	public ResponseEntity<List<Produto>> obterTodos(){
		return ResponseEntity.ok(produtoService.obterTodos()) ;
	}
		
	@GetMapping("/{id}")
	public Optional<Produto> obterPorId(@PathVariable Integer id){
		return produtoService.obterPorId(id);
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
