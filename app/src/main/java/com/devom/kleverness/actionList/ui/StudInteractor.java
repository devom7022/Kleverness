package com.devom.kleverness.actionList.ui;

import com.devom.kleverness.actionList.api.ApiClient;
import com.devom.kleverness.actionList.app.BaseApplication;
import com.devom.kleverness.actionList.model.StudResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StudInteractor {
    private static String TAG = StudInteractor.class.getSimpleName();
    private ApiClient apiClient;
    private StudResponse dataResponse;

    interface OnFinishedListener {
        void onFailure(String error);

        void onSuccess(StudResponse response);
    }

    public StudInteractor(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    void getDataRequest(final OnFinishedListener listener) {
        if (!BaseApplication.getConnectionToNetwork()) {
            listener.onFailure("Revise su conexión a internet");
        }
        Call<StudResponse> call = apiClient.getDataGnomes();
        call.enqueue(new Callback<StudResponse>() {
            @Override
            public void onResponse(Call<StudResponse> call, Response<StudResponse> response) {
                if (response.isSuccessful()) {
                    dataResponse = response.body();
                    if (dataResponse != null) {
                        listener.onSuccess(dataResponse);
                    }
                }
            }

            @Override
            public void onFailure(Call<StudResponse> call, Throwable t) {
                listener.onFailure("Intente más tarde");
            }
        });
    }
}
