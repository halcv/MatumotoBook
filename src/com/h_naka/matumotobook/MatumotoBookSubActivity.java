package com.h_naka.matumotobook;

import android.os.Bundle;
import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.content.Intent;
import android.widget.TextView;
import android.view.View.OnClickListener;
import android.view.View;
import android.widget.Button;

public class MatumotoBookSubActivity
	extends Activity
	implements OnClickListener {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sub);

		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

		Button btnClose = (Button)findViewById(R.id.closeButton);
		btnClose.setOnClickListener(this);
		
		Intent i = getIntent();
		String sTitle = i.getStringExtra("TITLE_NAME");
		int iTitlePosition = i.getIntExtra("TITLE_POSITION",0);
		setTitle(sTitle);

		String[] sSentens = getResources().getStringArray(R.array.sentens);
		
		TextView vText = (TextView)findViewById(R.id.textview);
		vText.setText(sSentens[iTitlePosition]);
	}
	
	public void onClick(View v) {
		switch(v.getId()) {
		case R.id.closeButton:
			finish();
			break;
		}
	}
}
