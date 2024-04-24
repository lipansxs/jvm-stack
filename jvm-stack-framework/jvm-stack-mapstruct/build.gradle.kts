
dependencies {
    implementation("org.mapstruct:mapstruct")
    testImplementation("org.junit.jupiter:junit-jupiter")
    annotationProcessor("org.mapstruct:mapstruct-processor")
}

tasks.test {
    useJUnitPlatform()
}