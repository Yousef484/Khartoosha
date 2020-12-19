package com.test.game.sprites;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;


public class Character {
    private static final int gravity = -15;
    private Vector2 position,velocity;
    private Texture character;
    private Animation animation;

    private Sound bulletSound;
    public Character(int x,int y){
        position = new Vector2(x,y);
        velocity= new Vector2(0,0);
        character = new Texture("mando.png");
        animation = new Animation(new TextureRegion(character), 1, .5f);
        //bulletSound = Gdx.audio.newSound(Gdx.files.internal(""));
    }
    public void update(float delta){

        animation.update(delta);
        velocity.add(0,gravity);
        velocity.scl(delta);
        position.add(velocity.x,velocity.y);

    velocity.scl(1/delta);
    }
    public Vector2 getPosition(){
        return position;
    }
    public TextureRegion getTexture(){
        return animation.getFrame();
    }
    public void jump() { velocity.y = 300; }
    public void moveRight() { velocity.x+=2; }
    public void moveLeft(){
        velocity.x-=2;
    }
    public void dispose() { character.dispose(); }

    public void fire(){ bulletSound.play(0.5f);}
}
