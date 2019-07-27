package com.devom.kleverness.actionList.di.module;

import android.app.Application;
import android.content.Context;

import com.devom.kleverness.actionList.di.scope.ApplicationScope;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationContextModule {

    private Application application;

    public ApplicationContextModule(Application application) {
        this.application = application;
    }

    @Provides
    @ApplicationScope
    Application provideApplication() {
        return application;
    }

    @Provides
    @ApplicationScope
    Context provideApplicationContext() {
        return application.getApplicationContext();
    }
}
