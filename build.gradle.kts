
buildscript {
    repositories {
        maven {
            url = uri("file://D:/repository")
        }
        mavenLocal()
        maven {
            setUrl("https://maven.aliyun.com/repository/public/")
        }
        maven {
            url = uri("https://plugins.gradle.org/m2/")
        }
        mavenCentral()
    }
    dependencies {
        classpath("io.freefair.gradle:lombok-plugin:8.4")
    }
}


allprojects {
    group = "com.lipanre"
    version = "1.0.0-SNAPSHOT"
}

subprojects {

    repositories {
        mavenLocal()
        maven {
            setUrl("https://maven.aliyun.com/repository/public/")
        }
        mavenCentral()
    }

    if (!this.name.endsWith("platform") && project.subprojects.isEmpty()) {
        apply(plugin = "maven-publish")
        apply(plugin = "io.freefair.lombok")
        apply(plugin = "java")

        configure<JavaPluginExtension> {
            sourceCompatibility = JavaVersion.VERSION_17
            targetCompatibility = JavaVersion.VERSION_17
        }

        val implementation by configurations
        val annotationProcessor by configurations
        dependencies {
            implementation(platform(project(":jvm-stack-platform")))
            annotationProcessor(platform(project(":jvm-stack-platform")))
        }

    }
}