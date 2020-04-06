import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.3.71" apply false
}

group = "com.uramnoil"

subprojects {
    repositories {
        jcenter()
        maven {
            url = uri("https://repo.nukkitx.com/main/")
        }
    }

    tasks.withType<KotlinCompile> {
        kotlinOptions.jvmTarget = "1.8"
        kotlinOptions.freeCompilerArgs += "-Xuse-experimental=kotlin.Experimental"
    }
}
