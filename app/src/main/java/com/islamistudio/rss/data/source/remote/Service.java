package com.islamistudio.rss.data.source.remote;

import android.util.Log;

import com.islamistudio.rss.data.source.remote.response.RssResponse;
import com.islamistudio.rss.utils.Configure;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

public class Service {

    private final String TAG = Service.class.getSimpleName();

    public void getXML() {

        Retrofit retrofit = createRetrofit();
        if (retrofit != null) {
            Api api = retrofit.create(Api.class);
            Call<RssResponse> callXML = api.getSoccerXML();
            callXML.enqueue(new Callback<RssResponse>() {
                @Override
                public void onResponse(Call<RssResponse> call, Response<RssResponse> response) {
                    if (response.isSuccessful()) {
                        Log.d(TAG, "onResponse: " + response);
                    }
                }

                @Override
                public void onFailure(Call<RssResponse> call, Throwable t) {
                    Log.d(TAG, "onFailure: " + t.getMessage());
                }
            });
        }
    }

    private Retrofit createRetrofit() {

        try {
            HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
            logging.level(HttpLoggingInterceptor.Level.BODY);

            OkHttpClient client = new OkHttpClient().newBuilder()
                    .connectTimeout(10, TimeUnit.SECONDS)
                    .writeTimeout(10, TimeUnit.SECONDS)
                    .readTimeout(10, TimeUnit.SECONDS)
                    .addInterceptor(logging)
                    .build();

            return new Retrofit.Builder()
                    .baseUrl(Configure.BASE_URL)
                    .addConverterFactory(SimpleXmlConverterFactory.create())
                    .client(client)
                    .build();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
