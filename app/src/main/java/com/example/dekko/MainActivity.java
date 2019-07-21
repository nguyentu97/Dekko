package com.example.dekko;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        Fragment fragment = new FragmentHome();
        fragmentTransaction.add(R.id.rl_fragment,fragment);
        fragmentTransaction.commit();


        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigaton);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                Fragment fragment = null;
                switch (menuItem.getItemId()){
                    case R.id.acc_home:
                        fragment = new FragmentHome();
                        Toast.makeText(MainActivity.this, "Trang chủ", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.acc_tich_diem:
                        Toast.makeText(MainActivity.this, "Tích điểm", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.acc_dung_diem:
                        Toast.makeText(MainActivity.this, "Dùng điểm", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.acc_notification:
                        Toast.makeText(MainActivity.this, "Thông báo", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.acc_user:
                        fragment = new FragmentUser();
                        Toast.makeText(MainActivity.this, "Tài khoản", Toast.LENGTH_SHORT).show();
                        break;
                }
                fragmentTransaction.replace(R.id.rl_fragment,fragment);
                fragmentTransaction.commit();
                return  true;
            }
        });
    }

}
