package com.example.franciscoandrade.okcupidchallenge.presentation;

import com.example.franciscoandrade.okcupidchallenge.data.model.Match;

import java.util.List;

public interface MatchContract {

    interface View{
        void setRecyclerView(List<Match> matchList);
        void showMessage();
    }

    interface Presenter{
        void getMatchList();

    }
}
