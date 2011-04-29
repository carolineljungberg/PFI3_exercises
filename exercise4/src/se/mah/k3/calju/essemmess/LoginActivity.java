package se.mah.k3.calju.essemmess;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import se.k3.goransson.andreas.essemmesslib.Essemmess;
import se.k3.goransson.andreas.essemmesslib.EssemmessHelper;
import se.k3.goransson.andreas.essemmesslib.EssemmessListener;
import se.k3.goransson.andreas.essemmesslib.EssemmessLoginEvent;
import se.k3.goransson.andreas.essemmesslib.EssemmessPublishEvent; 
import se.k3.goransson.andreas.essemmesslib.EssemmessReadEvent;

public class LoginActivity extends Activity implements OnClickListener, EssemmessListener{
public Essemmess mServer;

public void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.main);

mServer = EssemmessHelper.getServer(this);
mServer.addEssemmessEventListener(this);

Button submit = (Button) findViewById(R.id.login);
submit.setOnClickListener(this);
}

public void onClick(View view) {


	if (view.getId() == R.id.login) {
	EditText editText = (EditText) findViewById(R.id.username);
	EditText editText2 = (EditText) findViewById(R.id.password);


	String username = editText.getText().toString();
	String password = editText2.getText().toString();

	mServer.login(username, password);
	mServer.addEssemmessEventListener(this);
	

	}
}

@Override
public void NewEssemmessPosts(EssemmessReadEvent evt) {
	// TODO Auto-generated method stub
	
}

@Override
public void NewEssemmessLogin(EssemmessLoginEvent evt) {
	// TODO Auto-generated method stub
	if (evt.getLoggedin() == true){
	Intent implicit = new Intent(LoginActivity.this, PublishActivity.class);
	startActivity(implicit);
	

	}
	
}

@Override
public void NewEssemmessPublish(EssemmessPublishEvent evt) {
	// TODO Auto-generated method stub
	
}


}
