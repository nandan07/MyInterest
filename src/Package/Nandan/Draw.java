package Package.Nandan;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnTouchListener;

public class Draw extends Activity implements OnTouchListener {

	Mysurf surf;
	float x, y, sx, sy, fx, fy;
	Paint ln = new Paint();
	Paint pntm1 = new Paint();
	Paint pntm2 = new Paint();
	Paint pntm3 = new Paint();
	Paint pntm4 = new Paint();
	Paint pnt1 = new Paint();
	float[] a = new float[1000];
	float[] b = new float[1000];
	float[] c = new float[1000];
	float[] d = new float[1000];
	float[] a1 = new float[1000];
	float[] a2 = new float[1000];
	float[] b1 = new float[1000];
	float[] b2 = new float[1000];
	float[] c1 = new float[1000];
	float[] c2 = new float[1000];
	float[] d1 = new float[1000];
	float[] d2 = new float[1000];
	float[] p1 = new float[1000];
	float[] p2 = new float[1000];

	int l = 0, n = 0, s = 0;

	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		surf = new Mysurf(this);
		surf.setOnTouchListener(this);
		x = 0;
		y = 0;
		ln.setColor(Color.BLUE);
		pntm2.setColor(Color.BLACK);
		setContentView(surf);
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		surf.pause();
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		surf.resume();
	}

	@Override
	public boolean onTouch(View v, MotionEvent event) {
		// TODO Auto-generated method stub
		x = event.getX();
		y = event.getY();

		switch (event.getAction()) {
		case MotionEvent.ACTION_DOWN:
			if (event.getX() > 50 && s == 1) {
				a[l] = event.getX();
				b[l] = event.getY();
			} else if (event.getX() > 50 && s == 2) {
				a1[l] = event.getX();
				a2[l] = event.getY();
			} else if (event.getX() > 50 && s == 3) {
				p1[l] = event.getX();
				p2[l] = event.getY();

			} else if (event.getX() < 50 && y < 50) {
				undo();
			} else if (event.getX() < 50 && 50 < y && y < 100) {
				s = 1;
				pntm2.setColor(Color.CYAN);
				pntm3.setColor(Color.BLACK);
				pntm4.setColor(Color.BLACK);
			} else if (event.getX() < 50 && 100 < y && y < 150) {
				s = 2;
				pntm2.setColor(Color.BLACK);
				pntm4.setColor(Color.BLACK);
				pntm3.setColor(Color.CYAN);
			} else if (event.getX() < 50 && 150 < y && y < 200) {
				s = 3;
				pntm2.setColor(Color.BLACK);
				pntm3.setColor(Color.BLACK);
				pntm4.setColor(Color.CYAN);
			} else {
				s = 0;
				pntm2.setColor(Color.BLACK);
				pntm3.setColor(Color.BLACK);
				pntm4.setColor(Color.BLACK);
			}

			break;
		case MotionEvent.ACTION_UP:
			if (event.getX() > 50 && s == 1) {
				c[l] = event.getX();
				d[l] = event.getY();
				increase();
			} else if (event.getX() > 50 && s == 2) {
				b1[l] = event.getX();
				b2[l] = event.getY();
				ponits();
				increase();
			}
			else if (event.getX() > 50 && s == 3) {
				l++;
				p1[l] = 0;
				p2[l] = 0;
				l++;
			}
			break;
		case MotionEvent.ACTION_MOVE:
			if (event.getX() > 50 && s == 3) {
				l++;
				p1[l] = event.getX();
				p2[l] = event.getY();
				
			}
			break;
		}

		return true;
	}

	private void ponits() {
		c1[l] = b1[l];
		c2[l] = a2[l];
		d1[l] = a1[l];
		d2[l] = b2[l];

	}

	public class Mysurf extends SurfaceView implements Runnable {
		SurfaceHolder holder;
		Thread Thr = null;
		boolean v = false;

		Bitmap img = BitmapFactory.decodeResource(getResources(),
				R.drawable.undo);
		Bitmap img1 = BitmapFactory.decodeResource(getResources(),
				R.drawable.line);
		Bitmap img2 = BitmapFactory.decodeResource(getResources(),
				R.drawable.rect);
		Bitmap img3 = BitmapFactory.decodeResource(getResources(),
				R.drawable.pen);

		public Mysurf(Context context) {
			super(context);
			holder = getHolder();
		}

		@Override
		public void run() {
			while (v) {
				if (!holder.getSurface().isValid())
					continue;
				Canvas cv = holder.lockCanvas();
				cv.drawRGB(255, 255, 255);
				cv.drawRect(0, 0, 52, cv.getHeight(), pnt1);
				cv.drawRect(0, 50, 50, 100, pntm2);
				cv.drawRect(0, 100, 50, 150, pntm3);
				cv.drawRect(0, 150, 50, 200, pntm4);
				cv.drawBitmap(img, 0, 0, null);
				cv.drawBitmap(img1, 0, 50, null);
				cv.drawBitmap(img2, 0, 100, null);
				cv.drawBitmap(img3, 0, 150, null);
				for (int k = 0; k < 1000; k++) {
					if (a[k] > 0 && c[k] > 0 && (s > 0)) {
						cv.drawLine(a[k], b[k], c[k], d[k], ln);
						if (a[l] > 0 && (s == 1))
							cv.drawLine(a[l], b[l], x, y, ln);
					}

				}
				for (int j = 0; j < 1000; j++) {
					if (a1[j] > 0 && b1[j] > 0 && (s > 0)) {
						cv.drawLine(a1[j], a2[j], c1[j], c2[j], ln);
						cv.drawLine(a1[j], a2[j], d1[j], d2[j], ln);
						cv.drawLine(b1[j], b2[j], c1[j], c2[j], ln);
						cv.drawLine(b1[j], b2[j], d1[j], d2[j], ln);
						if (a1[l] > 0 && (s == 2)) {
							cv.drawLine(a1[l], a2[l], x, a2[l], ln);
							cv.drawLine(a1[l], a2[l], a1[l], y, ln);
							cv.drawLine(x, y, x, a2[l], ln);
							cv.drawLine(x, y, a1[l], y, ln);
						}
					}

				}
				for (int p = 1; p < 1000; p++){
					if (p1[p] > 0 && p1[p-1] > 0 && (s > 0)) {
					cv.drawLine(p1[p-1], p2[p-1], p1[p], p2[p], ln);
					}
				}
				holder.unlockCanvasAndPost(cv);

			}
		}

		public void pause() {
			v = false;
			while (true) {
				try {
					Thr.join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			}
			Thr = null;
		}

		public void resume() {
			v = true;
			Thr = new Thread(this);
			Thr.start();
		}
	}

	public void increase() {
		// TODO Auto-generated method stub
		l = l + 1;
		if (l >= 1000)
			l = 0;
	}

	private void undo() {
		if (l > 0)
			l--;
		a[l] = 0;
		b[l] = 0;
		c[l] = 0;
		d[l] = 0;
		a1[l] = 0;
		a2[l] = 0;
		b1[l] = 0;
		b2[l] = 0;
		c1[l] = 0;
		c2[l] = 0;
		d1[l] = 0;
		d2[l] = 0;
		p1[l] = 0;
		p2[l] = 0;

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
				Intent in1=new Intent("android.intent.action.DRAWHELP");
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
