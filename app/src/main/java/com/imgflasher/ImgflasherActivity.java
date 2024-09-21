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
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.*;
import org.json.*;
import android.content.pm.ActivityInfo;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import java.net.URLDecoder;
import java.lang.Process;

public class ImgflasherActivity extends AppCompatActivity {
	
	public final int REQ_CD_FILE_PICKER = 101;
	
	private Timer _timer = new Timer();
	
	private Toolbar _toolbar;
	private AppBarLayout _app_bar;
	private CoordinatorLayout _coordinator;
	private FloatingActionButton _fab;
	private DrawerLayout _drawer;
	private double selectn1 = 0;
	private double selectn = 0;
	private double n = 0;
	private double n1 = 0;
	private boolean running = false;
	private boolean fab = false;
	private Process process = null;
	public final int REQ_CD_Folder_PICKER = 1;
	private String output = "";
	private double count_files = 0;
	
	private ArrayList<HashMap<String, Object>> listmap = new ArrayList<>();
	private ArrayList<String> liststring = new ArrayList<>();
	
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
	private Button button4;
	private LinearLayout linear12;
	private Button button5;
	private ListView listview1;
	private LinearLayout linear14;
	private ListView listview2;
	private ProgressBar progressbar1;
	private LinearLayout _drawer_linear1;
	private ImageView _drawer_imageview1;
	private LinearLayout _drawer_linear3;
	private LinearLayout _drawer_linear2;
	private LinearLayout _drawer_linear5;
	private Button _drawer_button2;
	private LinearLayout _drawer_linear6;
	private Button _drawer_button1;
	
