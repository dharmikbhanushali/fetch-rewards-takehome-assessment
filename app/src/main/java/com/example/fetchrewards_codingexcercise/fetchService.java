package com.example.fetchrewards_codingexcercise;
import retrofit2.Call;
import retrofit2.http.GET;

import java.util.List;

/**
* creating an interface to define API endpoint to retrieve a list of items in our use case
* creating a call object*/
public interface fetchService {
    @GET("hiring.json")
    Call<List<Item>> getItems();
}
