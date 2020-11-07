object Versions {
    val kotlin = "1.4.10"
    val coroutines = "1.4.0-M1"
    val androidxTest = "1.2.0"
    val androidxTestExt = "1.1.1"
    val koin = "3.0.1-alpha-2"
    val junit = "5.3.2"
    val mockk = "1.9.3"
    val buildToolsVersion = "29.0.0"

    val mokoResources = "0.13.1"
    val mokoOther = "0.4.0"

    val minSdk = 24
    val targetSdk = 29
    val compileSdk = 29
    val navigation = "2.3.0"
    val material = "1.2.1"
    val appCompat = "1.2.0"
    val constraintLayout = "2.0.2"
    val androidGradlePlugin = "4.1.0"
    val hilt = "2.28-alpha"
}

object Deps {

    val androidGradlePlugin = "com.android.tools.build:gradle:${Versions.androidGradlePlugin}"

    object Coroutines {
        val common = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
        val android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"
        val test = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.coroutines}"
    }

    object KotlinTest {
        val common = "org.jetbrains.kotlin:kotlin-test-common:${Versions.kotlin}"
        val annotations = "org.jetbrains.kotlin:kotlin-test-annotations-common:${Versions.kotlin}"
        val jvm = "org.jetbrains.kotlin:kotlin-test:${Versions.kotlin}"
        val junit = "org.jetbrains.kotlin:kotlin-test-junit:${Versions.kotlin}"
    }

    object AndroidXTest {
        val core = "androidx.test:core:${Versions.androidxTest}"
        val junit = "androidx.test.ext:junit:${Versions.androidxTestExt}"
        val runner = "androidx.test:runner:${Versions.androidxTest}"
        val rules = "androidx.test:rules:${Versions.androidxTest}"
    }

    object Koin {
        val core = "org.koin:koin-core:${Versions.koin}"
        val test = "org.koin:koin-test:${Versions.koin}"
    }

    object JUnit {
        val core = "org.junit.jupiter:junit-jupiter-api:${Versions.junit}"
        val engine = "org.junit.jupiter:junit-jupiter-engine:${Versions.junit}"
        val params = "org.junit.jupiter:junit-jupiter-params:${Versions.junit}"
    }

    object MockK {
        val core = "io.mockk:mockk:${Versions.mockk}"
    }

    object Moko {
        val core = "dev.icerock.moko:resources:${Versions.mokoResources}"
        val parcelize = "dev.icerock.moko:parcelize:${Versions.mokoOther}"
        val graphics = "dev.icerock.moko:graphics:${Versions.mokoOther}"
    }

    object Android {
        object Material {
            val android = "com.google.android.material:material:${Versions.material}"
        }

        object AppCompat {
            val core = "androidx.appcompat:appcompat:${Versions.appCompat}"
        }

        object ConstraintLayout {
            val core = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
        }

        object Navigation {
            val fragment = "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}"
            val ui = "androidx.navigation:navigation-ui-ktx:${Versions.navigation}"
            val runtime = "androidx.navigation:navigation-runtime-ktx:${Versions.navigation}"
            val testing = "androidx.navigation:navigation-testing:${Versions.navigation}"
        }

        object Hilt {
            val core = "com.google.dagger:hilt-android:${Versions.hilt}"
            val compiler = "com.google.dagger:hilt-android-compiler:${Versions.hilt}"
        }
    }
}