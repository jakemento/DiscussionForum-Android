package com.epicodus.discussionforum.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.epicodus.discussionforum.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MessagesListActivity extends AppCompatActivity {
    @Bind(R.id.messagesListView) ListView mMessagesListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_messages_list);
        ButterKnife.bind(this);

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, )
    }
}
