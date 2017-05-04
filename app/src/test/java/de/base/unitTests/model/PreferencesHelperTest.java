package de.base.unitTests.model;

/**
 * Created by Sebastian Müller on 28.01.2017.
 */

import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;

import java.util.List;

import de.base.BuildConfig;
import de.base.data.local.PreferencesHelper;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class)
public class PreferencesHelperTest {

    PreferencesHelper mPreferencesHelper;

    @Before
    public void setup(){
        mPreferencesHelper = new PreferencesHelper(new ObjectMapper(), RuntimeEnvironment.application.getApplicationContext());
    }

    @Test
    public void testGetBookedAppointmentsNotNull(){
        //when
//        List<AppointmentVO> list = mPreferencesHelper.getBookedAppointments();

        //then
//        assertThat(list, notNullValue());
//        assertThat(list.size(), is(0));
    }

    @Test
    public void testGetUnconfirmedAppointmentsNotNull(){
        //when
//        List<BookingVO> list = mPreferencesHelper.getUnconfirmedAppointments();

        //then
//        assertThat(list, notNullValue());
//        assertThat(list.size(), is(0));
    }

    @Test
    public void testGetProviderListNotNull(){
        //when
//        List<ProviderVO> list = mPreferencesHelper.getProviderList();

        //then
//        assertThat(list, notNullValue());
//        assertThat(list.size(), is(0));
    }

    @Test
    public void testGetCustomerListNotNull(){
        //when
//        List<CustomerVO> list = mPreferencesHelper.getCustomerList();

        //then
//        assertThat(list, notNullValue());
//        assertThat(list.size(), is(0));
    }

    @Test
    public void testGetRessourceListNotNull(){
        //when
//        List<ResourceVO> list = mPreferencesHelper.getResourceList();

        //then
//        assertThat(list, notNullValue());
//        assertThat(list.size(), is(0));
    }


}
