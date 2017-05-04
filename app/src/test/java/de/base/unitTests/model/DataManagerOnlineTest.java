package de.base.unitTests.model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;

import java.io.IOException;
import java.net.InetAddress;
import java.util.ArrayList;

import okhttp3.Headers;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import de.base.unitTests.utility.InstanceProvider;
import de.base.unitTests.utility.ResponseBodies;
import de.base.BuildConfig;
import de.base.data.DataManager;
import de.base.data.IDataManager;
import de.base.data.local.MappingHelper;
import de.base.data.local.PreferencesHelper;
import de.base.data.remote.RetrofitHelper;
import de.base.utility.Connectivity;
import de.base.utility.eventbus.EventBus;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


/**
 * Created by scorp on 24.01.2017.
 */
@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class)
public class DataManagerOnlineTest {

    private MockWebServer mockedServer;
    private RetrofitHelper retrofitHelper;
    @Mock PreferencesHelper mPreferencesHelper;
    @Mock Connectivity mConnectivity;
    private MappingHelper mMappingHelper;
    @Mock EventBus mEventBus;

    Headers mHeaders;

    int port = 10001;

    IDataManager dataManager;

    @Before
    public void setup() throws IOException {
        MockitoAnnotations.initMocks(this);
        mockedServer = new MockWebServer();

        retrofitHelper = new RetrofitHelper(
                InstanceProvider.provideRetrofitInstance("http://" + InetAddress.getLocalHost().getHostAddress() + ":" + port)
                ,InstanceProvider.provideCookieJar());

        mMappingHelper = new MappingHelper();
        dataManager = new DataManager(RuntimeEnvironment.application, mPreferencesHelper, retrofitHelper, mMappingHelper, mEventBus, mConnectivity);

        when(mConnectivity.isConnected(RuntimeEnvironment.application.getApplicationContext())).thenReturn(true);

        mHeaders = new Headers.Builder()
                .add("Set Cookie", "PLAY_SESSION=\"1d5f563cf8e35ba37904bd0e060542a3036781cf-securesocial.network=userpass&___AT=bf8b004d88ec6711d460afe501394c8dbd86a1a3&securesocial.user=muellers%40th-brandenburg.de&___TS=1485693132411\"" +
                        ";Expires=Mon, 29-Jan-2020 12:32:12 GMT" +
                        ";Path=/")
                .build();

//        when(mPreferencesHelper.getAuthUserUuid()).thenReturn("1234");
//
//        when(mPreferencesHelper.getChosenAppointmentObject()).thenReturn(mock(AppointmentVO.class));
//        when(mPreferencesHelper.getChosenAppointmentUuid()).thenReturn("1234");
//
//        when(mPreferencesHelper.getChosenCustomerObject()).thenReturn(mock(CustomerVO.class));
//        when(mPreferencesHelper.getChosenCustomerUuid()).thenReturn("1234");
//
//        when(mPreferencesHelper.getChosenProviderObject()).thenReturn(mock(ProviderVO.class));
//        when(mPreferencesHelper.getChosenProviderUuid()).thenReturn("1234");
//
//        when(mPreferencesHelper.getChosenResourceObject()).thenReturn(mock(ResourceVO.class));
//        when(mPreferencesHelper.getChosenResourceUuid()).thenReturn("1234");
//
//        when(mPreferencesHelper.getBookedAppointments()).thenReturn(new ArrayList<>(10));
//        when(mPreferencesHelper.getCustomerList()).thenReturn(new ArrayList<>(10));
//        when(mPreferencesHelper.getProviderList()).thenReturn(new ArrayList<>(10));
//        when(mPreferencesHelper.getResourceList()).thenReturn(new ArrayList<>(10));
    }


