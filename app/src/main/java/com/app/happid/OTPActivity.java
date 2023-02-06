package com.app.happid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class OTPActivity extends AppCompatActivity {

    private String mobile;
    private TextView mobileTxt, submitTxtBtn, resendTxt;
    private EditText oneEdt, twoEdt, threeEdt, fourEdt;
    private ImageView editImg, backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp);
        initViews();
    }

    private void initViews() {

        mobile = getIntent().getStringExtra("mobile");

        mobileTxt = findViewById(R.id.mobileTxt);
        mobileTxt.setText(mobile);
        submitTxtBtn = findViewById(R.id.submitTxtBtn);
        resendTxt = findViewById(R.id.resendTxt);
        oneEdt = findViewById(R.id.oneEdt);
        twoEdt = findViewById(R.id.twoEdt);
        threeEdt = findViewById(R.id.threeEdt);
        fourEdt = findViewById(R.id.fourEdt);
        editImg = findViewById(R.id.editImg);
        backBtn = findViewById(R.id.backBtn);

        oneEdt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                twoEdt.requestFocus();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        twoEdt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                threeEdt.requestFocus();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        threeEdt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                fourEdt.requestFocus();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        submitTxtBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String one = oneEdt.getText().toString();
                String two = twoEdt.getText().toString();
                String three = threeEdt.getText().toString();
                String four = fourEdt.getText().toString();

                if (TextUtils.isEmpty(one)) {
                    Toast.makeText(OTPActivity.this, "Enter OTP", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(two)) {
                    Toast.makeText(OTPActivity.this, "Enter OTP", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(three)) {
                    Toast.makeText(OTPActivity.this, "Enter OTP", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(four)) {
                    Toast.makeText(OTPActivity.this, "Enter OTP", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(getApplicationContext(), ProfileActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });

        resendTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        editImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }
}