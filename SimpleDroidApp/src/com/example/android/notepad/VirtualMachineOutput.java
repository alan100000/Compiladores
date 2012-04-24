package com.example.android.notepad;

import java.io.IOException;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class VirtualMachineOutput extends Activity {

	
	/**
     * The EditText field from our UI. Keep track of this so we can extract the
     * text when we are finished.
     */
    private TextView mText;
    
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	
	    // TODO Auto-generated method stub
	    setContentView(R.layout.virtual_machine_output);
	    
	    // Set up click handlers for the text field and button
        mText = (TextView) this.findViewById(R.id.virtualMachineOutput);
        MyApp appState = ((MyApp)getApplicationContext());
        try {
			appState.getVM().run();
			mText.setText(appState.getVM().temporal);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
	}

}