    @Test
    public void testAuthenticate() throws IOException {

        //given
        mockedServer.enqueue(new MockResponse().setResponseCode(200).setHeaders(mHeaders).setBody(""));
        mockedServer.enqueue(new MockResponse().setResponseCode(202).setHeaders(mHeaders).setBody(""));
        mockedServer.enqueue(new MockResponse().setResponseCode(301).setHeaders(mHeaders).setBody(""));
        mockedServer.enqueue(new MockResponse().setResponseCode(302).setHeaders(mHeaders).setBody(""));
        mockedServer.enqueue(new MockResponse().setResponseCode(200).setHeaders(mHeaders).setBody(ResponseBodies.jsonUserVO));
        mockedServer.enqueue(new MockResponse().setResponseCode(404).setHeaders(mHeaders).setBody(""));
        mockedServer.enqueue(new MockResponse().setResponseCode(402).setHeaders(mHeaders).setBody(""));
        mockedServer.enqueue(new MockResponse().setResponseCode(403).setHeaders(mHeaders).setBody(""));
        mockedServer.enqueue(new MockResponse().setResponseCode(500).setHeaders(mHeaders).setBody(""));
        mockedServer.enqueue(new MockResponse().setResponseCode(503).setHeaders(mHeaders).setBody(""));


        mockedServer.start(InetAddress.getLocalHost(), port);

        //then
//        dataManager.authenticate("mock", "mock").test()
//                .assertValue(value -> value.getCode() == 200)
//                .assertValue(value -> !value.getHttpMessage().isEmpty());
//
//        dataManager.authenticate("mock", "mock").test()
//                .assertValue(value -> value.getCode() == 202)
//                .assertValue(value -> !value.getHttpMessage().isEmpty());
//
//        dataManager.authenticate("mock", "mock").test()
//                .assertValue(value -> value.getCode() == 301)
//                .assertValue(value -> !value.getHttpMessage().isEmpty());
//
//        dataManager.authenticate("mock", "mock").test()
//                .assertValue(value -> value.getCode() == 200)
//                .assertValue(value -> value.getBody() != null);
//
//        dataManager.authenticate("mock", "mock").test()
//                .assertValue(value -> value.getCode() == 404)
//                .assertValue(value -> !value.getHttpMessage().isEmpty());
//
//        dataManager.authenticate("mock", "mock").test()
//                .assertValue(value -> value.getCode() == 402)
//                .assertValue(value -> !value.getHttpMessage().isEmpty());
//
//        dataManager.authenticate("mock", "mock").test()
//                .assertValue(value -> value.getCode() == 403)
//                .assertValue(value -> !value.getHttpMessage().isEmpty());
//
//        dataManager.authenticate("mock", "mock").test()
//                .assertValue(value -> value.getCode() == 500)
//                .assertValue(value -> !value.getHttpMessage().isEmpty());
//
//        dataManager.authenticate("mock", "mock").test()
//                .assertValue(value -> value.getCode() == 503)
//                .assertValue(value -> !value.getHttpMessage().isEmpty());
    }

    @Test
    public void testGetUnconfirmedAppointmentsConnection() throws IOException {

        //when
        mockedServer.enqueue(new MockResponse().setResponseCode(200).setHeaders(mHeaders).setBody(ResponseBodies.jsonProviderList));
        mockedServer.enqueue(new MockResponse().setResponseCode(202).setHeaders(mHeaders).setBody(ResponseBodies.jsonProviderList));
        mockedServer.enqueue(new MockResponse().setResponseCode(301).setHeaders(mHeaders).setBody(""));
        mockedServer.enqueue(new MockResponse().setResponseCode(302).setHeaders(mHeaders).setBody(""));
        mockedServer.enqueue(new MockResponse().setResponseCode(404).setHeaders(mHeaders).setBody(""));
        mockedServer.enqueue(new MockResponse().setResponseCode(402).setHeaders(mHeaders).setBody(""));
        mockedServer.enqueue(new MockResponse().setResponseCode(403).setHeaders(mHeaders).setBody(""));
        mockedServer.enqueue(new MockResponse().setResponseCode(500).setHeaders(mHeaders).setBody(""));
        mockedServer.enqueue(new MockResponse().setResponseCode(503).setHeaders(mHeaders).setBody(""));

        mockedServer.start(InetAddress.getLocalHost(), port);
//        when(mPreferencesHelper.getUnconfirmedAppointments()).thenReturn(new ArrayList<>(10));

        //then
//        dataManager.getUnconfirmedAppointments().test()
//                .assertValue(value -> value.getCode() == 200 )
//                .assertValue(value -> value.getBody().size() == 0);
//
//        dataManager.getUnconfirmedAppointments().test()
//                .assertValue(value -> value.getCode() == 202)
//                .assertValue(value -> value.getHttpMessage() !=null && !value.getHttpMessage().isEmpty());
//
//        dataManager.getUnconfirmedAppointments().test()
//                .assertValue(value -> value.getCode() == 301)
//                .assertValue(value -> value.getHttpMessage() !=null && !value.getHttpMessage().isEmpty());
//
//        dataManager.getUnconfirmedAppointments().test()
//                .assertValue(value -> value.getCode() == 302)
//                .assertValue(value -> value.getHttpMessage() !=null && !value.getHttpMessage().isEmpty());
//
//        dataManager.getUnconfirmedAppointments().test()
//                .assertValue(value -> value.getCode() == 404)
//                .assertValue(value -> value.getHttpMessage() !=null && !value.getHttpMessage().isEmpty());
//
//        dataManager.getUnconfirmedAppointments().test()
//                .assertValue(value -> value.getCode() == 402)
//                .assertValue(value -> value.getHttpMessage() !=null && !value.getHttpMessage().isEmpty());
//
//        dataManager.getUnconfirmedAppointments().test()
//                .assertValue(value -> value.getCode() == 403)
//                .assertValue(value -> value.getHttpMessage() !=null && !value.getHttpMessage().isEmpty());
//
//        dataManager.getUnconfirmedAppointments().test()
//                .assertValue(value -> value.getCode() == 500)
//                .assertValue(value -> value.getHttpMessage() !=null && !value.getHttpMessage().isEmpty());
//
//        dataManager.getUnconfirmedAppointments().test()
//                .assertValue(value -> value.getCode() == 503)
//                .assertValue(value -> value.getHttpMessage() !=null && !value.getHttpMessage().isEmpty());
    }

