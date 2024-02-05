rootProject.name = "jvm-stack"
include("jvm-stack-platform", "jvm-stack-middleware")
include("jvm-stack-middleware:jvm-stack-redis")
findProject(":jvm-stack-middleware:jvm-stack-redis")?.name = "jvm-stack-redis"
include("jvm-stack-framework")
include("jvm-stack-framework:jvm-stack-cloud-alibaba")
findProject(":jvm-stack-framework:jvm-stack-cloud-alibaba")?.name = "jvm-stack-cloud-alibaba"
include("jvm-stack-framework:jvm-stack-cloud-alibaba:jvm-stack-cloud-alibaba-provider")
findProject(":jvm-stack-framework:jvm-stack-cloud-alibaba:jvm-stack-cloud-alibaba-provider")?.name = "jvm-stack-cloud-alibaba-provider"
include("jvm-stack-framework:jvm-stack-cloud-alibaba:jvm-stack-cloud-alibaba-consumer")
findProject(":jvm-stack-framework:jvm-stack-cloud-alibaba:jvm-stack-cloud-alibaba-consumer")?.name = "jvm-stack-cloud-alibaba-consumer"
include("jvm-stack-framework")
include("jvm-stack-framework:jvm-stack-springboot")
findProject(":jvm-stack-framework:jvm-stack-springboot")?.name = "jvm-stack-springboot"
