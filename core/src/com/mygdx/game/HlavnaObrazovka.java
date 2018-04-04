package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class HlavnaObrazovka extends ScreenAdapter {

    private SpriteBatch batch;
    private Hadik hadik;
    private int[][] plocha;
    private static final int KROK = 32;
    private float cas;
    private StavHry stav;

    public HlavnaObrazovka() {
        this.hadik = new Hadik();
        this.plocha = new int[15][20];
        this.cas = 0;
        this.stav = StavHry.IDE;
    }
    
    @Override
    public void show() {
        this.batch = new SpriteBatch();
        
    }

    @Override
    public void render(float delta) {
        Color farba = Color.BLACK;
        Gdx.gl.glClearColor(farba.r, farba.g, farba.b, farba.a);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        this.cas += delta;
        
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            this.hadik.nastavSmer(Smer.DOPRAVA);
        }
        
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            this.hadik.nastavSmer(Smer.DOLAVA);
        }
        
        if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
            this.hadik.nastavSmer(Smer.HORE);
        }
        
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            this.hadik.nastavSmer(Smer.DOLE);
        }
        
        if (this.cas > 0.5) {
            this.cas = 0;
            this.hadik.pohni(this.KROK);
        }
        
        
        if (this.hadik.siNaKraji()) {
            this.stav = StavHry.KONIEC;
        }
        this.batch.begin();
        
        this.hadik.vykresli(this.batch);
        
        this.batch.end();
    }

    @Override
    public void dispose() {
        this.batch.dispose();
    }
}