    @Test
    public void testGetBookedAppointments() throws IOException {
        //when
        mockedServer.enqueue(new MockResponse().setResponseCode(200).setHeaders(mHeaders).setBody(ResponseBodies.jsonProviderList));
        mockedServer.enqueue(new MockResponse().setResponseCode(202).setHeaders(mHeaders).setBody(ResponseBodies.jsonProviderList));
        mockedServer.enqueue(new MockResponse().setResponseCode(301).setHeaders(mHeaders).setBody(""));
        mockedServer.enqueue(new MockResponse().setResponseCode(302).setHeaders(mHeaders).setBody(""));
        mockedServer.enqueue(new MockResponse().setResponseCode(404).setHeaders(mHeaders).setBody(""));
        mockedServer.enqueue(new MockResponse().setResponseCode(402).setHeaders(mHeaders).setBody(""));
        mockedServer.enqueue(new MockResponse().setResponseCode(403).setHeaders(mHeaders).setBody(""));
        mockedServer.enqueue(new MockResponse().setResponseCode(500).setHeaders(mHeaders).setBody(""));
        mockedServer.enqueue(new MockResponse().setResponseCode(503).setHeaders(mHeaders).setBody(""));

        mockedServer.start(InetAddress.getLocalHost(), port);
//        when(mPreferencesHelper.getBookedAppointments()).thenReturn(new ArrayList<>(10));

        //then
//        dataManager.getBookedAppointments().test()
//                .assertValue(value -> value.getCode() == 200 )
//                .assertValue(value -> value.getBody().size() == 0);
//
//        dataManager.getBookedAppointments().test()
//                .assertValue(value -> value.getCode() == 202)
//                .assertValue(value -> value.getHttpMessage() !=null && !value.getHttpMessage().isEmpty());
//
//        dataManager.getBookedAppointments().test()
//                .assertValue(value -> value.getCode() == 301)
//                .assertValue(value -> value.getHttpMessage() !=null && !value.getHttpMessage().isEmpty());
//
//        dataManager.getBookedAppointments().test()
//                .assertValue(value -> value.getCode() == 302)
//                .assertValue(value -> value.getHttpMessage() !=null && !value.getHttpMessage().isEmpty());
//
//        dataManager.getBookedAppointments().test()
//                .assertValue(value -> value.getCode() == 404)
//                .assertValue(value -> value.getHttpMessage() !=null && !value.getHttpMessage().isEmpty());
//
//        dataManager.getBookedAppointments().test()
//                .assertValue(value -> value.getCode() == 402)
//                .assertValue(value -> value.getHttpMessage() !=null && !value.getHttpMessage().isEmpty());
//
//        dataManager.getBookedAppointments().test()
//                .assertValue(value -> value.getCode() == 403)
//                .assertValue(value -> value.getHttpMessage() !=null && !value.getHttpMessage().isEmpty());
//
//        dataManager.getBookedAppointments().test()
//                .assertValue(value -> value.getCode() == 500)
//                .assertValue(value -> value.getHttpMessage() !=null && !value.getHttpMessage().isEmpty());
//
//        dataManager.getBookedAppointments().test()
//                .assertValue(value -> value.getCode() == 503)
//                .assertValue(value -> value.getHttpMessage() !=null && !value.getHttpMessage().isEmpty());
    }

