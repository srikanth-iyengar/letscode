plugins {
    id("com.github.johnrengelman.shadow") version "7.1.2"
    id("io.micronaut.application") version "3.6.2"
}

version = "0.1"
group = "io.letscode"

repositories {
    mavenCentral()
}

dependencies {
    annotationProcessor("info.picocli:picocli-codegen")
    implementation("info.picocli:picocli")
    implementation("io.micronaut:micronaut-jackson-databind")
    implementation("io.micronaut.picocli:micronaut-picocli")
    implementation("jakarta.annotation:jakarta.annotation-api")
    runtimeOnly("ch.qos.logback:logback-classic")
    compileOnly("org.graalvm.nativeimage:svm")

    implementation("io.micronaut:micronaut-validation")

    testImplementation("io.micronaut:micronaut-http-client")

}


application {
    mainClass.set("io.letscode.CliCommand")
}
java {
    sourceCompatibility = JavaVersion.toVersion("17")
    targetCompatibility = JavaVersion.toVersion("17")
}

micronaut {
    testRuntime("junit5")
    processing {
        incremental(true)
        annotations("io.letscode.*")
    }
}



