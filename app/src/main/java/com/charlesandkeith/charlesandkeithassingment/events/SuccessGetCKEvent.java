package com.charlesandkeith.charlesandkeithassingment.events;

import com.charlesandkeith.charlesandkeithassingment.data.vos.CkVO;


import java.util.List;

public class SuccessGetCKEvent {

    private List<CkVO> ckLists;

    public SuccessGetCKEvent(List<CkVO> ckLists) {
        this.ckLists = ckLists;
    }

    public List<CkVO> getCkList() {
        return ckLists;
    }
}
