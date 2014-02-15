package game;
import java.io.IOException;

import org.jsfml.system.Vector2f;
import org.jsfml.window.Keyboard;
import org.jsfml.window.event.Event;
import org.jsfml.window.event.KeyEvent;

import engine.*;

public class Scoreboard {
	
	private void updat() {
		T.setX(target.getX());
		T.setY(target.getBoundTop()+target.getY());
		R.setX(target.getBoundRight()+target.getX());
		R.setY(target.getY());
		L.setX(target.getBoundLeft()+target.getX());
		L.setY(target.getY());
		B.setX(target.getX());
		B.setY(target.getBoundBottom()+target.getY());
	}
	
	DynamicObject target;
	DynamicObject T;
	DynamicObject R;
	DynamicObject L;
	DynamicObject B;
	DynamicObject push;
	InfiniteBox box;
	
	public Scoreboard() {
		try {
			target = new Player("res/basic_sprite.png",new XYZRAxes(0,0,0,0),10);
			StaticObject obj = new StaticObject("res/basic_sprite.png",new XYZRAxes(1000,1000,5000,0));
			push = new  DynamicObject("res/basic_sprite.png",new XYZRAxes(target.getX(),target.getY()+10,target.getZ(),0), 10);
			target.setOriginCenter();
			L = new  DynamicObject("res/cross.png",new XYZRAxes(target.getBoundLeft(),target.getY(),target.getZ(),0),10);
			R = new  DynamicObject("res/cross.png",new XYZRAxes(target.getBoundRight(),target.getY(),target.getZ(),0),10);
			T = new  DynamicObject("res/cross.png",new XYZRAxes(target.getX(),target.getBoundTop(),target.getZ(),0),10);
			B = new  DynamicObject(new XYZRAxes(target.getX(),target.getBoundBottom(),target.getZ(),0),new XYAxes(10,10),10);
			T.removeTexture();
			
			RenderCam render_cam = new RenderCam(obj, 1000, 1f);
			//render_cam.setTransitionspeed(0.5f);
			box = new InfiniteBox(10,0,false,true,render_cam);
			render_cam.makeDrawable(box);
			render_cam.makeDrawable(T);
			render_cam.makeDrawable(R);
			render_cam.makeDrawable(L);
			render_cam.makeDrawable(B);
			render_cam.makeDrawable(target);
			render_cam.makeDrawable(push);
			render_cam.makeDrawable(obj); //new Date() --dagens dato, new Date(year,month, day) --�r starter p� 1900 (n�:114)
			render_cam.setTarget(target, 1000f, 0.1f);
//			render_cam.enableFollowTargetRotation();
			
		while (Main.game_state == Main.states.scoreboard) {
			if (Keyboard.isKeyPressed(Keyboard.Key.E))
			{
				//target.addRotation(-10f);
				render_cam.addDistance(30f);
			}
			if (Keyboard.isKeyPressed(Keyboard.Key.Q))
			{
				//target.addRotation(-10f);
				render_cam.addDistance(-30f);
			}
			if (Keyboard.isKeyPressed(Keyboard.Key.LEFT))
			{
				//target.addRotation(-10f);
				target.addImpulseX(-10f);
			}
			if (Keyboard.isKeyPressed(Keyboard.Key.RIGHT)) {
				//target.addRotation(10f);
				target.addImpulseX(10f);
			}
			if (Keyboard.isKeyPressed(Keyboard.Key.UP)) {
				//target.setScaleWidth(target.getScaleWidth() + 0.1f);
				target.addImpulseY(-10f);
			}
			if (Keyboard.isKeyPressed(Keyboard.Key.DOWN)) {
				//target.setHeight(target.getHeight()+100);
				target.addImpulseY(10f);
			}
			target.addImpulseX(-target.getSpeedX()/2);
			target.addImpulseY(-target.getSpeedY()/2);
			target.update();
			updat();
			render_cam.renderFrame();
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}