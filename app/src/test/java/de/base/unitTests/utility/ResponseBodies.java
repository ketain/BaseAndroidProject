package de.base.unitTests.utility;

/**
 * Created by Sebastian Müller on 24.01.2017.
 */

public class ResponseBodies {

        public final static String jsonUserVO = "{\n" +
                "  \"uuid\": \"1234\",\n" +
                "  \"created\": 1485258681433,\n" +
                "  \"userName\": \"muellers@th-brandenburg.de\",\n" +
                "  \"firstName\": \"Sebastian\",\n" +
                "  \"lastName\": \"Müller\",\n" +
                "  \"email\": \"muellers@th-brandenburg.de\",\n" +
                "  \"mobile\": null,\n" +
                "  \"phone\": null,\n" +
                "  \"userId\": {\n" +
                "    \"id\": \"muellers@th-brandenburg.de\",\n" +
                "    \"provider\": \"userpass\"\n" +
                "  },\n" +
                "  \"address\": {\n" +
                "    \"uuid\": \"1234\",\n" +
                "    \"created\": 1485258681441,\n" +
                "    \"id\": 205,\n" +
                "    \"street\": \"\",\n" +
                "    \"houseNumber\": \"\",\n" +
                "    \"zipCode\": \"\",\n" +
                "    \"city\": \"\",\n" +
                "    \"countryCode\": \"DE\"\n" +
                "  },\n" +
                "  \"role\": \"SUPER_USER\",\n" +
                "  \"claimed\": true,\n" +
                "  \"language\": \"de\",\n" +
                "  \"companyId\": null,\n" +
                "  \"customerAt\": [\n" +
                "    {\n" +
                "      \"uuid\": \"1234\",\n" +
                "      \"created\": 1485258681570,\n" +
                "      \"id\": 29,\n" +
                "      \"name\": \"Müller\",\n" +
                "      \"slug\": \"mueller\",\n" +
                "      \"language\": \"de\",\n" +
                "      \"references\": [],\n" +
                "      \"companyId\": null,\n" +
                "      \"email\": \"muellers@th-brandenburg.de\",\n" +
                "      \"phone\": null,\n" +
                "      \"mobile\": \"-\",\n" +
                "      \"address\": {\n" +
                "        \"uuid\": \"1234\",\n" +
                "        \"created\": 1485258681570,\n" +
                "        \"id\": 206,\n" +
                "        \"street\": \"\",\n" +
                "        \"houseNumber\": \"\",\n" +
                "        \"zipCode\": \"\",\n" +
                "        \"city\": \"\",\n" +
                "        \"countryCode\": \"DE\"\n" +
                "      },\n" +
                "      \"invoiceAddress\": null,\n" +
                "      \"invoiceContactName\": null,\n" +
                "      \"invoiceCompanyName\": null,\n" +
                "      \"invoiceTaxId\": null,\n" +
                "      \"description\": null,\n" +
                "      \"impressum\": null,\n" +
                "      \"isAppointmentConfirmationRequired\": true,\n" +
                "      \"acceptNewCustomers\": true,\n" +
                "      \"branch\": {\n" +
                "        \"name\": \"Immobilien\",\n" +
                "        \"slug\": \"real-estate\"\n" +
                "      },\n" +
                "      \"defaultCurrencyCode\": \"EUR\",\n" +
                "      \"subbranch\": \"UNKNOWN\",\n" +
                "      \"planName\": \"Evaluation\",\n" +
                "      \"nextPlan\": null,\n" +
                "      \"planExpirationMillis\": 1487937081629,\n" +
                "      \"balance\": -3,\n" +
                "      \"contractName\": \"Evaluation\",\n" +
                "      \"hasManagerAccess\": true,\n" +
                "      \"ownerUserUuid\": \"1234\",\n" +
                "      \"ownerUsername\": \"muellers@th-brandenburg.de\",\n" +
                "      \"crmConnections\": \"\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"references\": [\n" +
                "    {\n" +
                "      \"uuid\": \"1234\",\n" +
                "      \"created\": 1485258681681,\n" +
                "      \"referenceNumber\": \"1234\",\n" +
                "      \"referencedPlatform\": \"analyticsUid\",\n" +
                "      \"user_uuid\": \"1234\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"staffOf\": [\n" +
                "    {\n" +
                "      \"uuid\": \"1234\",\n" +
                "      \"created\": 1485258681570,\n" +
                "      \"id\": 29,\n" +
                "      \"name\": \"Müller\",\n" +
                "      \"slug\": \"mueller\",\n" +
                "      \"language\": \"de\",\n" +
                "      \"references\": [],\n" +
                "      \"companyId\": null,\n" +
                "      \"email\": \"muellers@th-brandenburg.de\",\n" +
                "      \"phone\": null,\n" +
                "      \"mobile\": \"-\",\n" +
                "      \"address\": {\n" +
                "        \"uuid\": \"1234\",\n" +
                "        \"created\": 1485258681570,\n" +
                "        \"id\": 206,\n" +
                "        \"street\": \"\",\n" +
                "        \"houseNumber\": \"\",\n" +
                "        \"zipCode\": \"\",\n" +
                "        \"city\": \"\",\n" +
                "        \"countryCode\": \"DE\"\n" +
                "      },\n" +
                "      \"invoiceAddress\": null,\n" +
                "      \"invoiceContactName\": null,\n" +
                "      \"invoiceCompanyName\": null,\n" +
                "      \"invoiceTaxId\": null,\n" +
                "      \"description\": null,\n" +
                "      \"impressum\": null,\n" +
                "      \"isAppointmentConfirmationRequired\": true,\n" +
                "      \"acceptNewCustomers\": true,\n" +
                "      \"branch\": {\n" +
                "        \"name\": \"Immobilien\",\n" +
                "        \"slug\": \"real-estate\"\n" +
                "      },\n" +
                "      \"defaultCurrencyCode\": \"EUR\",\n" +
                "      \"subbranch\": \"UNKNOWN\",\n" +
                "      \"planName\": \"Evaluation\",\n" +
                "      \"nextPlan\": null,\n" +
                "      \"planExpirationMillis\": 1487937081629,\n" +
                "      \"balance\": -3,\n" +
                "      \"contractName\": \"Evaluation\",\n" +
                "      \"hasManagerAccess\": true,\n" +
                "      \"ownerUserUuid\": \"1234\",\n" +
                "      \"ownerUsername\": \"muellers@th-brandenburg.de\",\n" +
                "      \"crmConnections\": \"\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"passwordResetToken\": null,\n" +
                "  \"alreadyEvaluated\": true\n" +
                "}";


