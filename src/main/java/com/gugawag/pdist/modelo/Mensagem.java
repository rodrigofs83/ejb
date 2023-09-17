package com.gugawag.pdist.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.io.Serializable;

@Entity(name = "tb_memsagem")
public class Mensagem  implements Serializable {
    @Id
    private Long id;
    private  String  text;
    public Mensagem(){

    }
    public Mensagem(Long id , String text){
        this.id = id;
        this.text = text;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Long getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