    @Test
    public void testGetProviders() throws IOException {
        //when
        mockedServer.enqueue(new MockResponse().setResponseCode(200).setHeaders(mHeaders).setBody(ResponseBodies.jsonProviderList));
        mockedServer.enqueue(new MockResponse().setResponseCode(202).setHeaders(mHeaders).setBody(ResponseBodies.jsonProviderList));
        mockedServer.enqueue(new MockResponse().setResponseCode(301).setHeaders(mHeaders).setBody(""));
        mockedServer.enqueue(new MockResponse().setResponseCode(302).setHeaders(mHeaders).setBody(""));
        mockedServer.enqueue(new MockResponse().setResponseCode(404).setHeaders(mHeaders).setBody(""));
        mockedServer.enqueue(new MockResponse().setResponseCode(402).setHeaders(mHeaders).setBody(""));
        mockedServer.enqueue(new MockResponse().setResponseCode(403).setHeaders(mHeaders).setBody(""));
        mockedServer.enqueue(new MockResponse().setResponseCode(500).setHeaders(mHeaders).setBody(""));
        mockedServer.enqueue(new MockResponse().setResponseCode(503).setHeaders(mHeaders).setBody(""));

        mockedServer.start(InetAddress.getLocalHost(), port);
//        when(mPreferencesHelper.getProviderList()).thenReturn(new ArrayList<>(10));

        //then
//        dataManager.getProviders().test()
//                .assertValue(value -> value.getCode() == 200 )
//                .assertValue(value -> value.getBody().size() == 2);
//
//        dataManager.getProviders().test()
//                .assertValue(value -> value.getCode() == 202)
//                .assertValue(value -> value.getHttpMessage() !=null && !value.getHttpMessage().isEmpty());
//
//        dataManager.getProviders().test()
//                .assertValue(value -> value.getCode() == 301)
//                .assertValue(value -> value.getHttpMessage() !=null && !value.getHttpMessage().isEmpty());
//
//        dataManager.getProviders().test()
//                .assertValue(value -> value.getCode() == 302)
//                .assertValue(value -> value.getHttpMessage() !=null && !value.getHttpMessage().isEmpty());
//
//        dataManager.getProviders().test()
//                .assertValue(value -> value.getCode() == 404)
//                .assertValue(value -> value.getHttpMessage() !=null && !value.getHttpMessage().isEmpty());
//
//        dataManager.getProviders().test()
//                .assertValue(value -> value.getCode() == 402)
//                .assertValue(value -> value.getHttpMessage() !=null && !value.getHttpMessage().isEmpty());
//
//        dataManager.getProviders().test()
//                .assertValue(value -> value.getCode() == 403)
//                .assertValue(value -> value.getHttpMessage() !=null && !value.getHttpMessage().isEmpty());
//
//        dataManager.getProviders().test()
//                .assertValue(value -> value.getCode() == 500)
//                .assertValue(value -> value.getHttpMessage() !=null && !value.getHttpMessage().isEmpty());
//
//        dataManager.getProviders().test()
//                .assertValue(value -> value.getCode() == 503)
//                .assertValue(value -> value.getHttpMessage() !=null && !value.getHttpMessage().isEmpty());
    }

