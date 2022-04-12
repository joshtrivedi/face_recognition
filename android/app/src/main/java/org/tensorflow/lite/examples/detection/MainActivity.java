package org.tensorflow.lite.examples.detection;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.google.android.material.button.MaterialButton;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    private static final int EXTERNAL_WRITE_STORAGE_CODE = 23;
    private static final int EXTERNAL_READ_STORAGE_CODE = 22;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView username = (TextView) findViewById(R.id.username);
        TextView password = (TextView) findViewById(R.id.password);

        Button loginbtn = (Button) findViewById(R.id.loginbtn);
        getOutputMediaFile();

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkReadAndWritePermissions();
                if (username.getText().toString().equals("admin") && password.getText().toString().equals("admin")) {
                    Toast.makeText(MainActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(MainActivity.this, DetectorActivity.class);
                    startActivity(i);
                } else {
                    Toast.makeText(MainActivity.this, "Login Failed", Toast.LENGTH_SHORT).show();
                }

//                if (pictureFile != null)
//                    Toast.makeText(MainActivity.this, "File created", Toast.LENGTH_SHORT).show();
//                else
//                    Toast.makeText(MainActivity.this, "File not created", Toast.LENGTH_SHORT).show();
            }
        });


    }

    private void checkReadAndWritePermissions() {
        if (ContextCompat.checkSelfPermission(
                this, Manifest.permission.WRITE_EXTERNAL_STORAGE) ==
                PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(MainActivity.this, "Permissions Found", Toast.LENGTH_SHORT).show();
            return;
        } else {
            Toast.makeText(MainActivity.this, "Permissions NOT Found", Toast.LENGTH_SHORT).show();
            ActivityCompat.requestPermissions(this, new String[]{
                    Manifest.permission.WRITE_EXTERNAL_STORAGE
            }, EXTERNAL_WRITE_STORAGE_CODE);
            return;
        }
    }
    private void getOutputMediaFile() {
        File mediaStorageDir = new File(Environment.getRootDirectory()
                + "/Android/data/"
                + "FaceDetection"
                + "/Files");

        // This location works best if you want the created images to be shared
        // between applications and persist after your app has been uninstalled.

        // Create the storage directory if it does not exist
        if (!mediaStorageDir.exists()) {
            if (!mediaStorageDir.mkdirs()) {
                mediaStorageDir.mkdirs();
                return;
            }
        }
        // Create a media file name
//        String timeStamp = new SimpleDateFormat("ddMMyyyy_HHmm").format(new Date());
//        File mediaFile;
//        String mImageName = "MI_" + timeStamp + ".jpg";
//        mediaFile = new File(mediaStorageDir.getPath() + File.separator + mImageName);
//
//        return mediaFile;
    }
}

















































































































































































































