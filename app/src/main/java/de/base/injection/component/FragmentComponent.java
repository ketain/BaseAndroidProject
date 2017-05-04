package de.base.injection.component;

import dagger.Subcomponent;
import de.base.injection.module.FragmentModule;
import de.base.injection.scopes.PerFragment;

/**
 * Created by scorp on 15.02.2017.
 */
@PerFragment
@Subcomponent(modules = {FragmentModule.class})
public interface FragmentComponent {

}
