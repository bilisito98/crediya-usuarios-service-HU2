plugins {
    id("org.springframework.boot") version "3.3.1" apply false
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
    implementation(project(":infrastructure:entity"))
    implementation(project(":domain:model"))
    implementation(project(":domain:usecase"))

    implementation("org.springframework.boot:spring-boot-starter-data-r2dbc:3.3.1")
    implementation("io.r2dbc:r2dbc-postgresql:0.8.2.RELEASE")
    implementation("org.postgresql:postgresql:42.6.0")
    implementation("org.springframework.boot:spring-boot-starter")

    implementation("io.projectreactor:reactor-core:3.5.12")
    implementation(kotlin("stdlib"))

    compileOnly("org.projectlombok:lombok:1.18.30")
    annotationProcessor("org.projectlombok:lombok:1.18.30")

    testImplementation("org.springframework.boot:spring-boot-starter-test") {
        exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
    }
    testImplementation("io.projectreactor:reactor-test")
}
