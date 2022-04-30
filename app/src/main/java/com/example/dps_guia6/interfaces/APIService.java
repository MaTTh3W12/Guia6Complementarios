package com.example.dps_guia6.interfaces;

import com.example.dps_guia6.dto.Repository;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface APIService {

    @GET("users/{userName}/repos")
    Call<List<Repository>> getRepositories(@Path("userName") String userName);

}
