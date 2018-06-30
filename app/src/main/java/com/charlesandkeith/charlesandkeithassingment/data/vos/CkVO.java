package com.charlesandkeith.charlesandkeithassingment.data.vos;

import com.google.gson.annotations.SerializedName;

/**
 * Created by einandartun on 6/29/18.
 */

public class CkVO {

    @SerializedName("product-id")
    private int productId;

    @SerializedName("product-image")
    private String productImage;

    @SerializedName("product-title")
    private String productTitle;

    public int getProductId() {
        return productId;
    }

    public String getProductImage() {
        return productImage;
    }

    public String getProductTitle() {
        return productTitle;
    }
}