        public static final String jsonProviderList = "{\n" +
                "  \"api-info\": {\n" +
                "    \"version\": \"1\"\n" +
                "  },\n" +
                "  \"providers\": [\n" +
                "    {\n" +
                "      \"uuid\": \"1234\",\n" +
                "      \"created\": 1485258681570,\n" +
                "      \"id\": 29,\n" +
                "      \"name\": \"Müller\",\n" +
                "      \"slug\": \"mueller\",\n" +
                "      \"language\": \"de\",\n" +
                "      \"references\": [],\n" +
                "      \"companyId\": null,\n" +
                "      \"email\": \"muellers@th-brandenburg.de\",\n" +
                "      \"phone\": null,\n" +
                "      \"mobile\": \"-\",\n" +
                "      \"address\": {\n" +
                "        \"uuid\": \"1234\",\n" +
                "        \"created\": 1485258681570,\n" +
                "        \"id\": 206,\n" +
                "        \"street\": \"\",\n" +
                "        \"houseNumber\": \"\",\n" +
                "        \"zipCode\": \"\",\n" +
                "        \"city\": \"\",\n" +
                "        \"countryCode\": \"DE\"\n" +
                "      },\n" +
                "      \"invoiceAddress\": null,\n" +
                "      \"invoiceContactName\": null,\n" +
                "      \"invoiceCompanyName\": null,\n" +
                "      \"invoiceTaxId\": null,\n" +
                "      \"description\": null,\n" +
                "      \"impressum\": null,\n" +
                "      \"isAppointmentConfirmationRequired\": true,\n" +
                "      \"acceptNewCustomers\": true,\n" +
                "      \"branch\": {\n" +
                "        \"name\": \"Immobilien\",\n" +
                "        \"slug\": \"real-estate\"\n" +
                "      },\n" +
                "      \"defaultCurrencyCode\": \"EUR\",\n" +
                "      \"subbranch\": \"UNKNOWN\",\n" +
                "      \"planName\": \"Evaluation\",\n" +
                "      \"nextPlan\": null,\n" +
                "      \"planExpirationMillis\": 1487937081629,\n" +
                "      \"balance\": -3,\n" +
                "      \"contractName\": \"Evaluation\",\n" +
                "      \"hasManagerAccess\": true,\n" +
                "      \"ownerUserUuid\": \"1234\",\n" +
                "      \"ownerUsername\": \"muellers@th-brandenburg.de\",\n" +
                "      \"crmConnections\": \"\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"uuid\": \"1234\",\n" +
                "      \"created\": 1485273587515,\n" +
                "      \"id\": 30,\n" +
                "      \"name\": \"Schulz\",\n" +
                "      \"slug\": \"schulzens-immobilien-schleuder\",\n" +
                "      \"language\": \"de\",\n" +
                "      \"references\": [],\n" +
                "      \"companyId\": null,\n" +
                "      \"email\": \"sebastian@timum.de\",\n" +
                "      \"phone\": \"1243564743\",\n" +
                "      \"mobile\": \"2445547568574\",\n" +
                "      \"address\": {\n" +
                "        \"uuid\": \"1234\",\n" +
                "        \"created\": 1485273587518,\n" +
                "        \"id\": 210,\n" +
                "        \"street\": \"\",\n" +
                "        \"houseNumber\": \"\",\n" +
                "        \"zipCode\": \"\",\n" +
                "        \"city\": \"\",\n" +
                "        \"countryCode\": \"DE\"\n" +
                "      },\n" +
                "      \"invoiceAddress\": {\n" +
                "        \"uuid\": \"1234\",\n" +
                "        \"created\": 1485273587585,\n" +
                "        \"id\": 211,\n" +
                "        \"street\": \"\",\n" +
                "        \"houseNumber\": \"\",\n" +
                "        \"zipCode\": \"\",\n" +
                "        \"city\": \"\",\n" +
                "        \"countryCode\": \"DE\"\n" +
                "      },\n" +
                "      \"invoiceContactName\": \"\",\n" +
                "      \"invoiceCompanyName\": \"\",\n" +
                "      \"invoiceTaxId\": \"\",\n" +
                "      \"description\": \"\",\n" +
                "      \"impressum\": null,\n" +
                "      \"isAppointmentConfirmationRequired\": true,\n" +
                "      \"acceptNewCustomers\": true,\n" +
                "      \"branch\": {\n" +
                "        \"name\": \"Immobilien\",\n" +
                "        \"slug\": \"real-estate\"\n" +
                "      },\n" +
                "      \"defaultCurrencyCode\": \"EUR\",\n" +
                "      \"subbranch\": \"UNKNOWN\",\n" +
                "      \"planName\": \"Evaluation\",\n" +
                "      \"nextPlan\": null,\n" +
                "      \"planExpirationMillis\": 9223372036854775807,\n" +
                "      \"balance\": 0,\n" +
                "      \"contractName\": \"Evaluation\",\n" +
                "      \"hasManagerAccess\": true,\n" +
                "      \"ownerUserUuid\": \"6c919490-e22b-11e6-b7b7-e4a7a0ca32e8\",\n" +
                "      \"ownerUsername\": \"muellers@th-brandenburg.de\",\n" +
                "      \"crmConnections\": \"\"\n" +
                "    }\n" +
                "  ]\n" +
                "}";

