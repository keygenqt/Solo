pluginManagement {

    val artifactoryVersion: String by settings
    val manesPluginVersion: String by settings
    val spotlessVersion: String by settings

    repositories {
        gradlePluginPortal()
        mavenCentral()
    }

    plugins {
        // https://www.jfrog.com/confluence/display/JFROG/Gradle+Artifactory+Plugin
        id("com.jfrog.artifactory") version artifactoryVersion
        // https://github.com/ben-manes/gradle-versions-plugin
        id("com.github.ben-manes.versions") version manesPluginVersion
        // https://github.com/diffplug/spotless
        id("com.diffplug.spotless") version spotlessVersion
    }
}

enableFeaturePreview("VERSION_CATALOGS")

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven("https://artifactory.keygenqt.com/artifactory/open-source")
    }
    versionCatalogs {
        create("libs") {
            from(fileTree("dependencies"))
        }
    }
}

rootProject.name = "Solo"

// Sample app
include(":sample")

// Libs
include(":libs:chips")
include(":libs:loaders")
include(":libs:pager-indicator")