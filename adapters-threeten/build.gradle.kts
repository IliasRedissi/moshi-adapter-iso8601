plugins {
    kotlin("jvm") version "1.3.61"
}

dependencies {
    implementation(kotlin("stdlib-jdk7"))
    implementation("com.squareup.moshi:moshi:1.9.2")
    implementation("org.threeten:threetenbp:1.4.1")
    testImplementation("junit:junit:4.13")
}