package se.mah.k3.calju.whacamole;

import java.util.ArrayList;
import java.util.Random;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

public class Mole implements Drawable {
	private float _posX;
	private float _posY;
	private int alpha;
	private Paint _p;
	private float _radius = 20;
	private boolean alive = false;
	Random ranGen = new Random();

	public Mole(float posX, float posY){
		_posX = posX;
		_posY = posY;
		alpha = 255;
		_p = new Paint(Paint.ANTI_ALIAS_FLAG);
		_p.setARGB(255, 140, 25, 140);
		alive = false;
	}

	@Override
	public void update() {
		
		if(ranGen.nextInt(100)>90){
			alive = true;
			alpha=255;
		}
		
		
	}

	@Override
	public void draw(Canvas c) {

		if (alpha > 0){
		alpha = alpha - 20;
		}
		else if (alpha <= 0){
		alpha = 0;
		alive = false;
		}
		if (alive){
		c.drawCircle(_posX, _posY, _radius, _p);
		}
		}

	@Override
	public boolean pressed(MotionEvent m) {
		Log.i("k3", "pressed");
		boolean hit = false;
		float dx = (_posX - m.getX());
		float dy = (_posY - m.getY());
		float dist = (float) Math.sqrt((dx*dx)+(dy*dy));
		
		if(alpha>0){
		if(dist<_radius){
			alive = false;
			alpha = 0;
			hit = true;
			
		}
		}
		
		
		return hit;
	}
}



