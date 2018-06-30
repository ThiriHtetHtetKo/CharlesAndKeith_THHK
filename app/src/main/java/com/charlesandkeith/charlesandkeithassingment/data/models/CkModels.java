package com.charlesandkeith.charlesandkeithassingment.data.models;



import android.util.Log;

import com.charlesandkeith.charlesandkeithassingment.data.vos.CkVO;
import com.charlesandkeith.charlesandkeithassingment.events.SuccessGetCKEvent;
import com.charlesandkeith.charlesandkeithassingment.network.CkDataAgent;
import com.charlesandkeith.charlesandkeithassingment.network.RetrofitDataAgentImpl;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.HashMap;
import java.util.Map;

public class CkModels{

    private static CkModels objInstance;

    private static final String DUMMY_ACCESS_TOKEN = "b002c7e1a528b7cb460933fc2875e916";

    private CkDataAgent mDataAgent;

    private Map<Integer,CkVO> mCKlistMap;

    private CkModels(){
        mDataAgent = RetrofitDataAgentImpl.getsObjInstance();

        mCKlistMap = new HashMap<>();

        EventBus.getDefault().register(this);

    }

    public static CkModels getObjInstance(){

        if(objInstance==null){
            objInstance = new CkModels();

        }
        return objInstance;
    }

    public CkVO getCkListByProductId(int productId){
        return mCKlistMap.get(productId);

    }

    public void loadCkList(){
        mDataAgent.loadCkList(1, DUMMY_ACCESS_TOKEN);

    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public void onSuccessGetCK(SuccessGetCKEvent event){

        for(CkVO ckList:event.getCkList()){
            mCKlistMap.put(ckList.getProductId(),ckList);
        }
    }
}
