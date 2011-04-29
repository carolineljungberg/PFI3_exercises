package se.mah.k3.calju.essemmess;

import java.util.ArrayList;

import se.k3.goransson.andreas.essemmesslib.Essemmess;
import se.k3.goransson.andreas.essemmesslib.EssemmessHelper;
import se.k3.goransson.andreas.essemmesslib.EssemmessListener;
import se.k3.goransson.andreas.essemmesslib.EssemmessLoginEvent; import se.k3.goransson.andreas.essemmesslib.EssemmessPublishEvent; import se.k3.goransson.andreas.essemmesslib.EssemmessReadEvent;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;


public class ReadActivity extends Activity implements OnClickListener, EssemmessListener{
public Essemmess mServer;
private ListView lv1;

ArrayList<String> arrlist=new ArrayList<String>();

ListView listView1;
ArrayAdapter<String> adapter;

public void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.readmessage);

mServer = EssemmessHelper.getServer(this);
mServer.addEssemmessEventListener(this);


listView1=(ListView)findViewById(R.id.listView1);
listView1.setAdapter(adapter = new ArrayAdapter<String>(this,R.layout.listviewlayout,R.id.list_content , arrlist));
Button button1= (Button) findViewById(R.id.button1);
button1.setOnClickListener(this);
mServer.read("");



}


@Override
protected void onDestroy() {
	mServer.removeEssemmessEventListener(this);
	super.onDestroy();
}


@Override
public void NewEssemmessPosts(EssemmessReadEvent evt) {
// TODO Auto-generated method stub
for (int i = 0; i < evt.getPosts().size(); i++) {
arrlist.add(evt.getPosts().get(i).getUser() + ": " + evt.getPosts().get(i).getMessage());
}
adapter.notifyDataSetChanged();
}

@Override
public void NewEssemmessLogin(EssemmessLoginEvent evt) {
// TODO Auto-generated method stub

}

@Override
public void NewEssemmessPublish(EssemmessPublishEvent evt) {
// TODO Auto-generated method stub

}

@Override
public void onClick(View v) {
// TODO Auto-generated method stub
switch(v.getId()){
case R.id.button1:
	mServer.read("tagfield");
	mServer.read("messagefield");
	break;
}
}


}