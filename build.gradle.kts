buildscript {
    repositories {
        gradlePluginPortal()
        jcenter()
        google()
        mavenCentral()
        maven("https://dl.bintray.com/icerockdev/plugins")
        maven {
            setUrl("https://dl.bintray.com/ekito/koin")
        }
    }
    dependencies {
        classpath(kotlin("gradle-plugin", Versions.kotlin))
        classpath(Deps.androidGradlePlugin)
        classpath("dev.icerock.moko:resources-generator:${Versions.mokoResources}")
        classpath("com.google.dagger:hilt-android-gradle-plugin:${Versions.hilt}")
        classpath("androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.navigation}")
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
        jcenter()
        maven(url = "https://kotlin.bintray.com/kotlinx")
        //maven(url = "https://dl.bintray.com/ekito/koin") TODO: revert when Koin is available
        maven(url = "https://dl.bintray.com/touchlabpublic/kotlin")
        maven(url = "https://oss.sonatype.org/content/repositories/snapshots/")
    }
}
group = "com.tsquaredapps.liquidmultiplatform"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

allprojects {
    repositories {
        maven("https://dl.bintray.com/icerockdev/moko")
    }
}