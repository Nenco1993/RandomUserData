package com.example.neven.randomuserdata.adapters;

import android.content.Context;
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
import com.example.neven.randomuserdata.models.Result;

import java.util.List;

/**
 * Created by Neven on 8.4.2017..
 */
public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.MyViewHolder> {

    private List<Result> listResults;
    private Context context;

    public UsersAdapter(List<Result> listResults, Context context) {
        this.listResults = listResults;
        this.context = context;
    }

    class MyViewHolder extends RecyclerView.ViewHolder {


        @BindView(R.id.textView)
        TextView tvEmail;

        @BindView(R.id.ivLogo)
        ImageView ivLogo;


        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_user, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        Result singleResult = listResults.get(position);
        holder.tvEmail.setText(singleResult.getEmail());

        Glide
                .with(context)
                .load(singleResult.getPicture().getLarge())
                .placeholder(R.mipmap.ic_launcher)
                .crossFade()
                .into(holder.ivLogo);


    }

    @Override
    public int getItemCount() {
        return listResults.size();
    }
}
