package com.example.franciscoandrade.okcupidchallenge.presentation.recyclerView;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.franciscoandrade.okcupidchallenge.R;
import com.example.franciscoandrade.okcupidchallenge.data.model.Match;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class MatchListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private RecyclerViewClickListener mListener;
    private List<Match> listMatch= new ArrayList<>();
    private Context context;

    public MatchListAdapter(RecyclerViewClickListener listener) {
        mListener = listener;
    }

    public void updateData(List<Match> dataset) {
        listMatch.clear();
        listMatch.addAll(dataset);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MatchListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
         context = parent.getContext();
        View viewHolder = LayoutInflater.from(parent.getContext()).inflate(R.layout.match_viewholder, parent, false);
        return new MatchListViewHolder(viewHolder, mListener);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof MatchListViewHolder) {
            MatchListViewHolder rowHolder = (MatchListViewHolder) holder;
            String url=listMatch.get(position).getPhoto().getThumbPaths().getLarge();
            String location= listMatch.get(position).getCityName()+", "+listMatch.get(position).getStateCode();
            String matchPercentage= getPercentage(listMatch.get(position).getMatch())+context.getResources().getString(R.string.percentage_itemView);
            int age=listMatch.get(position).getAge();
            String ageLocation=age+" \u2022 "+location.toString();
            Picasso.get().load(url.toString()).fit().centerCrop().into(((MatchListViewHolder) holder).match_image);
            rowHolder.match_percentage.setText(matchPercentage);
            rowHolder.match_age_location.setText(ageLocation);
            rowHolder.match_username.setText(listMatch.get(position).getUsername());

            if(listMatch.get(position).getLiked()){
                holder.itemView.setBackgroundColor(context.getResources().getColor(R.color.liked_color));
            }
            else {
                holder.itemView.setBackgroundColor(Color.WHITE);
            }

        }
    }


    @Override
    public int getItemCount() {
        return listMatch.size();
    }

    private int getPercentage(int match) {
        return  match/100;
    }


}
