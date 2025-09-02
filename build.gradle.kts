plugins {
    kotlin("jvm") version "1.9.10" apply false
    id("org.springframework.boot") version "3.3.1" apply false
    id("io.spring.dependency-management") version "1.1.5" apply false
}

allprojects {
    repositories {
        mavenCentral()
        gradlePluginPortal()
    }
}

