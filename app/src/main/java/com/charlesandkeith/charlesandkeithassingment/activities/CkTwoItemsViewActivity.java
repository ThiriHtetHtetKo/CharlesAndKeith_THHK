package com.charlesandkeith.charlesandkeithassingment.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.charlesandkeith.charlesandkeithassingment.R;
import com.charlesandkeith.charlesandkeithassingment.adapters.CKListsAdapter;
import com.charlesandkeith.charlesandkeithassingment.data.models.CkModels;
import com.charlesandkeith.charlesandkeithassingment.data.vos.CkVO;
import com.charlesandkeith.charlesandkeithassingment.delegates.CkDelegate;

import butterknife.OnClick;

/**
 * Created by einandartun on 6/30/18.
 */

//TODO

public class CkTwoItemsViewActivity extends BaseActivity implements CkDelegate{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_twoviewitem);


    }


    @Override
    public void onTapItem(CkVO ckList) {

    }

    @Override
    public void onTapTwoViewItem() {


    }

    @Override
    public void onTapOneViewItem(){

    }
}
