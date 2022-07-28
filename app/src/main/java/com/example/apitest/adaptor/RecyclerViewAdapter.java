package com.example.apitest.adaptor;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.apitest.PostPojo;
import com.example.apitest.R;

import java.util.List;

public class RecyclerViewAdapter  extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{

    private Context context;
    private List<PostPojo> postPojoList;

    public RecyclerViewAdapter(Context context, List<PostPojo> postPojoList) {
        this.context = context;
        this.postPojoList = postPojoList;
    }

    @NonNull
    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_data, parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.ViewHolder holder, int position) {
        PostPojo postPojo = postPojoList.get(position);
        holder.vTvTitle.setText(postPojo.getTitle());
        holder.vTvBody.setText(postPojo.getBody());

    }

    @Override
    public int getItemCount() {
        return postPojoList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView vTvTitle;
        public TextView vTvBody;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            vTvTitle = itemView.findViewById(R.id.tvTitle);
            vTvBody = itemView.findViewById(R.id.tvBody);
        }

        @Override
        public void onClick(View view) {
            Log.d("ClickFromViewHolder", "Clicked");
        }
    }
}
