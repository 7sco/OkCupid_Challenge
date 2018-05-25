package com.example.franciscoandrade.okcupidchallenge.presentation.recyclerView;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.franciscoandrade.okcupidchallenge.R;
import com.example.franciscoandrade.okcupidchallenge.data.model.Match;

import java.util.ArrayList;
import java.util.List;

public class MatchListAdapter extends RecyclerView.Adapter<MatchListViewHolder> {
    private List<Match> listMatch;

    public MatchListAdapter(@Nullable List<Match> listMatch) {
        this.listMatch= listMatch;
    }

    @NonNull
    @Override
    public MatchListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View viewHolder = LayoutInflater.from(parent.getContext()).inflate(R.layout.match_viewholder, parent, false);
        return new MatchListViewHolder(viewHolder);
    }

    @Override
    public void onBindViewHolder(@NonNull MatchListViewHolder holder, int position) {
        Match match = listMatch.get(position);
        holder.bind(match);
    }

    @Override
    public int getItemCount() {
        return listMatch.size();
    }
}
