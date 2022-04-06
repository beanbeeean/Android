package com.example.myproduct.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.example.myproduct.R;
import com.example.myproduct.models.Product;

import java.util.ArrayList;

public class ProductListAdapter extends RecyclerView.Adapter<ProductListAdapter.ViewHolder> {

    ArrayList<Product> list;
    Context context;

    public ProductListAdapter(ArrayList<Product> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_product,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Product product = list.get(position);
        holder.productName.setText(product.getProductName());
        holder.sellInfo.setText(product.getSellInfo());
        holder.productPrice.setText(product.getProductPrice());
        holder.replyCount.setText(product.getReplyCount());
        holder.goodCount.setText(product.getGoodCount());

        Glide.with(context)
                .load(product.getProductImage())
                .centerCrop()
                .transform(new CenterCrop(), new RoundedCorners(30))
                .into(holder.productImageView);
    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView productImageView;
        TextView productName;
        TextView sellInfo;
        TextView productPrice;
        TextView replyCount;
        TextView goodCount;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            productImageView = itemView.findViewById(R.id.productImageView);
            productName = itemView.findViewById(R.id.productName);
            sellInfo = itemView.findViewById(R.id.sellInfo);
            productPrice = itemView.findViewById(R.id.productPrice);
            replyCount = itemView.findViewById(R.id.replyCount);
            goodCount = itemView.findViewById(R.id.goodCount);
        }
    }
}
