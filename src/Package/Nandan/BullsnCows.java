package Package.Nandan;

import java.util.Random;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class BullsnCows extends Activity implements OnClickListener {

	Button bt;
	TextView tv;
	EditText tx;
	static String s = "1111", s1;
	int n = 1, cnt = 0;
	String[] ans = new String[50];
	int[] bl = new int[50];
	int[] cw = new int[50];
	String st = "word \t Bulls \t Cows";

	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.bullsncows);
		intial();
		bt.setOnClickListener(this);
		genWord();
		tv.setText("Enter a 4 letter Word");
	}

	private void genWord() {
		Random ran = new Random();
		char a[] = { 'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p', 'a',
				's', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'z', 'x', 'c', 'v',
				'b', 'n', 'm' };
		char an[] = new char[4];
		for (int i = 0; i < 4; i++) {
			int m = 1;
			while (m >= 0) {
				an[i] = a[ran.nextInt(25)];
				m = s.indexOf(an[i]);
			}
			s = String.valueOf(an);
		}

	}

	private void intial() {
		bt = (Button) findViewById(R.id.button1);
		tv = (TextView) findViewById(R.id.txv);
		tx = (EditText) findViewById(R.id.editText1);

	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.button1:
			s1 = tx.getText().toString();
			n = s1.compareTo(s);
			if (n == 0) {
				tv.setText("Congratzzzz.!!!");
				tv.setTextSize(25);
				tv.setTextColor(Color.CYAN);
				Intent in = new Intent("android.intent.action.CONGRATS");
				startActivity(in);
			} else
				BullnCow(s1, s);
		}

	}

	private void BullnCow(String y1, String y) {

		char[] a, b = new char[4];
		int bull = 0, cows = 0;
		b = y1.toCharArray();
		a = y.toCharArray();
		for (char x : b) {
			int n = y.indexOf(x);
			if (n >= 0)
				cows++;
		}
		for (int j = 0; j < 4; j++) {
			if (a[j] == b[j])
				bull++;
		}
		cows = cows - bull;
		bl[cnt] = bull;
		cw[cnt] = cows;
		ans[cnt] = y1;
		st = (st + "\n" + ans[cnt] + "\t \t \t" + bl[cnt] + "\t \t \t" + cw[cnt]);
		tv.setText(st);
		cnt++;
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		finish();
	}

	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		super.onCreateOptionsMenu(menu);
		MenuInflater up=getMenuInflater();
		up.inflate(R.menu.mymenu, menu);
		return true;
	}

	
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		 super.onOptionsItemSelected(item);
		switch(item.getItemId())
		{
		case R.id.hlp:
			{
				Intent in1=new Intent("android.intent.action.HELP");
				startActivity(in1);
			}break;
		case R.id.ext:
		{
			finish();
		}
			
		}
		return true;
	}


}
