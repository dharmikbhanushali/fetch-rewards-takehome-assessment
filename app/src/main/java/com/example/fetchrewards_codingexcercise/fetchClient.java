package com.example.fetchrewards_codingexcercise;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
* Create a final variable for our target url(this is a base url)
* create retrofit instance
* create retrofit class to get the instance as a result, check whether the instance is empty
* convert json into gson objects to parse it in java*/
public class fetchClient {

    private static final String TARGET_URL = "https://fetch-hiring.s3.amazonaws.com/";

    private static Retrofit retrofit;

    public static Retrofit getRetrofitInstance() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(TARGET_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
