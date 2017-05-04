package de.base.injection.component;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;

import javax.inject.Singleton;

import dagger.Component;
import de.base.data.IDataManager;
import de.base.injection.ApplicationContext;
import de.base.injection.module.ActivityModule;
import de.base.injection.module.ApplicationModule;

/**
 * Created by Sebastian Müller on 14.10.2016.
 */
@Singleton
@Component(modules = {ApplicationModule.class })
public interface ApplicationComponent {

    @ApplicationContext
    Context context();
    Application application();
    Resources resources();
    IDataManager dataManager();

    ActivityComponent activityComponent(ActivityModule activityModule);

}
