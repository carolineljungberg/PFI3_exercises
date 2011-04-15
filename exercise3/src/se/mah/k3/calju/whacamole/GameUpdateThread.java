package se.mah.k3.calju.whacamole;

import android.os.Handler;
import android.util.Log;

public class GameUpdateThread extends Thread{
	Handler _handler;
	private boolean running =true;

	public GameUpdateThread(Handler handler) {
		_handler = handler;

	}

	public void run(){
		super.run();
		while(running){
			try{
				Log.i("k3", "Thread Running");
				_handler.obtainMessage(1).setTarget(_handler);
				
				Thread.sleep(2);
	} catch (InterruptedException e){
		//Log.i(StaticFields.TAG, e.getMessage());
}
}
}
}