package com.example.monkey.mobilefinal;

import android.app.ProgressDialog;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.animation.Animation;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.monkey.mobilefinal.adapter.ListViewAdapter;
import com.example.monkey.mobilefinal.adapter.ViewPagerAdapter;
import com.example.monkey.mobilefinal.audio.BaseAudioOb;
import com.example.monkey.mobilefinal.fragment.FirstFragment;
import com.example.monkey.mobilefinal.fragment.SecondFragment;
import com.example.monkey.mobilefinal.fragment.ThirdFragment;
import com.example.monkey.mobilefinal.view.Airport;
import com.example.monkey.mobilefinal.view.StoneMountian;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity implements AdapterView.OnItemClickListener{

    private ArrayList<String> listResult;

    @BindView(R.id.view_pager)
    ViewPager viewPager;

    @BindView(R.id.list_view)
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initial();

        listResult = new ArrayList<String>();
        createFakeResult();
        ListViewAdapter listViewAdapter = new ListViewAdapter(this, listResult);

        listView.setAdapter(listViewAdapter);
        listView.setOnItemClickListener(this);
        listView.invalidateViews();
    }

    private void initial(){
        ArrayList<View> viewList = new ArrayList<View>();
        viewList.add(new FirstFragment(this));
        viewList.add(new SecondFragment(this));
        viewList.add(new ThirdFragment(this));
        viewPager.setAdapter(new ViewPagerAdapter(viewList));
    }

    public void createFakeResult(){
        listResult.add("Atlanta");
        listResult.add("Stone Mountain");
        listResult.add("Local Music");
        listResult.add("Story");
        listResult.add("Airport");
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this, listResult.get(position) + " was clicked.", Toast.LENGTH_LONG).show();

        switch (position) {
            case 0:
                toActivity(PlayPagerActivity.class);
                break;
            case 1:
                toActivity(AnimationActivity.class);
                break;
            case 2:
                toActivity(PlayPagerActivity.class);
                break;
            case 3:
                toActivity(StoneMountian.class);
                break;
            case 4:
                toActivity(Airport.class);
                break;
            default:
                break;
        }

    }
}
