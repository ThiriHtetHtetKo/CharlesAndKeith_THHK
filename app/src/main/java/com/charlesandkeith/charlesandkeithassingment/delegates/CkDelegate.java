package com.charlesandkeith.charlesandkeithassingment.delegates;


import com.charlesandkeith.charlesandkeithassingment.data.vos.CkVO;

public interface CkDelegate {

    void onTapItem(CkVO ckList);

    void onTapTwoViewItem(); //TODO

    void onTapOneViewItem();
}
