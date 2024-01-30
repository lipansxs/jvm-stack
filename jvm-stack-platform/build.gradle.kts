import com.lipanre.jvm.buildsrc.Version

plugins {
    `java-platform`
}


javaPlatform {
    allowDependencies()
}

dependencies {

    ext {
        set("lombok.version", "1.18.30")
    }


    api(platform("org.springframework.boot:spring-boot-dependencies:${Version.springBootVersion}"))
    api(platform("org.springframework.cloud:spring-cloud-dependencies:${Version.springCloudVersion}"))
    api(platform("com.alibaba.cloud:spring-cloud-alibaba-dependencies:${Version.springCloudAlibabaVersion}"))

    constraints {
        api("org.projectlombok:lombok:${ext.get("lombok.version")}")
    }
}
