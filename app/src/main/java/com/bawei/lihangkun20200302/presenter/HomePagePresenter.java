package com.bawei.lihangkun20200302.presenter;

import com.bawei.lihangkun20200302.base.BaseIvew;
import com.bawei.lihangkun20200302.base.BasePresenter;
import com.bawei.lihangkun20200302.contral.IHomePageContral;
import com.bawei.lihangkun20200302.model.HomePageModel;

public class HomePagePresenter extends BasePresenter implements IHomePageContral.getPresenter {
    HomePageModel model;
    public HomePagePresenter(BaseIvew baseIvew) {
        super(baseIvew);
    }

    @Override
    public void getReJson(String json) {
                model.getReJson(json, new IHomePageContral.getModel.CallbackReJson() {
                    @Override
                    public void getReSuccess(String json) {
                        BaseIvew view = getView();
                        if(view instanceof IHomePageContral.getView){
                            ((IHomePageContral.getView)view).getReSuccess(json);
                        }
                    }

                    @Override
                    public void getReFaiuld(String json) {
                        BaseIvew view = getView();
                        if(view instanceof IHomePageContral.getView){
                            ((IHomePageContral.getView)view).getReFaiuld(json);
                        }
                    }
                });
    }

    @Override
    protected void initModel() {
        model=new HomePageModel();
    }
}
