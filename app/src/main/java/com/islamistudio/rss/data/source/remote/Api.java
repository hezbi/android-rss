package com.islamistudio.rss.data.source.remote;

import com.islamistudio.rss.data.source.remote.response.RssResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {

    @GET("sepakbola")
    Call<RssResponse> getSoccerXML();

}
