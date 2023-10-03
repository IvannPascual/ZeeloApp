plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlinx-serialization")
    id("kotlin-kapt")
}

android {
    namespace = "com.common.data"
    compileSdk = libs.versions.compileSdk.get().toInt()

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = libs.versions.jvmTarget.get()
    }
}

dependencies {
    implementation(libs.coroutine.core)
    implementation(libs.kotlinx.serialization)
    implementation(libs.hilt.android)
    implementation(project(":common:domain"))
    api(project(":core:libs:database"))

    kapt(libs.hilt.compiler)
    implementation(libs.hilt.navigation.compose)
}