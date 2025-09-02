plugins {
    id("java-library")
    id("io.spring.dependency-management")
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
    implementation(platform("org.springframework.boot:spring-boot-dependencies:3.2.3"))

    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-data-r2dbc")

    implementation("io.r2dbc:r2dbc-postgresql:0.8.2.RELEASE")

    compileOnly("org.projectlombok:lombok:1.18.30")
    annotationProcessor("org.projectlombok:lombok:1.18.30")
}
