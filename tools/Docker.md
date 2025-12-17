# Docker

## 常用操作

### docker exec

 + 进入容器

```shell
docker exec -it container_ID /bin/bash
```

### docker image

用于操作 docker 镜像

### docker container

用于操作 docker 容器

### docker pull

用于从 dockerhub 等平台拉取镜像
## 相关文件

### DOCKERFILE

DockerFile用于构建镜像（image）

### docker-compose.yml

docker-compose.yml 本质上就是对 docker run 命令的声明式封装，其中的配置选项与docker run 的参数一一对应。

