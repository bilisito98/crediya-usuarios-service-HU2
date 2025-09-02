plugins {
    id("org.springframework.boot") version "3.3.1" apply false
    id("io.spring.dependency-management")
    kotlin("jvm") version "1.9.10" apply false
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

    // ---- WebFlux
    implementation("org.springframework.boot:spring-boot-starter-webflux")

    // ---- R2DBC
    implementation("org.springframework.boot:spring-boot-starter-data-r2dbc")
    implementation("io.r2dbc:r2dbc-postgresql:0.8.2.RELEASE")
    implementation("org.postgresql:postgresql:42.6.0")

    // ---- Reactor ----
    implementation("io.projectreactor:reactor-core:3.5.12")

    // ---- Kotlin stdlib ----
    implementation(kotlin("stdlib"))

    // ---- Testing ----
    testImplementation("org.springframework.boot:spring-boot-starter-test") {
        exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
    }
}
