package se.mah.k3.calju.whacamole;

import android.app.Activity;
import android.os.Bundle;

public class Start extends Activity{

	@Override

	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(new GameEngine(this));
	}
}
