package com.adamioan.scriptrunner;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewCompat;
import android.text.Editable;
import android.text.TextUtils.TruncateAt;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import java.io.File;
import java.util.Arrays;
import java.util.Comparator;

public class FileActivity extends Activity {
    private static int CLICK_HEIGHT = 0;
    public static final int REQUEST_CODE = 1000;
    public static final int RESULT_CODE_LOAD = 1;
    public static final int RESULT_CODE_SAVE = 2;
    private static File selectedFile;
    private static File selectedFolder;
    private boolean loadMode;
    private EditText viewFilename;
    private EditText viewFilter;
    private LinearLayout viewList;

    /* renamed from: com.adamioan.scriptrunner.FileActivity.1 */
    class C01161 implements TextWatcher {
        C01161() {
        }

        public void onTextChanged(CharSequence s, int start, int before, int count) {
        }

        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        public void afterTextChanged(Editable s) {
            FileActivity.this.FilterFiles();
        }
    }

    /* renamed from: com.adamioan.scriptrunner.FileActivity.2 */
    class C01172 implements OnClickListener {
        C01172() {
        }

        public void onClick(View v) {
            FileActivity.this.viewFilter.setText("");
        }
    }

    /* renamed from: com.adamioan.scriptrunner.FileActivity.3 */
    class C01183 implements OnClickListener {
        C01183() {
        }

        public void onClick(View v) {
            if (FileActivity.selectedFolder != null && FileActivity.selectedFolder.getParent() != null && new File(FileActivity.selectedFolder.getParent()).exists()) {
                FileActivity.this.GetFolderContents(new File(FileActivity.selectedFolder.getParent()));
            }
        }
    }

    /* renamed from: com.adamioan.scriptrunner.FileActivity.4 */
    class C01194 implements OnClickListener {
        C01194() {
        }

        public void onClick(View v) {
            if (FileActivity.selectedFolder != null) {
                String typedName = FileActivity.this.viewFilename.getText().toString().trim();
                if (typedName.equals("")) {
                    Toast.makeText(FileActivity.this, C0127R.string.file_name_empty, 0).show();
                    FileActivity.this.viewFilename.requestFocus();
                } else if (typedName.equals(".") || typedName.equals("..") || typedName.contains("/") || typedName.contains("\\0")) {
                    Toast.makeText(FileActivity.this, C0127R.string.file_name_invalid, 0).show();
                    FileActivity.this.viewFilename.requestFocus();
                } else {
                    FileActivity.selectedFile = new File(FileActivity.selectedFolder + "/" + typedName);
                    Intent returnIntent = new Intent();
                    returnIntent.putExtra("file", FileActivity.selectedFile.toString());
                    FileActivity.this.setResult(FileActivity.RESULT_CODE_SAVE, returnIntent);
                    FileActivity.this.finish();
                }
            }
        }
    }

    /* renamed from: com.adamioan.scriptrunner.FileActivity.5 */
    class C01225 implements OnClickListener {
        private final /* synthetic */ File val$file;

        /* renamed from: com.adamioan.scriptrunner.FileActivity.5.1 */
        class C01201 implements DialogInterface.OnClickListener {
            private final /* synthetic */ File val$file;

            C01201(File file) {
                this.val$file = file;
            }

            public void onClick(DialogInterface dialog, int which) {
                FileActivity.selectedFile = this.val$file;
                dialog.dismiss();
                Intent returnIntent = new Intent();
                returnIntent.putExtra("file", this.val$file.toString());
                FileActivity.this.setResult(FileActivity.RESULT_CODE_LOAD, returnIntent);
                FileActivity.this.finish();
            }
        }

        /* renamed from: com.adamioan.scriptrunner.FileActivity.5.2 */
        class C01212 implements DialogInterface.OnClickListener {
            C01212() {
            }

            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        }

        C01225(File file) {
            this.val$file = file;
        }

        public void onClick(View v) {
            if (this.val$file.isDirectory()) {
                FileActivity.this.GetFolderContents(this.val$file);
            } else if (FileActivity.this.loadMode) {
                new Builder(FileActivity.this).setTitle(FileActivity.this.getTitle()).setMessage(FileActivity.this.getString(C0127R.string.file_load_conf).replace("###", this.val$file.getName())).setPositiveButton(C0127R.string.answer_yes, new C01201(this.val$file)).setNegativeButton(C0127R.string.answer_no, new C01212()).show();
            } else {
                FileActivity.this.viewFilename.setText(this.val$file.getName());
            }
        }
    }

    private static class FileComparator implements Comparator<File> {
        private FileComparator() {
        }

        public int compare(File f1, File f2) {
            int intDir1;
            int intDir2;
            if (f1.isDirectory()) {
                intDir1 = 0;
            } else {
                intDir1 = FileActivity.RESULT_CODE_LOAD;
            }
            if (f2.isDirectory()) {
                intDir2 = 0;
            } else {
                intDir2 = FileActivity.RESULT_CODE_LOAD;
            }
            return intDir1 != intDir2 ? intDir1 - intDir2 : f1.getName().compareToIgnoreCase(f2.getName());
        }
    }

    public FileActivity() {
        this.loadMode = false;
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(C0127R.layout.activity_file);
        if (getIntent() == null || getIntent().getExtras() == null) {
            finish();
            return;
        }
        this.loadMode = getIntent().getExtras().getBoolean("load");
        CLICK_HEIGHT = Functions.ConvertDipToPixels(40, this);
        ManageViews();
    }

