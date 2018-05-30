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
        holder.bind(listMatch.get(position), position);
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
        ImageView matchImage;
        @BindView(R.id.match_username)
        TextView matchUsernameTV;
        @BindView(R.id.match_age_location)
        TextView ageAndLocationTV;
        @BindView(R.id.match_percentage)
        TextView matchPercentageTV;
        private int position;

        public MatchListViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
        }


        public void bind(Match match, int position) {
            this.position=position;
            String imageUrl = match.getPhoto().getThumbPaths().getLarge();
            String matchPercentage = getPercentage(match.getMatch()) + itemView.getResources().getString(R.string.percentage_itemView);
            String matchLocation = match.getCityName() + ", " + match.getStateCode();
            int matchAge = match.getAge();
            String ageWithLocation = matchAge + " \u2022 " + matchLocation;

            Picasso.get().load(imageUrl).
                    fit().
                    centerCrop().
                    placeholder(R.drawable.ic_loading).
                    error(R.drawable.error_image).
                    into(matchImage);
            matchPercentageTV.setText(matchPercentage);
            ageAndLocationTV.setText(ageWithLocation);
            matchUsernameTV.setText(match.getUsername());

            if (match.getLiked()) {
                itemView.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.liked_color));
            } else {
                itemView.setBackgroundColor(Color.WHITE);
            }
        }

        private int getPercentage(int match) { return match/100; }

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
