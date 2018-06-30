package com.charlesandkeith.charlesandkeithassingment.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.charlesandkeith.charlesandkeithassingment.R;
import com.charlesandkeith.charlesandkeithassingment.data.models.CkModels;
import com.charlesandkeith.charlesandkeithassingment.data.vos.CkVO;

import butterknife.BindView;
import butterknife.ButterKnife;


public class CkDetailActivity extends BaseActivity {

    @BindView(R.id.tv_detail_item_name)
    TextView tvDetailItemName;

    @BindView(R.id.iv_detail_item)
    ImageView ivDetailItem;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_ck_detail);

        ButterKnife.bind(this,this);

        int productId = getIntent().getIntExtra("productId",1);

        CkVO talks = CkModels.getObjInstance().getCkListByProductId(productId);

        bindData(talks);

    }

    private void bindData(CkVO ckList){


        Glide.with(ivDetailItem.getContext())
                .load(ckList.getProductImage())
                .into(ivDetailItem);

        tvDetailItemName.setText(ckList.getProductTitle());

    }
}
