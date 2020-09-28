buildscript {
    val kotlin_version by extra("1.4.10")
    repositories {
        gradlePluginPortal()
        jcenter()
        google()
        mavenCentral()
        maven("https://dl.bintray.com/icerockdev/plugins")
    }
    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.4.10")
        classpath("com.android.tools.build:gradle:4.1.0-rc03")
        classpath("dev.icerock.moko:resources-generator:0.13.1")
    }
}
group = "com.tsquaredapps.liquidmutliplatform"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

allprojects {
    repositories {
        maven("https://dl.bintray.com/icerockdev/moko")
    }
}