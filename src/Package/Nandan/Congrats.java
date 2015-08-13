package Package.Nandan;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.MediaStore.Audio.Media;

public class Congrats extends Activity {

	MediaPlayer song;

	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.congrats);
		song = MediaPlayer.create(Congrats.this, R.raw.congrats);
		Thread th = new Thread() {
			public void run() {
				try {
					song.start();
					sleep(2000);

				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					Intent in = new Intent("android.intent.action.BULLSNCOWS");
					startActivity(in);
					song.stop();
					finish();
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
