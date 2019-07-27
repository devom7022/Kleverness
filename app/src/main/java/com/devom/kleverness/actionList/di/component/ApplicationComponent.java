package com.devom.kleverness.actionList.di.component;

import com.devom.kleverness.actionList.di.module.ApplicationContextModule;
import com.devom.kleverness.actionList.di.module.PresenterModule;
import com.devom.kleverness.actionList.di.module.RetrofitModule;
import com.devom.kleverness.actionList.di.scope.ApplicationScope;

import dagger.Component;

@ApplicationScope
@Component(modules = {ApplicationContextModule.class, RetrofitModule.class})
public interface ApplicationComponent {

    PresenterSubComponent plusPresenterSubComponent(PresenterModule presenterModule);
}
