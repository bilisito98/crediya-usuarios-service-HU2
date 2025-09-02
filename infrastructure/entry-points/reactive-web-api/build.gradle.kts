plugins {
    kotlin("jvm") version "1.9.10"
    id("io.spring.dependency-management") version "1.1.5"
    `java-library`
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

    implementation("org.springframework.boot:spring-boot-starter-webflux")
    implementation("io.projectreactor:reactor-core:3.5.12")
}

