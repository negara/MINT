package com.aziz.accessibilityEval;

import android.accounts.Account;
import android.content.Intent;
import android.database.SQLException;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.aziz.listener2.BuildConfig;
import com.aziz.listener2.R;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.api.client.googleapis.extensions.android.gms.auth.GoogleAccountCredential;
import com.google.api.client.util.ExponentialBackOff;
import com.google.api.services.sheets.v4.SheetsScopes;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    static final int REQUEST_AUTHORIZATION = 1001;
    private static final int REQUEST_ID = 1;
    public static final String[] SCOPES = {SheetsScopes.SPREADSHEETS};
    public static GoogleAccountCredential mCredential;
    private final String ACCOUNT_NANE = "aziznb890@gmail.com";
    private final String ACCOUNT_TYPE = BuildConfig.APPLICATION_ID;
    private final String LOG_TAG = "MainActivity";

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_main);
        ScreenshotManager.INSTANCE.requestScreenshotPermission(this, 1);
        Log.e("MainActivity", " Taking user's permission... ");
        if (ContextCompat.checkSelfPermission(this, "android.permission.INTERNET") != 0) {
            Log.e("MainActivity", " INTERNET permission is not available ");
        }
        if (ContextCompat.checkSelfPermission(this, "android.permission.GET_ACCOUNTS") != 0) {
            Log.e("MainActivity", " GET_ACCOUNTS permission is not available, requesting now... ");
            ActivityCompat.requestPermissions(this, new String[]{"android.permission.GET_ACCOUNTS"}, 1);
        }
        if (!isGooglePlayServicesAvailable()) {
            Log.e("SHEETS API", "No google API");
        } else {
            Log.e("SHEETS API", "google API is okay ");
        }
        mCredential = GoogleAccountCredential.usingOAuth2(getApplicationContext(), Arrays.asList(SCOPES)).setBackOff(new ExponentialBackOff());
        mCredential.setSelectedAccount(new Account("aziznb890@gmail.com", BuildConfig.APPLICATION_ID));
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1) {
            ScreenshotManager.INSTANCE.onActivityResult(resultCode, data);
            ScreenshotManager.INSTANCE.prepMedia(getApplicationContext());
        }
    }

    public void onClickDeleteAllRecords(View view) {
        if (((EditText) findViewById(R.id.editTextPass)).getText().toString().equals("x1989")) {
            try {
                MyAppDbHelper.DeleteAllRecords(new MyAppDbHelper(this).getWritableDatabase());
                Toast.makeText(this, "Deleting all records...", 0).show();
            } catch (SQLException e) {
                Toast.makeText(this, "DB error...", 0).show();
            }
        }
    }

//    private boolean isGooglePlayServicesAvailable() {
//        return GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(this) == 0;
//    }
}