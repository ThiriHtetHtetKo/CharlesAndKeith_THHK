package com.charlesandkeith.charlesandkeithassingment.network.responses;

import com.charlesandkeith.charlesandkeithassingment.data.vos.CkVO;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetCKResponse {

    private int code;

    private String message;

    private String apiVersion;

    private String page;

    @SerializedName("newProducts")
    private List<CkVO> ck_newProduct;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public String getApiVersion() {
        return apiVersion;
    }

    public String getPage() {
        return page;
    }

    public List<CkVO> getCkNewProduct() {
        return ck_newProduct;
    }

    public boolean isResponseOK(){
        return (code == 200 && ck_newProduct!= null);

    }
}
