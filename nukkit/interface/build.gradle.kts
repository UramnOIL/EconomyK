import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

version = "0.1"

plugins {
    kotlin("jvm")
}

repositories {
}

dependencies {
    implementation(project(":core"))
    compileOnly(kotlin("stdlib-jdk8"))
    compileOnly("cn.nukkit:nukkit:1.0-SNAPSHOT")
    implementation("com.uramnoil:knukkitutils:0.1.6")
}
val compileKotlin: KotlinCompile by tasks
compileKotlin.kotlinOptions {
	freeCompilerArgs = listOf("-XXLanguage:+InlineClasses")
}