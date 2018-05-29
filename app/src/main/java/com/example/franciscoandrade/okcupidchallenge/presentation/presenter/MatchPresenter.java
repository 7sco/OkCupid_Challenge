package com.example.franciscoandrade.okcupidchallenge.presentation.presenter;

import android.support.annotation.NonNull;
import com.example.franciscoandrade.okcupidchallenge.data.api.ClientService;
import com.example.franciscoandrade.okcupidchallenge.data.api.MatchApi;
import com.example.franciscoandrade.okcupidchallenge.data.model.MatchResponse;
import com.example.franciscoandrade.okcupidchallenge.presentation.MatchContract;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MatchPresenter implements MatchContract.Presenter {

    private static final String TAG= MatchPresenter.class.getSimpleName();
    private MatchContract.View viewImpl;
    private ClientService clientService;

    public MatchPresenter(@NonNull MatchContract.View viemImpl,
                          @NonNull ClientService clientService) {
        this.viewImpl = viemImpl;
        this.clientService = clientService;
    }

    @Override
    public void getMatchList() {
        MatchApi matchApi= clientService.getMatchApi();
        Call<MatchResponse> matchCall= matchApi.getFoodList();
        matchCall.enqueue(new Callback<MatchResponse>() {
            @Override
            public void onResponse(Call<MatchResponse> call, Response<MatchResponse> response) {
                viewImpl.setRecyclerView(response.body().getData());
            }

            @Override
            public void onFailure(Call<MatchResponse> call, Throwable t) {
                viewImpl.showMessage();
            }
        });
    }
}
