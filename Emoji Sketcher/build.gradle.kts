plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id ("maven-publish")
}

android {
    namespace = "softsuave.tech_matrix.emoji_sketcher"
    compileSdk = 33

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    kapt {
        generateStubs = true
    }
}
afterEvaluate {
    publishing {
        publications {
            create<MavenPublication>("maven") {
                groupId = "softsuave-tech-matrix"
                artifactId = "emoji-sketcher"
                version = "0.0.4"

                from(components["release"])
            }
        }
        repositories {
            maven {
                url = uri("https://jitpack.io")
            }
        }
    }
}


dependencies {
    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.10.0")
    implementation("androidx.compose.ui:ui-graphics-android:1.5.4")
    implementation(project(mapOf("path" to ":app")))
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    implementation("androidx.recyclerview:recyclerview:1.3.2")
    implementation("androidx.recyclerview:recyclerview-selection:1.1.0")
    implementation ("androidx.constraintlayout:constraintlayout:2.1.4")

    // dagger
    implementation ("com.google.dagger:dagger:2.28.3")
    annotationProcessor ("com.google.dagger:dagger-compiler:2.24")
    kapt ("com.google.dagger:dagger-compiler:2.24")
    androidTestImplementation ("com.google.dagger:dagger:2.28.3")
    androidTestAnnotationProcessor ("com.google.dagger:dagger-compiler:2.24")
    kaptAndroidTest ("com.google.dagger:dagger-compiler:2.24")

    testImplementation ("junit:junit:4.13.2")

    androidTestImplementation ("com.android.support.test:runner:1.0.2")

    androidTestImplementation ("com.squareup.assertj:assertj-android:1.2.0")
    androidTestImplementation  ("org.assertj:assertj-core:3.6.2")

    testImplementation ("org.mockito:mockito-core:2.19.0")
    testImplementation ("com.nhaarman.mockitokotlin2:mockito-kotlin:2.0.0-RC1")

    implementation ("org.jetbrains.kotlin:kotlin-stdlib-jdk7:1.9.0")

    //RxJava
    implementation("io.reactivex.rxjava2:rxjava:2.2.10")
    //RxAndroid
    implementation("io.reactivex.rxjava2:rxandroid:2.1.1")
    implementation("com.jakewharton.rxbinding3:rxbinding:3.0.0")
    implementation("com.jakewharton.rxbinding3:rxbinding-appcompat:3.0.0")
    implementation("com.jakewharton.rxbinding3:rxbinding-material:3.0.0")

    implementation ("androidx.lifecycle:lifecycle-extensions:2.2.0")
    implementation ("androidx.fragment:fragment-ktx:1.6.2")
    implementation ("com.jakewharton.timber:timber:4.7.1")

    // retrofit
    implementation ("com.squareup.retrofit2:retrofit:2.9.0")
    implementation ("com.squareup.retrofit2:adapter-rxjava2:2.6.0")
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation ("com.squareup.okhttp3:logging-interceptor:4.9.3")
}