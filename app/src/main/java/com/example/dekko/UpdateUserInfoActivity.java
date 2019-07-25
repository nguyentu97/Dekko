package com.example.dekko;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;

public class UpdateUserInfoActivity extends AppCompatActivity {
    RelativeLayout rlAccept;
    Intent intent;
    EditText edtPhone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_user_info);
        init();
        getData();

    }

    private void getData() {
        intent = getIntent();
        String phone = intent.getStringExtra("phonenumber");
        edtPhone.setText(phone);


    }

    private void init() {
        rlAccept = findViewById(R.id.rl_Accept);
        edtPhone = findViewById(R.id.edt_phone);

        rlAccept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(UpdateUserInfoActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
