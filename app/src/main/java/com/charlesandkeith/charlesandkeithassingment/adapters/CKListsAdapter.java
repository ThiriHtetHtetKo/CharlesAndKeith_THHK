package com.charlesandkeith.charlesandkeithassingment.adapters;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.charlesandkeith.charlesandkeithassingment.R;
import com.charlesandkeith.charlesandkeithassingment.data.vos.CkVO;
import com.charlesandkeith.charlesandkeithassingment.delegates.CkDelegate;
import com.charlesandkeith.charlesandkeithassingment.viewholders.CkListsViewHolder;

import java.util.ArrayList;
import java.util.List;

public class CKListsAdapter extends RecyclerView.Adapter<CkListsViewHolder> {

    private CkDelegate mckDelegate;

    private List<CkVO> mckList;

    public CKListsAdapter(CkDelegate ckDelegate){
        mckDelegate = ckDelegate;
        mckList = new ArrayList<>();

    }

    @NonNull
    @Override
    public CkListsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.viewholder_ck_lists, parent, false);

        return new CkListsViewHolder(view,mckDelegate);
    }

    @Override
    public void onBindViewHolder(CkListsViewHolder holder, int position) {
        holder.setCkList(mckList.get(position));
    }

    @Override
    public int getItemCount() {
        return mckList.size();

    }

    public void setMckList(List<CkVO> ckList){

        mckList = ckList;
        notifyDataSetChanged();
    }
}
