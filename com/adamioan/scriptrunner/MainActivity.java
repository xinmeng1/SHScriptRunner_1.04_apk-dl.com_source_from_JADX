package com.adamioan.scriptrunner;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.support.v7.app.ActionBarActivity;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.ads.AdRequest.Builder;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.location.GeofenceStatusCodes;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

@SuppressLint({"InflateParams"})
public class MainActivity extends ActionBarActivity {
    private static final String SP_SETTINGS = "settings";
    private AdView adView;
    private long lastBackPressTime;
    private boolean locked;
    private final Runtime runtime;
    private boolean suMode;
    private View viewBase;
    private View viewProgressContainer;
    private View viewResultContainer;
    private EditText viewScript;

    /* renamed from: com.adamioan.scriptrunner.MainActivity.1 */
    class C01231 implements OnClickListener {
        C01231() {
        }

        public void onClick(View v) {
            MainActivity.this.LockUnlockControls(false);
            try {
                MainActivity.this.viewResultContainer.setVisibility(8);
            } catch (Exception e) {
            }
        }
    }

    /* renamed from: com.adamioan.scriptrunner.MainActivity.2 */
    class C01252 implements Runnable {
        private final /* synthetic */ String val$command;

        /* renamed from: com.adamioan.scriptrunner.MainActivity.2.1 */
        class C01241 implements Runnable {
            private final /* synthetic */ StringBuffer val$sbError;
            private final /* synthetic */ StringBuffer val$sbOK;

            C01241(StringBuffer stringBuffer, StringBuffer stringBuffer2) {
                this.val$sbOK = stringBuffer;
                this.val$sbError = stringBuffer2;
            }

            public void run() {
                MainActivity.this.HideProgress();
                try {
                    ((TextView) MainActivity.this.findViewById(C0127R.id.main_result_ok)).setText(this.val$sbOK.toString());
                    ((TextView) MainActivity.this.findViewById(C0127R.id.main_result_error)).setText(this.val$sbError.toString());
                    MainActivity.this.viewResultContainer.setVisibility(0);
                } catch (Exception e) {
                }
            }
        }

        C01252(String str) {
            this.val$command = str;
        }

        public void run() {
            Exception e;
            try {
                Looper.prepare();
            } catch (Exception e2) {
            }
            StringBuffer sbOK = new StringBuffer();
            StringBuffer sbError = new StringBuffer();
            OutputStreamWriter osw = null;
            try {
                Process p;
                if (MainActivity.this.suMode) {
                    p = MainActivity.this.runtime.exec("su");
                } else {
                    File fileCommand = new File(MainActivity.this.getFilesDir() + "/command.sh");
                    Functions.WriteStringToFile(fileCommand, this.val$command + (this.val$command.endsWith("\n") ? "" : "\n"));
                    p = MainActivity.this.runtime.exec("chmod 755 " + fileCommand);
                    p = MainActivity.this.runtime.exec(fileCommand.toString());
                }
                OutputStreamWriter osw2 = new OutputStreamWriter(p.getOutputStream());
                try {
                    osw2.write(this.val$command + (this.val$command.endsWith("\n") ? "" : "\n"));
                    osw2.flush();
                    osw2.close();
                    p.waitFor();
                    BufferedReader bfOK = new BufferedReader(new InputStreamReader(p.getInputStream()));
                    String str = "";
                    while (true) {
                        str = bfOK.readLine();
                        if (str == null) {
                            break;
                        }
                        sbOK.append(new StringBuilder(String.valueOf(str)).append("\n").toString());
                    }
                    BufferedReader bfError = new BufferedReader(new InputStreamReader(p.getErrorStream()));
                    String str2 = "";
                    while (true) {
                        str2 = bfError.readLine();
                        if (str2 == null) {
                            break;
                        }
                        sbError.append(new StringBuilder(String.valueOf(str2)).append("\n").toString());
                    }
                    osw = osw2;
                } catch (Exception e3) {
                    e = e3;
                    osw = osw2;
                }
            } catch (Exception e4) {
                e = e4;
                e.printStackTrace();
                if (osw != null) {
                    try {
                        osw.close();
                    } catch (Exception e5) {
                    }
                }
                MainActivity.this.viewBase.post(new C01241(sbOK, sbError));
            }
            if (osw != null) {
                osw.close();
            }
            try {
                MainActivity.this.viewBase.post(new C01241(sbOK, sbError));
            } catch (Exception e6) {
            }
        }
    }