	private TimerTask timer;
	private TimerTask timer1;
	private Intent file_picker = new Intent(Intent.ACTION_GET_CONTENT);
	private Intent intent = new Intent();
	private SharedPreferences shared_perfernces;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.imgflasher);
		initialize(_savedInstanceState);
		
		if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED
		|| ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED) {
			ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1000);
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
		ActionBarDrawerToggle _toggle = new ActionBarDrawerToggle(ImgflasherActivity.this, _drawer, _toolbar, R.string.app_name, R.string.app_name);
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
		button4 = findViewById(R.id.button4);
		linear12 = findViewById(R.id.linear12);
		button5 = findViewById(R.id.button5);
		listview1 = findViewById(R.id.listview1);
		linear14 = findViewById(R.id.linear14);
		listview2 = findViewById(R.id.listview2);
		progressbar1 = findViewById(R.id.progressbar1);
		_drawer_linear1 = _nav_view.findViewById(R.id.linear1);
		_drawer_imageview1 = _nav_view.findViewById(R.id.imageview1);
		_drawer_linear3 = _nav_view.findViewById(R.id.linear3);
		_drawer_linear2 = _nav_view.findViewById(R.id.linear2);
		_drawer_linear5 = _nav_view.findViewById(R.id.linear5);
		_drawer_button2 = _nav_view.findViewById(R.id.button2);
		_drawer_linear6 = _nav_view.findViewById(R.id.linear6);
		_drawer_button1 = _nav_view.findViewById(R.id.button1);
		file_picker.setType("*/*");
		file_picker.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
		shared_perfernces = getSharedPreferences("shared_perfernces", Activity.MODE_PRIVATE);
		
		button2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (selectn > 0) {
					running = true;
					_fab.setImageResource(R.drawable.ic_close_white);
					_fab.setBackgroundTintList(android.content.res.ColorStateList.valueOf(0xFFFF0000));
					fab = false;
					shared_perfernces.edit().remove("exit_code").commit();
					shared_perfernces.edit().remove("break").commit();
					_fab.show();
					button2.setTextColor(0xFF9E9E9E);
					button3.setTextColor(0xFF9E9E9E);
					button4.setTextColor(0xFF9E9E9E);
					button5.setTextColor(0xFF9E9E9E);
					progressbar1.setProgress((int)10);
					button2.setEnabled(false);
					button3.setEnabled(false);
					button4.setEnabled(false);
					button5.setEnabled(false);
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
					for (int i = 0; i < n; i++) {
						  final int index = i;
						if (shared_perfernces.getString("break", "").equals("true")) {
							break;
						}
						if (listmap.get((int)i).get("selection").toString().equals("true")) {
							try {
								ProcessBuilder process_builder = new ProcessBuilder();
								process_builder.command("su", "-c", "imgf extract ".concat(listmap.get((int)i).get("partname").toString().concat(" /sdcard/download/ImgFlasher/".concat(listmap.get((int)i).get("partname").toString().concat(".img")))));
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
									shared_perfernces.edit().putString("break", "true").commit();
									_fab.setBackgroundTintList(android.content.res.ColorStateList.valueOf(0xFF00FF00));
									fab = true;
									_fab.setImageResource(R.drawable.ic_refresh_white);
									SketchwareUtil.showMessage(getApplicationContext(), "Error");
								}
							} catch (Exception e) {
								System.out.println(e.getMessage());
							}
						}
						if (index == n-1) {
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
						}
					}
					for(int _repeat112 = 0; _repeat112 < (int)(listmap.size()); _repeat112++) {
						listmap.get((int)_repeat112).put("selection", "false");
						selectn = 0;
					}
					((BaseAdapter)listview1.getAdapter()).notifyDataSetChanged();
				}
				else {
					SketchwareUtil.showMessage(getApplicationContext(), "no value is selected");
				}
			}
		});
		
		button3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (selectn1 > 0) {
					running = true;
					_fab.setBackgroundTintList(android.content.res.ColorStateList.valueOf(0xFFFF0000));
					fab = false;
					shared_perfernces.edit().remove("exit_code").commit();
					shared_perfernces.edit().remove("break").commit();
					_fab.hide();
					button2.setTextColor(0xFF9E9E9E);
					button3.setTextColor(0xFF9E9E9E);
					button4.setTextColor(0xFF9E9E9E);
					button5.setTextColor(0xFF9E9E9E);
					progressbar1.setProgress((int)10);
					button2.setEnabled(false);
					button3.setEnabled(false);
					button4.setEnabled(false);
					button5.setEnabled(false);
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
					for (int i = 0; i < n; i++) {
						  final int index = i;
						if (shared_perfernces.getString("break", "").equals("true")) {
							break;
						}
						if (listmap.get((int)i).get("selection1").toString().equals("true")) {
							try {
								ProcessBuilder process_builder = new ProcessBuilder();
								process_builder.command("su", "-c", "imgf flash ".concat(listmap.get((int)i).get("path").toString().concat(" /dev/block/".concat(listmap.get((int)i).get("partname").toString()))));
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
									shared_perfernces.edit().putString("break", "true").commit();
									_fab.setBackgroundTintList(android.content.res.ColorStateList.valueOf(0xFF00FF00));
									fab = true;
									_fab.setImageResource(R.drawable.ic_refresh_white);
									SketchwareUtil.showMessage(getApplicationContext(), "Error");
								}
							} catch (Exception e) {
								System.out.println(e.getMessage());
							}
						}
						if (index == n-1) {
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
						}
					}
					for(int _repeat108 = 0; _repeat108 < (int)(listmap.size()); _repeat108++) {
						listmap.get((int)_repeat108).put("selection1", "false");
						selectn1 = 0;
					}
					_fab.show();
					((BaseAdapter)listview1.getAdapter()).notifyDataSetChanged();
				}
				else {
					SketchwareUtil.showMessage(getApplicationContext(), "no value is selected");
				}
			}
		});
		
		button4.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				Intent folder_picker = new Intent(Intent.ACTION_OPEN_DOCUMENT_TREE);
				startActivityForResult(folder_picker, 1);
			}
		});
		
		button5.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				for (int i = 0; i < n1; i++) {
					  listmap.get((int)i).put("selection1", "false");
					listmap.get((int)i).put("path", "");
				}
				((BaseAdapter)listview2.getAdapter()).notifyDataSetChanged();
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
				button4.setEnabled(true);
				button5.setEnabled(true);
				_fab.hide();
				button2.setTextColor(0xFFFFFFFF);
				button3.setTextColor(0xFFFFFFFF);
				button4.setTextColor(0xFFFFFFFF);
				button5.setTextColor(0xFFFFFFFF);
				progressbar1.setProgress((int)0);
				progressbar1.getProgressDrawable().setColorFilter(
				    0xFF151515, android.graphics.PorterDuff.Mode.SRC_IN);
				for(int _repeat32 = 0; _repeat32 < (int)(listmap.size()); _repeat32++) {
					listmap.get((int)_repeat32).put("selection", "false");
					listmap.get((int)_repeat32).put("selection1", "false");
				}
				((BaseAdapter)listview1.getAdapter()).notifyDataSetChanged();
				((BaseAdapter)listview2.getAdapter()).notifyDataSetChanged();
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
		selectn = 0;
		selectn1 = 0;
		
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
			button4.setElevation(d*21);
			android.graphics.drawable.RippleDrawable SketchUi_RD = new android.graphics.drawable.RippleDrawable(new android.content.res.ColorStateList(new int[][]{new int[]{}}, new int[]{0xFF303030}), SketchUi, null);
			button4.setBackground(SketchUi_RD);
			button4.setClickable(true);
		}
		{
			android.graphics.drawable.GradientDrawable SketchUi = new android.graphics.drawable.GradientDrawable();
			int d = (int) getApplicationContext().getResources().getDisplayMetrics().density;
			SketchUi.setColor(0xFF101010);
			button5.setElevation(d*21);
			android.graphics.drawable.RippleDrawable SketchUi_RD = new android.graphics.drawable.RippleDrawable(new android.content.res.ColorStateList(new int[][]{new int[]{}}, new int[]{0xFF303030}), SketchUi, null);
			button5.setBackground(SketchUi_RD);
			button5.setClickable(true);
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
		 try {
			 Runtime.getRuntime().exec("su -c mkdir -p /sdcard/download/ImgFlasher");
			            Process process = Runtime.getRuntime().exec("su -c imgf list");
			            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
			            StringBuilder output = new StringBuilder();
			            String line;
			            while ((line = reader.readLine()) != null) {
				                output.append(line).append("\n");
				          
				            }
			            process.waitFor();
			
			       
			String[] lines = output.toString().split("\n");
			
			// افتراض أن كل سطر يحتوي على format مثل: partname devname size
			for (String ln : lines) {
				    String[] parts = ln.trim().split("\\s+"); // تقسيم باستخدام المسافات البيضاء
				    if (parts.length == 3) { // التأكد من أن السطر يحتوي على 3 أجزاء
					        HashMap<String, Object> _item = new HashMap<>();
					        _item.put("partname", parts[0].trim());
					        _item.put("devname", parts[1].trim());
					        _item.put("size", parts[2].trim());
					        _item.put("path", ""); // إضافة الحقل الإضافي إذا كان مطلوبًا
					        listmap.add(_item);
					    }
			}
			for(int _repeat100 = 0; _repeat100 < (int)(listmap.size()); _repeat100++) {
				listmap.get((int)n).put("selection", "false");
				n++;
				listmap.get((int)n1).put("selection1", "false");
				n1++;
			}
			listview1.setAdapter(new Listview1Adapter(listmap));
			listview2.setAdapter(new Listview2Adapter(listmap));
			((BaseAdapter)listview1.getAdapter()).notifyDataSetChanged();
			((BaseAdapter)listview2.getAdapter()).notifyDataSetChanged();
			 } catch (Exception s) {
			 }
		progressbar1.getProgressDrawable().setColorFilter(
		    0xFF151515, android.graphics.PorterDuff.Mode.SRC_IN);
		_drawer_button1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (!running) {
					if (!fab) {
						_drawer.closeDrawer(GravityCompat.START);
						startActivity(new Intent(ImgflasherActivity.this, ImageKitchenActivity.class)); Animatoo.animateFade(ImgflasherActivity.this);
						
						finish();
					}
				}
			}
		});
	}
	
	@Override
	protected void onActivityResult(int _requestCode, int _resultCode, Intent _data) {
		super.onActivityResult(_requestCode, _resultCode, _data);
		count_files = 0;
		if (_requestCode == REQ_CD_Folder_PICKER && _resultCode == RESULT_OK) {
				    if (_data != null) {
						        Uri uri = _data.getData();
						String path =  uri.getPath().replace("/tree/", "/storage/");
						path = path.replace("primary:", FileUtil.getExternalStorageDir()+"/");
						path = path.replace("//storage/", "/");
						path =  path.replace(":", "/");
						liststring.clear();
						FileUtil.listDir(path.concat("/"), liststring);
						for (int i = 0; i < liststring.size(); i++) {
								  if (FileUtil.isFile(liststring.get((int)(i))) && liststring.get((int)(i)).endsWith(".img")) {
										for (int l = 0;  l < listmap.size(); l++) {
												  if (listmap.get((int)l).get("partname").toString().concat(".img").equals(Uri.parse(liststring.get((int)(i))).getLastPathSegment())) {
														listmap.get((int)l).put("path", liststring.get((int)(i)));
														count_files++;
												}
										}
								}
						}
						if (!(count_files == 0)) {
								((BaseAdapter)listview2.getAdapter()).notifyDataSetChanged();
						}
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
					listmap.get((int)Integer.parseInt(shared_perfernces.getString("position", ""))).put("path", _filePath.get((int)(0)));
					((BaseAdapter)listview2.getAdapter()).notifyDataSetChanged();
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
	public class Listview1Adapter extends BaseAdapter {
		
		ArrayList<HashMap<String, Object>> _data;
		
		public Listview1Adapter(ArrayList<HashMap<String, Object>> _arr) {
			_data = _arr;
		}
		
		@Override
		public int getCount() {
			return _data.size();
		}
		
		@Override
		public HashMap<String, Object> getItem(int _index) {
			return _data.get(_index);
		}
		
		@Override
		public long getItemId(int _index) {
			return _index;
		}
		
		@Override
		public View getView(final int _position, View _v, ViewGroup _container) {
			LayoutInflater _inflater = getLayoutInflater();
			View _view = _v;
			if (_view == null) {
				_view = _inflater.inflate(R.layout.block, null);
			}
			
			final LinearLayout linear1 = _view.findViewById(R.id.linear1);
			final ImageView imageview1 = _view.findViewById(R.id.imageview1);
			final LinearLayout linear2 = _view.findViewById(R.id.linear2);
			final TextView textview1 = _view.findViewById(R.id.textview1);
			final TextView textview2 = _view.findViewById(R.id.textview2);
			final TextView textview3 = _view.findViewById(R.id.textview3);
			
			textview1.setText(listmap.get((int)_position).get("partname").toString());
			textview2.setText(listmap.get((int)_position).get("devname").toString());
			textview3.setText(listmap.get((int)_position).get("size").toString());
			if (running) {
				imageview1.setEnabled(false);
			}
			else {
				imageview1.setEnabled(true);
			}
			imageview1.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {
					if (listmap.get((int)_position).get("selection").toString().equals("true")) {
						listmap.get((int)_position).put("selection", "false");
						linear1.setBackgroundColor(0xFF151515);
						selectn--;
					}
					else {
						listmap.get((int)_position).put("selection", "true");
						linear1.setBackgroundColor(0xFF1A237E);
						selectn++;
					}
				}
			});
			if (listmap.get((int)_position).get("selection").toString().equals("true")) {
				linear1.setBackgroundColor(0xFF1A237E);
			}
			else {
				linear1.setBackgroundColor(0xFF151515);
			}
			
			return _view;
		}
	}
	
	public class Listview2Adapter extends BaseAdapter {
		
		ArrayList<HashMap<String, Object>> _data;
		
		public Listview2Adapter(ArrayList<HashMap<String, Object>> _arr) {
			_data = _arr;
		}
		
		@Override
		public int getCount() {
			return _data.size();
		}
		
		@Override
		public HashMap<String, Object> getItem(int _index) {
			return _data.get(_index);
		}
		
		@Override
		public long getItemId(int _index) {
			return _index;
		}
		
		@Override
		public View getView(final int _position, View _v, ViewGroup _container) {
			LayoutInflater _inflater = getLayoutInflater();
			View _view = _v;
			if (_view == null) {
				_view = _inflater.inflate(R.layout.block1, null);
			}
			
			final LinearLayout linear1 = _view.findViewById(R.id.linear1);
			final ImageView imageview1 = _view.findViewById(R.id.imageview1);
			final LinearLayout linear2 = _view.findViewById(R.id.linear2);
			final ImageView imageview2 = _view.findViewById(R.id.imageview2);
			final TextView textview1 = _view.findViewById(R.id.textview1);
			final TextView textview2 = _view.findViewById(R.id.textview2);
			final TextView textview3 = _view.findViewById(R.id.textview3);
			
			textview1.setText(listmap.get((int)_position).get("partname").toString());
			textview2.setText(listmap.get((int)_position).get("devname").toString());
			textview3.setText(listmap.get((int)_position).get("path").toString());
			if (running) {
				imageview1.setEnabled(false);
			}
			else {
				imageview1.setEnabled(true);
			}
			imageview1.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {
					if (!textview3.getText().toString().equals("")) {
						if (listmap.get((int)_position).get("selection1").toString().equals("true")) {
							listmap.get((int)_position).put("selection1", "false");
							selectn1--;
							if (listmap.get((int)_position).get("path").toString().equals("")) {
								linear1.setBackgroundColor(0xFF151515);
							}
							else {
								linear1.setBackgroundColor(0xFF202020);
							}
						}
						else {
							listmap.get((int)_position).put("selection1", "true");
							linear1.setBackgroundColor(0xFF1A237E);
							selectn1++;
						}
					}
					else {
						SketchwareUtil.showMessage(getApplicationContext(), "no file selected :/");
					}
				}
			});
			if (listmap.get((int)_position).get("selection1").toString().equals("true")) {
				linear1.setBackgroundColor(0xFF1A237E);
			}
			else {
				if (listmap.get((int)_position).get("path").toString().equals("")) {
					linear1.setBackgroundColor(0xFF151515);
				}
				else {
					linear1.setBackgroundColor(0xFF202020);
				}
			}
			imageview2.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {
					shared_perfernces.edit().putString("position", String.valueOf((long)(_position))).commit();
					startActivityForResult(file_picker, REQ_CD_FILE_PICKER);
				}
			});
			
			return _view;
		}
	}
}