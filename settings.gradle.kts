rootProject.name = "jvm-stack"
include("jvm-stack-platform", "jvm-stack-middleware")
include("jvm-stack-middleware:jvm-stack-redis")
include("jvm-stack-framework")
include("jvm-stack-framework:jvm-stack-cloud-alibaba")
include("jvm-stack-framework:jvm-stack-cloud-alibaba:jvm-stack-cloud-alibaba-provider")
include("jvm-stack-framework:jvm-stack-cloud-alibaba:jvm-stack-cloud-alibaba-consumer")
include("jvm-stack-framework:jvm-stack-springboot")
include("jvm-stack-framework:jvm-stack-cloud-alibaba:jvm-stack-cloud-gateway")
include("jvm-stack-framework:jvm-stack-spring-security")
findProject(":jvm-stack-framework:jvm-stack-cloud-alibaba:jvm-stack-cloud-gateway")?.name = "jvm-stack-cloud-gateway"
include("jvm-stack-framework:jvm-stack-mapstruct")
findProject(":jvm-stack-framework:jvm-stack-mapstruct")?.name = "jvm-stack-mapstruct"
