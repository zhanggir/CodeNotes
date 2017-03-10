package com.example.administrator.scorellview_listview;

import android.os.Handler;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView mListView;
    private ArrayAdapter<String> adapter;
    private List<String> mDatas;
    private Button mBtn;
    private ProgressBar mPrb;
    private Handler mHandle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mHandle=new Handler();
        mListView= (ListView) this.findViewById(R.id.listview);
        mDatas=new ArrayList<>();
        adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,mDatas);
        for(int i=0;i<50;i++){
            mDatas.add("这是第"+(i+1)+"条数据");
        }
//手动添加更多数据
      //  addMore(mListView);

        mListView.setAdapter(adapter);
        mListView.setOnScrollListener(listener);
        //设置高度
       // setHight(mListView);

    }

    private void setHight(ListView mListView) {
        ListAdapter listAdapter=mListView.getAdapter();
        if(listAdapter==null){
            return;
        }
        int totalHeight=0;
       for (int i=0;i< listAdapter.getCount();i++){
           View listItem=listAdapter.getView(i,null,mListView);
           listItem.measure(0,0);
           totalHeight+=listItem.getMeasuredHeight();
       }
        int deviderSpec=mListView.getDividerHeight()*(listAdapter.getCount()-1);
 ViewGroup.LayoutParams params= mListView.getLayoutParams();
        params.height=totalHeight+deviderSpec;
        mListView.setLayoutParams(params);
    }
    public void addMore(ListView listView){
        View view= LayoutInflater.from(getApplicationContext()).inflate(R.layout.add_more,null);
     listView.addFooterView(view);
        mPrb= (ProgressBar) findViewById(R.id.prb);
        mBtn= (Button) findViewById(R.id.btn_addmore);
        mBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mBtn.setVisibility(View.GONE);
                mPrb.setVisibility(View.VISIBLE);
                mHandle.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        addDatas();
                        mBtn.setVisibility(View.VISIBLE);
                        mPrb.setVisibility(View.GONE);
                        adapter.notifyDataSetChanged();
                    }
                },1500);
            }
        });

    }
    public void addDatas(){
        for (int i=0;i<10;i++){
            mDatas.add("这是第"+(1+i)+"条新数据");
        }
    }
    private int visiblelastIndex;
    AbsListView.OnScrollListener listener=new AbsListView.OnScrollListener() {
        @Override
        public void onScrollStateChanged(AbsListView absListView, int scrollState) {
int lastIndex=adapter.getCount()-1;
            if(scrollState==SCROLL_STATE_IDLE&&lastIndex==visiblelastIndex){
                addDatas();
                adapter.notifyDataSetChanged();
            }
        }

        @Override
        public void onScroll(AbsListView absListView, int first, int showcount, int totalcount) {
visiblelastIndex=first+showcount-1;
        }
    };
}
