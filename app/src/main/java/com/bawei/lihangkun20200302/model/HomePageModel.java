package com.bawei.lihangkun20200302.model;

import com.bawei.lihangkun20200302.contral.IHomePageContral;
import com.bawei.lihangkun20200302.util.VolleyUtiles;

public class HomePageModel implements IHomePageContral.getModel {
    @Override
    public void getReJson(String json, final CallbackReJson callbackReJson) {
        VolleyUtiles.getInstance().getDoGet(json, new VolleyUtiles.CallBackJson() {
            @Override
            public void succ(String json) {
                callbackReJson.getReSuccess(json);
            }

            @Override
            public void faiuld(String json) {
                callbackReJson.getReFaiuld(json);
            }
        });
    }
}
