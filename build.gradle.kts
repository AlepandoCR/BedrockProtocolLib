plugins {
    kotlin("jvm") version "2.1.21"
    id("com.github.johnrengelman.shadow") version "8.1.1"
}

val geyserApiVersion = "2.8.3"

group = "gg.cloudworld.geyser.protocol"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven("https://repo.opencollab.dev/main/")
}

dependencies {
    implementation(kotlin("stdlib"))
    compileOnly("org.geysermc.geyser:api:$geyserApiVersion-SNAPSHOT")
    compileOnly("org.geysermc.geyser:core:$geyserApiVersion-SNAPSHOT")
}

kotlin {
    jvmToolchain(21)
}
