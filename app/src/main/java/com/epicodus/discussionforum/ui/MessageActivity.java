package com.epicodus.discussionforum.ui;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.epicodus.discussionforum.Constants;
import com.epicodus.discussionforum.R;
import com.epicodus.discussionforum.models.Message;
import com.firebase.client.Firebase;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MessageActivity extends AppCompatActivity implements View.OnClickListener {
    @Bind(R.id.messageEditText) EditText mMessageEditText;
    @Bind(R.id.authorEditText) EditText mAuthorEditText;
    @Bind(R.id.categoryEditText) EditText mCategoryEditText;
    @Bind(R.id.postMessageButton) Button mPostMessageButton;
    @Bind(R.id.savedMessagesButton) Button mSavedMessagesButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);
        ButterKnife.bind(this);

        mPostMessageButton.setOnClickListener(this);
        mSavedMessagesButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == mPostMessageButton) {
            String message = mMessageEditText.getText().toString();
            String author = mAuthorEditText.getText().toString();
            String category = mCategoryEditText.getText().toString();
            saveMessagetoFirebase(message);
            Intent intent = new Intent(MessageActivity.this, MessagesListActivity.class);
            intent.putExtra("message", message);
            intent.putExtra("author", author);
            intent.putExtra("category", category);
            startActivity(intent);
        }

        if (v == mSavedMessagesButton) {
            Intent intent = new Intent(MessageActivity.this, SavedMessageListActivity.class);
            startActivity(intent);
        }
    }



    public void saveMessagetoFirebase(String message) {
        Firebase savedMessageRef = new Firebase(Constants.FIREBASE_URL_MESSAGES);
        savedMessageRef.push().setValue(message);
    }
}
