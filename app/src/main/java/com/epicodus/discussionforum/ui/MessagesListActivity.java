package com.epicodus.discussionforum.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.epicodus.discussionforum.R;
import com.epicodus.discussionforum.models.Message;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MessagesListActivity extends AppCompatActivity {
    @Bind(R.id.messagesListView)
    ListView mMessagesListView;
    public ArrayList<Message> mMessages = new ArrayList<>();
    public static final String TAG = MessagesListActivity.class.getSimpleName();

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

        String[] messageNames = new String[mMessages.size()];
        for (int i = 0; i < messageNames.length; i++) {
            messageNames[i] = mMessages.get(i).getMessage();
        }
        ArrayAdapter adapter = new ArrayAdapter(MessagesListActivity.this, android.R.layout.simple_list_item_1, messageNames);
        mMessagesListView.setAdapter(adapter);

    }
}