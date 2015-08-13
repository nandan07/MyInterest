package Package.Nandan;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Menu extends ListActivity {

	String[] s = { "Application", "Game", "BullsnCows", "Draw" };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setListAdapter(new ArrayAdapter<String>(Menu.this,
				android.R.layout.simple_list_item_1, s));
	}

	protected void onListItemClick(ListView l, View v, int pos, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, pos, id);
		String st = s[pos];
		Class cls;
		try {
			cls = Class.forName("Package.Nandan." + st);
			Intent intn = new Intent(Menu.this, cls);
			startActivity(intn);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
