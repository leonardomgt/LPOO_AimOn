package com.aimon.game.view.game;

import com.aimon.game.AimOn;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;

/**
 * Created by Leo on 18/04/2017.
 */

public class GameScreen extends ScreenAdapter {

    final AimOn game;

    Texture background;

    OrthographicCamera camera;

    public GameScreen(AimOn game) {
        this.game = game;

        background = new Texture(Gdx.files.internal("backgroundGame.jpg"));

        // create the camera and the SpriteBatch
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 960, 540);
    }
}
