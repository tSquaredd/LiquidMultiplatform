import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget

plugins {
    kotlin("multiplatform")
    id("com.android.library")
    id("kotlin-android-extensions")
    id("dev.icerock.mobile.multiplatform-resources")
}
group = "com.tsquaredapps.liquidmultiplatform"
version = "1.0-SNAPSHOT"

repositories {
    gradlePluginPortal()
    google()
    jcenter()
    mavenCentral()
}
kotlin {
    android()
    ios {
        binaries {
            framework {
                baseName = "shared"
            }
        }
    }
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(Deps.Coroutines.common)
                implementation(Deps.Coroutines.common)
                implementation(Deps.Koin.core)
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(Deps.KotlinTest.common)
                implementation(Deps.KotlinTest.annotations)
                implementation(Deps.Koin.test)
                implementation(Deps.JUnit.core)
                runtimeOnly(Deps.JUnit.engine)
                implementation(Deps.JUnit.params)
                implementation(Deps.MockK.core)
            }
        }
        val androidMain by getting {
            dependencies {
                implementation(kotlin("stdlib", Versions.kotlin))
                implementation(Deps.Coroutines.android)
            }
        }
        val androidTest by getting {
            dependencies {
                implementation(Deps.KotlinTest.jvm)
                implementation(Deps.KotlinTest.junit)
                implementation(Deps.AndroidXTest.core)
                implementation(Deps.AndroidXTest.junit)
                implementation(Deps.AndroidXTest.runner)
                implementation(Deps.AndroidXTest.rules)
                implementation(Deps.Coroutines.test)
            }
        }
        val iosMain by getting {
            dependencies {
                implementation(Deps.Coroutines.common) {
                    version {
                        strictly(Versions.coroutines)
                    }
                }
                implementation(Deps.Koin.core)
            }
        }
    }
}
android {
    compileSdkVersion(Versions.compileSdk)
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    defaultConfig {
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
}

dependencies {
    commonMainApi(Deps.Moko.core)
    commonMainImplementation(Deps.Moko.parcelize)
    commonMainImplementation(Deps.Moko.graphics)
}

multiplatformResources {
    multiplatformResourcesPackage = "com.tsquaredapps.liquidmultiplatform" // required
    iosBaseLocalizationRegion = "en" // optional, default "en"
    multiplatformResourcesSourceSet = "commonMain"  // optional, default "commonMain"
}

val packForXcode by tasks.creating(Sync::class) {
    group = "build"
    val mode = System.getenv("CONFIGURATION") ?: "DEBUG"
    val sdkName = System.getenv("SDK_NAME") ?: "iphonesimulator"
    val targetName = "ios" + if (sdkName.startsWith("iphoneos")) "Arm64" else "X64"
    val framework =
        kotlin.targets.getByName<KotlinNativeTarget>(targetName).binaries.getFramework(mode)
    inputs.property("mode", mode)
    dependsOn(framework.linkTask)
    val targetDir = File(buildDir, "xcode-frameworks")
    from({ framework.outputDirectory })
    into(targetDir)
}
tasks.getByName("build").dependsOn(packForXcode)