package com.example.binner;

import android.media.Image;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ViewPager mViewPager;
    private List<ImageView> imageViews;
    private List<View> dots;
    private TextView textView;
    private String[] titles={"张三","李四","王五","赵六","臧克家"};
    private int[] imageIds={R.drawable.aaa,R.drawable.bb,R.drawable.cc,R.drawable.dd,R.drawable.ee};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mViewPager= (ViewPager) this.findViewById(R.id.viewpager);
        textView= (TextView) this.findViewById(R.id.txt_picture_descript);

        textView.setText(titles[0]);
        imageViews=new ArrayList<>();
        for (int i=0;i<imageIds.length;i++){
            ImageView imageView=new ImageView(this);
            imageView.setBackgroundResource(imageIds[i]);
            imageViews.add(imageView);
        }
        dots=new ArrayList<>();
        dots.add(findViewById(R.id.view_0));
        dots.add(findViewById(R.id.view_1));
        dots.add(findViewById(R.id.view_2));
        dots.add(findViewById(R.id.view_3));
        dots.add(findViewById(R.id.view_4));
    }
}