    /* renamed from: com.adamioan.scriptrunner.MainActivity.3 */
    class C01263 implements OnClickListener {
        private final /* synthetic */ Dialog val$dialog;

        C01263(Dialog dialog) {
            this.val$dialog = dialog;
        }

        public void onClick(View v) {
            this.val$dialog.dismiss();
        }
    }

    public MainActivity() {
        this.suMode = false;
        this.locked = false;
        this.lastBackPressTime = 0;
        this.runtime = Runtime.getRuntime();
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) C0127R.layout.activity_main);
        ManageViews();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(C0127R.menu.main, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        boolean z = false;
        if (this.locked) {
            return super.onOptionsItemSelected(item);
        }
        Functions.HideKeyboard(this.viewScript);
        int id = item.getItemId();
        switch (id) {
            case C0127R.id.action_run:
                RunScript(this.viewScript.getText().toString());
                return true;
            case C0127R.id.action_su:
                boolean z2;
                if (this.suMode) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                this.suMode = z2;
                item.setIcon(this.suMode ? C0127R.drawable.action_su_on : C0127R.drawable.action_su);
                Toast.makeText(this, this.suMode ? C0127R.string.info_su_enabled : C0127R.string.info_su_disabled, 0).show();
                return true;
            case C0127R.id.action_load:
            case C0127R.id.action_save:
                Intent intentFile = new Intent(getApplicationContext(), FileActivity.class);
                String str = "load";
                if (id == C0127R.id.action_load) {
                    z = true;
                }
                intentFile.putExtra(str, z);
                startActivityForResult(intentFile, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE);
                return true;
            case C0127R.id.action_about:
                ShowAbout();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void onBackPressed() {
        if (!this.locked) {
            if (this.viewResultContainer != null && this.viewResultContainer.getVisibility() == 0) {
                try {
                    findViewById(C0127R.id.main_result_close).performClick();
                } catch (Exception e) {
                }
            } else if (System.currentTimeMillis() - this.lastBackPressTime > 2000) {
                Toast.makeText(this, getString(C0127R.string.main_back_to_close), 0).show();
                this.lastBackPressTime = System.currentTimeMillis();
            } else {
                super.onBackPressed();
            }
        }
    }

    protected void onPause() {
        this.adView.pause();
        Functions.HideKeyboard(this.viewScript);
        super.onPause();
    }

    protected void onResume() {
        super.onResume();
        this.adView.resume();
    }

    protected void onDestroy() {
        this.adView.destroy();
        super.onDestroy();
    }

    private void ManageViews() {
        try {
            this.viewBase = findViewById(C0127R.id.main_base);
            this.viewResultContainer = findViewById(C0127R.id.main_result_container);
            this.viewProgressContainer = findViewById(C0127R.id.main_progress_container);
            this.viewScript = (EditText) findViewById(C0127R.id.main_script);
            findViewById(C0127R.id.main_result_close).setOnClickListener(new C01231());
            InitializeAd();
            String strLast = getSharedPreferences(SP_SETTINGS, 0).getString("last", null);
            if (strLast != null) {
                LoadFile(new File(strLast));
            }
        } catch (Exception e) {
            Log.e("ManageViews", e.toString() + (e.getMessage() != null ? " " + e.getMessage().toString() : ""));
        }
    }

    private void InitializeAd() {
        this.adView = (AdView) findViewById(C0127R.id.adView);
        this.adView.loadAd(new Builder().addTestDevice("9F609BACDD68A302776CEAAD06BD3A6D").addTestDevice("94C4AA0676D75F803CAE8044F12BFF8E").build());
    }

    private void RunScript(String command) {
        ShowProgress();
        try {
            Looper.prepare();
        } catch (Exception e) {
        }
        new Thread(new C01252(command)).start();
    }

    private void ShowProgress() {
        LockUnlockControls(true);
        try {
            Functions.HideKeyboard(this.viewScript);
            View viewProgress = findViewById(C0127R.id.main_progress);
            RotateAnimation anim = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
            anim.setRepeatCount(-1);
            anim.setDuration(1000);
            this.viewProgressContainer.setVisibility(0);
            viewProgress.clearAnimation();
            viewProgress.setAnimation(anim);
        } catch (Exception e) {
            Log.e("ShowProgress", e.toString() + (e.getMessage() != null ? " " + e.getMessage().toString() : ""));
        }
    }

    private void HideProgress() {
        try {
            findViewById(C0127R.id.main_progress).clearAnimation();
            this.viewProgressContainer.setVisibility(8);
        } catch (Exception e) {
            Log.e("HideProgress", e.toString() + (e.getMessage() != null ? " " + e.getMessage().toString() : ""));
        }
    }

    private void LockUnlockControls(boolean lock) {
        try {
            this.locked = lock;
            this.viewScript.setEnabled(!this.locked);
        } catch (Exception e) {
            Log.e("LockControls", e.toString() + (e.getMessage() != null ? " " + e.getMessage().toString() : ""));
        }
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE) {
            File file = null;
            try {
                file = new File(data.getExtras().getString("file"));
            } catch (Exception e) {
            }
            if (file != null) {
                if (resultCode == 1) {
                    if (file.exists()) {
                        LoadFile(file);
                    } else {
                        return;
                    }
                } else if (resultCode == 2) {
                    try {
                        Functions.WriteStringToFile(file, this.viewScript.getText().toString());
                        Toast.makeText(this, C0127R.string.main_file_saved_successfully, 0).show();
                        getSharedPreferences(SP_SETTINGS, 0).edit().putString("last", file.toString()).commit();
                    } catch (Exception e2) {
                        Log.e("SaveScript", e2.toString() + (e2.getMessage() != null ? " " + e2.getMessage().toString() : ""));
                        Toast.makeText(this, getString(C0127R.string.main_file_save_error) + (e2.getMessage() != null ? "\n" + e2.getMessage().toString() : ""), 0).show();
                    }
                }
            } else {
                return;
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    private void LoadFile(File file) {
        try {
            if (file.exists() && file.isFile()) {
                try {
                    this.viewScript.setText(Functions.ReadFileContents(file));
                    Toast.makeText(this, C0127R.string.main_file_loaded_successfully, 0).show();
                    getSharedPreferences(SP_SETTINGS, 0).edit().putString("last", file.toString()).commit();
                    return;
                } catch (Exception e) {
                    Log.e("LoadScript", e.toString() + (e.getMessage() != null ? " " + e.getMessage().toString() : ""));
                    Toast.makeText(this, getString(C0127R.string.main_file_load_error) + (e.getMessage() != null ? "\n" + e.getMessage().toString() : ""), 0).show();
                    return;
                }
            }
            getSharedPreferences(SP_SETTINGS, 0).edit().remove("last").commit();
        } catch (Exception e2) {
            String str;
            String str2 = "LoadFile";
            StringBuilder stringBuilder = new StringBuilder(String.valueOf(e2.toString()));
            if (e2.getMessage() != null) {
                str = " " + e2.getMessage().toString();
            } else {
                str = "";
            }
            Log.e(str2, stringBuilder.append(str).toString());
        }
    }

    private void ShowAbout() {
        try {
            Dialog dialog = new Dialog(this, 16973840);
            LinearLayout viewDialog = (LinearLayout) ((LayoutInflater) getSystemService("layout_inflater")).inflate(C0127R.layout.dialog_about, null, false);
            ((TextView) viewDialog.findViewById(C0127R.id.about_version)).setText(getString(C0127R.string.app_name) + " v" + getPackageManager().getPackageInfo(getPackageName(), 0).versionName);
            TextView viewInfo = (TextView) viewDialog.findViewById(C0127R.id.about_info);
            viewInfo.setText(Html.fromHtml(getString(C0127R.string.about_email_caption) + " <a href=\"mailto:" + getString(C0127R.string.about_email_value) + "\"><font color=blue>" + getString(C0127R.string.about_email_value) + "</font></a><br>" + getString(C0127R.string.about_site_caption) + " <a href=\"" + getString(C0127R.string.about_site_value) + "\"><font color=blue>" + getString(C0127R.string.about_site_value) + "</font></a>"));
            viewInfo.setMovementMethod(LinkMovementMethod.getInstance());
            viewDialog.findViewById(C0127R.id.about_close).setOnClickListener(new C01263(dialog));
            View viewGear = viewDialog.findViewById(C0127R.id.about_gear);
            RotateAnimation anim = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
            anim.setInterpolator(new LinearInterpolator());
            anim.setRepeatCount(-1);
            anim.setDuration(10000);
            viewGear.setAnimation(anim);
            dialog.setContentView(viewDialog);
            dialog.setCancelable(true);
            dialog.show();
        } catch (Exception e) {
            Log.e("ShowAbout", e.toString() + (e.getMessage() != null ? " " + e.getMessage().toString() : ""));
        }
    }
}
