package com.bawei.lihangkun20200302.contral;

import com.bawei.lihangkun20200302.base.BaseIvew;

public class IHomePageContral {
    public interface getView extends BaseIvew {
        void getReSuccess(String json);
        void getReFaiuld(String json);
    }
    public interface getPresenter{
        void getReJson(String json);
    }
    public interface getModel{
        void getReJson(String json,CallbackReJson callbackReJson);
        interface CallbackReJson{
            void getReSuccess(String json);
            void getReFaiuld(String json);
        }
    }
}
