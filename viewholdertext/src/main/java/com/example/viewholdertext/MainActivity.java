package com.example.viewholdertext;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView mListView;
    private List<PersonInfo> mDatas;
    PersonInfo personInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mListView= (ListView) this.findViewById(R.id.lst);
//        for (int i=0;i<50;i++){
//
//        }
       personInfo=new PersonInfo(1,"zhaansan");

        init();
        MyAdapter adapter=new MyAdapter(this,mDatas);
        mListView.setAdapter(adapter);
    }
//初始化数据；
    private void init() {
        mDatas=new ArrayList<>();
        mDatas.add(personInfo);
    }
}
