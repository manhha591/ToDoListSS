plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.example.todolistss"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.todolistss"
        minSdk = 24
        targetSdk = 34
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    buildFeatures {
        viewBinding = true
    }
}


dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.constraintlayout)
    implementation(libs.lifecycle.livedata.ktx)
    implementation(libs.lifecycle.viewmodel.ktx)
    implementation(libs.navigation.fragment)
    implementation(libs.navigation.ui)
    implementation(libs.activity)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
    implementation("com.github.myDario:DarioWeekViewDatePicker:1.0.3")
    //implementation ("com.ramijemli.percentagechartview:percentagechartview:0.3.1")
    implementation ("androidx.fragment:fragment-ktx:1.3.6")
    implementation ("androidx.viewpager2:viewpager2:1.0.0")
}