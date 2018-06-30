package com.charlesandkeith.charlesandkeithassingment.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toolbar;

import com.charlesandkeith.charlesandkeithassingment.R;
import com.charlesandkeith.charlesandkeithassingment.data.vos.CkVO;
import com.charlesandkeith.charlesandkeithassingment.delegates.CkDelegate;

/**
 * Created by einandartun on 6/30/18.
 */

//TODO

public class CkTwoItemsViewActivity extends BaseActivity implements CkDelegate{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.viewholder_twoviewitem);

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
    public void onTapItem(CkVO ckList) {

    }

    @Override
    public void onTapTwoViewItem() {


    }

    @Override
    public void onTapOneViewItem(){

    }
}
