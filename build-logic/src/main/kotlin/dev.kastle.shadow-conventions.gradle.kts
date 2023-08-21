import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar

plugins {
    id("dev.kastle.java-conventions")
    id("com.github.johnrengelman.shadow")
}

tasks {
    shadowJar {
        archiveClassifier.set("")
        archiveFileName.set("CCAbstractMenuLoader.jar")
        relocate("com.fasterxml.jackson", "dev.kastle.libs.jackson")
    }

    build {
        dependsOn(shadowJar)
    }
}