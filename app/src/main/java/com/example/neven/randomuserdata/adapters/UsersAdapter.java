package com.example.neven.randomuserdata.adapters;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.bumptech.glide.Glide;
import com.example.neven.randomuserdata.R;


import java.util.List;

/**
 * Created by Neven on 8.4.2017..
 */
public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.MyViewHolder> {

    private List<Item> listItems;
    private Context context;

    public UsersAdapter(List<Item> listItems, Context context) {
        this.listItems = listItems;
        this.context = context;
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        @Nullable
        @BindView(R.id.tvHeader)
        TextView tvHeader;


        @Nullable
        @BindView(R.id.ivPersonPic)
        ImageView ivPersonPic;


        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view;

        if (viewType == 0) {

            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_header, parent, false);


        } else {

            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_child, parent, false);


        }


        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        if (isHeaderType(position)) {

            bindHeaderItem(holder, position);


        } else {

            bindChildItem(holder, position);


        }


    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    @Override
    public int getItemViewType(int position) {

        return listItems.get(position).getItemType() == Item.HEADER_ITEM_TYPE ? 0 : 1;

    }

    private void bindHeaderItem(MyViewHolder holder, int position) {

        holder.tvHeader.setText(listItems.get(position).getTitleOrPicURL());

    }

    private void bindChildItem(MyViewHolder holder, int position) {


        Glide
                .with(context)
                .load(listItems.get(position).getTitleOrPicURL())
                .placeholder(R.mipmap.ic_launcher)
                .crossFade()
                .into(holder.ivPersonPic);


    }

    public boolean isHeaderType(int position) {

        boolean value;

        if (listItems.get(position).getItemType() == Item.HEADER_ITEM_TYPE) {

            value = true;

        } else {

            value = false;
        }

        return value;


    }


}
