package com.badlogic.rogq;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Audio;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Main implements ApplicationListener {
    Texture background;
    Texture star;
    Texture hat;
    Music music;

    SpriteBatch batch;
    FitViewport viewport;

    Sprite starSprite;

    @Override
    public void create() {
        // Prepare your application here.
        background = new Texture("background.png");
        star = new Texture("star.png");
        hat = new Texture("sta1r.png");
        music = Gdx.audio.newMusic(Gdx.files.internal("music.mp3"));

        batch = new SpriteBatch();
        viewport = new FitViewport(8,5);
        starSprite = new Sprite(hat);
        starSprite.setSize(1, 1);
    }

    @Override
    public void resize(int width, int height) {
        // Resize your application here. The parameters represent the new window size.
        viewport.update(width, height, true);
    }

    @Override
    public void render() {
        // Draw your application here.
        input();
        draw();
        logic();
    }

    private void input() {
        float speed = .50f;
        if (Gdx.input.isKeyJustPressed(Keys.D)) {
            starSprite.translateX(speed);

        }
        if (Gdx.input.isKeyJustPressed(Keys.A)) {
            starSprite.translateX(-speed);
        }
        if (Gdx.input.isKeyJustPressed(Keys.W)) {
            starSprite.translateY(speed);
        }
        if (Gdx.input.isKeyJustPressed(Keys.S)) {
            starSprite.translateY(-speed);
        }
    }
    private void draw() {
        ScreenUtils.clear(Color.GRAY);
        viewport.apply();
        batch.setProjectionMatrix(viewport.getCamera().combined);
        batch.begin();
        float width = viewport.getWorldWidth();
        float height = viewport.getWorldHeight();

        batch.draw(star, 0, 0, width, height);
        starSprite.draw(batch);

        batch.end();
    }
    private void logic() {

    }
    @Override
    public void pause() {
        // Invoked when your application is paused.
    }

    @Override
    public void resume() {
        // Invoked when your application is resumed after pause.
    }

    @Override
    public void dispose() {
        // Destroy application's resources here.
    }
}
