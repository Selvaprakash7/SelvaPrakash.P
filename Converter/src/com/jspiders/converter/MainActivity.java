package com.jspiders.converter;

import android.os.Bundle;
import android.app.Activity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;



public class MainActivity extends Activity implements OnItemSelectedListener,TextWatcher {
	Spinner spinner;
	EditText entereditText;
    EditText anseditText;
	TextView fromtextView,totextView;
	
	Button convertbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner = (Spinner) findViewById(R.id.spinner);
        fromtextView=(TextView) findViewById(R.id.fromtextView);
        totextView=(TextView) findViewById(R.id.totextView);
       
        entereditText = (EditText) findViewById(R.id.entereditText);
        anseditText = (EditText) findViewById(R.id.anseditText);
        convertbutton = (Button) findViewById(R.id.convertbutton);
        final String[] properties={"Temparature","Time","Mass"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_dropdown_item_1line, properties);
        spinner.setAdapter(adapter);
        anseditText.setEnabled(false);
        
        spinner.setOnItemSelectedListener(MainActivity.this);
        
       
        
    }

	@Override
	public void onItemSelected(AdapterView<?> arg0, View arg1, int pos,
			long arg3) {
		 entereditText.setText("");
		 anseditText.setText("");
		
		switch (pos) {
		case 0:
			fromtextView.setText("°C");
			totextView.setText("°F");
			
			 convertbutton.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View v) {
						if(entereditText.getText().length()==0)
						{
							entereditText.setError("Please enter The Value");
							}
						else{
						double celsius =Double.valueOf(entereditText.getText().toString());
						double fahrenheit = (9.0/5.0) * celsius + 32;
						anseditText.setText(String.valueOf(fahrenheit));
						}
						
					}
				});
			break;
		case 1:
			fromtextView.setText("min");
			totextView.setText("sec");
			
			 convertbutton.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View v) {
						if(entereditText.getText().length()==0)
						{	entereditText.setError("Enter The Value");
		
						}
						else{		double m =Double.valueOf(entereditText.getText().toString());
						double s = m*60;
						anseditText.setText(String.valueOf(s));
						}
					}
				});
			break;
		case 2:
			fromtextView.setText("kg");
			totextView.setText("g");
			
			 convertbutton.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View v) {
						if(entereditText.getText().length()==0)
						{	entereditText.setError("Enter The Value");}
						else	{double kg =Double.valueOf(entereditText.getText().toString());
						double g = kg * 1000;
						anseditText.setText(String.valueOf(g));
						}
					}
				});
			break;


	
		}
		
	}

	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		
		
	}

	@Override
	public void afterTextChanged(Editable s) {
		
		
	}

	@Override
	public void beforeTextChanged(CharSequence s, int start, int count,
			int after) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTextChanged(CharSequence s, int start, int before, int count) {
		
		
	}
	
	
	

    


    
    
}
