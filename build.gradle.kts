plugins {
    id("java-library")
    id("com.github.johnrengelman.shadow") version "8.1.1"
    kotlin("jvm") version "1.9.23"
}

group = "gg.cloudworld.geyser.protocol"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven("https://repo.opencollab.dev/main/")
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}

dependencies {
    val geyserApiVersion = "2.8.3"

    compileOnly("org.geysermc.geyser:api:$geyserApiVersion-SNAPSHOT")
    compileOnly("org.geysermc.geyser:core:$geyserApiVersion-SNAPSHOT")
}