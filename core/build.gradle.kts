plugins {
    kotlin("jvm")
}

dependencies {
    val implementation by configurations
    implementation(kotlin("stdlib"))
    implementation("org.jetbrains.exposed:exposed-core:0.23.1")
    implementation("org.jetbrains.exposed:exposed-dao:0.23.1")
    implementation("org.jetbrains.exposed:exposed-jdbc:0.23.1")
}