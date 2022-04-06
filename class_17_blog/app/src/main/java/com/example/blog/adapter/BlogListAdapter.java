package com.example.blog.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.blog.R;
import com.example.blog.models.response.ResPost;

import java.util.ArrayList;
import java.util.List;

public class BlogListAdapter extends RecyclerView.Adapter<BlogListAdapter.ViewHolder>{

    private List<ResPost> list = new ArrayList<>();

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.item_blog_card,parent,false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ResPost resPost = list.get(position);
        // 이미지 그림을 그려야 함.
        holder.titleTextView.setText(resPost.title);
        holder.userNameTextView.setText(resPost.user.getUsername());
        holder.contentTextView.setText(resPost.content);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        View itemView;
        ImageView imageView;
        TextView titleTextView;
        TextView userNameTextView;
        TextView contentTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.itemView = itemView;
            imageView = itemView.findViewById(R.id.blogImageView);
            titleTextView = itemView.findViewById(R.id.blogTitleTextView);
            userNameTextView = itemView.findViewById(R.id.blogUserNameTextView);
            contentTextView = itemView.findViewById(R.id.blogContentTextView);
        }
    }
}
