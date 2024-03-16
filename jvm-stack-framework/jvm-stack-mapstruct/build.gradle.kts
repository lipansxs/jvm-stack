import com.lipanre.jvm.buildsrc.Version

dependencies {
    implementation("org.mapstruct:mapstruct")
    testImplementation("org.junit.jupiter:junit-jupiter")
    annotationProcessor("org.mapstruct:mapstruct-processor:${Version.mapStructVersion}")
}

tasks.test {
    useJUnitPlatform()
}