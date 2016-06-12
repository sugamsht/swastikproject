package com.sanjogstha.np.swastik1.api;

import com.sanjogstha.np.swastik1.model.Content;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Sugam on 6/4/2016.
 */
public interface ApiService {
    /*
   Retrofit get annotation with our URL
   And our method that will return us the List of ContactList
   */
    @GET("aef90a032d8a2765543065eaaa696cc2/raw/e57a8c199a60282c6407cb1fde523c563c6c79c3/swastik.json")
    Call<Content> getMyJSON();
}
