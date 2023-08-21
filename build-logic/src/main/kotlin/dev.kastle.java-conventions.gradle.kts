import org.gradle.accessors.dm.LibrariesForLibs

plugins {
    `java-library`
    `maven-publish`
}

// https://github.com/gradle/gradle/issues/15383
val libs = the<LibrariesForLibs>()

repositories {
    mavenLocal()
    maven("https://repo.maven.apache.org/maven2/")
    maven("https://repo.papermc.io/repository/maven-public/")
    maven("https://jitpack.io")
}

group = properties["group"] as String
version = properties["version"] as String
java.sourceCompatibility = JavaVersion.VERSION_17

publishing {
    publications.create<MavenPublication>("maven") {
        from(components["java"])
    }
}

tasks.withType<JavaCompile>() {
    options.encoding = "UTF-8"
}

tasks.withType<Javadoc>() {
    options.encoding = "UTF-8"
}

tasks {
    processResources {
        filesMatching(listOf("plugin.yml")) {
            expand(
                "id" to properties["id"],
                "name" to properties["pluginName"],
                "version" to properties["version"],
                "paperApiVersion" to parseApiVersion(libs.versions.paper.api.get()),
                "description" to properties["description"],
                "url" to properties["url"],
                "authors" to properties["authors"]
            )
        }
    }
}

fun parseApiVersion(input: String): String {
    val regex = Regex("""^(\d+\.\d+)""")
    val matchResult = regex.find(input)
    val version = matchResult?.groupValues?.get(1)

    return version ?: "unknown"
}