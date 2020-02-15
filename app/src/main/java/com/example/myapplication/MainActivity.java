package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button bt1,bt2,bt3;
    private FragmentManager fragmentManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt1=findViewById(R.id.first);
        bt2=findViewById(R.id.second);
        bt3=findViewById(R.id.third);
        bt1.setOnClickListener(this);
        bt2.setOnClickListener(this);
        bt3.setOnClickListener(this);
        fragmentManager=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        SecondFragment fragment=new SecondFragment();
        fragmentTransaction.add(R.id.container,fragment);
        fragmentTransaction.commit();
    }

    @Override
    public void onClick(View v) {
        Fragment fragment=null;
        switch (v.getId())
        {
            case R.id.first:
                fragment=new FirstFragment();
                break;
            case R.id.second:
                fragment=new SecondFragment();
                break;
            case R.id.third:
                fragment=new ThirdFragment();
                break;
        }
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container,fragment);
        fragmentTransaction.commit();
    }
}
