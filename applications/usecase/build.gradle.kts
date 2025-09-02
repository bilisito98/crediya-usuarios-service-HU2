plugins {
    java
}

group = "co.com.crediya"
version = "1.0.0-SNAPSHOT"

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}

repositories {
    mavenCentral()
}

dependencies {
    // Dependencias de dominio
    implementation(project(":domain:model"))
    implementation(project(":domain:usecase"))

    // Lombok
    compileOnly("org.projectlombok:lombok:1.18.28")
    annotationProcessor("org.projectlombok:lombok:1.18.28")

    // Logging
    implementation("org.slf4j:slf4j-api:2.0.9")

    // Spring Transaction
    implementation("org.springframework:spring-tx:6.1.11")

    // Reactor
    implementation("io.projectreactor:reactor-core:3.5.14")
}
