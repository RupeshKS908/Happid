package com.app.happid;

import android.Manifest;
import android.app.AlertDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;

public class ProfileActivity extends AppCompatActivity {

    private CircleImageView profileImg;
    private EditText firstNameTxt, lastNameTxt, phoneTxt, postCodeEdtTxt;
    private TextView submitTxtBtn;

    public static final int PERMISSION_REQUEST = 1234;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        check_permission();
        initView();
    }

    private void check_permission() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {
            requestCameraPermission();
        }
    }

    private void requestCameraPermission() {
        if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.CAMERA)) {
            ActivityCompat.requestPermissions(ProfileActivity.this, new String[]{Manifest.permission.CAMERA}, PERMISSION_REQUEST);
        } else {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, PERMISSION_REQUEST);
        }
    }

    private void initView() {

        firstNameTxt = findViewById(R.id.firstNameTxt);
        lastNameTxt = findViewById(R.id.lastNameTxt);
        phoneTxt = findViewById(R.id.phoneTxt);
        postCodeEdtTxt = findViewById(R.id.postCodeEdtTxt);
        submitTxtBtn = findViewById(R.id.submitTxtBtn);
        profileImg = findViewById(R.id.profileImg);

        profileImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(ProfileActivity.this);
                LayoutInflater inflater = getLayoutInflater();
                View view = inflater.inflate(R.layout.layout_choose_image, null);
                LinearLayout cameraLayout = view.findViewById(com.app.happid.R.id.cameraLayout);
                LinearLayout galleryLayout = view.findViewById(com.app.happid.R.id.galleryLayout);

                cameraLayout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                });

                galleryLayout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                });

                builder.setView(view);
                builder.create();
                builder.show();
            }
        });

        submitTxtBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }
}