    @Test
    public void testGetCustomers() throws IOException {
        //when
        mockedServer.enqueue(new MockResponse().setResponseCode(200).setHeaders(mHeaders).setBody(ResponseBodies.jsonCustomerList));
        mockedServer.enqueue(new MockResponse().setResponseCode(202).setHeaders(mHeaders).setBody(ResponseBodies.jsonCustomerList));
        mockedServer.enqueue(new MockResponse().setResponseCode(301).setHeaders(mHeaders).setBody(""));
        mockedServer.enqueue(new MockResponse().setResponseCode(302).setHeaders(mHeaders).setBody(""));
        mockedServer.enqueue(new MockResponse().setResponseCode(404).setHeaders(mHeaders).setBody(""));
        mockedServer.enqueue(new MockResponse().setResponseCode(402).setHeaders(mHeaders).setBody(""));
        mockedServer.enqueue(new MockResponse().setResponseCode(403).setHeaders(mHeaders).setBody(""));
        mockedServer.enqueue(new MockResponse().setResponseCode(500).setHeaders(mHeaders).setBody(""));
        mockedServer.enqueue(new MockResponse().setResponseCode(503).setHeaders(mHeaders).setBody(""));

        mockedServer.start(InetAddress.getLocalHost(), port);
//        when(mPreferencesHelper.getCustomerList()).thenReturn(new ArrayList<>(10));

        //then
//        dataManager.getProviderCustomers().test()
//                .assertValue(value -> value.getCode() == 200 )
//                .assertValue(value -> value.getBody().size() == 3);
//
//        dataManager.getProviderCustomers().test()
//                .assertValue(value -> value.getCode() == 202)
//                .assertValue(value -> value.getHttpMessage() !=null && !value.getHttpMessage().isEmpty());
//
//        dataManager.getProviderCustomers().test()
//                .assertValue(value -> value.getCode() == 301)
//                .assertValue(value -> value.getHttpMessage() !=null && !value.getHttpMessage().isEmpty());
//
//        dataManager.getProviderCustomers().test()
//                .assertValue(value -> value.getCode() == 302)
//                .assertValue(value -> value.getHttpMessage() !=null && !value.getHttpMessage().isEmpty());
//
//        dataManager.getProviderCustomers().test()
//                .assertValue(value -> value.getCode() == 404)
//                .assertValue(value -> value.getHttpMessage() !=null && !value.getHttpMessage().isEmpty());
//
//        dataManager.getProviderCustomers().test()
//                .assertValue(value -> value.getCode() == 402)
//                .assertValue(value -> value.getHttpMessage() !=null && !value.getHttpMessage().isEmpty());
//
//        dataManager.getProviderCustomers().test()
//                .assertValue(value -> value.getCode() == 403)
//                .assertValue(value -> value.getHttpMessage() !=null && !value.getHttpMessage().isEmpty());
//
//        dataManager.getProviderCustomers().test()
//                .assertValue(value -> value.getCode() == 500)
//                .assertValue(value -> value.getHttpMessage() !=null && !value.getHttpMessage().isEmpty());
//
//        dataManager.getProviderCustomers().test()
//                .assertValue(value -> value.getCode() == 503)
//                .assertValue(value -> value.getHttpMessage() !=null && !value.getHttpMessage().isEmpty());
    }

    @Test
    public void testGetResources() throws IOException {
        //when
        mockedServer.enqueue(new MockResponse().setResponseCode(200).setHeaders(mHeaders).setBody(ResponseBodies.jsonResourceList));
        mockedServer.enqueue(new MockResponse().setResponseCode(202).setHeaders(mHeaders).setBody(ResponseBodies.jsonResourceList));
        mockedServer.enqueue(new MockResponse().setResponseCode(301).setHeaders(mHeaders).setBody(""));
        mockedServer.enqueue(new MockResponse().setResponseCode(302).setHeaders(mHeaders).setBody(""));
        mockedServer.enqueue(new MockResponse().setResponseCode(404).setHeaders(mHeaders).setBody(""));
        mockedServer.enqueue(new MockResponse().setResponseCode(402).setHeaders(mHeaders).setBody(""));
        mockedServer.enqueue(new MockResponse().setResponseCode(403).setHeaders(mHeaders).setBody(""));
        mockedServer.enqueue(new MockResponse().setResponseCode(500).setHeaders(mHeaders).setBody(""));
        mockedServer.enqueue(new MockResponse().setResponseCode(503).setHeaders(mHeaders).setBody(""));

        mockedServer.start(InetAddress.getLocalHost(), port);
//        when(mPreferencesHelper.getResourceList()).thenReturn(new ArrayList<>(10));

        //then
//        dataManager.getProviderResources().test()
//                .assertValue(value -> value.getCode() == 200 )
//                .assertValue(value -> value.getBody().size() == 3);
//
//        dataManager.getProviderResources().test()
//                .assertValue(value -> value.getCode() == 202)
//                .assertValue(value -> value.getHttpMessage() !=null && !value.getHttpMessage().isEmpty());
//
//        dataManager.getProviderResources().test()
//                .assertValue(value -> value.getCode() == 301)
//                .assertValue(value -> value.getHttpMessage() !=null && !value.getHttpMessage().isEmpty());
//
//        dataManager.getProviderResources().test()
//                .assertValue(value -> value.getCode() == 302)
//                .assertValue(value -> value.getHttpMessage() !=null && !value.getHttpMessage().isEmpty());
//
//        dataManager.getProviderResources().test()
//                .assertValue(value -> value.getCode() == 404)
//                .assertValue(value -> value.getHttpMessage() !=null && !value.getHttpMessage().isEmpty());
//
//        dataManager.getProviderResources().test()
//                .assertValue(value -> value.getCode() == 402)
//                .assertValue(value -> value.getHttpMessage() !=null && !value.getHttpMessage().isEmpty());
//
//        dataManager.getProviderResources().test()
//                .assertValue(value -> value.getCode() == 403)
//                .assertValue(value -> value.getHttpMessage() !=null && !value.getHttpMessage().isEmpty());
//
//        dataManager.getProviderResources().test()
//                .assertValue(value -> value.getCode() == 500)
//                .assertValue(value -> value.getHttpMessage() !=null && !value.getHttpMessage().isEmpty());
//
//        dataManager.getProviderResources().test()
//                .assertValue(value -> value.getCode() == 503)
//                .assertValue(value -> value.getHttpMessage() !=null && !value.getHttpMessage().isEmpty());
    }