        public static final String jsonCustomerList = "{\n" +
                "  \"api-info\": {\n" +
                "    \"version\": \"1\"\n" +
                "  },\n" +
                "  \"customers\": [\n" +
                "    {\n" +
                "      \"uuid\": \"1234\",\n" +
                "      \"email\": \"böttcher@weißNicht.de\",\n" +
                "      \"name\": \"Bernd Böttcher\",\n" +
                "      \"mobile\": \"3453656563\",\n" +
                "      \"provider\": \"6ca67c20-e22b-11e6-b7b7-e4a7a0ca32e8\",\n" +
                "      \"activityUrl\": \"http://localhost:9000/activityLog/c69eb950-e22f-11e6-b5cd-e4a7a0ca32e8?page=0&limit=20&token=caac9bdecf47aecbf47bc6aa4d13444512e63e6e_YzY5ZWI5NTAtZTIyZi0xMWU2LWI1Y2QtZTRhN2EwY2EzMmU4-1485528816767\",\n" +
                "      \"canEdit\": true\n" +
                "    },\n" +
                "    {\n" +
                "      \"uuid\": \"1234\",\n" +
                "      \"email\": \"muellers@th-brandenburg.de\",\n" +
                "      \"name\": \"Sebastian Müller\",\n" +
                "      \"mobile\": \"\",\n" +
                "      \"provider\": \"6ca67c20-e22b-11e6-b7b7-e4a7a0ca32e8\",\n" +
                "      \"activityUrl\": \"http://localhost:9000/activityLog/07908c40-e230-11e6-b5cd-e4a7a0ca32e8?page=0&limit=20&token=9f0a0782a8ae472f587fd02a072850930ec81246_MDc5MDhjNDAtZTIzMC0xMWU2LWI1Y2QtZTRhN2EwY2EzMmU4-1485528816767\",\n" +
                "      \"canEdit\": false,\n" +
                "      \"user\": {\n" +
                "        \"uuid\": \"1234\",\n" +
                "        \"created\": 1485258681433,\n" +
                "        \"userName\": \"muellers@th-brandenburg.de\",\n" +
                "        \"firstName\": \"Sebastian\",\n" +
                "        \"lastName\": \"Müller\",\n" +
                "        \"email\": \"muellers@th-brandenburg.de\",\n" +
                "        \"mobile\": null,\n" +
                "        \"phone\": null,\n" +
                "        \"userId\": {\n" +
                "          \"id\": \"muellers@th-brandenburg.de\",\n" +
                "          \"provider\": \"userpass\"\n" +
                "        },\n" +
                "        \"address\": {\n" +
                "          \"uuid\": \"1234\",\n" +
                "          \"created\": 1485258681441,\n" +
                "          \"id\": 205,\n" +
                "          \"street\": \"\",\n" +
                "          \"houseNumber\": \"\",\n" +
                "          \"zipCode\": \"\",\n" +
                "          \"city\": \"\",\n" +
                "          \"countryCode\": \"DE\"\n" +
                "        },\n" +
                "        \"role\": \"SUPER_USER\",\n" +
                "        \"claimed\": true,\n" +
                "        \"language\": \"de\",\n" +
                "        \"companyId\": null,\n" +
                "        \"customerAt\": [\n" +
                "          {\n" +
                "            \"uuid\": \"1234\",\n" +
                "            \"created\": 1485258681570,\n" +
                "            \"id\": 29,\n" +
                "            \"name\": \"Müller\",\n" +
                "            \"slug\": \"mueller\",\n" +
                "            \"language\": \"de\",\n" +
                "            \"references\": [],\n" +
                "            \"companyId\": null,\n" +
                "            \"email\": \"muellers@th-brandenburg.de\",\n" +
                "            \"phone\": null,\n" +
                "            \"mobile\": \"-\",\n" +
                "            \"address\": {\n" +
                "              \"uuid\": \"1234\",\n" +
                "              \"created\": 1485258681570,\n" +
                "              \"id\": 206,\n" +
                "              \"street\": \"\",\n" +
                "              \"houseNumber\": \"\",\n" +
                "              \"zipCode\": \"\",\n" +
                "              \"city\": \"\",\n" +
                "              \"countryCode\": \"DE\"\n" +
                "            },\n" +
                "            \"invoiceAddress\": null,\n" +
                "            \"invoiceContactName\": null,\n" +
                "            \"invoiceCompanyName\": null,\n" +
                "            \"invoiceTaxId\": null,\n" +
                "            \"description\": null,\n" +
                "            \"impressum\": null,\n" +
                "            \"isAppointmentConfirmationRequired\": true,\n" +
                "            \"acceptNewCustomers\": true,\n" +
                "            \"branch\": {\n" +
                "              \"name\": \"Immobilien\",\n" +
                "              \"slug\": \"real-estate\"\n" +
                "            },\n" +
                "            \"defaultCurrencyCode\": \"EUR\",\n" +
                "            \"subbranch\": \"UNKNOWN\",\n" +
                "            \"planName\": \"Evaluation\",\n" +
                "            \"nextPlan\": null,\n" +
                "            \"planExpirationMillis\": 1487937081629,\n" +
                "            \"crmConnections\": \"\",\n" +
                "            \"ownerUsername\": \"muellers@th-brandenburg.de\",\n" +
                "            \"ownerUserUuid\": \"1234\",\n" +
                "            \"contractName\": \"Evaluation\",\n" +
                "            \"hasManagerAccess\": true,\n" +
                "            \"balance\": -3\n" +
                "          }\n" +
                "        ],\n" +
                "        \"references\": [\n" +
                "          {\n" +
                "            \"uuid\": \"1234\",\n" +
                "            \"created\": 1485258681681,\n" +
                "            \"referenceNumber\": \"6cb6a8c0-e22b-11e6-b7b7-e4a7a0ca32e8\",\n" +
                "            \"referencedPlatform\": \"analyticsUid\",\n" +
                "            \"user_uuid\": \"1234\"\n" +
                "          }\n" +
                "        ],\n" +
                "        \"staffOf\": [\n" +
                "          {\n" +
                "            \"uuid\": \"1234\",\n" +
                "            \"created\": 1485273587515,\n" +
                "            \"id\": 30,\n" +
                "            \"name\": \"Schulz\",\n" +
                "            \"slug\": \"schulzens-immobilien-schleuder\",\n" +
                "            \"language\": \"de\",\n" +
                "            \"references\": [],\n" +
                "            \"companyId\": null,\n" +
                "            \"email\": \"sebastian@timum.de\",\n" +
                "            \"phone\": \"1243564743\",\n" +
                "            \"mobile\": \"2445547568574\",\n" +
                "            \"address\": {\n" +
                "              \"uuid\": \"1234\",\n" +
                "              \"created\": 1485273587518,\n" +
                "              \"id\": 210,\n" +
                "              \"street\": \"\",\n" +
                "              \"houseNumber\": \"\",\n" +
                "              \"zipCode\": \"\",\n" +
                "              \"city\": \"\",\n" +
                "              \"countryCode\": \"DE\"\n" +
                "            },\n" +
                "            \"invoiceAddress\": {\n" +
                "              \"uuid\": \"1234\",\n" +
                "              \"created\": 1485273587585,\n" +
                "              \"id\": 211,\n" +
                "              \"street\": \"\",\n" +
                "              \"houseNumber\": \"\",\n" +
                "              \"zipCode\": \"\",\n" +
                "              \"city\": \"\",\n" +
                "              \"countryCode\": \"DE\"\n" +
                "            },\n" +
                "            \"invoiceContactName\": \"\",\n" +
                "            \"invoiceCompanyName\": \"\",\n" +
                "            \"invoiceTaxId\": \"\",\n" +
                "            \"description\": \"\",\n" +
                "            \"impressum\": null,\n" +
                "            \"isAppointmentConfirmationRequired\": true,\n" +
                "            \"acceptNewCustomers\": true,\n" +
                "            \"branch\": {\n" +
                "              \"name\": \"Immobilien\",\n" +
                "              \"slug\": \"real-estate\"\n" +
                "            },\n" +
                "            \"defaultCurrencyCode\": \"EUR\",\n" +
                "            \"subbranch\": \"UNKNOWN\",\n" +
                "            \"planName\": \"Evaluation\",\n" +
                "            \"nextPlan\": null,\n" +
                "            \"planExpirationMillis\": 9223372036854775807,\n" +
                "            \"crmConnections\": \"\",\n" +
                "            \"ownerUsername\": \"muellers@th-brandenburg.de\",\n" +
                "            \"ownerUserUuid\": \"6c919490-e22b-11e6-b7b7-e4a7a0ca32e8\",\n" +
                "            \"contractName\": \"Evaluation\",\n" +
                "            \"hasManagerAccess\": true,\n" +
                "            \"balance\": 0\n" +
                "          },\n" +
                "          {\n" +
                "            \"uuid\": \"1234\",\n" +
                "            \"created\": 1485258681570,\n" +
                "            \"id\": 29,\n" +
                "            \"name\": \"Müller\",\n" +
                "            \"slug\": \"mueller\",\n" +
                "            \"language\": \"de\",\n" +
                "            \"references\": [],\n" +
                "            \"companyId\": null,\n" +
                "            \"email\": \"muellers@th-brandenburg.de\",\n" +
                "            \"phone\": null,\n" +
                "            \"mobile\": \"-\",\n" +
                "            \"address\": {\n" +
                "              \"uuid\": \"1234\",\n" +
                "              \"created\": 1485258681570,\n" +
                "              \"id\": 206,\n" +
                "              \"street\": \"\",\n" +
                "              \"houseNumber\": \"\",\n" +
                "              \"zipCode\": \"\",\n" +
                "              \"city\": \"\",\n" +
                "              \"countryCode\": \"DE\"\n" +
                "            },\n" +
                "            \"invoiceAddress\": null,\n" +
                "            \"invoiceContactName\": null,\n" +
                "            \"invoiceCompanyName\": null,\n" +
                "            \"invoiceTaxId\": null,\n" +
                "            \"description\": null,\n" +
                "            \"impressum\": null,\n" +
                "            \"isAppointmentConfirmationRequired\": true,\n" +
                "            \"acceptNewCustomers\": true,\n" +
                "            \"branch\": {\n" +
                "              \"name\": \"Immobilien\",\n" +
                "              \"slug\": \"real-estate\"\n" +
                "            },\n" +
                "            \"defaultCurrencyCode\": \"EUR\",\n" +
                "            \"subbranch\": \"UNKNOWN\",\n" +
                "            \"planName\": \"Evaluation\",\n" +
                "            \"nextPlan\": null,\n" +
                "            \"planExpirationMillis\": 1487937081629,\n" +
                "            \"crmConnections\": \"\",\n" +
                "            \"ownerUsername\": \"muellers@th-brandenburg.de\",\n" +
                "            \"ownerUserUuid\": \"6c919490-e22b-11e6-b7b7-e4a7a0ca32e8\",\n" +
                "            \"contractName\": \"Evaluation\",\n" +
                "            \"hasManagerAccess\": true,\n" +
                "            \"balance\": -3\n" +
                "          }\n" +
                "        ],\n" +
                "        \"passwordResetToken\": null,\n" +
                "        \"alreadyEvaluated\": true,\n" +
                "        \"authToken\": \"dedf434b178bd51edf6663a4da9006bd17f4d23c_eE9SaHRCd0NEMXpmeURjUDFyTE9ZY0Y5ZG43RXFB\",\n" +
                "        \"analytics_uid\": \"6cb6a8c0-e22b-11e6-b7b7-e4a7a0ca32e8\",\n" +
                "        \"emailConfirmed\": true\n" +
                "      }\n" +
                "    },\n" +
                "    {\n" +
                "      \"uuid\": \"1234\",\n" +
                "      \"email\": \"vielhauer@web.de\",\n" +
                "      \"name\": \"Rolf Vielhauer\",\n" +
                "      \"mobile\": \"13643343\",\n" +
                "      \"provider\": \"6ca67c20-e22b-11e6-b7b7-e4a7a0ca32e8\",\n" +
                "      \"activityUrl\": \"http://localhost:9000/activityLog/4bb37050-e4a0-11e6-b147-e4a7a0ca32e8?page=0&limit=20&token=6a8ee72d19aeb26c09864a273755b23c1de77498_NGJiMzcwNTAtZTRhMC0xMWU2LWIxNDctZTRhN2EwY2EzMmU4-1485528816781\",\n" +
                "      \"canEdit\": true\n" +
                "    }\n" +
                "  ]\n" +
                "}";

