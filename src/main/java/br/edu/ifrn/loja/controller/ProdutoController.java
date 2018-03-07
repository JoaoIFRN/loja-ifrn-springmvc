/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrn.loja.controller;

import br.edu.ifrn.loja.dao.ProdutoDAO;
import br.edu.ifrn.loja.model.Produto;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author joaon
 */
@Controller
public class ProdutoController {
    
    @Autowired
    private ProdutoDAO produtoDAO;
    
    @RequestMapping("produtos")
    public ModelAndView produtos(){
        List<Produto> produtos = produtoDAO.listar();
        ModelAndView modelAndView = new ModelAndView("list");
        modelAndView.addObject("produtos", produtos);
        return modelAndView;
    }
}
