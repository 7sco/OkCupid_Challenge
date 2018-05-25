package com.example.franciscoandrade.okcupidchallenge.presentation;

import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.util.Log;

import com.example.franciscoandrade.okcupidchallenge.R;
import com.example.franciscoandrade.okcupidchallenge.data.api.ClientService;
import com.example.franciscoandrade.okcupidchallenge.data.api.MatchApi;
import com.example.franciscoandrade.okcupidchallenge.data.model.MatchResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MatchPresenter implements MatchContract.Presenter {

    private static final String TAG= MatchPresenter.class.getSimpleName();
    private MatchContract.View viemImpl;
    private ClientService clientService;

    public MatchPresenter(@NonNull MatchContract.View viemImpl,
                          @NonNull ClientService clientService) {
        this.viemImpl = viemImpl;
        this.clientService = clientService;
    }

    @Override
    public void getMatchList() {
        MatchApi matchApi= clientService.getFoodApi();
        Call<MatchResponse> matchCall= matchApi.getFoodList();
        matchCall.enqueue(new Callback<MatchResponse>() {
            @Override
            public void onResponse(Call<MatchResponse> call, Response<MatchResponse> response) {
                viemImpl.setRecyclerView(response.body().getData());
            }

            @Override
            public void onFailure(Call<MatchResponse> call, Throwable t) {
                viemImpl.showMessage();
            }
        });
    }

}
