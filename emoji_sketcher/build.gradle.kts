plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlin-android")
    id("kotlin-kapt")
    id("maven-publish")
}
android {
    namespace = "com.softsuave.emoji_sketcher"
    compileSdk = 34

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
    buildFeatures {
        viewBinding = true
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
/*publishing {
    publications {
        register<MavenPublication>("release") {
            groupId = "softsuave-tech-matrix"
            artifactId = "emoji-sketcher"
            version = "1.0.1"

            afterEvaluate {
                from(components["release"])
            }
        }
    }
}*/
publishing {
//    repositories {
//        maven {
//            name = "GitHubPackages"
//            url = uri("https://maven.pkg.github.com/softsuave-tech-matrix/emoji_sketcher")
//            credentials {
//                username = project.findProperty("gpr.user").toString()
//                password = project.findProperty("gpr.token").toString()
//            }
//        }
//    }
    publications {

        register<MavenPublication>("release") {
            afterEvaluate {
                from(components["release"])
                groupId = "softsuave_tech_matrix"
                artifactId = "emoji_sketcher"
                version = "4.1.2"
            }
        }
    }
}
dependencies {

    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.7.0")

    implementation("androidx.core:core-ktx:1.13.1")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("androidx.recyclerview:recyclerview:1.3.2")
    implementation("androidx.recyclerview:recyclerview-selection:1.1.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    // dagger
    implementation("com.google.dagger:dagger:2.48")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    annotationProcessor("com.google.dagger:dagger-compiler:2.48")
    kapt("com.google.dagger:dagger-compiler:2.48")
    androidTestImplementation("com.google.dagger:dagger:2.48")
    androidTestAnnotationProcessor("com.google.dagger:dagger-compiler:2.48")
    kaptAndroidTest("com.google.dagger:dagger-compiler:2.48")
    //Timber
    implementation("com.jakewharton.timber:timber:4.7.1")
    //RxJava
    implementation("io.reactivex.rxjava2:rxjava:2.2.10")
    //RxAndroid
    implementation("io.reactivex.rxjava2:rxandroid:2.1.1")
    implementation("com.jakewharton.rxbinding3:rxbinding:3.0.0")
    implementation("com.jakewharton.rxbinding3:rxbinding-appcompat:3.0.0")
    implementation("com.jakewharton.rxbinding3:rxbinding-material:3.0.0")

    // retrofit
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:adapter-rxjava2:2.6.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("com.squareup.okhttp3:logging-interceptor:4.9.3")

}