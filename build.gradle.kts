plugins {
    java
    application
}

repositories {
    mavenCentral()
}

<<<<<<< HEAD
dependencies {
    //JUnit API
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.9.3")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.9.3")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

application {
    val main: String? by project
    mainClass.set(main ?: "snakerunner.core.Main")
}

tasks.test {
    useJUnitPlatform()
}

=======
application {
    val main: String? by project
    mainClass.set(main ?: "snakerunner.core.Main")
}
>>>>>>> ab5f6f4 (Added build.gradle.kts & setting.gradle.kts)
