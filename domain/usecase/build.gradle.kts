plugins {
    kotlin("jvm") version "1.9.10"
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
    implementation(kotlin("stdlib"))
    implementation("io.projectreactor:reactor-core:3.5.12")

    compileOnly("org.projectlombok:lombok:1.18.32")
    annotationProcessor("org.projectlombok:lombok:1.18.32")
}
