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
		final EditText edit2   = (EditText)findViewById(R.id.editText2);
		final EditText edit3   = (EditText)findViewById(R.id.editText3);
		final Button button = (Button) findViewById(R.id.btncheck);
		final Button button1 = (Button) findViewById(R.id.button1);
		final TextView txt = (TextView) findViewById(R.id.textView1);
		
		
		dic.add("amor");
		dic.add("roma");
		dic.add("mora");
		dic.add("ramo");
		dic.add("omar");
		String dictionary="";
		
		for(int i=0;i<dic.size();i++)
		{
			dictionary=dictionary+", "+dic.get(i).toString();
		}
		edit2.setText(dictionary);
		
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
               
            	String aux="";
            	Vector ve= new Vector();
            	
            	if(edit.getText().toString()!="")
            	{
            		ve=generate(edit.getText().toString());
            	}
            	
            	
            	 
                 for(int i=0;i<ve.size();i++)
                 {
                	 aux = aux+", "+ve.elementAt(i).toString();
                	 //txt.setText(aux);
                 
                 }  
                 aux=doAnagrama(ve);
                 txt.setText(aux);
            	 
            }
        });
		
        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
               dic.add(edit3.getText().toString());
               
               	String dict="";
	       		for(int i=0;i<dic.size();i++)
	       		{
	       			dict=dict+", "+dic.get(i).toString();
	       		}
	       		edit2.setText(dict);
	            }
        });
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
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
