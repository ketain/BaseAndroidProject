package de.base.unitTests.model;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;

import java.util.ArrayList;

import de.base.BuildConfig;
import de.base.data.DataManager;
import de.base.data.IDataManager;
import de.base.data.local.MappingHelper;
import de.base.data.local.PreferencesHelper;
import de.base.data.remote.RetrofitHelper;
import de.base.utility.Connectivity;
import de.base.utility.eventbus.EventBus;

import static org.mockito.Mockito.when;

/**
 * Created by Sebastian Müller on 27.01.2017.
 */
@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class)
public class DataManagerOfflineTest {
    @Mock
    PreferencesHelper mPreferencesHelper;

    @Mock
    RetrofitHelper mRetrofitHelper;

    @Mock
    Connectivity mConnectivity;

    @Mock
    MappingHelper mMappingHelper;

    @Mock
    EventBus mEventBus;

    IDataManager dataManager;

    @Before
    public void setup() throws Exception {
        MockitoAnnotations.initMocks(this);

        dataManager = new DataManager(RuntimeEnvironment.application.getApplicationContext(), mPreferencesHelper, mRetrofitHelper, mMappingHelper, mEventBus, mConnectivity);
        when(mConnectivity.isConnected(RuntimeEnvironment.application.getApplicationContext())).thenReturn(false);
//        when(mPreferencesHelper.getUnconfirmedAppointments()).thenReturn(new ArrayList<>(10));
    }

    @Test
    public void testGetUnconfirmedAppointments(){
//        dataManager.getUnconfirmedAppointments().test()
//                .assertValue(value -> value.getCode() == 200 )
//                .assertValue(value -> value.getBody().size() == 0);

//        when(mPreferencesHelper.getUnconfirmedAppointments()).thenReturn(null);
//        dataManager.getUnconfirmedAppointments().test()
//                .assertValue(value -> value.getCode() == 400)
//                .assertValue(value -> value.getHttpMessage() !=null && !value.getHttpMessage().isEmpty());
    }

    @Test
    public void testGetBookedAppointments(){
//        dataManager.getBookedAppointments().test()
//                .assertValue(value -> value.getCode() == 200 )
//                .assertValue(value -> value.getBody().size() == 0);

//        when(mPreferencesHelper.getBookedAppointments()).thenReturn(null);
//        dataManager.getBookedAppointments().test()
//                .assertValue(value -> value.getCode() == 400)
//                .assertValue(value -> value.getHttpMessage() !=null && !value.getHttpMessage().isEmpty());
    }

    @Test
    public void testGetProviders(){
//        dataManager.getProviders().test()
//                .assertValue(value -> value.getCode() == 200 )
//                .assertValue(value -> value.getBody().size() == 0);

//        when(mPreferencesHelper.getProviderList()).thenReturn(null);
//        dataManager.getProviders().test()
//                .assertValue(value -> value.getCode() == 400)
//                .assertValue(value -> value.getHttpMessage() !=null && !value.getHttpMessage().isEmpty());
    }

    @Test
    public void testGetCustomers(){
//        dataManager.getProviderCustomers().test()
//                .assertValue(value -> value.getCode() == 200 )
//                .assertValue(value -> value.getBody().size() == 0);

//        when(mPreferencesHelper.getCustomerList()).thenReturn(null);
//        dataManager.getProviderCustomers().test()
//                .assertValue(value -> value.getCode() == 400)
//                .assertValue(value -> value.getHttpMessage() !=null && !value.getHttpMessage().isEmpty());
    }

    @Test
    public void testGetResources(){
//        dataManager.getProviderResources().test()
//                .assertValue(value -> value.getCode() == 200 )
//                .assertValue(value -> value.getBody().size() == 0);

//        when(mPreferencesHelper.getResourceList()).thenReturn(null);
//        dataManager.getProviderResources().test()
//                .assertValue(value -> value.getCode() == 400)
//                .assertValue(value -> value.getHttpMessage() !=null && !value.getHttpMessage().isEmpty());
    }


}
