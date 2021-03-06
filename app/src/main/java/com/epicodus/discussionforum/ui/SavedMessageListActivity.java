package com.epicodus.discussionforum.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.epicodus.discussionforum.Constants;
import com.epicodus.discussionforum.R;
import com.epicodus.discussionforum.adapters.FirebaseMessageListAdapter;
import com.epicodus.discussionforum.models.Message;
import com.firebase.client.Firebase;
import com.firebase.client.Query;

import butterknife.Bind;
import butterknife.ButterKnife;

public class SavedMessageListActivity extends AppCompatActivity {
    private Query mQuery;
    private Firebase mFirebaseMessagesRef;
    private FirebaseMessageListAdapter mAdapter;

    @Bind(R.id.recyclerView) RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);
        ButterKnife.bind(this);

        mFirebaseMessagesRef = new Firebase(Constants.FIREBASE_URL_MESSAGES);

        setUpFirebaseQuery();
        setUpRecyclerView();
    }

    private void setUpFirebaseQuery() {
        String message = mFirebaseMessagesRef.toString();
        mQuery = new Firebase(message);
    }

    private void setUpRecyclerView() {
        mAdapter = new FirebaseMessageListAdapter(mQuery, Message.class);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mAdapter);

    }
}
