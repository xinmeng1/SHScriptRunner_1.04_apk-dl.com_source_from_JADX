package com.adamioan.scriptrunner;

import android.content.Context;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.google.android.gms.location.GeofenceStatusCodes;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.OutputStreamWriter;

public class Functions {
    public static int ConvertDipToPixels(int dips, Context context) {
        try {
            return (int) TypedValue.applyDimension(1, (float) dips, context.getResources().getDisplayMetrics());
        } catch (Exception e) {
            try {
                return (int) TypedValue.applyDimension(1, (float) dips, context.getResources().getDisplayMetrics());
            } catch (Exception e2) {
                return dips;
            }
        }
    }

    public static boolean WriteStringToFile(File file, String data) {
        Exception e;
        Throwable th;
        boolean everythingOK = true;
        OutputStreamWriter outputStreamWriter = null;
        try {
            OutputStreamWriter outputStreamWriter2 = new OutputStreamWriter(new FileOutputStream(file));
            try {
                outputStreamWriter2.write(data);
                if (outputStreamWriter2 != null) {
                    try {
                        outputStreamWriter2.close();
                        outputStreamWriter = outputStreamWriter2;
                    } catch (Exception e2) {
                        outputStreamWriter = outputStreamWriter2;
                    }
                }
            } catch (Exception e3) {
                e = e3;
                outputStreamWriter = outputStreamWriter2;
                try {
                    Log.e("WriteStringToFile", e.toString() + (e.getMessage() == null ? " " + e.getMessage().toString() : ""));
                    everythingOK = false;
                    if (outputStreamWriter != null) {
                        try {
                            outputStreamWriter.close();
                        } catch (Exception e4) {
                        }
                    }
                    return everythingOK;
                } catch (Throwable th2) {
                    th = th2;
                    if (outputStreamWriter != null) {
                        try {
                            outputStreamWriter.close();
                        } catch (Exception e5) {
                        }
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                outputStreamWriter = outputStreamWriter2;
                if (outputStreamWriter != null) {
                    outputStreamWriter.close();
                }
                throw th;
            }
        } catch (Exception e6) {
            e = e6;
            if (e.getMessage() == null) {
            }
            Log.e("WriteStringToFile", e.toString() + (e.getMessage() == null ? " " + e.getMessage().toString() : ""));
            everythingOK = false;
            if (outputStreamWriter != null) {
                outputStreamWriter.close();
            }
            return everythingOK;
        }
        return everythingOK;
    }

    public static String ReadFileContents(File file) {
        BufferedReader reader = null;
        try {
            StringBuffer fileData = new StringBuffer(GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE);
            BufferedReader reader2 = new BufferedReader(new FileReader(file));
            try {
                char[] buf = new char[AccessibilityNodeInfoCompat.ACTION_NEXT_HTML_ELEMENT];
                while (true) {
                    int numRead = reader2.read(buf);
                    if (numRead == -1) {
                        reader2.close();
                        reader = reader2;
                        return fileData.toString();
                    }
                    fileData.append(String.valueOf(buf, 0, numRead));
                    buf = new char[AccessibilityNodeInfoCompat.ACTION_NEXT_HTML_ELEMENT];
                }
            } catch (Exception e) {
                reader = reader2;
                if (reader != null) {
                    try {
                        reader.close();
                    } catch (Exception e2) {
                    }
                }
                return "";
            }
        } catch (Exception e3) {
            if (reader != null) {
                reader.close();
            }
            return "";
        }
    }

    public static void HideKeyboard(View view) {
        try {
            ((InputMethodManager) view.getContext().getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
        } catch (Exception e) {
            Log.e("HideKeyboard", e.toString() + (e.getMessage() != null ? " " + e.getMessage().toString() : ""));
        }
    }
}
