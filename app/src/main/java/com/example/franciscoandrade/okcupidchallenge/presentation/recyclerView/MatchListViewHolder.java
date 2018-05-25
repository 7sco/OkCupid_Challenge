package com.example.franciscoandrade.okcupidchallenge.presentation.recyclerView;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.franciscoandrade.okcupidchallenge.R;
import com.example.franciscoandrade.okcupidchallenge.data.model.Match;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MatchListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    @BindView(R.id.match_image)
    ImageView match_image;
    @BindView(R.id.match_username)
    TextView match_username;
    @BindView(R.id.match_age_location)
    TextView match_age_location;
    @BindView(R.id.match_percentage)
    TextView match_percentage;
    private boolean likeState;


    public MatchListViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        itemView.setOnClickListener(this);
    }

    public void bind(Match match) {

        String url = match.getPhoto().getThumbPaths().getLarge();
        String percentage = getPercentage(match.getMatch()) + " " + itemView.getContext().getResources().getString(R.string.percentage_itemView);
        String location = match.getCityName() + ", " + match.getStateCode();
        int age = match.getAge();
        String ageLocation = age + " \u2022 " + location;
        likeState=match.getLiked();

        Picasso.get().load(url).fit().centerCrop().into(match_image);
        match_percentage.setText(percentage);
        match_age_location.setText(ageLocation);
        match_username.setText(match.getUsername());

        if (match.getLiked()) {
            itemView.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.liked_color));
        } else {
            itemView.setBackgroundColor(Color.WHITE);
        }

    }

    private int getPercentage(int match) {
        return match / 100;
    }


    @Override
    public void onClick(View v) {

        if (!likeState){
            itemView.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.liked_color));
            likeState=true;
        }
        else {
            itemView.setBackgroundColor(Color.WHITE);
            likeState=false;
        }
    }

}

