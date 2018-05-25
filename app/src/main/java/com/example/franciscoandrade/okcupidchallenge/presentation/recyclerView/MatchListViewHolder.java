package com.example.franciscoandrade.okcupidchallenge.presentation.recyclerView;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.franciscoandrade.okcupidchallenge.R;
import com.example.franciscoandrade.okcupidchallenge.data.model.Match;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MatchListViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.match_image)
    ImageView match_image;
    @BindView(R.id.match_username)
    TextView match_username;
    @BindView(R.id.match_age_location)
    TextView match_age_location;
    @BindView(R.id.match_percentage)
    TextView match_percentage;

    public MatchListViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void bind(Match match) {
        StringBuilder url= new StringBuilder(match.getPhoto().getThumbPaths().getLarge());
        StringBuilder location= new StringBuilder(match.getCityName()+", "+match.getStateCode());
        int age=match.getAge();
        StringBuilder ageLocation=new StringBuilder(age+" \u2022 "+location.toString());
        StringBuilder matchPercentage= new StringBuilder(getPercentage(match.getMatch())+itemView.getResources().getString(R.string.percentage_itemView));

        Picasso.get().load(url.toString()).fit().centerCrop().into(match_image);
        match_username.setText(match.getUsername());
        match_age_location.setText( ageLocation.toString());
        match_percentage.setText(matchPercentage);
    }

    private int getPercentage(int match) {
        return  match/100;
    }
}
