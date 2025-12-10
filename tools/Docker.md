# Docker

## DOCKERFILE 与 docker-compose.yml 的区别

DockerFile用于构建镜像（image），docker-compose.yml 本质上就是对 docker run 命令的声明式封装，其中的配置选项与docker run 的参数一一对应。

## docker-compose.yml 配置



## 常用操作

 + 进入容器

```shell
docker exec -it container_ID /bin/bash
```