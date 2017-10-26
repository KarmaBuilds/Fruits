package com.codetest.karma.myapplication;

import android.app.Application;

import com.codetest.karma.myapplication.di.components.AppComponent;
import com.codetest.karma.myapplication.di.components.DaggerActivityDetailComponent;
import com.codetest.karma.myapplication.di.components.DaggerActivityMainComponent;
import com.codetest.karma.myapplication.di.components.DaggerAppComponent;
import com.codetest.karma.myapplication.di.components.DaggerDataComponent;
import com.codetest.karma.myapplication.di.components.DaggerPresenterComponent;
import com.codetest.karma.myapplication.di.components.DataComponent;
import com.codetest.karma.myapplication.di.components.PresenterComponent;
import com.codetest.karma.myapplication.di.modules.AppModule;
import com.codetest.karma.myapplication.views.BaseActivity;
import com.codetest.karma.myapplication.views.DetailActivity;
import com.codetest.karma.myapplication.views.MainActivity;

/**
 * Created by karma on 25/10/2017.
 */

public class TheApplication extends Application {
    private AppComponent appComponent;
    private DataComponent dataComponent;
    private PresenterComponent presenterComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        this.appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
        this.dataComponent = DaggerDataComponent.builder()
                .appComponent(appComponent)
                .build();
        this.presenterComponent = DaggerPresenterComponent.builder()
                .dataComponent(dataComponent)
                .build();
    }

    public void inject(BaseActivity activity) {
        if (activity instanceof MainActivity) {
            DaggerActivityMainComponent.builder()
                    .presenterComponent(presenterComponent)
                    .build().inject((MainActivity) activity);
            return;
        }

        if (activity instanceof DetailActivity) {
            DaggerActivityDetailComponent.builder()
                    .presenterComponent(presenterComponent)
                    .build().inject((DetailActivity) activity);
            return;
        }
    }
}