        public static final String jsonResourceList = "{\n" +
                "  \"api-info\": {\n" +
                "    \"version\": \"1\"\n" +
                "  },\n" +
                "  \"provider\": \"6ca67c20-e22b-11e6-b7b7-e4a7a0ca32e8\",\n" +
                "  \"resources\": [\n" +
                "    {\n" +
                "      \"uuid\": \"1234\",\n" +
                "      \"public_name\": \"Wohnung in Bernau 4 Zi und Balkon\",\n" +
                "      \"reference_number\": \"\",\n" +
                "      \"internal_name\": \"Wohnung in Bernau 4 Zi und Balkon(intern)\",\n" +
                "      \"description\": \"\",\n" +
                "      \"product_ids\": [\n" +
                "        \"239e78e0-e22e-11e6-b5cd-e4a7a0ca32e8\"\n" +
                "      ]\n" +
                "    },\n" +
                "    {\n" +
                "      \"uuid\": \"1234\",\n" +
                "      \"public_name\": \"Haus am See\",\n" +
                "      \"reference_number\": \"\",\n" +
                "      \"internal_name\": \"Haus am See (intern)\",\n" +
                "      \"description\": \"Sehr schön dort\",\n" +
                "      \"product_ids\": [\n" +
                "        \"239e78e0-e22e-11e6-b5cd-e4a7a0ca32e8\"\n" +
                "      ]\n" +
                "    },\n" +
                "    {\n" +
                "      \"uuid\": \"1234\",\n" +
                "      \"public_name\": \"Wunderschöne Altbauwohnung im Herzen Berlins\",\n" +
                "      \"reference_number\": \"\",\n" +
                "      \"internal_name\": \"Wunderschöne Altbauwohnung im Herzen Berlins (intern)\",\n" +
                "      \"description\": \"\",\n" +
                "      \"product_ids\": [\n" +
                "        \"239e78e0-e22e-11e6-b5cd-e4a7a0ca32e8\"\n" +
                "      ]\n" +
                "    }\n" +
                "  ]\n" +
                "}";

