package com.imgflasher;

import android.animation.*;
import android.app.*;
import android.content.*;
import android.content.res.*;
import android.graphics.*;
import android.graphics.drawable.*;
import android.media.*;
import android.net.*;
import android.os.*;
import android.text.*;
import android.text.style.*;
import android.util.*;
import android.view.*;
import android.view.View.*;
import android.view.animation.*;
import android.webkit.*;
import android.widget.*;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.blogspot.atifsoftwares.animatoolib.*;
import java.io.*;
import java.text.*;
import java.util.*;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.*;
import org.json.*;
import java.lang.Process;


public class MainActivity extends AppCompatActivity {
	
	private Timer _timer = new Timer();
	
	private Process process = null;
	
	private LinearLayout background;
	private ImageView android;
	
	private TimerTask timer;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.main);
		initialize(_savedInstanceState);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		background = findViewById(R.id.background);
		android = findViewById(R.id.android);
	}
	
	private void initializeLogic() {
		getWindow().getDecorView().setSystemUiVisibility(0);
		
		// Set navigation bar color to dark and icons to light
		getWindow().setNavigationBarColor(Color.parseColor("#FF121212"));
		getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR);
		try {
			ProcessBuilder process_builder = new ProcessBuilder();
			process_builder.redirectErrorStream(true);
			process_builder.command("sh", "-c", "command -v su");
			Process process = process_builder.start();
			int exit_code = process.waitFor();
			if (exit_code == 0) {
				process_builder.command("su", "-c", "whoami");
				process = process_builder.start();
				BufferedReader buffered_reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
				            String line;
				            while ((line = buffered_reader.readLine()) != null) {
					                if (line.equals("root")) {
						if (Build.VERSION.SDK_INT > Build.VERSION_CODES.KITKAT) {
							Window w =MainActivity.this.getWindow();
							w.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
							w.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS); w.setStatusBarColor(0xFF000000);
						}
						timer = new TimerTask() {
							@Override
							public void run() {
								runOnUiThread(new Runnable() {
									@Override
									public void run() {
										startActivity(new Intent(MainActivity.this, ImgflasherActivity.class)); Animatoo.animateFade(MainActivity.this);
										
										finish();
									}
								});
							}
						};
						_timer.schedule(timer, (int)(600));
					}
					else {
						SketchwareUtil.showMessage(getApplicationContext(), "root permission denied");
					}
					            }
			}
			else {
				SketchwareUtil.showMessage(getApplicationContext(), "you don't have root ");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void _intent_animation(final View _view) {
		ScaleAnimation fade_in = new ScaleAnimation(0.9f, 1f, 0.9f, 1f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.7f);
		fade_in.setDuration(300);
		fade_in.setFillAfter(true);
		_view.startAnimation(fade_in);
	}
	
}
