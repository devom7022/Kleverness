package com.devom.kleverness.actionList.di.module;

import com.devom.kleverness.actionList.api.ApiClient;
import com.devom.kleverness.actionList.di.scope.SessionScope;
import com.devom.kleverness.actionList.ui.StudInteractor;
import com.devom.kleverness.actionList.ui.StudPresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class PresenterModule {
    @Provides
    @SessionScope
    StudInteractor providerCitizenInteractor(ApiClient apiClient) {
        return new StudInteractor(apiClient);
    }

    @Provides
    @SessionScope
    StudPresenter providesPresenterCitizen(StudInteractor interactor) {
        return new StudPresenter(interactor);
    }
}
