package com.wkats.sqlite2;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;


public class MainActivity extends Activity implements OnClickListener
{
Button b1,b2;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
	{
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		b1= (Button) findViewById(R.id.button1);
		b2= (Button) findViewById(R.id.button2);
    	b1.setOnClickListener(this);
		b2.setOnClickListener(this);
		
    }

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
	}
		
}
