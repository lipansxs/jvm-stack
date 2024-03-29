
dependencies {
    implementation("org.springframework.boot:spring-boot-starter-actuator")
    implementation("org.springframework.boot:spring-boot-starter-web")

    // nacos 服务发现依赖
    implementation("com.alibaba.cloud:spring-cloud-starter-alibaba-nacos-discovery")
    implementation("com.alibaba.cloud:spring-cloud-starter-alibaba-seata")
    implementation("com.baomidou:mybatis-plus-boot-starter")
    implementation("mysql:mysql-connector-java")
}
