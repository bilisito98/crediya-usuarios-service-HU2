plugins {
    kotlin("jvm") version "1.9.10"
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":domain:model"))
    implementation(kotlin("stdlib"))
    implementation("io.projectreactor:reactor-core:3.5.12")
    // Logging
    implementation("org.slf4j:slf4j-api:2.0.9")

    // Spring Transaction
    implementation("org.springframework:spring-tx:6.1.11")

    // Reactor
    implementation("io.projectreactor:reactor-core:3.5.14")

    compileOnly("org.projectlombok:lombok:1.18.32")
    annotationProcessor("org.projectlombok:lombok:1.18.32")

}
