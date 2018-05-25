package com.example.franciscoandrade.okcupidchallenge.presentation;

import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.example.franciscoandrade.okcupidchallenge.R;
import com.example.franciscoandrade.okcupidchallenge.data.api.ClientService;
import com.example.franciscoandrade.okcupidchallenge.data.model.Match;
import com.example.franciscoandrade.okcupidchallenge.presentation.recyclerView.MatchListAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MatchActivity extends AppCompatActivity implements MatchContract.View {

    @BindView(R.id.match_rv)
    RecyclerView matchRv;
    private MatchListAdapter adapter = new MatchListAdapter();
    private ArrayList<Match> savedMatchList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match);
        ButterKnife.bind(this);
        ClientService clientService = new ClientService(getString(R.string.WW_Domain));
        MatchContract.Presenter presenter = new MatchPresenter(this, clientService);

        if(savedInstanceState!=null){
            savedMatchList=(ArrayList<Match>) savedInstanceState.getSerializable("listBeforeRotation");
            adapter.addMatches(savedMatchList);
            matchRv.setAdapter(adapter);
        }
        else {
            presenter.getMatchList();
        }

        getRotation();

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putSerializable("listBeforeRotation",  savedMatchList);
        super.onSaveInstanceState(outState);
    }
    @Override
    public void setRecyclerView(List<Match> matchList) {
        adapter.addMatches(matchList);
        savedMatchList= new ArrayList<>();
        savedMatchList.addAll(matchList);
        matchRv.setAdapter(adapter);
    }

    @Override
    public void showMessage() {
        String message=this.getString(R.string.error_no_internet);
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    public void getRotation() {
        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
            matchRv.setLayoutManager(new GridLayoutManager(this, 4));
        }
    }
}
