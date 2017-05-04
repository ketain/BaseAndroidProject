package de.base.injection.component;

import android.support.v4.app.FragmentManager;

import dagger.Subcomponent;
import de.base.injection.module.ActivityModule;
import de.base.injection.module.FragmentModule;
import de.base.injection.scopes.PerActivity;
import de.base.ui.splash.SplashActivity;

/**
 * Created by Sebastian Müller on 14.10.2016.
 */
@PerActivity
@Subcomponent(modules = {ActivityModule.class})
public interface ActivityComponent {
    void bind(SplashActivity splashActivity);

    FragmentComponent fragmentComponent(FragmentModule fragmentModule);

    FragmentManager fragmentManager();

}
