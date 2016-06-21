/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.List;
import modelo.Usuario;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author marcio
 */
public class UsuarioDAO {
    private final Session sessao;
    
    public UsuarioDAO() {
         sessao = HibernateUtil.getSessionFactory().openSession();
        
    }
    
    public void salvar(Usuario s) {
        Transaction t = sessao.beginTransaction();
        sessao.saveOrUpdate(s);
        t.commit();
    }
    
    public void atualizar(Usuario s){
        sessao.update(s);
    }
    
    public Usuario carregar(int id) {
        return (Usuario) sessao.load(Usuario.class, id);
    }
    
    public Usuario carregarUsuarioNome(String nome){
        return (Usuario)sessao.load(Usuario.class, nome);
    }
    
    public void remover(int id) {
        Transaction t = sessao.beginTransaction();
        t.begin();
        
        sessao.delete(carregar(id));
        t.commit();
    }
    
    public List<Usuario> listar() {
        return sessao.createCriteria(Usuario.class).list();
    } 
    
    public void encerrar() {
            sessao.close();
   
    }
    
}
