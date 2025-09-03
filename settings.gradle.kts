pluginManagement {
    repositories {
        gradlePluginPortal()
        mavenCentral()
        google()
    }
}

rootProject.name = "crediya-usuarios-service"

include("infrastructure:entity")
project(":infrastructure:entity").projectDir = file("infrastructure/entity")

include("domain:model")
project(":domain:model").projectDir = file("domain/model")

include("domain:usecase")
project(":domain:usecase").projectDir = file("domain/usecase")

include("infrastructure:driven-adapters")
project(":infrastructure:driven-adapters").projectDir = file("infrastructure/driven-adapters")

include("infrastructure:entry-points:reactive-web")
project(":infrastructure:entry-points:reactive-web").projectDir = file("infrastructure/entry-points/reactive-web")

include("applications:usecase")
project(":applications:usecase").projectDir = file("applications/usecase")

include("applications:app-service")
project(":applications:app-service").projectDir = file("applications/app-service")
