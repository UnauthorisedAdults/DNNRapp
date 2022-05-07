package com.unauthorisedadults.dnnr.network;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface RecipeAPI {
    @Headers({"Accept: application/json"})
    @GET("rest/server.api")
    Call<RecipeResponse> getRecipe();

}
