buildscript {
    repositories {
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
    version = "1.0-SNAPSHOT"
}

subprojects {

    repositories {
        mavenLocal()
        maven {
            setUrl("https://maven.aliyun.com/repository/public/")
        }
        mavenCentral()
    }

    if (project.name != "jvm-stack-platform" && project.subprojects.isEmpty()) {
        apply(plugin = "java")
        apply(plugin = "io.freefair.lombok")


        plugins.withId("java") {
            val extension = this@subprojects.extensions.getByType<JavaPluginExtension>()
            extension.sourceCompatibility = JavaVersion.VERSION_17
            extension.targetCompatibility = JavaVersion.VERSION_17
        }

        val implementation by configurations
        dependencies {
            implementation(platform(project(":jvm-stack-platform")))
        }

    }
}