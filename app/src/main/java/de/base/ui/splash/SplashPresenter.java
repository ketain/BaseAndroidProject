package de.base.ui.splash;

import javax.inject.Inject;

import de.base.data.IDataManager;
import de.base.ui.base.BasePresenter;
import de.base.utility.customized_classes.CheckableCookieJar;


/**
 * Created by Sebastian Müller on 03.01.2017.
 */

public class SplashPresenter extends BasePresenter<SplashMvpView> {

    private final IDataManager mDataManager;
    private final CheckableCookieJar mCookieJar;

    @Inject
    SplashPresenter(IDataManager dataManager, CheckableCookieJar cookieJar) {
        mDataManager = dataManager;
        mCookieJar = cookieJar;
    }

    boolean isSessionCookieExpired(){
        return mCookieJar.isSessionCookieExpired();
    }

    void clearAllCookies(){
        getMvpView().displayToast("All cookies cleared.");
        mDataManager.invalidateAllCookies();
    }


    boolean isConnected(){
        return mDataManager.isConnected();
    }
}