        public static final String jsonAppointment = "{\n" +
                "  \"uuid\": \"1234\",\n" +
                "  \"kind\": \"models.SingleAppointment\",\n" +
                "  \"product_id\": \"239e78e0-e22e-11e6-b5cd-e4a7a0ca32e8\",\n" +
                "  \"product_name\": \"Besichtigung\",\n" +
                "  \"price\": {\n" +
                "    \"value\": \"0,00\",\n" +
                "    \"currency\": \"EUR\"\n" +
                "  },\n" +
                "  \"resource_id\": \"99a0e410-e22e-11e6-b5cd-e4a7a0ca32e8\",\n" +
                "  \"from\": \"2017-02-22T10:00:00Z\",\n" +
                "  \"to\": \"2017-02-22T10:10:00Z\",\n" +
                "  \"state\": \"unconfirmed\",\n" +
                "  \"created_by_provider\": \"false\",\n" +
                "  \"created_by_id\": \"6c919490-e22b-11e6-b7b7-e4a7a0ca32e8\",\n" +
                "  \"notes\": \"\",\n" +
                "  \"provider_uuid\": \"1234\",\n" +
                "  \"addressVisible\": false,\n" +
                "  \"addressOrigin\": \"NONE\",\n" +
                "  \"address\": null,\n" +
                "  \"customer_user_id\": \"6c919490-e22b-11e6-b7b7-e4a7a0ca32e8\",\n" +
                "  \"customer_uuid\": \"1234\",\n" +
                "  \"customer_email\": \"muellers@th-brandenburg.de\",\n" +
                "  \"customer_name\": \"Sebastian Müller\",\n" +
                "  \"customer_mobile\": \"\"\n" +
                "}";
}
