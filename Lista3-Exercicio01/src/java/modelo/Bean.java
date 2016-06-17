package modelo;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class Bean {
    private String nomeUsuario;
   

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }
 
    public String login() {
        if(nomeUsuario.equals(""))
            return "erro";
        else
            return "sucesso";
    }
}
