package com.example.franciscoandrade.okcupidchallenge.presentation;

import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.franciscoandrade.okcupidchallenge.R;
import com.example.franciscoandrade.okcupidchallenge.data.api.ClientService;
import com.example.franciscoandrade.okcupidchallenge.data.model.Match;
import com.example.franciscoandrade.okcupidchallenge.presentation.recyclerView.MatchListAdapter;
import com.example.franciscoandrade.okcupidchallenge.presentation.recyclerView.RecyclerViewClickListener;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Retrofit;

public class MatchActivity extends AppCompatActivity implements MatchContract.View {

    @BindView(R.id.match_rv)
    RecyclerView matchRv;
    MatchListAdapter matchListAdapter;
    private ArrayList<Match> tempList;
    RecyclerViewClickListener listener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match);
        ButterKnife.bind(this);
        ClientService clientService = new ClientService(getString(R.string.WW_Domain));
        MatchContract.Presenter presenter = new MatchPresenter(this, clientService, getResources());

        getRotation();
        getListener();

        matchListAdapter = new MatchListAdapter(listener);

        if(savedInstanceState!=null){
            tempList=(ArrayList<Match>) savedInstanceState.getSerializable("listBeforeRotation");
            matchListAdapter.updateData(tempList);

        }
        else {
            presenter.getMatchList();
        }

        matchRv.setAdapter(matchListAdapter);

    }

    private void getListener() {
        listener=new RecyclerViewClickListener() {
            @Override
            public void onClick(View view, int position) {
                if(!tempList.get(position).getLiked()){
                    view.setBackgroundColor(getResources().getColor(R.color.liked_color));
                    tempList.get(position).setLiked(true);
                }
                else {
                    view.setBackgroundColor(Color.WHITE);
                    tempList.get(position).setLiked(false);
                }
            }
        };

    }

        @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putSerializable("listBeforeRotation",  tempList);
        super.onSaveInstanceState(outState);
    }
    @Override
    public void setRecyclerView(List<Match> matchList) {
        matchListAdapter.updateData(matchList);
        tempList= new ArrayList<>();
        tempList.addAll(matchList);
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    public void getRotation() {
        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
            matchRv.setLayoutManager(new GridLayoutManager(this, 4));
        }
    }
}
