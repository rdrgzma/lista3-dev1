/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.List;
import modelo.RegistroPeso;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author marcio
 */
public class RegistroPesoDAO {
    private final Session sessao;

    public RegistroPesoDAO() {
        this.sessao = HibernateUtil.getSessionFactory().openSession();
    }
    
    
    
        public void salvar(RegistroPeso s) {
        Transaction t = sessao.beginTransaction();
        sessao.saveOrUpdate(s);
        t.commit();
    }
    
    public void atualizar(RegistroPeso s){
        sessao.update(s);
    }
    
    public RegistroPeso carregar(int id) {
        return (RegistroPeso) sessao.load(RegistroPeso.class, id);
    }
    
    public void remover(int id) {
        Transaction t = sessao.beginTransaction();
        t.begin();
        
        sessao.delete(carregar(id));
        t.commit();
    }
    
    public List<RegistroPeso> listarTodosRegistros() {
        return sessao.createCriteria(RegistroPeso.class).list();
    } 
    
    public List<RegistroPeso>listarRegistrosPesoUsuario(int id){
        List<RegistroPeso> registros = sessao.createQuery("from RegistroPeso where id_usuario = :id ").setInteger("id", id).list();
        return registros;
    }
    
    public void encerrar() {
            sessao.close();
   
    }
    
}
