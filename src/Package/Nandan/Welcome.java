package Package.Nandan;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;

public class Welcome extends Activity {

	MediaPlayer song;

	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		song = MediaPlayer.create(Welcome.this, R.raw.sword);
		setContentView(R.layout.welcome);
		Thread th = new Thread() {
			public void run() {
				try {
					sleep(1000);
					song.start();
					sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					Intent in = new Intent("android.intent.action.MENU");
					startActivity(in);
				}

			}
		};
		th.start();
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		finish();
	}

}
