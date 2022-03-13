object Deps {
    // Android
    val androidx_core = "androidx.core:core-ktx:${Versions.androidx_core}"
    val androidx_appCompat = "androidx.appcompat:appcompat:${Versions.androidx_appCompat}"
    val androidx_constraintLayout =
        "androidx.constraintlayout:constraintlayout:${Versions.androidx_constraintLayout}"
    val materialDesign = "com.google.android.material:material:${Versions.materialDesign}"


    //dagger hilt
    const val dagger = "com.google.dagger:dagger:${Versions.dagger}"
    const val dagger_compiler = "com.google.dagger:dagger-compiler:${Versions.dagger}"
    const val legacy_support = "androidx.legacy:legacy-support-v4:${Versions.legacy_support}"

    // hilt
    const val hilt_android = "com.google.dagger:hilt-android:${Versions.hilt_android}"
    const val hilt_android_compiler =
        "com.google.dagger:hilt-android-compiler:${Versions.hilt_android}"
    const val hilt_android_gradle =
        "com.google.dagger:hilt-android-gradle-plugin:${Versions.hilt_android}"
    const val androidx_hilt_compiler =
        "androidx.hilt:hilt-compiler:${Versions.androidx_hilt_compiler}"
    val androidx_navigation_safe_args =
        "androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.androidx_navigation_safe_args}"


    //Testing
    val junit = "junit:junit:${Versions.jUnit}"
    val androidx_test_junit = "androidx.test.ext:junit:${Versions.androidx_test_junit}"
    val androidx_test_espresso =
        "androidx.test.espresso:espresso-core:${Versions.androidx_test_espresso}"
}