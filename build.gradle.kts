import org.jetbrains.compose.desktop.application.dsl.TargetFormat

plugins {
    kotlin("jvm")
    id("org.jetbrains.compose")
    id("org.jetbrains.kotlin.plugin.serialization") version "1.6.10"
    id("dev.hydraulic.conveyor") version "1.10"
}

apply(plugin = "org.jetbrains.kotlin.plugin.serialization")

group = "io.github"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    google()
    maven("https://jitpack.io")
    maven("https://maven.scijava.org/content/repositories/public/")
}

dependencies {
    implementation("br.com.devsrsouza.compose.icons:font-awesome:1.1.0")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.3")
    implementation("club.minnced:java-discord-rpc:2.0.2")
    linuxAmd64(compose.desktop.linux_x64)
    macAmd64(compose.desktop.macos_x64)
    macAarch64(compose.desktop.macos_arm64)
    windowsAmd64(compose.desktop.windows_x64)
}

compose.desktop {
    application {
        mainClass = "MainKt"


        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.AppImage, TargetFormat.Pkg)
            packageName = "Tritium"
            packageVersion = "1.0.0"
            appResourcesRootDir.set(project.layout.projectDirectory.dir("resources"))

            linux {
                appCategory = "Utility"

            }
        }
    }
}

configurations.all {
    attributes {
        attribute(Attribute.of("ui", String::class.java), "awt")
    }
}