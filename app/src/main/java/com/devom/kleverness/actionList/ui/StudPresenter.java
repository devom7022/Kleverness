package com.devom.kleverness.actionList.ui;

import com.devom.kleverness.actionList.model.StudResponse;

public class StudPresenter implements StudInteractor.OnFinishedListener {
    private StudView view;
    private StudInteractor interactor;

    public StudPresenter(StudInteractor interactor) {
        this.interactor = interactor;
    }

    void setView(StudView view) {
        this.view = view;
    }

    void onDestroy() {
        view = null;
    }

    void getData() {
        if (view != null) {
            view.showProgress();
        }
        interactor.getDataRequest(this);
    }

    @Override
    public void onSuccess(StudResponse response) {
        if (view != null) {
            view.setItemsOnAdapters(response);
            view.hideProgress();
        }
    }

    @Override
    public void onFailure(String error) {
        if (view != null) {
            view.hideProgress();
            view.onFailure(error);
        }
    }
}
