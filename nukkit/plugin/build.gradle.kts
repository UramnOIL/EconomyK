plugins {
    kotlin("jvm")
    id("net.minecrell.plugin-yml.nukkit") version "0.3.0"
}

version = "0.1"

repositories {
}

dependencies {
    implementation(project(":core"))
    implementation(project(":nukkit:interface"))
    implementation(kotlin("stdlib-jdk8"))
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.3.5")
    implementation("com.uramnoil:knukkitutils:0.1.6")
    compileOnly("cn.nukkit:nukkit:1.0-SNAPSHOT")
}
