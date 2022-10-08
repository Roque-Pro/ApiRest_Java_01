package com.teste.primeiroexemplo.repository;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;
import com.teste.primeiroexemplo.model.Produto;

@Repository

public class ProdutoRepository {

    private ArrayList<Produto> produtos = new ArrayList<Produto>();
    private int ultimoId = 0;

    /* Metodo Retorna lista de Produtos */
    public List<Produto> obterTodos(){
        return produtos;

        
    }
    /** Metodo para obter Produto
     * @param id que sera localizado
     * @return retorna um produto caso tenha encontrado.
     */
    public Optional<Produto> obterPorId(int id) {
        return produtos.stream().filter(produto -> produto.getId() == id)
        .findFirst();
    }   

     /**Metodo para adcionar Produto
     * @param produto que sera adcionado
     * @return retorna produto que foi adcionado a lista.
     */

    public Produto adcionar(Produto produto){
        ultimoId++;
        produto.setId(ultimoId);
        produtos.add(produto);
        return produto;
    }

      /**Metodo para deletar Produto por Id
     * @param id do produto a ser deletado
     */

    public void deletar(int id){
        produtos.removeIf(produto -> produto.getId() == id);

    }

    /**Metodo para atualizar produto na lista
     *@param produto que será atualizado
     *@return retorna o produto apos atualizar lista 
     */
    public Produto atualizar(Produto produto){


        //Encontrar produto na lista
        Optional<Produto> produtoEncontrado =  obterPorId(produto.getId());

        if(produtoEncontrado.isEmpty()){
            throw new InputMismatchException("Produto não encontrado");

        }
        //Remover produto antigo da lista
        deletar(produto.getId());

        //Adcionar produto atualizado;
        produtos.add(produto);
        return produto;

        
    }
}
