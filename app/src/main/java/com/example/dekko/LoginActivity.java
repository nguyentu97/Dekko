package com.example.dekko;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    RelativeLayout rlLoginButton;
    EditText edtPhoneNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();
    }

    void init() {
        rlLoginButton = findViewById(R.id.rl_login_button);
        edtPhoneNumber = findViewById(R.id.edt_phone_number);
        edtPhoneNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phone = edtPhoneNumber.getText().toString();
                if (phone.length() > 9) {
                    Toast.makeText(LoginActivity.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(LoginActivity.this, UpdateUserInfoActivity.class);
                    intent.putExtra("phonenumber", phone);
                    setLogin();
                    startActivity(intent);
                } else {
                    Toast.makeText(LoginActivity.this, "Nhập sai! Mời nhập lại", Toast.LENGTH_SHORT).show();
                    edtPhoneNumber.setText("");
                }
            }
        });
    }

    private void setLogin() {
        SharedPreferences sharedPreferences = getSharedPreferences("dekko", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("isLogin", true);
        editor.apply();
    }

}
