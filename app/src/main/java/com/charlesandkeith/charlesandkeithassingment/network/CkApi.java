package com.charlesandkeith.charlesandkeithassingment.network;


import com.charlesandkeith.charlesandkeithassingment.Utils.CkConstants;
import com.charlesandkeith.charlesandkeithassingment.network.responses.GetCKResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface CkApi {

    @FormUrlEncoded
    @POST(CkConstants.GET_Ck)
    Call<GetCKResponse> loadCklist(
            @Field(CkConstants.PARAM_ACCESS_TOKEN) String accessToken,
            @Field(CkConstants.PARAM_PAGE) int page);

}
