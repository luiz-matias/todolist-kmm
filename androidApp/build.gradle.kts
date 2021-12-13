plugins {
    id("com.android.application")
    kotlin("android")
    id("kotlin-android")
}

android {
    compileSdk = 31
    defaultConfig {
        applicationId = "com.luizmatias.todoapp.android"
        minSdk = 21
        targetSdk = 31
        versionCode = 1
        versionName = "1.0"
        vectorDrawables {
            useSupportLibrary = true
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.1.0-beta04"
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation(project(":shared"))

    //Compose
    implementation("com.google.android.material:material:1.6.0-alpha01")
    implementation("androidx.compose.foundation:foundation:1.1.0-beta04")
    implementation("androidx.compose.foundation:foundation-layout:1.1.0-beta04")
    //implementation("androidx.compose.material:material:1.1.0-beta04")
    implementation("androidx.compose.material3:material3:1.0.0-alpha02")
    implementation("androidx.activity:activity-compose:1.4.0")
    implementation("androidx.compose.ui:ui:1.1.0-beta04")
    implementation("androidx.compose.ui:ui-tooling-preview:1.1.0-beta04")
    debugImplementation("androidx.compose.ui:ui-tooling:1.1.0-beta04")
    androidTestImplementation("androidx.compose.ui:ui-test-junit4:1.1.0-beta04")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.4.0")

    //Koin for DI
    implementation("io.insert-koin:koin-core:3.1.4")
    implementation("io.insert-koin:koin-android:3.1.4")
    implementation("io.insert-koin:koin-androidx-compose:3.1.4")
    testImplementation("io.insert-koin:koin-test:3.1.4")
    testImplementation("io.insert-koin:koin-test-junit4:3.1.4")

    //Layout dependencies
    implementation("com.google.android.material:material:1.4.0")
    implementation("androidx.appcompat:appcompat:1.4.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.2")
}