    @Test
    public void testConfirmAppointment() throws IOException {
        //when
        mockedServer.enqueue(new MockResponse().setResponseCode(200).setHeaders(mHeaders).setBody(ResponseBodies.jsonAppointment));
        mockedServer.enqueue(new MockResponse().setResponseCode(202).setHeaders(mHeaders).setBody(ResponseBodies.jsonAppointment));
        mockedServer.enqueue(new MockResponse().setResponseCode(301).setHeaders(mHeaders).setBody(""));
        mockedServer.enqueue(new MockResponse().setResponseCode(302).setHeaders(mHeaders).setBody(""));
        mockedServer.enqueue(new MockResponse().setResponseCode(404).setHeaders(mHeaders).setBody(""));
        mockedServer.enqueue(new MockResponse().setResponseCode(402).setHeaders(mHeaders).setBody(""));
        mockedServer.enqueue(new MockResponse().setResponseCode(403).setHeaders(mHeaders).setBody(""));
        mockedServer.enqueue(new MockResponse().setResponseCode(500).setHeaders(mHeaders).setBody(""));
        mockedServer.enqueue(new MockResponse().setResponseCode(503).setHeaders(mHeaders).setBody(""));

        mockedServer.start(InetAddress.getLocalHost(), port);

        //then
//        dataManager.confirmAppointment("1234").test()
//                .assertValue(value -> value.getCode() == 200 )
//                .assertValue(value -> value.getBody() != null);
//
//        dataManager.confirmAppointment("1234").test()
//                .assertValue(value -> value.getCode() == 202)
//                .assertValue(value -> value.getHttpMessage() !=null && !value.getHttpMessage().isEmpty());
//
//        dataManager.confirmAppointment("1234").test()
//                .assertValue(value -> value.getCode() == 301)
//                .assertValue(value -> value.getHttpMessage() !=null && !value.getHttpMessage().isEmpty());
//
//        dataManager.confirmAppointment("1234").test()
//                .assertValue(value -> value.getCode() == 302)
//                .assertValue(value -> value.getHttpMessage() !=null && !value.getHttpMessage().isEmpty());
//
//        dataManager.confirmAppointment("1234").test()
//                .assertValue(value -> value.getCode() == 404)
//                .assertValue(value -> value.getHttpMessage() !=null && !value.getHttpMessage().isEmpty());
//
//        dataManager.confirmAppointment("1234").test()
//                .assertValue(value -> value.getCode() == 402)
//                .assertValue(value -> value.getHttpMessage() !=null && !value.getHttpMessage().isEmpty());
//
//        dataManager.confirmAppointment("1234").test()
//                .assertValue(value -> value.getCode() == 403)
//                .assertValue(value -> value.getHttpMessage() !=null && !value.getHttpMessage().isEmpty());
//
//        dataManager.confirmAppointment("1234").test()
//                .assertValue(value -> value.getCode() == 500)
//                .assertValue(value -> value.getHttpMessage() !=null && !value.getHttpMessage().isEmpty());
//
//        dataManager.confirmAppointment("1234").test()
//                .assertValue(value -> value.getCode() == 503)
//                .assertValue(value -> value.getHttpMessage() !=null && !value.getHttpMessage().isEmpty());
    }

