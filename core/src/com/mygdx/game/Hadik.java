/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 *
 * @author iva
 */
public class Hadik {
    private int posX;
    private int posY;
    private Smer smer;
    private int dlzka;
    private Texture imgHlava;
    private Texture imgChvost;
    
    public Hadik() {
        this.dlzka = 1;
        this.imgHlava = new Texture("hlava.png");
        this.imgChvost = new Texture("chvost.png");
        this.posX = Gdx.graphics.getWidth() / 2;
        this.posY = Gdx.graphics.getHeight() / 2;
        this.smer = Smer.HORE;
    }
     
    public void vykresli(SpriteBatch batch) {
        batch.draw(this.imgHlava, this.posX, this.posY);
    }

    void nastavSmer(Smer smer) {
        this.smer = smer;
    }
    
    void pohni(int krok) {
        switch (this.smer) {
            case DOPRAVA:
                this.posX += krok;
                break;
            case DOLAVA:
                this.posX -= krok;
                break;
            case HORE:
                this.posY += krok;
                break;
            case DOLE:
                this.posY -= krok;
                break;
            default:
                throw new AssertionError();
        }
            
            
    }

    boolean siNaKraji() {
        if (this.posX < 0) {
            this.posX = 0;
            return true;
        }
        
        if (this.posY < 0) {
            this.posY = 0;
            return true;
        }
        
        if (this.posX + this.imgHlava.getWidth() > Gdx.graphics.getWidth()) {
            this.posX = Gdx.graphics.getWidth() - this.imgHlava.getHeight();
            return true;
        }
        
        if (this.posY + this.imgHlava.getHeight() > Gdx.graphics.getHeight()) {
            this.posY = Gdx.graphics.getHeight() - this.imgHlava.getHeight();
            return true;
        }
        
        return false;
    }
}
