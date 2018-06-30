package com.charlesandkeith.charlesandkeithassingment.network;


import com.charlesandkeith.charlesandkeithassingment.Utils.CkConstants;
import com.charlesandkeith.charlesandkeithassingment.events.ApiErrorEvent;
import com.charlesandkeith.charlesandkeithassingment.events.SuccessGetCKEvent;
import com.charlesandkeith.charlesandkeithassingment.network.responses.GetCKResponse;


import org.greenrobot.eventbus.EventBus;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public class RetrofitDataAgentImpl implements CkDataAgent {

    private static RetrofitDataAgentImpl sObjInstance;

    private CkApi mTheApi;


    private RetrofitDataAgentImpl() {

        final OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(15, java.util.concurrent.TimeUnit.SECONDS)
                .writeTimeout(15, java.util.concurrent.TimeUnit.SECONDS)
                .readTimeout(15, java.util.concurrent.TimeUnit.SECONDS)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(CkConstants.API_BASE)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();

        mTheApi = retrofit.create(CkApi.class);
    }

    public static RetrofitDataAgentImpl getsObjInstance() {
        if (sObjInstance == null) {
            sObjInstance = new RetrofitDataAgentImpl();
        }
        return sObjInstance;
    }

    @Override
    public void loadCkList(int page, String accessToken) {

        Call<GetCKResponse> loadCkCall = mTheApi.loadCklist(accessToken, page);

        loadCkCall.enqueue(new Callback<GetCKResponse>() {
            @Override
            public void onResponse(Call<GetCKResponse> call, Response<GetCKResponse> response) {
                GetCKResponse ckResponse =  response.body();

                if(ckResponse != null && ckResponse.isResponseOK()){

                    SuccessGetCKEvent event = new SuccessGetCKEvent(ckResponse.getCkNewProduct());
                    EventBus.getDefault().post(event);
                } else {
                    if(ckResponse == null){
                        ApiErrorEvent event = new ApiErrorEvent("Empty response in network call");
                        EventBus.getDefault().post(event);
                    } else {
                        ApiErrorEvent event = new ApiErrorEvent(ckResponse.getMessage());
                        EventBus.getDefault().post(event);
                    }
                }

            }

            @Override
            public void onFailure(Call<GetCKResponse> call, Throwable t) {
                ApiErrorEvent event = new ApiErrorEvent(t.getMessage());
                EventBus.getDefault().post(event);

            }
        });

    }
}