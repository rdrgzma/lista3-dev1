/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author 00026108
 */
@ManagedBean
@SessionScoped
public class NumberQuiz {
    private int score = 0;
    private int resposta = 0;
    private int tentativas = 0;
    private int palpite = 0;
    private String msg ="";

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getResposta() {
        return resposta;
    }

    public void setResposta(int resposta) {
        this.resposta = resposta;
    }

    public int getTentativas() {
        return tentativas;
    }

    public void setTentativas(int tentativas) {
        this.tentativas = tentativas;
    }
    
     public int getPalpite() {
        return palpite;
    }

    public void setPalpite(int palpite) {
        this.palpite = palpite;
    }
    
      public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
     public String responder() {
        tentativas++;
        if(palpite == getResposta()) {
            score++;
            
            return "acerto";
        } else {
            if(palpite < getResposta()){
                msg = "O seu palpite é Menor que o número sorteado!";
            }else{
                msg = "o seu palpite é Maior que o número sorteado!";
            }
            palpite =0;
        }
            return "repetir";
       
    }
     
       public String reiniciar() {
       msg = "";
        score = 0;
        tentativas = 0;
        resposta = 0;
        palpite = 0;
        return "inicio";
    }

  

   
}
