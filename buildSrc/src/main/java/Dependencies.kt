object Deps {
    // Android
    const val androidx_core = "androidx.core:core-ktx:${Versions.androidx_core}"
    const val androidx_appCompat = "androidx.appcompat:appcompat:${Versions.androidx_appCompat}"
    const val androidx_constraintLayout =
        "androidx.constraintlayout:constraintlayout:${Versions.androidx_constraintLayout}"
    const val androidx_navigation_safe_args =
        "androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.androidx_navigation_safe_args}"
    const val androidx_navigation_fragment =
        "androidx.navigation:navigation-fragment-ktx:${Versions.androidx_navigation}"
    const val androidx_navigation_ui =
        "androidx.navigation:navigation-ui-ktx:${Versions.androidx_navigation}"
    const val androidx_activity = "androidx.activity:activity-ktx:${Versions.androidx_activity}"
    const val androidx_fragment = "androidx.fragment:fragment-ktx:${Versions.androidx_fragment}"
    const val materialDesign = "com.google.android.material:material:${Versions.materialDesign}"

    // Lifecycle
    const val androidx_lifecycle_livedata =
        "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycle_version}"
    const val androidx_lifecycle_runtime =
        "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycle_version}"
    const val androidx_lifecycle_viewmodel =
        "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle_version}"
    const val androidx_lifecycle_common =
        "androidx.lifecycle:lifecycle-common-java8:${Versions.lifecycle_version}"

    // Dagger Hilt
    const val dagger = "com.google.dagger:dagger:${Versions.dagger}"
    const val dagger_compiler = "com.google.dagger:dagger-compiler:${Versions.dagger}"
    const val legacy_support = "androidx.legacy:legacy-support-v4:${Versions.legacy_support}"

    // Hilt
    const val hilt_android = "com.google.dagger:hilt-android:${Versions.hilt_android}"
    const val hilt_android_compiler =
        "com.google.dagger:hilt-android-compiler:${Versions.hilt_android}"
    const val hilt_android_gradle =
        "com.google.dagger:hilt-android-gradle-plugin:${Versions.hilt_android}"
    const val androidx_hilt_compiler =
        "androidx.hilt:hilt-compiler:${Versions.androidx_hilt_compiler}"

    // Retrofit with rxjava
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val retrofit_converter_gson = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
    const val retrofit2_rxjava2_adapter =
        "com.jakewharton.retrofit:retrofit2-rxjava2-adapter:${Versions.retrofit2_rxjava2_adapter}"
    const val rxjava2 = "io.reactivex.rxjava2:rxjava:${Versions.rxjava2}"
    const val rxjava2_rxandroid = "io.reactivex.rxjava2:rxandroid:${Versions.rxjava2_rxandroid}"

    // Coroutines
    const val coroutine_version_core =
        "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutine_version}"
    const val coroutine_version_android =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutine_version}"

    //Picasso
    const val picasso = "com.squareup.picasso:picasso:${Versions.picasso}"

    // GUI Scalability
    const val gui_scalability_density_independant_pixels = "com.intuit.sdp:sdp-android:${Versions.gui_scalability}"
    const val gui_scalability_scale_independant_pixels = "com.intuit.ssp:ssp-android:${Versions.gui_scalability}"


    // Testing
    const val androidx_test_junit_ktx = "androidx.test.ext:junit-ktx:${Versions.androidx_test_junit}"
    const val androidx_test_core_ktx =  "androidx.test:core-ktx:${Versions.androidx_test}"
    const val robolectric = "org.robolectric:robolectric:${Versions.robolectric}"
    const val androidx_arch_core_testing = "androidx.arch.core:core-testing:${Versions.androidx_arch_core_testing}"

    const val androidx_test_runner = "androidx.test:runner:${Versions.androidx_test}"
    const val androidx_test_espresso = "androidx.test.espresso:espresso-core:${Versions.androidx_test_espresso}"
    const val androidx_test_rules = "androidx.test:rules:${Versions.androidx_test}"
    const val androidx_test_ext = "androidx.test.ext:truth:${Versions.androidx_test}"
    const val androidx_test_junit = "androidx.test.ext:junit:${Versions.androidx_test_junit}"

}