package com.charlesandkeith.charlesandkeithassingment.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.charlesandkeith.charlesandkeithassingment.R;
import com.charlesandkeith.charlesandkeithassingment.data.vos.CkVO;
import com.charlesandkeith.charlesandkeithassingment.delegates.CkDelegate;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CkListsViewHolder extends RecyclerView.ViewHolder {

    private CkDelegate mckDelegate;

    private CkVO mckList;

    @BindView(R.id.iv_item_list)
    ImageView ivItemList;

    @BindView(R.id.tv_item_name)
    TextView tvItemName;

    public CkListsViewHolder(View itemView, CkDelegate ckDelegate) {
        super(itemView);
        ButterKnife.bind(this,itemView);
        mckDelegate = ckDelegate;

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mckDelegate.onTapItem(mckList);
            }
        });
    }

    public void setCkList(CkVO ckList){
        mckList = ckList;

        tvItemName.setText(ckList.getProductTitle());

        Glide.with(ivItemList.getContext())
                .load(ckList.getProductImage())
                .into(ivItemList);

    }
}
