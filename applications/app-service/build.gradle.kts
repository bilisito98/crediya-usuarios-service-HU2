plugins {
    id("org.springframework.boot") version "3.3.1"
    id("io.spring.dependency-management") version "1.1.5"
    kotlin("jvm") version "1.9.10"
    kotlin("plugin.spring") version "1.9.10"
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
    implementation(project(":domain:usecase"))
    implementation(project(":infrastructure:entity"))
    implementation(project(":infrastructure:driven-adapters"))

    // Spring Boot Starters
    implementation("org.springframework.boot:spring-boot-starter-webflux:3.3.1")
    implementation("org.springframework.boot:spring-boot-starter-data-r2dbc:3.3.1")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa:3.3.1")

    // R2DBC Postgres (versión estable)
    implementation("io.r2dbc:r2dbc-postgresql:0.8.13.RELEASE")
    implementation("org.postgresql:postgresql:42.7.3")

    // Flyway
    implementation("org.flywaydb:flyway-core:10.20.0")

    // Validación
    implementation("org.springframework.boot:spring-boot-starter-validation:3.3.1")

    // OpenAPI/Swagger
    implementation("org.springdoc:springdoc-openapi-starter-webflux-ui:2.3.0")

    // Jackson + Kotlin
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.17.1")
    implementation("org.jetbrains.kotlin:kotlin-reflect:1.9.10")

    // Lombok
    compileOnly("org.projectlombok:lombok:1.18.32")
    annotationProcessor("org.projectlombok:lombok:1.18.32")

    // Tests
    testCompileOnly("org.projectlombok:lombok:1.18.32")
    testAnnotationProcessor("org.projectlombok:lombok:1.18.32")
    testImplementation("org.springframework.boot:spring-boot-starter-test:3.3.1")
}


// Configuración de BootJar
tasks.withType<org.springframework.boot.gradle.tasks.bundling.BootJar> {
    archiveFileName.set("app-service.jar")
    mainClass.set("co.com.crediya.solicitudes.appservice.AppServiceApplication")
}

tasks.withType<org.springframework.boot.gradle.tasks.run.BootRun> {
    mainClass.set("co.com.crediya.solicitudes.appservice.AppServiceApplication")
}
