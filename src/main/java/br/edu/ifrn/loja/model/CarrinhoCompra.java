/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrn.loja.model;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

/**
 *
 * @author joaon
 */
@Component
@Scope(value = WebApplicationContext.SCOPE_SESSION)
public class CarrinhoCompra {
    
    private Map<Integer,ItemCarrinho> itens = new LinkedHashMap<Integer,ItemCarrinho>();

    public void adicionarItem(ItemCarrinho item){
        itens.put(item.getProduto().getId(),item);
    }
    
    public List<ItemCarrinho> getItens() {
        return (List<ItemCarrinho>) itens.values();
    }    
        
}
