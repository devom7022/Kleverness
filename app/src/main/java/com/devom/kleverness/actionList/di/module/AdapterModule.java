package com.devom.kleverness.actionList.di.module;

import android.content.Context;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.request.RequestOptions;
import com.devom.kleverness.actionList.R;
import com.devom.kleverness.actionList.adapters.StudAdapter;
import com.devom.kleverness.actionList.di.scope.SessionScope;

import dagger.Module;
import dagger.Provides;

@Module
public class AdapterModule {
    @Provides
    @SessionScope
    RequestManager initGlide(Context context) {
        RequestOptions options = new RequestOptions()
                .placeholder(R.drawable.item_blank_state)
                .error(R.drawable.item_error_state);

        return Glide.with(context)
                .setDefaultRequestOptions(options);
    }

    @SessionScope
    @Provides
    StudAdapter provideCitizenAdapter(RequestManager requestManager) {
        return new StudAdapter(requestManager);
    }
}