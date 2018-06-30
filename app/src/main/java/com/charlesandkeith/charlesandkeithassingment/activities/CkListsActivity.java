package com.charlesandkeith.charlesandkeithassingment.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.charlesandkeith.charlesandkeithassingment.R;
import com.charlesandkeith.charlesandkeithassingment.adapters.CKListsAdapter;
import com.charlesandkeith.charlesandkeithassingment.data.models.CkModels;
import com.charlesandkeith.charlesandkeithassingment.data.vos.CkVO;
import com.charlesandkeith.charlesandkeithassingment.delegates.CkDelegate;
import com.charlesandkeith.charlesandkeithassingment.events.SuccessGetCKEvent;
import com.charlesandkeith.charlesandkeithassingment.viewholders.CkListsViewHolder;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class CkListsActivity extends BaseActivity implements CkDelegate {

    private CKListsAdapter mckListAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_ck_lists);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        RecyclerView rvCKLists = findViewById(R.id.rv_ckLists);
        mckListAdapter = new CKListsAdapter(this);
        rvCKLists.setAdapter(mckListAdapter);
        rvCKLists.setLayoutManager(new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false));

        CkModels.getObjInstance().loadCkList();

        final ImageView btnTwoItemView = findViewById(R.id.iv_two_item_view);
        btnTwoItemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Toast.makeText(view.getContext(), "Navigate to Register", Toast.LENGTH_SHORT).show();
                Snackbar.make(view, "Navigate to Register", Snackbar.LENGTH_INDEFINITE).show();

                Intent intent = new Intent(getApplicationContext(),CkTwoItemsViewActivity.class);
                startActivity(intent);

            }
        });

        final ImageView btnOneItemView = findViewById(R.id.iv_one_item_view);
        btnOneItemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Toast.makeText(view.getContext(), "Navigate to Register", Toast.LENGTH_SHORT).show();
                Snackbar.make(view, "Navigate to Register", Snackbar.LENGTH_INDEFINITE).show();

                Intent intent = new Intent(getApplicationContext(),CkListsActivity.class);
                startActivity(intent);

            }
        });


    }

    @Override
    protected void onStart(){
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onStop(){
        super.onStop();
        EventBus.getDefault().unregister(this);
    }


    @Override
    public void onTapItem(CkVO ckList) {

        Intent intent= new Intent(getApplicationContext(),CkDetailActivity.class);
        intent.putExtra("productId",ckList.getProductId());
        startActivity(intent);

    }

    //TODO
    public void onTapTwoViewItem(){
        Intent intent = new Intent(getApplicationContext(),CkTwoItemsViewActivity.class);
        startActivity(intent);
    }

    //TODO
    public void onTapOneViewItem(){
        Intent intent = new Intent(getApplicationContext(),CkListsViewHolder.class);
        startActivity(intent);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onSuccessGetCk(SuccessGetCKEvent event){
        Log.d("onSuccessGetCK","onSuccessGetCK : " + event.getCkList().size());
        mckListAdapter.setMckList(event.getCkList());
    }

}
