rootProject.name = "jvm-stack"
include("jvm-stack-platform", "jvm-stack-middleware")
include("jvm-stack-middleware:jvm-stack-redis")
findProject(":jvm-stack-middleware:jvm-stack-redis")?.name = "jvm-stack-redis"
include("jvm-stack-framework")
include("jvm-stack-framework:jvm-stack-cloud-alibaba")
findProject(":jvm-stack-framework:jvm-stack-cloud-alibaba")?.name = "jvm-stack-cloud-alibaba"
include("jvm-stack-framework:jvm-stack-cloud-alibaba:jvm-stack-cloud-alibaba-service1")
findProject(":jvm-stack-framework:jvm-stack-cloud-alibaba:jvm-stack-cloud-alibaba-service1")?.name = "jvm-stack-cloud-alibaba-service1"
