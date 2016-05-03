package com.epicodus.discussionforum.ui;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.epicodus.discussionforum.R;
import com.epicodus.discussionforum.adapters.MessagePagerAdapter;
import com.epicodus.discussionforum.models.Message;

import org.parceler.Parcels;

import java.lang.reflect.Array;
import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MessageDetailActivity extends AppCompatActivity {
    @Bind(R.id.viewPager) ViewPager mViewPager;
    private MessagePagerAdapter adapterViewPager;
    ArrayList<Message> mMessages = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_detail);
        ButterKnife.bind(this);
        mMessages = Parcels.unwrap(getIntent().getParcelableExtra("messages"));
        int startingPosition = Integer.parseInt(getIntent().getStringExtra("position"));
        adapterViewPager = new MessagePagerAdapter(getSupportFragmentManager(), mMessages);
        mViewPager.setAdapter(adapterViewPager);
        mViewPager.setCurrentItem(startingPosition);
    }
}
