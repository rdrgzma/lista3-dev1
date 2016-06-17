/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Date;

/**
 *
 * @author 00026108
 */
public class RegistroPeso {
    private Date data;
    private double peso;

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
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
    
    
}
