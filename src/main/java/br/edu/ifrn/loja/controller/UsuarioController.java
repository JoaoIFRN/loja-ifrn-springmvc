/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrn.loja.controller;

import br.edu.ifrn.loja.dao.UsuarioDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author joaon
 */
@Controller
@RequestMapping(path = "/usuarios")
public class UsuarioController {
    
    @Autowired
    private UsuarioDAO usuarioDAO;
    
    @GetMapping(path = "/lista")
    public ModelAndView usuarios(){
        return new ModelAndView("usuarios/lista","usuarios",usuarioDAO.listar());
    }
}
