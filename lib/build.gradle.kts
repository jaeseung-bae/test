plugins {
    id("demo.kotlin-common-conventions")
    `java-library` // <2>
    `maven-publish`
    signing
}

repositories {
    gradlePluginPortal() // <2>
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin")
}

publishing {
    publications {
        create<MavenPublication>("mavenJava") {
            groupId = "io.github.jaeseung-bae.sdk"
            artifactId = "finschia-kt"
//            io.github.finschia.finschia-kt
//            groupId = "io.github.jaeseung-bae.finschia-kt"
//            artifactId = "finschia-kt-crypto"
//            groupId = "io.github.finschia.finschia-kt"
//            artifactId = "finschia-kt-tx"
            if (System.getProperty("VERSION") != null) {
                version = System.getProperty("VERSION").substring(1) // without v
            }

            from(components["java"])
            pom {
                name.set("finschia-kt")
                description.set("A concise description of my library")
                url.set("https://github.com/jaeseung-bae/test/")
                licenses {
                    license {
                        name.set("The Apache License, Version 2.0")
                        url.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
                    }
                }
                developers {
                    developer {
                        id.set("dev")
                        name.set("dev")
                        email.set("dev@finschia.org")
                    }
                }
                scm {
                    connection.set("scm:git:git://github.com:jaeseung-bae/test.git")
                    developerConnection.set("scm:git:ssh://github.com:jaeseung-bae/test.git")
                    url.set("https://github.com/jaeseung-bae/test/")
                }
            }
        }
    }
    repositories {
        maven {
            name = "OSSRH"
            url = uri("https://s01.oss.sonatype.org/content/repositories/releases/")
            credentials {
                username = System.getenv("OSSRH_USERNAME")
                password = System.getenv("OSSRH_PW")
            }
        }
    }
}

java{
    withJavadocJar()
    withSourcesJar()
}


signing {
    val signingKey: String? by project
    val signingPassword: String? by project
    useInMemoryPgpKeys(signingKey, signingPassword)
    sign(publishing.publications["mavenJava"])
}

tasks.javadoc {
    if (JavaVersion.current().isJava9Compatible) {
        (options as StandardJavadocDocletOptions).addBooleanOption("html5", true)
    }
}
