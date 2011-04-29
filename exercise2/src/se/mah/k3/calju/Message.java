package se.mah.k3.calju;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class Message extends Activity implements OnClickListener {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        Button b1 = (Button) findViewById(R.id.button1); 
        b1.setOnClickListener(this);
    }
	public void onClick(View v) {
		
		EditText rubrik = (EditText) findViewById(R.id.tagfield);
		EditText text = (EditText) findViewById(R.id.messagefield);
		String s1 = rubrik.getText().toString();
		String s2 = text.getText().toString();
		String s3 = s1 + "\n" + s2;
		Toast t = Toast.makeText(this, s3, Toast.LENGTH_LONG);
		t.show();
		rubrik.setText("");
		text.setText("");

	}  
}
