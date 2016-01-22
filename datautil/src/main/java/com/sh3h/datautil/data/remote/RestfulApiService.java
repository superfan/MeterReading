package com.sh3h.datautil.data.remote;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
//import com.sh3h.datautil.BuildConfig;
import com.sh3h.datautil.data.model.Ribot;

import java.util.List;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.logging.HttpLoggingInterceptor;
import com.squareup.otto.Bus;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.RxJavaCallAdapterFactory;
import retrofit.http.GET;
import rx.Observable;

public interface RestfulApiService {
    String ENDPOINT = "https://api.ribot.io/";

    @GET("ribots")
    Observable<List<Ribot>> getRibots();

    /******** Helper class that sets up a new services *******/
    class Factory {
        public static RestfulApiService newInstance(Bus bus, String baseUrl) {
            OkHttpClient okHttpClient = new OkHttpClient();
            okHttpClient.interceptors().add(new UnauthorisedInterceptor(bus));
            HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
            logging.setLevel(true ? HttpLoggingInterceptor.Level.BODY
                    : HttpLoggingInterceptor.Level.NONE); // BuildConfig.DEBUG
            okHttpClient.interceptors().add(logging);

            Gson gson = new GsonBuilder()
                    .setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
                    .create();
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .client(okHttpClient)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .build();
            return retrofit.create(RestfulApiService.class);
        }
    }
}
