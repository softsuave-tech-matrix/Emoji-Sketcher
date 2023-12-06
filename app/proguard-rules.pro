# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile

#-keep class okhttp3.** { *; }
#-keep interface okhttp3.** { *; }
#-dontwarn okhttp3.**
#-dontnote okhttp3.**
#
#-keepclassmembers class softsuave.tech_matrix.emoji_sketcher.api** { <fields>;}
#-keepclassmembers class softsuave.tech_matrix.emoji_sketcher.model** { <fields>;}
#-keepclassmembers class softsuave.tech_matrix.emoji_sketcher.data** { <fields>;}
#-keepclassmembers class softsuave.tech_matrix.emoji_sketcher.di** { <fields>;}
#
#-keep class com.google.crypto.** { *; }  #For app crash when open the app
#
#-keep class **$$Parcelable { *; }
#
#-keep class androidx.appcompat.widget.** { *; }
#-keep class softsuave.tech_matrix.emoji_sketcher.ui.EmojiDrawPresenter { *; }
#
## RxJava
#-dontwarn rx.**
#-keep class rx.** { *; }
#-keep interface rx.** { *; }
#-dontwarn sun.misc.Unsafe
## If using RxJava 2, add these rules:
#-dontwarn io.reactivex.**
#-keep class io.reactivex.** { *; }
#-keep interface io.reactivex.** { *; }
#
## Retrofit
#-dontwarn retrofit2.**
#-keep class retrofit2.** { *; }
#-keepattributes Signature
#-keepattributes Exceptions
#-keepclasseswithmembers class * {
#    @retrofit2.http.* <methods>;
#}