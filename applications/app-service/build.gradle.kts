plugins {
    java
    id("org.springframework.boot") version "3.3.1"
    id("io.spring.dependency-management") version "1.1.5"
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
    // Dependencias locales
    implementation(project(":applications:usecase"))
    implementation(project(":domain:model"))
    implementation(project(":domain:usecase"))
    implementation(project(":infrastructure:driven-adapters"))
    implementation(project(":infrastructure:entry-points:reactive-web-api"))

    // Spring Boot y R2DBC
    implementation("org.springframework.boot:spring-boot-starter-webflux:3.3.1")
    implementation("org.springframework.boot:spring-boot-starter-data-r2dbc:3.3.1")
    implementation("io.r2dbc:r2dbc-postgresql:0.8.2.RELEASE")

    // Swagger
    implementation("org.springdoc:springdoc-openapi-starter-webflux-ui:2.2.0")

    // Lombok
    compileOnly("org.projectlombok:lombok:1.18.28")
    annotationProcessor("org.projectlombok:lombok:1.18.28")

    // Tests
    testImplementation("org.springframework.boot:spring-boot-starter-test:3.3.1")
    testImplementation("io.projectreactor:reactor-test:3.5.12")
}

// Configuración de BootJar
tasks.withType<org.springframework.boot.gradle.tasks.bundling.BootJar> {
    archiveFileName.set("app-service.jar")
    mainClass.set("co.com.crediya.solicitudes.appservice.AppServiceApplication")
}

tasks.withType<org.springframework.boot.gradle.tasks.run.BootRun> {
    mainClass.set("co.com.crediya.solicitudes.appservice.AppServiceApplication")
}
