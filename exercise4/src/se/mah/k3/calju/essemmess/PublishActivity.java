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

public class PublishActivity extends Activity implements OnClickListener, EssemmessListener{
public Essemmess mServer;

public void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.publishmessage);

mServer = EssemmessHelper.getServer(this);
mServer.addEssemmessEventListener(this);

Button submit = (Button) findViewById(R.id.submit);
submit.setOnClickListener(this);
}

public void onClick(View view) {


	if (view.getId() == R.id.submit) {
	EditText editText = (EditText) findViewById(R.id.tagfield);
	EditText editText2 = (EditText) findViewById(R.id.messagefield);


	String tagfield = editText.getText().toString();
	String messagefield = editText2.getText().toString();

	
	mServer.post(tagfield, messagefield);
	

	}
}

@Override
public void NewEssemmessPosts(EssemmessReadEvent evt) {
	// TODO Auto-generated method stub
	
}

@Override
public void NewEssemmessLogin(EssemmessLoginEvent evt) {

	
}

@Override
public void NewEssemmessPublish(EssemmessPublishEvent evt) {
	// TODO Auto-generated method stub
	
	if(evt.getMessage() != null);
	Intent implicit = new Intent(PublishActivity.this, ReadActivity.class);
	startActivity(implicit);
}


}
