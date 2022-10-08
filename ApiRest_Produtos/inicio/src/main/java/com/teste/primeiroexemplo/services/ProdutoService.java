package com.teste.primeiroexemplo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.teste.primeiroexemplo.model.Produto;
import com.teste.primeiroexemplo.repository.ProdutoRepository;

@Service
public class ProdutoService {
    
    @Autowired
    private ProdutoRepository produtoRepository;


     /**Metodo para adcionar Produto
     * @param produto que sera adcionado
     * @return retorna produto que foi adcionado a lista.
     */
    public List<Produto> obterTodos(){
        return produtoRepository.obterTodos();
    }

      /** Metodo para obter Produto
     * @param id que sera localizado
     * @return retorna um produto caso tenha encontrado.
     */
    public Optional<Produto> obterPorId(int id) {
       return produtoRepository.obterPorId(id);
    } 

       /**Metodo para adcionar Produto
     * @param produto que sera adcionado
     * @return retorna produto que foi adcionado a lista.
     */

    public Produto adcionar(Produto produto){
        /**Poderia ter regra de negocio para validar produto */
      return produtoRepository.adcionar(produto);
    }
        /**Metodo para deletar Produto por Id
     * @param id do produto a ser deletado
     */

    public void deletar(int id){
        produtoRepository.deletar(id);
    }

     /**Metodo para atualizar produto na lista
     *@param produto que será atualizado
     *@return retorna o produto apos atualizar lista 
     */
    public Produto atualizar(int id, Produto produto){
        //Poderia ter varicao no ID
        produto.setId(id);

        return produtoRepository.atualizar(produto);


        
    }
}