    protected void onPause() {
        super.onPause();
        Functions.HideKeyboard(this.viewFilter);
    }

    private void ManageViews() {
        try {
            int i;
            if (selectedFile == null) {
                selectedFolder = new File(System.getenv("EXTERNAL_STORAGE"));
            } else if (selectedFile.exists() && selectedFile.isFile()) {
                selectedFolder = new File(selectedFile.getParent());
            }
            setTitle(this.loadMode ? C0127R.string.file_title_load : C0127R.string.file_title_save);
            this.viewFilter = (EditText) findViewById(C0127R.id.file_filter);
            this.viewList = (LinearLayout) findViewById(C0127R.id.file_list);
            this.viewFilename = (EditText) findViewById(C0127R.id.file_name);
            this.viewFilter.addTextChangedListener(new C01161());
            findViewById(C0127R.id.file_filter_container).setVisibility(this.loadMode ? 0 : 8);
            View findViewById = findViewById(C0127R.id.file_name_container);
            if (this.loadMode) {
                i = 8;
            } else {
                i = 0;
            }
            findViewById.setVisibility(i);
            findViewById(C0127R.id.file_filter_clear).setOnClickListener(new C01172());
            findViewById(C0127R.id.file_folder_up).setOnClickListener(new C01183());
            if (selectedFile != null) {
                this.viewFilename.setText(selectedFile.getName());
            }
            findViewById(C0127R.id.file_save).setOnClickListener(new C01194());
            GetFolderContents(selectedFolder);
        } catch (Exception e) {
            String str;
            String str2 = "ManageViews";
            StringBuilder stringBuilder = new StringBuilder(String.valueOf(e.toString()));
            if (e.getMessage() != null) {
                str = " " + e.getMessage().toString();
            } else {
                str = "";
            }
            Log.e(str2, stringBuilder.append(str).toString());
        }
    }

    private void FilterFiles() {
        try {
            String filter = this.viewFilter.getText().toString().toLowerCase();
            if (this.viewList.getChildCount() != 0) {
                LinearLayout viewContents = (LinearLayout) this.viewList.getChildAt(0);
                if (viewContents.getChildCount() != 0) {
                    for (int i = 0; i < viewContents.getChildCount(); i += RESULT_CODE_LOAD) {
                        View childAt = viewContents.getChildAt(i);
                        int i2 = (filter.equals("") || (viewContents.getChildAt(i).getTag() != null && viewContents.getChildAt(i).getTag().toString().contains(filter))) ? 0 : 8;
                        childAt.setVisibility(i2);
                    }
                }
            }
        } catch (Exception e) {
            Log.e("FilterFiles", e.toString() + (e.getMessage() != null ? " " + e.getMessage().toString() : ""));
        }
    }

    private void GetFolderContents(File folder) {
        try {
            selectedFolder = folder;
            Functions.HideKeyboard(this.viewFilter);
            TextView viewTitle = (TextView) findViewById(C0127R.id.file_current_folder);
            viewTitle.setText(folder.toString());
            viewTitle.setEllipsize(TruncateAt.START);
            viewTitle.setLines(RESULT_CODE_LOAD);
            String filter = this.viewFilter.getText().toString().toLowerCase();
            this.viewList.removeAllViews();
            LinearLayout viewContents = new LinearLayout(this);
            viewContents.setOrientation(RESULT_CODE_LOAD);
            File[] fileList = folder.listFiles();
            TextView viewText;
            if (fileList == null) {
                viewText = new TextView(this);
                viewContents.addView(viewText, new LayoutParams(-1, -2));
                viewText.setLines(RESULT_CODE_LOAD);
                viewText.setGravity(17);
                viewText.setText(C0127R.string.file_empty_folder);
                viewText.setTextColor(ViewCompat.MEASURED_STATE_MASK);
                viewText.setTag(null);
                viewText.setEllipsize(TruncateAt.END);
                viewText.setPadding(0, 30, 0, 0);
            } else {
                Arrays.sort(fileList, new FileComparator());
                int length = fileList.length;
                for (int i = 0; i < length; i += RESULT_CODE_LOAD) {
                    File file = fileList[i];
                    viewText = new TextView(this);
                    viewContents.addView(viewText, new LayoutParams(-1, -2));
                    viewText.setMinimumHeight(CLICK_HEIGHT);
                    viewText.setLines(RESULT_CODE_LOAD);
                    viewText.setGravity(19);
                    viewText.setText(file.getName());
                    viewText.setTextColor(ViewCompat.MEASURED_STATE_MASK);
                    viewText.setTag(file.getName().toLowerCase());
                    viewText.setEllipsize(TruncateAt.END);
                    viewText.setCompoundDrawablesWithIntrinsicBounds(file.isDirectory() ? C0127R.drawable.icon_folder : C0127R.drawable.icon_file, 0, 0, 0);
                    viewText.setCompoundDrawablePadding(5);
                    int i2 = (filter.equals("") || file.getName().toLowerCase().contains(filter)) ? 0 : 8;
                    viewText.setVisibility(i2);
                    viewText.setOnClickListener(new C01225(file));
                }
            }
            this.viewList.addView(viewContents, new LayoutParams(-1, -2));
        } catch (Exception e) {
            Log.e("GetFolderContents", e.toString() + (e.getMessage() != null ? " " + e.getMessage().toString() : ""));
        }
    }
}
