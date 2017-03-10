package com.example.administrator.myeventbus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class MainActivity extends AppCompatActivity {
    TextView mTxt;
    Button mBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTxt= (TextView) findViewById(R.id.txt);
        mBtn= (Button) findViewById(R.id.btn_jump);
        EventBus.getDefault().register(this);
        mBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),SecondaryActivity.class);
            startActivity(intent);
            }
        });

    }
    @Subscribe(threadMode=ThreadMode.MAIN)
    public void threadMsg(MessageEvent messageEvent){
        String str=messageEvent.getMessge();
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
        mTxt.setText(str);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}