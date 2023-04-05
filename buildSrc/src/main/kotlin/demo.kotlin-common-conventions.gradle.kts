
plugins {
    id("org.jetbrains.kotlin.jvm") // <1>
    jacoco
}

repositories {
    mavenCentral() // <2>
}

dependencies {
    constraints {
        implementation("org.apache.commons:commons-text:1.9") // <3>

        implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    }

    implementation(platform("org.jetbrains.kotlin:kotlin-bom")) // <4>

    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8") // <5>

    implementation(platform("org.jetbrains.kotlin:kotlin-bom")) // <6>

    testImplementation("org.junit.jupiter:junit-jupiter:5.7.2") // <7>

    // https://mvnrepository.com/artifact/org.assertj/assertj-core
    testImplementation("org.assertj:assertj-core:3.6.1")
}

tasks.test {
    useJUnitPlatform() // <8>
}

//tasks.test {
//    finalizedBy(tasks.jacocoTestReport) // report is always generated after tests run
//}
tasks.jacocoTestReport {
    dependsOn(tasks.test) // tests are required to run before generating the report
}

tasks.jacocoTestReport {
    reports {
        xml.required.set(true)
        csv.required.set(true)
        html.outputLocation.set(layout.buildDirectory.dir("jacocoHtml"))
    }
}