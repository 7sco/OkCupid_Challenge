package com.example.franciscoandrade.okcupidchallenge.presentation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import com.example.franciscoandrade.okcupidchallenge.R;
import com.example.franciscoandrade.okcupidchallenge.data.api.ClientService;
import com.example.franciscoandrade.okcupidchallenge.data.model.Match;
import com.example.franciscoandrade.okcupidchallenge.presentation.recyclerView.MatchListAdapter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Retrofit;

public class MatchActivity extends AppCompatActivity implements MatchContract.View {

    @BindView(R.id.match_rv)
    RecyclerView matchRv;

    private MatchListAdapter matchListAdapter;
    private MatchContract.Presenter presenter;
    ClientService clientService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match);
        ButterKnife.bind(this);
        clientService= new ClientService(getString(R.string.WW_Domain));
        presenter= new MatchPresenter(this, clientService, getResources());
        presenter.getMatchList();
        setRecycler();
    }

    private void setRecycler() {
    }

    @Override
    public void setRecyclerView(List<Match> matchList) {
        matchListAdapter = new MatchListAdapter(matchList);
        matchRv.setAdapter(matchListAdapter);
    }
}
