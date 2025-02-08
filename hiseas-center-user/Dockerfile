FROM eclipse-temurin:21-jre-alpine

# 设置工作目录
WORKDIR /app

# 复制打包好的应用到镜像
COPY hiseas-center-user-service/target/hiseas-center-user-service-*-SNAPSHOT.jar app.jar

# 创建非 root 用户
RUN addgroup -S appgroup && adduser -S appuser -G appgroup

# 安装 curl
RUN apk update && apk add --no-cache curl

ARG PROFILE
ARG SERVER_URL

# 切换到非 root 用户
USER appuser

# 设置时区和 Java 启动参数以及环境
ENV TZ=Asia/Shanghai JAVA_OPTS="-Xms512m -Xmx512m"
ENV PROFILE=${PROFILE}
ENV SERVER_URL=${SERVER_URL}

# 暴露应用运行端口
EXPOSE 8000

# 启动应用
CMD java ${JAVA_OPTS} -Djava.security.egd=file:/dev/./urandom -DSERVER_URL=${SERVER_URL} -jar app.jar --spring.profiles.active=${PROFILE}
