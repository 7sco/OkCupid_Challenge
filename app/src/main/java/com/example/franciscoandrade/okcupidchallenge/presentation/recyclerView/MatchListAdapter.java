package com.example.franciscoandrade.okcupidchallenge.presentation.recyclerView;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.franciscoandrade.okcupidchallenge.R;
import com.example.franciscoandrade.okcupidchallenge.data.model.Match;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;
import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MatchListAdapter extends RecyclerView.Adapter<MatchListAdapter.MatchListViewHolder> {
    private List<Match> listMatch= new ArrayList<>();

    @NonNull
    @Override
    public MatchListAdapter.MatchListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View viewHolder = LayoutInflater.from(parent.getContext()).inflate(R.layout.match_viewholder, parent, false);
        return new MatchListAdapter.MatchListViewHolder(viewHolder);
    }

    @Override
    public void onBindViewHolder(@NonNull MatchListViewHolder holder, int position) {
        holder.bind(listMatch, position);
    }

    private int getPercentage(int match) {
        return match/100;
    }

    @Override
    public int getItemCount() {
        return listMatch.size();
    }

    public void addMatches(List<Match> listMatch) {
        this.listMatch.clear();
        this.listMatch.addAll(listMatch);
        notifyDataSetChanged();
    }

    public class MatchListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        @BindView(R.id.match_image)
        ImageView match_image;
        @BindView(R.id.match_username)
        TextView match_username;
        @BindView(R.id.match_age_location)
        TextView match_age_location;
        @BindView(R.id.match_percentage)
        TextView match_percentage;
        int position;

        public MatchListViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
        }


        public void bind(List<Match> listMatch, int position) {
            Match match= listMatch.get(position);
            this.position=position;
            String imageUrl = match.getPhoto().getThumbPaths().getLarge();
            String percentage = getPercentage(match.getMatch()) + " " + itemView.getResources().getString(R.string.percentage_itemView);
            String location = match.getCityName() + ", " + match.getStateCode();
            int age = match.getAge();
            String ageLocation = age + " \u2022 " + location;

            Picasso.get().load(imageUrl).
                    fit().
                    centerCrop().
                    //error(R.mipmap.).
                    into(match_image);
            match_percentage.setText(percentage);
            match_age_location.setText(ageLocation);
            match_username.setText(match.getUsername());

            if (match.getLiked()) {
                itemView.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.liked_color));
            } else {
                itemView.setBackgroundColor(Color.WHITE);
            }
        }

        @Override
        public void onClick(View v) {
            if (! listMatch.get(position).getLiked()){
                itemView.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.liked_color));
                listMatch.get(position).setLiked(true);
            }
            else {
                itemView.setBackgroundColor(Color.WHITE);
                listMatch.get(position).setLiked(false);
            }
        }
    }
}
