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
    private RecyclerViewClickListener mListener;

    public MatchListViewHolder(View itemView, RecyclerViewClickListener listener) {
        super(itemView);
        mListener=listener;
        ButterKnife.bind(this, itemView);
        itemView.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        mListener.onClick(v, getAdapterPosition());
    }
}
