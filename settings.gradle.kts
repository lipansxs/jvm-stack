rootProject.name = "jvm-stack"
include("jvm-stack-platform", "jvm-stack-middleware")
include("jvm-stack-middleware:jvm-stack-redis")
findProject(":jvm-stack-middleware:jvm-stack-redis")?.name = "jvm-stack-redis"
