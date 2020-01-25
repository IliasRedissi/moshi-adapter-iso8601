plugins {
    kotlin("jvm") version "1.3.61"
}

group = "com.redissi"
version = "0.1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation("com.squareup.moshi:moshi:1.9.2")
    testImplementation("junit:junit:4.13")
}

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
}