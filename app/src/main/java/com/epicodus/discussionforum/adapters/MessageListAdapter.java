package com.epicodus.discussionforum.adapters;


import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.epicodus.discussionforum.R;
import com.epicodus.discussionforum.models.Message;
import com.epicodus.discussionforum.ui.MessageDetailActivity;
import com.firebase.client.core.Context;

import org.parceler.Parcels;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MessageListAdapter extends RecyclerView.Adapter<MessageViewHolder> {
    private ArrayList<Message> mMessages = new ArrayList<>();
    private Context mContext;

    public MessageListAdapter(Context context, ArrayList<Message> messages) {
        mContext = context;
        mMessages = messages;
    }

    @Override
    public MessageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.message_list_item, parent, false);

        MessageViewHolder viewHolder = new MessageViewHolder(view, mMessages);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MessageViewHolder holder, int position) {
        holder.bindMessage(mMessages.get(position));
    }

    @Override
    public int getItemCount() {

        return mMessages.size();
    }

}