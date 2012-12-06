package com.h_naka.matumotobook;

import android.os.Bundle;
import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.widget.ListView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AdapterView.OnItemClickListener;
import android.content.Intent;

public class MatumotoBookMainActivity
	extends Activity
	implements OnItemClickListener {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

		ListView vList = (ListView)findViewById(R.id.listview);
		String [] sTitle = getResources().getStringArray(R.array.title_names);
		ArrayAdapter<String> adp = new ArrayAdapter<String>(this,R.layout.title,sTitle);
		vList.setAdapter(adp);
		vList.setOnItemClickListener(this);
	}

	public void onItemClick(AdapterView<?> parent,View v,int pos,long id) {
		String title = (String)(parent.getAdapter().getItem(pos));;
		createSubActivity(title,pos);
	}

	private void createSubActivity(String title,int pos) {
		Intent i = new Intent(this,MatumotoBookSubActivity.class);
		i.putExtra("TITLE_NAME",title);
		i.putExtra("TITLE_POSITION",pos);
		startActivity(i);
	}
}
