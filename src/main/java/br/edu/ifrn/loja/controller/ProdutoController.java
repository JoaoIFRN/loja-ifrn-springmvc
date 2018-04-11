/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrn.loja.controller;

import br.edu.ifrn.loja.dao.ProdutoDAO;
import br.edu.ifrn.loja.model.Produto;
import br.edu.ifrn.loja.utilidades.FileSaver;
import java.io.IOException;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author joaon
 */
@Controller
@RequestMapping(path = "/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoDAO produtoDAO;
    
    @Autowired
    private FileSaver fileSaver;

    @GetMapping(path = "/lista")
    public ModelAndView produtos() {
        List<Produto> produtos = produtoDAO.listar();
        ModelAndView modelAndView = new ModelAndView("/produtos/lista");
        modelAndView.addObject("produtos", produtos);
        return modelAndView;
    }

    @GetMapping(path = "/form")
    public String exibirForm(Produto produto) {                
        return "/produtos/form";
    }

    @PostMapping
    public String salvar(MultipartFile foto, @Valid @ModelAttribute("produto") Produto produto, BindingResult bind, RedirectAttributes redirectAttributes) throws IOException {

        //System.out.println(foto.getOriginalFilename());
        
        if (bind.hasErrors()) {
            return "/produtos/form";
        }
        
        String path = fileSaver.write("arquivos-foto", foto);
        produto.setFotoPath(path);

        boolean atualizar = produto.getId() == null ? false : true;
        produtoDAO.salvar(produto);
        if (atualizar) {
            redirectAttributes.addFlashAttribute("mensagem", "Produto atualizado com sucesso.");
        } else {
            redirectAttributes.addFlashAttribute("mensagem", "Produto salvo com sucesso.");
        }
        return "redirect:/produtos/lista";
    }

    @GetMapping(path = "/excluir/{id}")
    public String excluir(@PathVariable("id") int id, RedirectAttributes redirectAttributes) {
        produtoDAO.excluir(id);
        redirectAttributes.addFlashAttribute("mensagem", "Produto excluído com sucesso.");
        return "redirect:/produtos/lista";
    }

    @GetMapping(path = "/atualizar/{id}")
    public ModelAndView preAtualizar(@PathVariable("id") Integer id) {
        Produto produto = produtoDAO.buscarProduto(id);
        return new ModelAndView("/produtos/form", "produto", produto);
    }
    
    @GetMapping(path = "/detalhe/{id}")
    public ModelAndView detalhe(@PathVariable("id") Integer id) {
        Produto produto = produtoDAO.buscarProduto(id);
        return new ModelAndView("/produtos/detalhe", "produto", produto);
    }
}
