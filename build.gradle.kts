plugins {
    kotlin("jvm") version "1.3.72"
    application
    id()
}

group = "io.github.lucasschwenke.cabal"
version = "1.0.0-SNAPSHOT"

val launcherClassName = "io.vertx.core.Launcher"

application {
    mainClassName = launcherClassName
}

repositories {
    mavenCentral()
    jcenter()
    maven {
        url = uri("https://dl.bintray.com/lucasschwenke/maven")
    }
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))

    //env
    implementation("com.natpryce:konfig:1.6.10.0")

    //injection
    implementation("org.koin:koin-core:2.1.6")

    //jackson
    implementation("com.fasterxml.jackson.core:jackson-databind:2.11.3")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.11.3")

    //vertx
    implementation("io.vertx:vertx-core:3.9.4")
    implementation("io.vertx:vertx-web:3.9.4")
    implementation("io.vertx:vertx-lang-kotlin:3.9.4")

    //database
    implementation("com.zaxxer:HikariCP:3.4.5")
    implementation("org.jdbi:jdbi3-core:3.17.0")
    implementation("org.jdbi:jdbi3-kotlin:3.17.0")
    implementation("com.microsoft.sqlserver:mssql-jdbc:8.4.1.jre11")

    //javax
    implementation("javax.xml.bind:jaxb-api:2.3.1")

    //logs
    implementation("io.github.lucasschwenke:logging:1.1.0")
}

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "11"
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = "11"
    }
}
