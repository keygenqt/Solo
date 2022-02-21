plugins {
    id("com.android.library")
    kotlin("android")
}

val name = "pager-indicator"
version = "0.0.3"
group = "com.keygenqt.solo.pager_indicator"

android {

    compileSdk = libs.versions.compileSdk.get().toInt()

    defaultConfig {

        minSdk = libs.versions.minSdk.get().toInt()
        targetSdk = libs.versions.targetSdk.get().toInt()

        setProperty("archivesBaseName", "$name-$version")
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.composeVersion.get()
    }

    kotlinOptions {
        freeCompilerArgs = freeCompilerArgs + "-Xopt-in=kotlin.RequiresOptIn"
    }

    packagingOptions {
        resources {
            excludes.add("/META-INF/{AL2.0,LGPL2.1}")
        }
    }
}

dependencies {

    val composeVersion = libs.versions.composeVersion.get()

    implementation("androidx.compose.ui:ui:$composeVersion")
    implementation("androidx.compose.ui:ui-tooling:$composeVersion")
    implementation("androidx.compose.material:material:$composeVersion")
}