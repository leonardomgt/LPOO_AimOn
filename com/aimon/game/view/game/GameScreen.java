package com.aimon.game.view.game;

import com.aimon.game.AimOn;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;

/**
 * Created by Leo on 18/04/2017.
 */

public class GameScreen extends ScreenAdapter {

    final AimOn game;

    OrthographicCamera camera;

    public GameScreen(AimOn game) {
        this.game = game;

        loadAssets();

        // create the camera and the SpriteBatch
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 960, 540);
    }

    private void loadAssets(){

        this.game.getAssetManager().load("backgroundGame.jpg", Texture.class);

        this.game.getAssetManager().finishLoading();

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();
    }
}
