val GROUP: String by project
val VERSION_NAME: String by project

group = GROUP

subprojects {
    version = VERSION_NAME

    repositories {
        mavenCentral()
    }
}