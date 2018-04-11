/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrn.loja.model;

import java.util.ArrayList;
import java.util.List;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

/**
 *
 * @author joaon
 */
@Component
//@Scope(value = WebApplicationContext.SCOPE_SESSION)
public class CarrinhoCompra {
    
    private List<ItemCarrinho> itens = new ArrayList();

    public void adicionarItem(ItemCarrinho item){
        itens.add(item);
    }
    
    public List<ItemCarrinho> getItens() {
        return itens;
    }

    public void setItens(List<ItemCarrinho> itens) {
        this.itens = itens;
    }            
        
}
