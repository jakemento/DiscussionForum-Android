package com.epicodus.discussionforum.ui;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.epicodus.discussionforum.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MessageActivity extends AppCompatActivity {
    @Bind(R.id.messageEditText) EditText mMessageEditText;
    @Bind(R.id.authorEditText) EditText mAuthorEditText;
    @Bind(R.id.categoryEditText) EditText mCategoryEditText;
    @Bind(R.id.postMessageButton) Button mPostMessageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);
        ButterKnife.bind(this);

        mPostMessageButton.setOnClickListener(new View.OnClickListener(){
            @Override
                    public void onClick(View v) {
                String message = mMessageEditText.getText().toString();
                String author = mAuthorEditText.getText().toString();
                String category = mCategoryEditText.getText().toString();
                Intent intent = new Intent(MessageActivity.this, MessagesListActivity.class);
                intent.putExtra("message", message);
                intent.putExtra("author", author);
                intent.putExtra("category", category);
                startActivity(intent);
            }


        });
    }
}
