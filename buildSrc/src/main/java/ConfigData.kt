import org.gradle.api.JavaVersion

object ConfigData {
    const val minSdkVersion = 23
    const val compileSdkVersion = 31
    const val targetSdkVersion = 31
    const val versionCode = 1
    const val versionName = "1.0"
    const val buildToolsVersion = "30.0.3"

    @JvmField
    val javaVersion = JavaVersion.VERSION_11
}