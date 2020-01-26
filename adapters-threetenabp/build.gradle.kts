plugins {
    kotlin("jvm") version "1.3.61"
}

dependencies {
    implementation(kotlin("stdlib-jdk7"))
    implementation("com.squareup.moshi:moshi:1.9.2")
    implementation("com.jakewharton.threetenabp:threetenabp:1.2.2")
    testImplementation("junit:junit:4.13")
}

apply("$rootDir/gradle/gradle-mvn-push.gradle")