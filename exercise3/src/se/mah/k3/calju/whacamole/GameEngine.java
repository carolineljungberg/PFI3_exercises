package se.mah.k3.calju.whacamole;

import java.util.ArrayList;
import java.util.List;

import android.R.color;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

public class GameEngine extends View implements Callback{
	private int score;
	Paint background;
	Paint holes;
	private Handler myHandler;
	private List<Drawable> myMoles = new ArrayList<Drawable>();

public GameEngine(Context context) {
	super(context);
	background  = new Paint();
	holes = new Paint(Paint.ANTI_ALIAS_FLAG);
	holes.setARGB(255, 5, 5, 5);
	background.setARGB(255, 200, 200, 200);
	myHandler = new Handler ((android.os.Handler.Callback) this);
	new GameUpdateThread(myHandler).start();
	createMoles();
	
}


private void createMoles() {
	// TODO Auto-generated method stub
	for(int i = 0; i<3;i++){
	for(int j = 0;j<3;j++) {
	myMoles.add(new Mole(80+(i*70), 80+(j*70)));
	}

	}

	}
 


@Override
protected void onDraw(Canvas canvas){
	super.onDraw(canvas);
	canvas.drawPaint(background);
	for(int i = 0; i<3;i++){
		for(int j = 0;j<3;j++) {
		canvas.drawCircle(80+(i*70),80+(j*70), 30, holes);
		
		}

		}

	for (Drawable d: myMoles){
		d.draw(canvas);
		
	}
	
}
	
	@Override
	public boolean onTouchEvent(MotionEvent event){
		Log.i("touch: ", +event.getX()+","+event.getY());
		for (Drawable d : myMoles){
			d.pressed(event);
			score++;
		}
		update();
		return super.onTouchEvent(event);
	}
	
		
	

private void update(){
	for(Drawable d : myMoles){
	d.update();

}
this.invalidate();
}


@Override
public boolean handleMessage(Message mess) {
	
	Log.i("K3", "Mess: " + mess.what);
	if(mess.what == 1){
 update();
}
	return false;
}
}