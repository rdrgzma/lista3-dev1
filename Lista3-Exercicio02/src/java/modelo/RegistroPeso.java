/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author 00026108
 */
@Entity
@Table(name = "registrospeso")
public class RegistroPeso implements Serializable {
    @Id
    @GeneratedValue
    private int id;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataRegistro;
    private double peso;
    @ManyToOne
    @JoinColumn(name="id_usuario")
     private Usuario usuario;
    
     public int getID() {
        return id;
    }

    public void setID(int ID) {
        this.id = ID;
    }
    

    public Date getDataRegistro() {
        return dataRegistro;
    }

    public void setDataRegistro(Date data) {
        this.dataRegistro = data;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }
    
    public String calculoIMC(double h){
        double imc = this.peso/(h*h);
        if ( imc < 18.5 ){
            return "Magreza";
        }else if(imc<24.9){
            return "Saudavel";
        }else if(imc<29.9){
             return "Sobrepeso";
        }else if(imc<34.9){
            return "Obesidade Grau I";
        }else if(imc<39.9){
            return "Obesidade Grau II";
        }
            return "Obesidade Grau III";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

}
