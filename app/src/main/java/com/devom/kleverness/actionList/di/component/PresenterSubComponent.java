package com.devom.kleverness.actionList.di.component;

import com.devom.kleverness.actionList.di.module.AdapterModule;
import com.devom.kleverness.actionList.di.module.PresenterModule;
import com.devom.kleverness.actionList.di.scope.SessionScope;
import com.devom.kleverness.actionList.ui.StudActivity;

import dagger.Subcomponent;

@SessionScope
@Subcomponent(modules = {PresenterModule.class, AdapterModule.class})
public interface PresenterSubComponent {
    void inject(StudActivity activity);
}
