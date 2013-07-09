package com.rickstart.anagrama;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import android.R.string;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

	public List<String> dic=new ArrayList<String>();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		final EditText edit   = (EditText)findViewById(R.id.editText1);
		final Button button = (Button) findViewById(R.id.btncheck);
		final TextView txt = (TextView) findViewById(R.id.textView1);
		
		dic.add("amor");
		dic.add("roma");
		dic.add("mora");
		dic.add("ramo");
		dic.add("omar");
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
            	String aux="";
            	Vector ve= new Vector();
            	//txt.setText(edit.getText().toString());
            	if(edit.getText().toString()!="")
            	{
            		ve=generate(edit.getText().toString());
            	}
            	//String word="roma";
            	//Vector ve=generate(word);
            	
            	 
                 for(int i=0;i<ve.size();i++)
                 {
                	 aux = aux+", "+ve.elementAt(i).toString();
                	 //txt.setText(aux);
                 
                 }  
                 aux=doAnagrama(ve);
                 txt.setText(aux);
            	 
            }
        });
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public String anagrama(String word)
	{
		
		String str="";
		char[] charArray = new char[word.length()];

		for(int i=0;i<word.length();i++)
		{
			charArray[i]=word.charAt(i);
		}
		
		
		return str;
	}
	
	public String doAnagrama(Vector ve)
	{
		
	
		

	
	   String source="";
	   String a1="";
	   String a2="";
	   for(int i=0;i<ve.size();i++)
	   {
		   a1=ve.elementAt(i).toString();
		   for(int j=0;j<dic.size();j++)
		   {
			   a2=dic.get(j).toString();
			   if(a1.equals(a2))
			   {
				   source=source+", "+ve.elementAt(i).toString();
			   }
				   
		   }
	   }
	   
	   return source;
		
		
		
	
	}
	
	   private void generateR(String source, String partial,Vector out)
	   {
	     String newPartial=new String(partial);
	     String newSource;
	     if (source.length()==0)
	     {
	       out.addElement(newPartial);
	       return;
	     }
	     for(int i=0;i<source.length();i++)
	     {
	       newPartial=partial.concat(source.substring(i,i+1));
	       newSource=source.substring(0,i);
	       if (i<(source.length()+1))
	         newSource=newSource.concat(source.substring(i+1,source.length()));
	       generateR(newSource, newPartial, out);
	     }
	   }
	   
	   public Vector generate(String source)
	   {
	     Vector out=new Vector();
	     String partial=new String();
	     generateR(source, partial, out);
	     return out;
	   }
	   


}
