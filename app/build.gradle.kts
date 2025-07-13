plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
//    id("com.google.devtools.ksp") version "2.1.21-2.0.1"
    alias (libs.plugins.hilt.application)
    id("kotlin-kapt")
    alias(libs.plugins.google.gms.google.services)
}

android {
    namespace = "com.example.shoplyecommerceapp"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.shoplyecommerceapp"
        minSdk = 35
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }

    buildFeatures {
        viewBinding = true
        compose = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.credentials)
    implementation(libs.androidx.credentials.play.services.auth)
    implementation(libs.googleid)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
    implementation(libs.androidx.fragment.ktx)
    implementation(libs.constraintlayout)
    implementation(libs.androidx.appcompat)
    implementation(libs.recyclerview)
    implementation(libs.material)
    implementation(libs.androidx.viewpager2)

    //dot
    implementation(libs.dotsindicator)

    //live data
    implementation(libs.androidx.lifecycle.livedata.ktx)

    //view model
    implementation(libs.androidx.lifecycle.viewmodel.ktx)

    // daggle hilt
    implementation (libs.hilt.android)
    kapt (libs.hilt.android.compiler)

    //Glide
    implementation(libs.glide)

    //retrofit
    implementation(libs.retrofit)

    //Firebase
    implementation(libs.firebase.auth)

    //coroutine
    implementation(libs.kotlinx.coroutines.android)
}