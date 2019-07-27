package com.devom.kleverness.actionList.ui;

import com.devom.kleverness.actionList.model.StudResponse;

public interface StudView {
    void showProgress();

    void hideProgress();

    void setItemsOnAdapters(StudResponse citizens);

    void onFailure(String error);
}
