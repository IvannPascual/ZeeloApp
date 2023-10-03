pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
    dependencyResolutionManagement {

        versionCatalogs {
            create("libs") {
                from(files("gradle/wrapper/libs.versions.toml"))
            }
        }
    }
}

rootProject.name = "Zeelo"
include(":app")
include(":core:libs:navigation")
include(":common:data")
include(":common:domain")
include(":core:libs:database")
include(":core:libs:ui")
