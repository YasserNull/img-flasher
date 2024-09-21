package com.imgflasher;

import android.Manifest;
import android.animation.*;
import android.app.*;
import android.app.Activity;
import android.content.*;
import android.content.ClipData;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.*;
import android.graphics.*;
import android.graphics.drawable.*;
import android.media.*;
import android.net.*;
import android.net.Uri;
import android.os.*;
import android.text.*;
import android.text.style.*;
import android.util.*;
import android.view.*;
import android.view.View;
import android.view.View.*;
import android.view.animation.*;
import android.webkit.*;
import android.widget.*;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.*;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.blogspot.atifsoftwares.animatoolib.*;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.io.*;
import java.text.*;
import java.util.*;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.*;
import org.json.*;
import java.lang.Process;

public class ImageKitchenActivity extends AppCompatActivity {
	
	public final int REQ_CD_FILE_PICKER = 101;
	
	private Timer _timer = new Timer();
	
	private Toolbar _toolbar;
	private AppBarLayout _app_bar;
	private CoordinatorLayout _coordinator;
	private FloatingActionButton _fab;
	private DrawerLayout _drawer;
	private Process process = null;
	private boolean fab = false;
	private boolean running = false;
	int REQ_CD_Folder_PICKER = 1;
	private double file = 0;
	private double folder = 0;
	
	private LinearLayout linear1;
	private LinearLayout linear2;
	private LinearLayout linear4;
	private LinearLayout linear6;
	private TextView textview1;
	private TextView textview2;
	private LinearLayout linear7;
	private ScrollView vscroll1;
	private TextView textview3;
	private TextView textview4;
	private HorizontalScrollView hscroll1;
	private TextView textview5;
	private LinearLayout linear5;
	private LinearLayout linear11;
	private LinearLayout linear13;
	private LinearLayout linear15;
	private LinearLayout linear8;
	private Button button2;
	private LinearLayout linear9;
	private LinearLayout linear16;
	private Button button3;
	private LinearLayout linear10;
	private LinearLayout linear12;
	private LinearLayout linear14;
	private LinearLayout linear17;
	private LinearLayout linear25;
	private LinearLayout linear18;
	private LinearLayout linear19;
	private LinearLayout linear20;
	private TextView textview6;
	private TextView textview12;
	private ImageView imageview1;
	private TextView textview7;
	private TextView textview13;
	private ImageView imageview2;
	private LinearLayout linear22;
	private LinearLayout linear23;
	private TextView textview9;
	private TextView textview14;
	private ImageView imageview4;
	private TextView textview10;
	private TextView textview15;
	private ImageView imageview5;
	private ProgressBar progressbar1;
	private LinearLayout _drawer_linear1;
	private ImageView _drawer_imageview1;
	private LinearLayout _drawer_linear3;
	private LinearLayout _drawer_linear2;
	private LinearLayout _drawer_linear5;
	private Button _drawer_button2;
	private LinearLayout _drawer_linear6;
	private Button _drawer_button1;
	
