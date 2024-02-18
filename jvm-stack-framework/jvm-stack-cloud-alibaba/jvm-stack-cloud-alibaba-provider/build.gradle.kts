
dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation("org.springframework.boot:spring-boot-starter-actuator")
    implementation("org.springframework.boot:spring-boot-starter-web")

    // nacos 服务发现依赖
    implementation("com.alibaba.cloud:spring-cloud-starter-alibaba-nacos-discovery")
}
