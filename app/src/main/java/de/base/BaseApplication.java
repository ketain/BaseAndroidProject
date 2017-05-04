package de.base;

import android.app.Application;
import android.content.Context;

import de.base.injection.component.ApplicationComponent;
import de.base.injection.component.DaggerApplicationComponent;
import de.base.injection.module.ApplicationModule;

public class BaseApplication extends Application {

    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }

    public static ApplicationComponent getApplicationComponent(Context context){
        return ((BaseApplication)context.getApplicationContext()).applicationComponent;
    }
}
