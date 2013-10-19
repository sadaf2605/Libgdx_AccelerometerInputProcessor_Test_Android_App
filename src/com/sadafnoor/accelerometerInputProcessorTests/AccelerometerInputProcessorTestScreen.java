package com.sadafnoor.accelerometerInputProcessorTests;
/*******************************************************************************
 * Copyright 2011 See AUTHORS file.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/



import com.badlogic.gdx.AccelerometerInputProcessor;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.GLCommon;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Pixmap.Format;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;


public class AccelerometerInputProcessorTestScreen implements Screen , AccelerometerInputProcessor {
	Skin skin;
	Stage stage;
	SpriteBatch batch;

	TextButton textButton;
	
	
	Game g;
	private TextButtonStyle textButtonStyle;
	public AccelerometerInputProcessorTestScreen(Game g){
		create();
		this.g=g;
	}

	public void create(){
		batch = new SpriteBatch();
		stage = new Stage();
//		Gdx.input.setInputProcessor(stage);
		Gdx.input.setInputProcessor(this);

		// A skin can be loaded via JSON or defined programmatically, either is fine. Using a skin is optional but strongly
		// recommended solely for the convenience of getting a texture, region, etc as a drawable, tinted drawable, etc.
		skin = new Skin();
		
	
		//skin.add("white", new Texture(pixmap));

		// Store the default libgdx font under the name "default".
		BitmapFont bfont=new BitmapFont();
		bfont.scale(1);
		skin.add("default",bfont);
		
		textButtonStyle = new TextButtonStyle();
		textButtonStyle.font = skin.getFont("default");
		skin.add("default", textButtonStyle);

		

	

		
		// Create a button with the "default" TextButtonStyle. A 3rd parameter can be used to specify a name other than "default".
		textButton=new TextButton("initial",skin);
		textButton.setPosition(50, 50);
		stage.addActor(textButton);
		

		
	}

	public void render (float delta) {
		if(textButtonStyle==null){
			create();
		}
		Gdx.gl.glClearColor(0.2f, 0.2f, 0.2f, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
		stage.draw();
		Table.drawDebug(stage);
	}

	@Override
	public void resize (int width, int height) {
		stage.setViewport(width, height, false);
	}

	@Override
	public void dispose () {
		stage.dispose();
		skin.dispose();
	}

	

	@Override
	public void show() {
		// TODO Auto-generated method stub
		create();
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean keyDown(int keycode) {
		// TODO Auto-generated method stub
		textButton.setText("hello "+keycode);
		return true;
	}

	@Override
	public boolean keyUp(int keycode) {
	
		return true;
	}

	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
				return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
	
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean onTiltX(float x) {
		textButton.setText("tiltx"+x);
		return false;
	}

	@Override
	public boolean onTiltY (float y) {
		//textButton.setText("tilty"+y);
		
		return false;
	}

	@Override
	public boolean onTiltZ (float z) {
		//textButton.setText("tiltz"+z);
		
		return false;
	}

	
}
