package com.devom.kleverness.actionList.api;

import com.devom.kleverness.actionList.model.StudResponse;

import retrofit2.Call;
import retrofit2.http.GET;

import static com.devom.kleverness.actionList.api.ApiConstants.DATA_GNOMES;

public interface ApiClient {
    @GET(DATA_GNOMES)
    Call<StudResponse> getDataGnomes();
}