    @Test
    public void testRejectAppointment()throws IOException{
        //when
        mockedServer.enqueue(new MockResponse().setResponseCode(200).setHeaders(mHeaders).setBody(ResponseBodies.jsonAppointment));
        mockedServer.enqueue(new MockResponse().setResponseCode(202).setHeaders(mHeaders).setBody(ResponseBodies.jsonAppointment));
        mockedServer.enqueue(new MockResponse().setResponseCode(301).setHeaders(mHeaders).setBody(""));
        mockedServer.enqueue(new MockResponse().setResponseCode(302).setHeaders(mHeaders).setBody(""));
        mockedServer.enqueue(new MockResponse().setResponseCode(404).setHeaders(mHeaders).setBody(""));
        mockedServer.enqueue(new MockResponse().setResponseCode(402).setHeaders(mHeaders).setBody(""));
        mockedServer.enqueue(new MockResponse().setResponseCode(403).setHeaders(mHeaders).setBody(""));
        mockedServer.enqueue(new MockResponse().setResponseCode(500).setHeaders(mHeaders).setBody(""));
        mockedServer.enqueue(new MockResponse().setResponseCode(503).setHeaders(mHeaders).setBody(""));

        mockedServer.start(InetAddress.getLocalHost(), port);

        //then
//        dataManager.rejectAppointmentDoNotify("1234").test()
//                .assertValue(value -> value.getCode() == 200 );
//
//        dataManager.rejectAppointmentDoNotify("1234").test()
//                .assertValue(value -> value.getCode() == 202)
//                .assertValue(value -> value.getHttpMessage() !=null && value.getHttpMessage().isEmpty());
//
//        dataManager.rejectAppointmentDoNotify("1234").test()
//                .assertValue(value -> value.getCode() == 301)
//                .assertValue(value -> value.getHttpMessage() !=null && value.getHttpMessage().isEmpty());
//
//        dataManager.rejectAppointmentDoNotify("1234").test()
//                .assertValue(value -> value.getCode() == 302)
//                .assertValue(value -> value.getHttpMessage() !=null && value.getHttpMessage().isEmpty());
//
//        dataManager.rejectAppointmentDoNotify("1234").test()
//                .assertValue(value -> value.getCode() == 404)
//                .assertValue(value -> value.getHttpMessage() !=null && value.getHttpMessage().isEmpty());
//
//        dataManager.rejectAppointmentDoNotify("1234").test()
//                .assertValue(value -> value.getCode() == 402)
//                .assertValue(value -> value.getHttpMessage() !=null && value.getHttpMessage().isEmpty());
//
//        dataManager.rejectAppointmentDoNotify("1234").test()
//                .assertValue(value -> value.getCode() == 403)
//                .assertValue(value -> value.getHttpMessage() !=null && value.getHttpMessage().isEmpty());
//
//        dataManager.rejectAppointmentDoNotify("1234").test()
//                .assertValue(value -> value.getCode() == 500)
//                .assertValue(value -> value.getHttpMessage() !=null && value.getHttpMessage().isEmpty());
//
//        dataManager.rejectAppointmentDoNotify("1234").test()
//                .assertValue(value -> value.getCode() == 503)
//                .assertValue(value -> value.getHttpMessage() !=null && value.getHttpMessage().isEmpty());
    }

    @Test
    public void testSendDirectBookingLink()throws IOException{
        //when
        mockedServer.enqueue(new MockResponse().setResponseCode(200).setHeaders(mHeaders).setBody(ResponseBodies.jsonAppointment));
        mockedServer.enqueue(new MockResponse().setResponseCode(202).setHeaders(mHeaders).setBody(ResponseBodies.jsonAppointment));
        mockedServer.enqueue(new MockResponse().setResponseCode(301).setHeaders(mHeaders).setBody(""));
        mockedServer.enqueue(new MockResponse().setResponseCode(302).setHeaders(mHeaders).setBody(""));
        mockedServer.enqueue(new MockResponse().setResponseCode(404).setHeaders(mHeaders).setBody(""));
        mockedServer.enqueue(new MockResponse().setResponseCode(402).setHeaders(mHeaders).setBody(""));
        mockedServer.enqueue(new MockResponse().setResponseCode(403).setHeaders(mHeaders).setBody(""));
        mockedServer.enqueue(new MockResponse().setResponseCode(500).setHeaders(mHeaders).setBody(""));
        mockedServer.enqueue(new MockResponse().setResponseCode(503).setHeaders(mHeaders).setBody(""));

        mockedServer.start(InetAddress.getLocalHost(), port);

        //then
//        dataManager.sendDirectBookingLink("1234").test()
//                .assertValue(value -> value.getCode() == 200 );
//
//        dataManager.sendDirectBookingLink("1234").test()
//                .assertValue(value -> value.getCode() == 202)
//                .assertValue(value -> value.getHttpMessage() !=null && value.getHttpMessage().isEmpty());
//
//        dataManager.sendDirectBookingLink("1234").test()
//                .assertValue(value -> value.getCode() == 301)
//                .assertValue(value -> value.getHttpMessage() !=null && value.getHttpMessage().isEmpty());
//
//        dataManager.sendDirectBookingLink("1234").test()
//                .assertValue(value -> value.getCode() == 302)
//                .assertValue(value -> value.getHttpMessage() !=null && value.getHttpMessage().isEmpty());
//
//        dataManager.sendDirectBookingLink("1234").test()
//                .assertValue(value -> value.getCode() == 404)
//                .assertValue(value -> value.getHttpMessage() !=null && value.getHttpMessage().isEmpty());
//
//        dataManager.sendDirectBookingLink("1234").test()
//                .assertValue(value -> value.getCode() == 402)
//                .assertValue(value -> value.getHttpMessage() !=null && value.getHttpMessage().isEmpty());
//
//        dataManager.sendDirectBookingLink("1234").test()
//                .assertValue(value -> value.getCode() == 403)
//                .assertValue(value -> value.getHttpMessage() !=null && value.getHttpMessage().isEmpty());
//
//        dataManager.sendDirectBookingLink("1234").test()
//                .assertValue(value -> value.getCode() == 500)
//                .assertValue(value -> value.getHttpMessage() !=null && value.getHttpMessage().isEmpty());
//
//        dataManager.sendDirectBookingLink("1234").test()
//                .assertValue(value -> value.getCode() == 503)
//                .assertValue(value -> value.getHttpMessage() !=null && value.getHttpMessage().isEmpty());
    }

