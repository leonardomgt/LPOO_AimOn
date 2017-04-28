package com.aimon.game.view.menu;

import com.aimon.game.AimOn;
import com.aimon.game.view.game.GameScreen;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;

/**
 * Created by Leo on 18/04/2017.
 */

public class MainMenuScreen extends ScreenAdapter {

    final AimOn game;

    public Texture backgroundImage;
    public Texture buttonReleased;
    public Texture buttonPressed;

    float buttonsRate;

    final int screenCenterWidth, screenCenterHeight;
    OrthographicCamera camera;

    public MainMenuScreen(AimOn game) {
        this.game = game;

        loadAssets();
        camera = createCamera();

        buttonsRate = (float)buttonPressed.getWidth()/buttonPressed.getHeight();

        screenCenterHeight = (int) camera.viewportHeight/2;
        screenCenterWidth = (int) camera.viewportWidth/2;



    }

    private OrthographicCamera createCamera() {
        OrthographicCamera camera = new OrthographicCamera();
        camera.setToOrtho(false, 960, 540);
        return camera;
    }


    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();
        game.getBatch().setProjectionMatrix(camera.combined);

        game.getBatch().begin();
        game.getBatch().draw(backgroundImage,0,0,camera.viewportWidth,camera.viewportHeight);
        game.getBatch().draw(buttonReleased,
                        50 + screenCenterWidth - (camera.viewportHeight /4 * buttonsRate)/2,
                        screenCenterHeight - camera.viewportHeight /4/2,
                        camera.viewportHeight /4 * buttonsRate,
                        camera.viewportHeight /4);
        game.font.draw(game.getBatch(), "Welcome to AimOn!!! ", 100, 150);
        game.font.draw(game.getBatch(), "Tap anywhere to begin!", 100, 100);
        game.font.draw(game.getBatch(), "Record: " + game.record, 100, 200);
        game.getBatch().end();

        if (Gdx.input.justTouched()) {
            game.setScreen(new GameScreen(game));
            dispose();
        }
    }

    @Override
    public void dispose() {

    }

    private void loadAssets(){

        this.game.getAssetManager().load("backgroundMainMenu.png", Texture.class);
        this.game.getAssetManager().load("button.png", Texture.class);
        this.game.getAssetManager().load("buttonPressed.png", Texture.class);

        this.game.getAssetManager().finishLoading();

    }
}
