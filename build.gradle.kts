plugins {
    alias(libs.plugins.lombok)
    id("dev.kastle.shadow-conventions")
    alias(libs.plugins.shadow)
    `java-library`
}

dependencies {
    implementation(libs.jackson.databind)
    compileOnly(libs.paper.api)
    compileOnly(libs.abstract.menus)
}