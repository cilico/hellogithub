package com.example.testprint;

import java.io.UnsupportedEncodingException;

import org.apache.http.util.EncodingUtils;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Paint;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import hardware.print.printer;
import hardware.print.printer.PrintType;
import hardware.print.BarcodeCreate;

public class TestPrintMainActivity extends Activity {

	Button m_btnTest,m_btnPrint,m_btnStep,m_btnTest24;
	EditText m_exit;
	Spinner m_spinner;
	printer m_printer=new printer();
	Paint m_pat = new Paint();
	ArrayAdapter<String> m_adapter;
	private void showToast(String str){ 
	    Toast.makeText(this, str, Toast.LENGTH_SHORT).show();}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_test_print_main);
		m_btnTest=(Button)findViewById(R.id.btn_test);
		m_btnStep=(Button)findViewById(R.id.btn_Step);
		m_btnPrint=(Button)findViewById(R.id.ButtonPrint);
		m_btnTest24=(Button)findViewById(R.id.btn_test24);
		m_exit=(EditText)findViewById(R.id.Edit0);
		m_spinner=(Spinner)findViewById(R.id.spinner1);
		String []strAct={"0","1","2","3","4","5","6","7","8","9"};		
		m_adapter=new ArrayAdapter<String>(TestPrintMainActivity.this,android.R.layout.simple_spinner_item,strAct);
		m_adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
		m_spinner.setAdapter(m_adapter);

		m_printer.Open();
		m_spinner.setOnItemSelectedListener(new OnItemSelectedListener(){

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				// TODO Auto-generated method stub
				byte btGrayLevel=(byte)m_spinner.getSelectedItemPosition();
				m_printer.SetGrayLevel(btGrayLevel);
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
		m_btnTest.setOnClickListener(new OnClickListener(){
     
			@Override 
			public void onClick(View arg0) {
				
				// TODO Auto-generated method stub
				int i=0;
				//for(i=0;i<10;i++)
				{
				m_printer.PrintStringEx("\nPrinter test\n", 40, false, true,printer.PrintType.Centering);
				String str="~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~";
				//m_printer.PrintString(str, 20);
				m_printer.PrintLineInit(18);
				m_printer.PrintLineString(str, 18, PrintType.Centering, true);
				m_printer.PrintLineEnd();

				m_printer.PrintLineInit(24);
				m_printer.PrintLineString("Type", 24, PrintType.Left, true);
				m_printer.PrintLineString("Industrial Android ", 20, 210, true);//160
				m_printer.PrintLineEnd();
				m_printer.PrintLineInit(24);
				//m_printer.PrintLineString("Type", 24, PrintType.Left, true);
				m_printer.PrintLineString("Intelligent Terminal", 20, 210, true);//160
				m_printer.PrintLineEnd();				
				m_printer.PrintLineInit(24);
				m_printer.PrintLineString("Time to market", 24, PrintType.Left, true);
				m_printer.PrintLineString("Year 2015", 22, 210, true);//160	
				m_printer.PrintLineEnd();
				m_printer.PrintLineInit(24);
				m_printer.PrintLineString("Dimension", 24, PrintType.Left, true);
				m_printer.PrintLineString("205.5*87*39mm", 22, 210, true);//160					
				m_printer.PrintLineEnd();				
				m_printer.PrintLineInit(24);
				m_printer.PrintLineString("CPU", 24, PrintType.Left, true);
				m_printer.PrintLineString("Quad-core", 22, 210, true);//160					
				m_printer.PrintLineEnd();
				m_printer.PrintLineInit(24);
				m_printer.PrintLineString("Operation System", 24, PrintType.Left, true);
				m_printer.PrintLineString("Android 4.2.2", 22, 210, true);//160					
				m_printer.PrintLineEnd();	
				m_printer.PrintLineInit(24);
				m_printer.PrintLineString("Thermal printer", 24, PrintType.Left, true);
				m_printer.PrintLineString(" 2'' 384dots ", 22, 210, true);//160					
				m_printer.PrintLineEnd();	
				m_printer.PrintLineInit(24);
				//m_printer.PrintLineString("Thermal printer", 24, PrintType.Left, true);
				m_printer.PrintLineString("thermal printer ", 22, 210, true);//160					
				m_printer.PrintLineEnd();	
				m_printer.PrintLineInit(24);
				//m_printer.PrintLineString("Thermal printer", 24, PrintType.Left, true);
				m_printer.PrintLineString("Printing speed", 22, 210, true);//160					
				m_printer.PrintLineEnd();
				m_printer.PrintLineInit(24);
				//m_printer.PrintLineString("Thermal printer", 24, PrintType.Left, true);
				m_printer.PrintLineString("15mm/Second", 22, 210, true);//160					
				m_printer.PrintLineEnd();		

				m_printer.PrintLineInit(24);
				m_printer.PrintLineString("Standby time", 24, PrintType.Left, true);
				m_printer.PrintLineString("72hours", 22, 210, true);//160					
				m_printer.PrintLineEnd();				
				m_printer.PrintLineInit(18);
				m_printer.PrintLineString(str, 18, PrintType.Centering, true);
				m_printer.PrintLineEnd();
				m_printer.PrintLineInit(24);
				m_printer.PrintLineString("Working temperature", 24, PrintType.Left, true);
				m_printer.PrintLineString("-25~65¡æ", 24, PrintType.Right, true);//160					
				m_printer.PrintLineEnd();	
				m_printer.PrintLineInit(24);
				m_printer.PrintLineString("Storage temperature", 24, PrintType.Left, true);
				m_printer.PrintLineString("-30~70 ¡æ", 24, PrintType.Right, true);//160					
				m_printer.PrintLineEnd();
				m_printer.PrintLineInit(24);
				m_printer.PrintLineString("Humidity", 24, PrintType.Left, true);
				m_printer.PrintLineString("0~95%", 24, PrintType.Right, true);//160					
				m_printer.PrintLineEnd();	
				m_printer.PrintLineInit(18);
				m_printer.PrintLineString(str, 18, PrintType.Centering, true);
				m_printer.PrintLineEnd();
//				try {
//					Thread.sleep(2000);
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
				}
//				Bitmap bm=BitmapFactory.decodeResource(getResources(), R.drawable.logo);
				Bitmap bm=null;
				try {
					bm = BarcodeCreate.encodeAsBitmap("2015111616093",
							BarcodeFormat.EAN_13, 384, 40);
				} catch (WriterException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(bm!=null)
				{
					m_printer.PrintBitmap(bm);
				}
				m_printer.PrintLineInit(40);
				m_printer.PrintLineString("", 24, PrintType.Right, true);//160					
				m_printer.PrintLineEnd();
					

//				if(m_printer.IsOutOfPaper())
//				{
//					showToast("out of paper");
//				}
			}			
		});
		m_btnTest24.setOnClickListener(new OnClickListener()
		{

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub	
				m_printer.PrintString("\r\n");
				m_printer.PrintString("\r\n");
				m_printer.PrintString("\r\n");
				m_printer.PrintString24Ex("Print test demo\r\n",printer.ArrangeType.Centering);
				m_printer.PrintString24("Type");
				m_printer.PrintString24Location(": Industrial  Android\r\n",216);
				m_printer.PrintString24("Time to market");
				m_printer.PrintString24Location(": Year 2015\r\n",216);
				m_printer.PrintString24("Type");
				m_printer.PrintString24Location(": Industrial  Android\r\n",216);
				m_printer.PrintString24("Time to market");
				m_printer.PrintString24Location(": Year 2015\r\n",216);
				m_printer.PrintString24("Type");
				m_printer.PrintString24Location(": Industrial  Android\r\n",216);
				m_printer.PrintString24("Time to market");
				m_printer.PrintString24Location(": Year 2015\r\n",216);
			}
			  
		});   
		m_btnPrint.setOnClickListener(new OnClickListener()
		{

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				m_printer.PrintString(m_exit.getText().toString(),24);			
			}
				
		});
		m_btnStep.setOnClickListener(new OnClickListener()
		{

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				m_printer.Step((byte)0xff);   
	
			}
			
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.test_print_main, menu);
		return true;
	}

}
