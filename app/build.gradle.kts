plugins {
    id("com.android.application")
}

android {
    namespace = "com.example.androiduitesting"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.androiduitesting"
        minSdk = 24
        targetSdk = 33
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
        // 你项目是 Java，保持 1.8 即可
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.10.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")

    // 单元测试
    testImplementation("junit:junit:4.13.2")

    // 仪器测试（AndroidX Test）
    // junit 扩展：提供 AndroidJUnit4
    androidTestImplementation("androidx.test.ext:junit:1.2.1")
    // Runner（也包含 filters 包，提供 @LargeTest 等注解）
    androidTestImplementation("androidx.test:runner:1.6.2")
    // Espresso
    androidTestImplementation("androidx.test.espresso:espresso-core:3.6.1")
    // 如需 ActivityScenario 等规则，可再加（可选）
    androidTestImplementation("androidx.test:rules:1.6.1")
}