    @Test
    public void cancelAppointment()throws IOException{
        //when
        mockedServer.enqueue(new MockResponse().setResponseCode(200).setHeaders(mHeaders).setBody(ResponseBodies.jsonAppointment));
        mockedServer.enqueue(new MockResponse().setResponseCode(202).setHeaders(mHeaders).setBody(ResponseBodies.jsonAppointment));
        mockedServer.enqueue(new MockResponse().setResponseCode(301).setHeaders(mHeaders).setBody(""));
        mockedServer.enqueue(new MockResponse().setResponseCode(302).setHeaders(mHeaders).setBody(""));
        mockedServer.enqueue(new MockResponse().setResponseCode(404).setHeaders(mHeaders).setBody(""));
        mockedServer.enqueue(new MockResponse().setResponseCode(402).setHeaders(mHeaders).setBody(""));
        mockedServer.enqueue(new MockResponse().setResponseCode(403).setHeaders(mHeaders).setBody(""));
        mockedServer.enqueue(new MockResponse().setResponseCode(500).setHeaders(mHeaders).setBody(""));
        mockedServer.enqueue(new MockResponse().setResponseCode(503).setHeaders(mHeaders).setBody(""));

        mockedServer.start(InetAddress.getLocalHost(), port);

        //then
//        dataManager.cancelAppointmentDontNotify("1234").test()
//                .assertValue(value -> value.getCode() == 200 );
//
//        dataManager.cancelAppointmentDontNotify("1234").test()
//                .assertValue(value -> value.getCode() == 202)
//                .assertValue(value -> value.getHttpMessage() !=null && value.getHttpMessage().isEmpty());
//
//        dataManager.cancelAppointmentDontNotify("1234").test()
//                .assertValue(value -> value.getCode() == 301)
//                .assertValue(value -> value.getHttpMessage() !=null && value.getHttpMessage().isEmpty());
//
//        dataManager.cancelAppointmentDontNotify("1234").test()
//                .assertValue(value -> value.getCode() == 302)
//                .assertValue(value -> value.getHttpMessage() !=null && value.getHttpMessage().isEmpty());
//
//        dataManager.cancelAppointmentDontNotify("1234").test()
//                .assertValue(value -> value.getCode() == 404)
//                .assertValue(value -> value.getHttpMessage() !=null && value.getHttpMessage().isEmpty());
//
//        dataManager.cancelAppointmentDontNotify("1234").test()
//                .assertValue(value -> value.getCode() == 402)
//                .assertValue(value -> value.getHttpMessage() !=null && value.getHttpMessage().isEmpty());
//
//        dataManager.cancelAppointmentDontNotify("1234").test()
//                .assertValue(value -> value.getCode() == 403)
//                .assertValue(value -> value.getHttpMessage() !=null && value.getHttpMessage().isEmpty());
//
//        dataManager.cancelAppointmentDontNotify("1234").test()
//                .assertValue(value -> value.getCode() == 500)
//                .assertValue(value -> value.getHttpMessage() !=null && value.getHttpMessage().isEmpty());
//
//        dataManager.cancelAppointmentDontNotify("1234").test()
//                .assertValue(value -> value.getCode() == 503)
//                .assertValue(value -> value.getHttpMessage() !=null && value.getHttpMessage().isEmpty());
    }


    @After
    public void finish() throws IOException {
        mockedServer.shutdown();
    }



    //***************************** Utility ********************************************************


}
