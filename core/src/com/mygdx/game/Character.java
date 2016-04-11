package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class Character {
    Rectangle charBox1;
    Sprite sprGengar;
    Texture txrReg, txrFlip;
    float fGravity;

    public Character() {
        txrReg = new Texture("gengar.png");
        txrFlip = new Texture("gengarf.png");
        sprGengar = new Sprite(txrReg, 0, 0, 128, 128);
        sprGengar.setSize(Gdx.graphics.getWidth()/5, Gdx.graphics.getWidth()/5);
        charBox1 = new Rectangle(0f, 0f, sprGengar.getWidth(), sprGengar.getHeight());
        this.setPosition(0, 0);
        fGravity = 0;
    }

    public int bounds(Rectangle r) {
        if (charBox1.overlaps(r)) {
            return 1;
        }
        return -1;
    }

    public void action(int type, float x, float y) {
        if (type == 1) {
            setPosition(charBox1.x, y);
            fGravity = 0;
        }
        else if (type == 2) {
            setPosition(x, charBox1.y);
        }
        else if (type == 3) {
            x -= sprGengar.getWidth();
            setPosition(x, charBox1.y);
        }
        else if (type == 4) {
            y -= sprGengar.getHeight();
            setPosition(charBox1.x, y);
        }
    }

    public void update(float delta) {
        //fGravity = gravity strength
        fGravity -= (40 * delta);
        charBox1.y += fGravity;
        sprGengar.setPosition(charBox1.x, charBox1.y);
    }

    public void setPosition(float x, float y) {
        charBox1.x = x;
        charBox1.y = y;
        sprGengar.setPosition(x, y);
    }

    public void moveLeft(float delta) {
        charBox1.x -= (200 * delta);
        sprGengar.setPosition(charBox1.x, charBox1.y);
    }

    public void moveRight(float delta) {
        charBox1.x += (200 * delta);
        sprGengar.setPosition(charBox1.x, charBox1.y);
    }

    public void draw1(SpriteBatch batch) {
        sprGengar.setTexture(txrReg);
        sprGengar.draw(batch);
    }

    public void draw2(SpriteBatch batch) {
        sprGengar.setTexture(txrFlip);
        sprGengar.draw(batch);
    }

    public void jump() {
        //add jump height
        fGravity = 15;
    }
}
