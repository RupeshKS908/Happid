package com.app.happid;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private TextView getStartedTxtBtn;
    private EditText mobileNoEdt;
    private ImageView backBtn;
    private EditText oneEdtTxt, twoEdtTxt, threeEdtTxt, fourEdtTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initViews();
    }

    private void initViews() {

        getStartedTxtBtn = findViewById(R.id.getStartedTxtBtn);
        mobileNoEdt = findViewById(R.id.mobileNoEdt);
        backBtn = findViewById(R.id.backBtn);

        getStartedTxtBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String mobile = mobileNoEdt.getText().toString();

                if (TextUtils.isEmpty(mobile) && mobile.length() > 9 && mobile.length() <= 10) {
                    Toast.makeText(LoginActivity.this, "Enter Valid Mobile Number.", Toast.LENGTH_SHORT).show();
                } else {
                    /*Intent intent = new Intent(getApplicationContext(), OTPActivity.class);
                    intent.putExtra("mobile", mobile);
                    startActivity(intent);
                    finish();*/
                    AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
                    LayoutInflater inflater = getLayoutInflater();
                    View view = inflater.inflate(R.layout.layout_otp, null);
                    oneEdtTxt = view.findViewById(com.app.happid.R.id.oneEdtTxt);
                    oneEdtTxt.requestFocus();
                    oneEdtTxt.addTextChangedListener(new TextWatcher() {
                        @Override
                        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                        }

                        @Override
                        public void onTextChanged(CharSequence s, int start, int before, int count) {
                            twoEdtTxt.requestFocus();
                        }

                        @Override
                        public void afterTextChanged(Editable s) {

                        }
                    });
                    twoEdtTxt = view.findViewById(com.app.happid.R.id.twoEdtTxt);
                    twoEdtTxt.addTextChangedListener(new TextWatcher() {
                        @Override
                        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                        }

                        @Override
                        public void onTextChanged(CharSequence s, int start, int before, int count) {
                            threeEdtTxt.requestFocus();
                        }

                        @Override
                        public void afterTextChanged(Editable s) {

                        }
                    });
                    threeEdtTxt = view.findViewById(com.app.happid.R.id.threeEdtTxt);
                    threeEdtTxt.addTextChangedListener(new TextWatcher() {
                        @Override
                        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                        }

                        @Override
                        public void onTextChanged(CharSequence s, int start, int before, int count) {
                            fourEdtTxt.requestFocus();
                        }

                        @Override
                        public void afterTextChanged(Editable s) {

                        }
                    });
                    fourEdtTxt = view.findViewById(com.app.happid.R.id.fourEdtTxt);
                    fourEdtTxt.addTextChangedListener(new TextWatcher() {
                        @Override
                        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                        }

                        @Override
                        public void onTextChanged(CharSequence s, int start, int before, int count) {
                            String oneTxt = oneEdtTxt.getText().toString();
                            String twoTxt = twoEdtTxt.getText().toString();
                            String threeTxt = threeEdtTxt.getText().toString();
                            String fourTxt = fourEdtTxt.getText().toString();

                            if(TextUtils.isEmpty(oneTxt)){
                                Toast.makeText(LoginActivity.this, "Enter OTP", Toast.LENGTH_SHORT).show();
                            }
                            else if(TextUtils.isEmpty(twoTxt)){
                                Toast.makeText(LoginActivity.this, "Enter OTP", Toast.LENGTH_SHORT).show();
                            }
                            else if(TextUtils.isEmpty(threeTxt)){
                                Toast.makeText(LoginActivity.this, "Enter OTP", Toast.LENGTH_SHORT).show();
                            }
                            else if(TextUtils.isEmpty(fourTxt)){
                                Toast.makeText(LoginActivity.this, "Enter OTP", Toast.LENGTH_SHORT).show();
                            }
                            else {
                                Intent intent = new Intent(getApplicationContext(), OTPActivity.class);
                                startActivity(intent);
                                finish();
                            }
                        }

                        @Override
                        public void afterTextChanged(Editable s) {

                        }
                    });

                    builder.setView(view);
                    builder.create();
                    builder.show();
                }
            }
        });

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), IntroActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }
}