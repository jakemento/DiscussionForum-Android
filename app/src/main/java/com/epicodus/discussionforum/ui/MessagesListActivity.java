package com.epicodus.discussionforum.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.epicodus.discussionforum.R;
import com.epicodus.discussionforum.adapters.MessageListAdapter;
import com.epicodus.discussionforum.models.Message;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MessagesListActivity extends AppCompatActivity {
    public static final String TAG = MessagesListActivity.class.getSimpleName();
    @Bind(R.id.recyclerView)
    RecyclerView mRecyclerView;
    private MessageListAdapter mAdapter;

    public ArrayList<Message> mMessages = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_messages_list);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        String message = intent.getStringExtra("message");

        getMessages(message);
    }

    private void getMessages(String message) {
        mAdapter = new MessageListAdapter(getApplicationContext(), mMessages);
        mRecyclerView.setAdapter(mAdapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MessagesListActivity.this);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setHasFixedSize(true);
    }
}