	private Intent intent = new Intent();
	private TimerTask timer;
	private TimerTask timer1;
	private SharedPreferences shared_perfernces;
	private Intent file_picker = new Intent(Intent.ACTION_GET_CONTENT);
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.image_kitchen);
		initialize(_savedInstanceState);
		
		if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED) {
			ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.READ_EXTERNAL_STORAGE}, 1000);
		} else {
			initializeLogic();
		}
	}
	
	@Override
	public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
		super.onRequestPermissionsResult(requestCode, permissions, grantResults);
		if (requestCode == 1000) {
			initializeLogic();
		}
	}
	
	private void initialize(Bundle _savedInstanceState) {
		_app_bar = findViewById(R.id._app_bar);
		_coordinator = findViewById(R.id._coordinator);
		_toolbar = findViewById(R.id._toolbar);
		setSupportActionBar(_toolbar);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().setHomeButtonEnabled(true);
		_toolbar.setNavigationOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _v) {
				onBackPressed();
			}
		});
		_fab = findViewById(R.id._fab);
		
		_drawer = findViewById(R.id._drawer);
		ActionBarDrawerToggle _toggle = new ActionBarDrawerToggle(ImageKitchenActivity.this, _drawer, _toolbar, R.string.app_name, R.string.app_name);
		_drawer.addDrawerListener(_toggle);
		_toggle.syncState();
		
		LinearLayout _nav_view = findViewById(R.id._nav_view);
		
		linear1 = findViewById(R.id.linear1);
		linear2 = findViewById(R.id.linear2);
		linear4 = findViewById(R.id.linear4);
		linear6 = findViewById(R.id.linear6);
		textview1 = findViewById(R.id.textview1);
		textview2 = findViewById(R.id.textview2);
		linear7 = findViewById(R.id.linear7);
		vscroll1 = findViewById(R.id.vscroll1);
		textview3 = findViewById(R.id.textview3);
		textview4 = findViewById(R.id.textview4);
		hscroll1 = findViewById(R.id.hscroll1);
		textview5 = findViewById(R.id.textview5);
		linear5 = findViewById(R.id.linear5);
		linear11 = findViewById(R.id.linear11);
		linear13 = findViewById(R.id.linear13);
		linear15 = findViewById(R.id.linear15);
		linear8 = findViewById(R.id.linear8);
		button2 = findViewById(R.id.button2);
		linear9 = findViewById(R.id.linear9);
		linear16 = findViewById(R.id.linear16);
		button3 = findViewById(R.id.button3);
		linear10 = findViewById(R.id.linear10);
		linear12 = findViewById(R.id.linear12);
		linear14 = findViewById(R.id.linear14);
		linear17 = findViewById(R.id.linear17);
		linear25 = findViewById(R.id.linear25);
		linear18 = findViewById(R.id.linear18);
		linear19 = findViewById(R.id.linear19);
		linear20 = findViewById(R.id.linear20);
		textview6 = findViewById(R.id.textview6);
		textview12 = findViewById(R.id.textview12);
		imageview1 = findViewById(R.id.imageview1);
		textview7 = findViewById(R.id.textview7);
		textview13 = findViewById(R.id.textview13);
		imageview2 = findViewById(R.id.imageview2);
		linear22 = findViewById(R.id.linear22);
		linear23 = findViewById(R.id.linear23);
		textview9 = findViewById(R.id.textview9);
		textview14 = findViewById(R.id.textview14);
		imageview4 = findViewById(R.id.imageview4);
		textview10 = findViewById(R.id.textview10);
		textview15 = findViewById(R.id.textview15);
		imageview5 = findViewById(R.id.imageview5);
		progressbar1 = findViewById(R.id.progressbar1);
		_drawer_linear1 = _nav_view.findViewById(R.id.linear1);
		_drawer_imageview1 = _nav_view.findViewById(R.id.imageview1);
		_drawer_linear3 = _nav_view.findViewById(R.id.linear3);
		_drawer_linear2 = _nav_view.findViewById(R.id.linear2);
		_drawer_linear5 = _nav_view.findViewById(R.id.linear5);
		_drawer_button2 = _nav_view.findViewById(R.id.button2);
		_drawer_linear6 = _nav_view.findViewById(R.id.linear6);
		_drawer_button1 = _nav_view.findViewById(R.id.button1);
		shared_perfernces = getSharedPreferences("shared_perfernces", Activity.MODE_PRIVATE);
		file_picker.setType("*/*");
		file_picker.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
		
		button2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (!textview12.getText().toString().equals("") && !textview13.getText().toString().equals("")) {
					running = true;
					_fab.setImageResource(R.drawable.ic_close_white);
					_fab.setBackgroundTintList(android.content.res.ColorStateList.valueOf(0xFFFF0000));
					fab = false;
					shared_perfernces.edit().remove("exit_code").commit();
					_fab.show();
					button2.setTextColor(0xFF9E9E9E);
					button3.setTextColor(0xFF9E9E9E);
					progressbar1.setProgress((int)10);
					button2.setEnabled(false);
					button3.setEnabled(false);
					progressbar1.getProgressDrawable().setColorFilter(
					    0xFF00FF00, android.graphics.PorterDuff.Mode.SRC_IN);
					timer = new TimerTask() {
						@Override
						public void run() {
							runOnUiThread(new Runnable() {
								@Override
								public void run() {
									progressbar1.setProgress((int)1 + progressbar1.getProgress());
									if (progressbar1.getProgress() == 100) {
										timer.cancel();
									}
								}
							});
						}
					};
					_timer.scheduleAtFixedRate(timer, (int)(1000), (int)(1000));
					try {
						ProcessBuilder process_builder = new ProcessBuilder();
						process_builder.command("su", "-c", "imgf unpack ".concat(textview12.getText().toString().concat(" ".concat(textview13.getText().toString()))));
						process_builder.redirectErrorStream(true);
						Process process = process_builder.start();
						BufferedReader buffered_reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
						            String line;
						            while ((line = buffered_reader.readLine()) != null) {
							                textview5.append("\n"+line);
							            }
						int exit_code = process.waitFor();
						shared_perfernces.edit().putString("exit_code", String.valueOf((long)(exit_code))).commit();
						if (exit_code != 0) {
							timer.cancel();
							progressbar1.getProgressDrawable().setColorFilter(
							    0xFFFF0000, android.graphics.PorterDuff.Mode.SRC_IN);
							_fab.setBackgroundTintList(android.content.res.ColorStateList.valueOf(0xFF00FF00));
							fab = true;
							_fab.setImageResource(R.drawable.ic_refresh_white);
							SketchwareUtil.showMessage(getApplicationContext(), "Error");
						}
						if (shared_perfernces.getString("exit_code", "").equals("0")) {
							timer1 = new TimerTask() {
								@Override
								public void run() {
									runOnUiThread(new Runnable() {
										@Override
										public void run() {
											progressbar1.setProgress((int)1 + progressbar1.getProgress());
											if (progressbar1.getProgress() == 100) {
												_fab.setImageResource(R.drawable.ic_refresh_white);
												fab = false;
												_fab.setBackgroundTintList(android.content.res.ColorStateList.valueOf(0xFF00FF00));
												timer1.cancel();
											}
										}
									});
								}
							};
							_timer.scheduleAtFixedRate(timer1, (int)(1), (int)(1));
						}
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
				}
				else {
					SketchwareUtil.showMessage(getApplicationContext(), "error");
				}
			}
		});
		
		button3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (!textview14.getText().toString().equals("") && !textview15.getText().toString().equals("")) {
					running = true;
					_fab.setImageResource(R.drawable.ic_close_white);
					_fab.setBackgroundTintList(android.content.res.ColorStateList.valueOf(0xFFFF0000));
					fab = false;
					shared_perfernces.edit().remove("exit_code").commit();
					_fab.show();
					button2.setTextColor(0xFF9E9E9E);
					button3.setTextColor(0xFF9E9E9E);
					progressbar1.setProgress((int)10);
					button2.setEnabled(false);
					button3.setEnabled(false);
					progressbar1.getProgressDrawable().setColorFilter(
					    0xFF00FF00, android.graphics.PorterDuff.Mode.SRC_IN);
					timer = new TimerTask() {
						@Override
						public void run() {
							runOnUiThread(new Runnable() {
								@Override
								public void run() {
									progressbar1.setProgress((int)1 + progressbar1.getProgress());
									if (progressbar1.getProgress() == 100) {
										timer.cancel();
									}
								}
							});
						}
					};
					_timer.scheduleAtFixedRate(timer, (int)(1000), (int)(1000));
					try {
						ProcessBuilder process_builder = new ProcessBuilder();
						process_builder.command("su", "-c", "imgf repack ".concat(textview14.getText().toString().concat(" ".concat(textview15.getText().toString().concat(" ".concat(textview14.getText().toString().replace(Uri.parse(textview14.getText().toString()).getLastPathSegment(), "").concat("new-".concat(Uri.parse(textview14.getText().toString()).getLastPathSegment()))))))));
						process_builder.redirectErrorStream(true);
						Process process = process_builder.start();
						BufferedReader buffered_reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
						            String line;
						            while ((line = buffered_reader.readLine()) != null) {
							                textview5.append("\n"+line);
							            }
						int exit_code = process.waitFor();
						shared_perfernces.edit().putString("exit_code", String.valueOf((long)(exit_code))).commit();
						if (exit_code != 0) {
							timer.cancel();
							progressbar1.getProgressDrawable().setColorFilter(
							    0xFFFF0000, android.graphics.PorterDuff.Mode.SRC_IN);
							_fab.setBackgroundTintList(android.content.res.ColorStateList.valueOf(0xFF00FF00));
							fab = true;
							_fab.setImageResource(R.drawable.ic_refresh_white);
							SketchwareUtil.showMessage(getApplicationContext(), "Error");
						}
						if (shared_perfernces.getString("exit_code", "").equals("0")) {
							timer1 = new TimerTask() {
								@Override
								public void run() {
									runOnUiThread(new Runnable() {
										@Override
										public void run() {
											progressbar1.setProgress((int)1 + progressbar1.getProgress());
											if (progressbar1.getProgress() == 100) {
												_fab.setImageResource(R.drawable.ic_refresh_white);
												fab = false;
												_fab.setBackgroundTintList(android.content.res.ColorStateList.valueOf(0xFF00FF00));
												timer1.cancel();
											}
										}
									});
								}
							};
							_timer.scheduleAtFixedRate(timer1, (int)(1), (int)(1));
						}
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
				}
				else {
					SketchwareUtil.showMessage(getApplicationContext(), "error");
				}
			}
		});
		
		imageview1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				startActivityForResult(file_picker, REQ_CD_FILE_PICKER);
				file = 1;
			}
		});
		
		imageview2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				Intent folder_picker = new Intent(Intent.ACTION_OPEN_DOCUMENT_TREE);
				startActivityForResult(folder_picker, 1);
				folder = 1;
			}
		});
		
		imageview4.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				startActivityForResult(file_picker, REQ_CD_FILE_PICKER);
				file = 2;
			}
		});
		
		imageview5.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				Intent folder_picker = new Intent(Intent.ACTION_OPEN_DOCUMENT_TREE);
				startActivityForResult(folder_picker, 1);
				folder = 2;
			}
		});
		
		_fab.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (timer != null) {
					timer.cancel();
				}
				if (timer1 != null) {
					timer1.cancel();
				}
				button2.setEnabled(true);
				button3.setEnabled(true);
				_fab.hide();
				button2.setTextColor(0xFFFFFFFF);
				button3.setTextColor(0xFFFFFFFF);
				progressbar1.setProgress((int)0);
				progressbar1.getProgressDrawable().setColorFilter(
				    0xFF151515, android.graphics.PorterDuff.Mode.SRC_IN);
				running = false;
				if (!fab) {
					if (process != null) {
						     process.destroy();
					}
				}
			}
		});
	}
	
	private void initializeLogic() {
		getWindow().getDecorView().setSystemUiVisibility(0);
		
		// Set navigation bar color to dark and icons to light
		getWindow().setNavigationBarColor(Color.parseColor("#FF121212"));
		getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR);
		_fab.setBackgroundTintList(android.content.res.ColorStateList.valueOf(0xFF00E676));
		textview5.setTextSize((int)10);
		_fab.hide();
		
		{
			android.graphics.drawable.GradientDrawable SketchUi = new android.graphics.drawable.GradientDrawable();
			int d = (int) getApplicationContext().getResources().getDisplayMetrics().density;
			SketchUi.setColor(0xFF101010);
			button2.setElevation(d*21);
			android.graphics.drawable.RippleDrawable SketchUi_RD = new android.graphics.drawable.RippleDrawable(new android.content.res.ColorStateList(new int[][]{new int[]{}}, new int[]{0xFF303030}), SketchUi, null);
			button2.setBackground(SketchUi_RD);
			button2.setClickable(true);
		}
		{
			android.graphics.drawable.GradientDrawable SketchUi = new android.graphics.drawable.GradientDrawable();
			int d = (int) getApplicationContext().getResources().getDisplayMetrics().density;
			SketchUi.setColor(0xFF101010);
			button3.setElevation(d*21);
			android.graphics.drawable.RippleDrawable SketchUi_RD = new android.graphics.drawable.RippleDrawable(new android.content.res.ColorStateList(new int[][]{new int[]{}}, new int[]{0xFF303030}), SketchUi, null);
			button3.setBackground(SketchUi_RD);
			button3.setClickable(true);
		}
		
		{
			android.graphics.drawable.GradientDrawable SketchUi = new android.graphics.drawable.GradientDrawable();
			int d = (int) getApplicationContext().getResources().getDisplayMetrics().density;
			SketchUi.setColor(0xFF101010);
			button2.setElevation(d*21);
			android.graphics.drawable.RippleDrawable SketchUi_RD = new android.graphics.drawable.RippleDrawable(new android.content.res.ColorStateList(new int[][]{new int[]{}}, new int[]{0xFF303030}), SketchUi, null);
			_drawer_button2.setBackground(SketchUi_RD);
			_drawer_button2.setClickable(true);
		}
		{
			android.graphics.drawable.GradientDrawable SketchUi = new android.graphics.drawable.GradientDrawable();
			int d = (int) getApplicationContext().getResources().getDisplayMetrics().density;
			SketchUi.setColor(0xFF101010);
			button3.setElevation(d*21);
			android.graphics.drawable.RippleDrawable SketchUi_RD = new android.graphics.drawable.RippleDrawable(new android.content.res.ColorStateList(new int[][]{new int[]{}}, new int[]{0xFF303030}), SketchUi, null);
			_drawer_button1.setBackground(SketchUi_RD);
			_drawer_button1.setClickable(true);
		}
		textview1.setText("Brand : ".concat(Build.BRAND));
		textview2.setText("Model : ".concat(Build.MODEL));
		progressbar1.getProgressDrawable().setColorFilter(
		    0xFF151515, android.graphics.PorterDuff.Mode.SRC_IN);
		file = 0;
		_drawer_button2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (!running) {
					if (!fab) {
						_drawer.closeDrawer(GravityCompat.START);
						startActivity(new Intent(ImageKitchenActivity.this, ImgflasherActivity.class)); Animatoo.animateFade(ImageKitchenActivity.this);
						
						finish();
					}
				}
			}
		});
	}
	
	@Override
	protected void onActivityResult(int _requestCode, int _resultCode, Intent _data) {
		super.onActivityResult(_requestCode, _resultCode, _data);
		if (_requestCode == REQ_CD_Folder_PICKER && _resultCode == RESULT_OK) {
				    if (_data != null) {
						        Uri uri = _data.getData();
						String path =  uri.getPath().replace("/tree/", "/storage/");
						path = path.replace("primary:", FileUtil.getExternalStorageDir()+"/");
						path = path.replace("//storage/", "/");
						path =  path.replace(":", "/");
						if (folder == 1) {
								textview13.setText(path.concat("/"));
						}
						if (folder == 2) {
								textview15.setText(path.concat("/"));
						}
						folder = 0;
				}
		}
		
		switch (_requestCode) {
			case REQ_CD_FILE_PICKER:
			if (_resultCode == Activity.RESULT_OK) {
				ArrayList<String> _filePath = new ArrayList<>();
				if (_data != null) {
					if (_data.getClipData() != null) {
						for (int _index = 0; _index < _data.getClipData().getItemCount(); _index++) {
							ClipData.Item _item = _data.getClipData().getItemAt(_index);
							_filePath.add(FileUtil.convertUriToFilePath(getApplicationContext(), _item.getUri()));
						}
					}
					else {
						_filePath.add(FileUtil.convertUriToFilePath(getApplicationContext(), _data.getData()));
					}
				}
				if (Uri.parse(_filePath.get((int)(0))).getLastPathSegment().endsWith(".img")) {
					if (file == 1) {
						textview12.setText(_filePath.get((int)(0)));
					}
					if (file == 2) {
						textview14.setText(_filePath.get((int)(0)));
					}
					file = 0;
				}
				else {
					SketchwareUtil.showMessage(getApplicationContext(), "Error : not img file");
				}
			}
			else {
				
			}
			break;
			default:
			break;
		}
	}
	
	
	@Override
	public void onBackPressed() {
		if (_drawer.isDrawerOpen(GravityCompat.START)) {
			_drawer.closeDrawer(GravityCompat.START);
		} else {
			super.onBackPressed();
		}
	}
}