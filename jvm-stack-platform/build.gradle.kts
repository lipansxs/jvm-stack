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
        set("mybatis-plus.version", "3.5.5")
        set("mysql-connector.version", "8.0.33")
        set("fast-json.version", "2.0.47")
        set("jjwt.version", "0.12.5")
        set("javax-servlet.version", "4.0.1")
        set("hutool.version", "5.8.26")
        set("mysql-connector.version", "8.0.31")
    }


    api(platform("org.springframework.boot:spring-boot-dependencies:${Version.springBootVersion}"))
    api(platform("org.springframework.cloud:spring-cloud-dependencies:${Version.springCloudVersion}"))
    api(platform("com.alibaba.cloud:spring-cloud-alibaba-dependencies:${Version.springCloudAlibabaVersion}"))
    api("cn.hutool:hutool-bom:${ext.get("hutool.version")}")
    api(platform("org.junit:junit-bom:${Version.junitBomVersion}"))
    api("org.mapstruct:mapstruct-processor:${Version.mapStructVersion}")
    api("org.mapstruct:mapstruct:${Version.mapStructVersion}")


    constraints {
        api("org.projectlombok:lombok:${ext.get("lombok.version")}")
        api("com.baomidou:mybatis-plus-boot-starter:${ext.get("mybatis-plus.version")}")
        api("mysql:mysql-connector-java:${ext.get("mysql-connector.version")}")
        api("com.alibaba:fastjson:${ext.get("fast-json.version")}")
        api("io.jsonwebtoken:jjwt:${ext.get("jjwt.version")}")
        api("javax.servlet:javax.servlet-api:${ext.get("javax-servlet.version")}")
        api("mysql:mysql-connector-java:${ext.get("mysql-connector.version")}")
    }
}
