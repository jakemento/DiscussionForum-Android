package com.epicodus.discussionforum.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.epicodus.discussionforum.R;
import com.epicodus.discussionforum.models.Message;
import com.epicodus.discussionforum.ui.MessageDetailActivity;



import org.parceler.Parcels;
import org.w3c.dom.Text;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Guest on 5/3/16.
 */
public class MessageViewHolder extends RecyclerView.ViewHolder {
    @Bind(R.id.messageNameTextView) TextView mMessageNameTextView;
    @Bind(R.id.authorTextView) TextView mAuthorTextView;
    @Bind(R.id.categoryTextView) TextView mCategoryTextView;

    private Context mContext;
    private ArrayList<Message> mMessages = new ArrayList<>();

    public MessageViewHolder(View itemView, ArrayList<Message> messages) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        mContext = itemView.getContext();
        mMessages = messages;
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int itemPosition = getLayoutPosition();
                Intent intent = new Intent(mContext, MessageDetailActivity.class);
                intent.putExtra("position", itemPosition + "");
                intent.putExtra("messages", Parcels.wrap(mMessages));
                mContext.startActivity(intent);
            }
        });
    }
    public void bindMessage(Message message) {
        mMessageNameTextView.setText(message.getMessage());
        mAuthorTextView.setText(message.getAuthor());
        mCategoryTextView.setText(message.getCategory());
    }

}
