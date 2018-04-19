/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrn.loja.controller;

import br.edu.ifrn.loja.dao.ProdutoDAO;
import br.edu.ifrn.loja.model.CarrinhoCompra;
import br.edu.ifrn.loja.model.ItemCarrinho;
import br.edu.ifrn.loja.model.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author joaon
 */
@Controller
@RequestMapping(path = "/carrinho")
@Scope(value = WebApplicationContext.SCOPE_REQUEST)
public class CarrinhoController {

    @Autowired
    private CarrinhoCompra carrinhoCompra;

    @Autowired
    private ProdutoDAO produtoDAO;

    @GetMapping(path = "/add/{id}")
    public ModelAndView adicionarItem(@PathVariable("id") Integer id) {
        carrinhoCompra.adicionarItem(criarItemCarrinho(id));
        ModelAndView modelAndView = new ModelAndView("/produtos/lista");
        modelAndView.addObject("produtos", produtoDAO.listar());
        return modelAndView;
    }

    private ItemCarrinho criarItemCarrinho(Integer id) {
        Produto produto = produtoDAO.buscarProduto(id);
        ItemCarrinho itemCarrinho = new ItemCarrinho();
        itemCarrinho.setProduto(produto);
        itemCarrinho.setQuantidade(1);
        return itemCarrinho;
    }

}
