/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import javax.annotation.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import modelo.Usuario;
import persistencia.UsuarioDAO;

/**
 *
 * @author marcio
 */
@ManagedBean
@SessionScoped
public class UsuarioBean {

    private String nomeUsuario;
    private String senha;
    private UsuarioDAO dao;
    private Usuario usuario;

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    public String login() {
        
       usuario = dao.carregarUsuarioNome(nomeUsuario);
        if(usuario!=null && usuario.getSenha()==senha)
            return "boasvindas";
        else
            return "falha";
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public UsuarioDAO getDao() {
        return dao;
    }

    public void setDao(UsuarioDAO dao) {
        this.dao = dao;
    }
}
    

