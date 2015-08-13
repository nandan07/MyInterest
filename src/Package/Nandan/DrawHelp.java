package Package.Nandan;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class DrawHelp extends Activity
{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.drawhelp);
	}
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		super.onCreateOptionsMenu(menu);
		MenuInflater up=getMenuInflater();
		up.inflate(R.menu.drawmenu, menu);
		return true;
	}

	
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		 super.onOptionsItemSelected(item);
		switch(item.getItemId())
		{
		case R.id.dh:
			{
				Intent in1=new Intent("android.intent.action.HELP");
				startActivity(in1);
			}break;
		case R.id.ext2:
		{
			finish();
		}
			
		}
		return true;
	}

}
