package io.github.sergiolinss.Controller;

import io.github.sergiolinss.Entity.Produto;
import io.github.sergiolinss.Repository.RepositorioProdutos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/produtos")
public class ProdutosController {
    private RepositorioProdutos repositorioProdutos;

    @Autowired
    public ProdutosController(RepositorioProdutos repositorioProdutos){
        this.repositorioProdutos = repositorioProdutos;

    }
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK) // testando o found no get
    public Produto getProdutoById(@PathVariable Integer id){
        Optional<Produto> produto = repositorioProdutos.findById(id);

        return repositorioProdutos.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não encontrado"));

    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Produto saveProduto(@RequestBody Produto produto){

        return repositorioProdutos.save(produto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProduto(@PathVariable Integer id){
        repositorioProdutos.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não deletado, pois não existe com esse ID"));
        repositorioProdutos.deleteById(id);
    }
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateProduto(@PathVariable Integer id, @RequestBody Produto produtoToUpdate){
        Produto produtoExistente = repositorioProdutos.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "produto não encontrado"));

        produtoExistente.setDescricao(produtoToUpdate.getDescricao());
        produtoExistente.setPrecoUnitario(produtoToUpdate.getPrecoUnitario());

        repositorioProdutos.save(produtoExistente);

    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Produto> getProdutos (Produto filtrarProduto){
        ExampleMatcher matcher = ExampleMatcher.matching().withIgnoreCase().withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);

        Example example = Example.of(filtrarProduto, matcher);
        return repositorioProdutos.findAll();
    }


}
