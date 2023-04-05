plugins {
    id("demo.kotlin-application-conventions")
}

dependencies {
    implementation("org.apache.commons:commons-text")
}

application {
    mainClass.set("MainKt")
}

//plugins {
//    kotlin("jvm") version "1.8.0"
//    application
//}
//
//group = "org.example"
//version = "1.0-SNAPSHOT"
//
//repositories {
//    mavenCentral()
//}
//
//dependencies {
//    testImplementation(kotlin("test"))// https://mvnrepository.com/artifact/org.assertj/assertj-core
//    testImplementation("org.assertj:assertj-core:3.6.1")
//
//}
//
//tasks.test {
//    useJUnitPlatform()
//}
//
//kotlin {
//    jvmToolchain(8)
//}
//
