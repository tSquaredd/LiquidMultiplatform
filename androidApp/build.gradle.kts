plugins {
    id("com.android.application")
    kotlin("android")
    id("kotlin-android-extensions")
    id("kotlin-android")
    id("kotlin-kapt")
    id("androidx.navigation.safeargs.kotlin")
    id("dagger.hilt.android.plugin")
}
group = "com.tsquaredapps.liquidmultiplatform"
version = "1.0-SNAPSHOT"

repositories {
    gradlePluginPortal()
    google()
    jcenter()
    mavenCentral()
}

android {
    compileSdkVersion(Versions.compileSdk)
    buildToolsVersion = Versions.buildToolsVersion
    defaultConfig {
        applicationId = "com.tsquaredapps.liquidmultiplatform.androidApp"
        minSdkVersion(Versions.minSdk)
        targetSdkVersion(Versions.targetSdk)
        versionCode = 1
        versionName = "1.0"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }

    buildFeatures {
        viewBinding = true
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {
    implementation(kotlin("stdlib-jdk7", org.jetbrains.kotlin.config.KotlinCompilerVersion.VERSION))
    implementation(project(":shared"))
    implementation(Deps.Android.Material.android)
    implementation(Deps.Android.AppCompat.core)
    implementation(Deps.Android.ConstraintLayout.core)
    implementation("org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin}")
    implementation("androidx.legacy:legacy-support-v4:1.0.0")

    // Navigation
    implementation(Deps.Android.Navigation.fragment)
    implementation(Deps.Android.Navigation.ui)
    implementation(Deps.Android.Navigation.runtime)
    androidTestImplementation(Deps.Android.Navigation.testing)


    implementation(Deps.Android.Hilt.core)
    kapt(Deps.Android.Hilt.compiler)
}
