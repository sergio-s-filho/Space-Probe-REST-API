package com.example.sonda.model;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "TB_SONDAS")


public class SondaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    private int posX;

    @Column(nullable = false)
    private int posY;

    @Column(nullable = false)
    private char orientacao;

    @Transient
    private char[] posicoes = {'N','L','S','O'};

    @Transient
    private int rotacao;


    public void followCommands(String commands){
        rotacao = new String(posicoes).indexOf(orientacao);
        for(int i = 0; i < commands.length(); i++){
            if(commands.charAt(i) == 'L'){
                rotacao--;
            }else if(commands.charAt(i) == 'R'){
                rotacao++;
            }else if(commands.charAt(i) == 'M'){
                defineOrientacao(rotacao);
                makeMovement(orientacao);
            }
        }
        defineOrientacao(rotacao);
    }

    public void defineOrientacao(int rot){
        if(rot % posicoes.length < 0){
            orientacao = posicoes[posicoes.length + (rot % posicoes.length)];
        }else{
            orientacao = posicoes[rot % posicoes.length];
        }
    }

    public void makeMovement(char dir){
        if(dir == 'N'){
            posY++;
        }else if(dir == 'S'){
            posY--;
        }else if(dir == 'O'){
            posX--;
        }else if(dir == 'L'){
            posX++;
        }
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public char getOrientacao() {
        return orientacao;
    }

    public void setOrientacao(char orientacao) {
        this.orientacao = orientacao;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }


}
