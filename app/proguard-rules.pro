# Add project specific ProGuard rules here.
# By default, the flags in this file are appended to flags specified
# in C:\androidSDKnew/tools/proguard/proguard-android.txt
# You can edit the include path and order by changing the proguardFiles
# directive in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# Add any project specific keep options here:

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

#   compile "com.github.buchandersenn:android-permission-manager:$ANDROID_PERMISSION_MANAGER_VERSION"



#   compile group: 'org.apache.commons', name: 'commons-lang3', version: '3.4'
#   compile group: 'commons-io', name: 'commons-io', version: '2.5'



#   compile "com.squareup.retrofit2:converter-jackson:$RETROFIT_VERSION"
#   compile "com.squareup.retrofit2:adapter-rxjava:$RETROFIT_VERSION"
#   compile 'com.squareup.okhttp3:logging-interceptor:3.5.0'
#   compile 'com.github.franmontiel:PersistentCookieJar:v1.0.0'

#   //dagger
#   compile "com.google.dagger:dagger:$DAGGER_VERSION"
#   provided 'org.glassfish:javax.annotation:10.0-b28' //Required by Dagger2
#   apt daggerCompiler
#   testApt daggerCompiler
#   androidTestApt daggerCompiler

#   //64k limit
#   compile "com.android.support:multidex:$MULTIDEX_VERSION"

##################### Retrofit ############################
# Platform calls Class.forName on types which do not exist on Android to determine platform.
-dontnote retrofit2.Platform
# Platform used when running on RoboVM on iOS. Will not be used at runtime.
-dontnote retrofit2.Platform$IOS$MainThreadExecutor
# Platform used when running on Java 8 VMs. Will not be used at runtime.
-dontwarn retrofit2.Platform$Java8
# Retain generic type information for use by reflection by converters and adapters.
-keepattributes Signature
# Retain declared checked exceptions for use by a Proxy instance.
-keepattributes Exceptions



##################### rxAndroid ############################
-keepclassmembers class rx.internal.util.unsafe.** {
    long producerIndex;
    long consumerIndex;
}

##################### Jackson ############################
-keepattributes *Annotation*,EnclosingMethod,Signature
-keepnames class com.fasterxml.jackson.** { *; }
-dontwarn com.fasterxml.jackson.databind.**
-keep class org.codehaus.** { *; }
-keepclassmembers public final enum org.codehaus.jackson.annotate.JsonAutoDetect$Visibility {
public static final org.codehaus.jackson.annotate.JsonAutoDetect$Visibility *; }
-keep public class your.class.** {
  *;
}

##################### Butterknife ############################
# Retain generated class which implement Unbinder.
-keep public class * implements butterknife.Unbinder { public <init>(...); }

# Prevent obfuscation of types which use ButterKnife annotations since the simple name
# is used to reflectively look up the generated ViewBinding.
-keep class butterknife.*
-keepclasseswithmembernames class * { @butterknife.* <methods>; }
-keepclasseswithmembernames class * { @butterknife.* <fields>; }

##################### Iconics ############################
-keep class .R
-keep class **.R$* {
    <fields>;
}

##################### Icepick ############################
-dontwarn icepick.**
-keep class icepick.** { *; }
-keep class **$$Icepick { *; }
-keepclasseswithmembernames class * {
    @icepick.* <fields>;
}
-keepnames class * { @icepick.State *;}

##################### Retrolambda ############################
-dontwarn java.lang.invoke.*

##################### Okio - this imported by THIS app! Some other library does so :( ############################
-dontwarn okio.**