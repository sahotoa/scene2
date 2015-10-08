package com.mygdx.scene2;

import java.util.Iterator;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.actions.MoveToAction;
import com.badlogic.gdx.scenes.scene2d.actions.RotateToAction;
import com.badlogic.gdx.scenes.scene2d.actions.ScaleToAction;
import com.mygdx.scene2.SceneTwo.MyActor;

public class SceneTwo extends ApplicationAdapter {
	public class MyActor extends Actor {
		Texture texture = new Texture(Gdx.files.internal("data/jet.png"));
		float actorX = 0;
		float actorY = 0;
		public boolean started = false;
		
		
		public MyActor(){
			setBounds(getX(),getY(),texture.getWidth(),texture.getHeight());
			/*addListener(new InputListener(){
				public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
					((MyActor)event.getTarget()).started = true;
					return true;
				}
			});*/
		}
		
		@Override
		public void draw(Batch batch, float alpha){
			batch.draw(texture,this.getX(),getY(),this.getOriginX(),this.getOriginY(),this.getWidth(),
		            this.getHeight(),this.getScaleX(), this.getScaleY(),this.getRotation(),0,0,
		            texture.getWidth(),texture.getHeight(),false,false);
		}
		
		/*@Override
		public void act(float delta){
		    for(Iterator<Action> iter = this.getActions().iterator(); iter.hasNext();){
		        iter.next().act(delta);
		    }
		}*/
	}
	
	private Stage stage;
	
	@Override
	public void create () {
		stage = new Stage();
		Gdx.input.setInputProcessor(stage);
		
		MyActor myActor = new MyActor();
		/*myActor.setTouchable(Touchable.enabled);*/
		MoveToAction moveAction = new MoveToAction();
		RotateToAction rotateAction = new RotateToAction();
		ScaleToAction scaleAction = new ScaleToAction();
		
		moveAction.setPosition(300f, 0f);
		moveAction.setDuration(5f);
		rotateAction.setRotation(90f);
		rotateAction.setDuration(5f);
		scaleAction.setScale(0.5f);
		scaleAction.setDuration(5f);
		
		myActor.addAction(moveAction);
		myActor.addAction(rotateAction);
		myActor.addAction(scaleAction);
		
		stage.addActor(myActor);
	}
	
	
	@Override
	public void dispose(){
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		stage.act(Gdx.graphics.getDeltaTime());
		stage.draw();
	}
}
