# openSSH

## 简介
  
OpenSSH 是目前 Linux、macOS 和 Windows（WSL/PowerShell）上最常用的安全连接工具。它不仅用于远程登录，还涵盖了文件传输、端口转发等功能。
## 连接命令——ssh

### 登录远程服务器

最基本的用途是登录远程服务器

```shell
# 登录，可以在 ~/.ssh/config 中配置以简化命令写法 
ssh [用户名]@[主机IP或域名]
```

常用参数如下：
+ -p：指定端口
+ -v：调试模式，连接失败时查看详细日志（等级与 v 的数量有关，最高 `-vvv`）
+ 直接执行命令：`ssh [user]@[host] "command"` 执行一条命令就退出
+ -i：指定私钥文件

### 端口转发

SSH 可以在建立安全连接的同时，进行网络流量转发：
+ -L：本地转发，将远程服务器上的服务转发至本地端口

```shell
# 将远程服务器的 3306 服务转发至本地 3307 端口
ssh -L 3307:127.0.0.1:3306 [user]@[host]
```

+ -R：远程转发

```shell
# 将本地 9090 上的服务转发至远程服务器的 8080 端口
ssh -R 9090:127.0.0.1:8080 [user]@[host]
```

+ -D：动态转发，建立 sock5 代理 （正向代理）

```shell
# 使用服务器代替自身访问某些服务，用于突破内网限制
ssh -D 1080 [user]@[host]
```

>**tips：**
>可以结合 clash 的 rule 规则实现灵活的代理访问
## 文件传输命令——scp&sftp

### scp

用法类似 cp ，简单粗暴
+ 传输文件

```shell
# 本地->远程
scp local_file.txt [user]@[host]:/home/user/
# 远程->本地
scp [user]:[host]:/var/www/index.html .
```

+ 传输文件夹

```shell
scp -r local_folder [user]@[host]:/remote/path
```

+ 指定端口

```shell
scp -P 2222 file.txt [user]@[host]:/path
```

### sftp

交互式的文件传输，用法类似于 ftp
+ 连接服务器

```shell
# 连接服务器
sftp [user]@[host]
```

连接成功后可以使用如下命令：
+ `put [local_file]`
+ `get [remote file]
+ `ls/cd`
+ `lls/lcd`：local ls/local cd，用于操作本地目录
## 密钥管理

### ssh-kengen

+ 在本地生成密钥对

```shell
# 使用 RSA 生成长度为 4096 的密钥对
ssh-keygen -t rsa -b 4096

# 或者使用更加现代化的 ed25519 算法 
ssh-kengen -t ed25519
```

会在  `~/.ssh` 下生成两个文件 `id_rsa` 和 `id_rsa.pub`  

+ 将公钥上传到服务器

```shell
# Linux/macOS
# 默认端口
ssh-copy-id [user]@[host]

# 非默认端口
ssh-copy-id -p [port] [user]@[host]
```

若系统中没有该命令，可手动复制公钥内容追加到服务器对应账号的 `~/.ssh/authorized_keys` 文件中
## 配置文件

位于 `~/.ssh/config` ，可为不同服务器配置别名

```config

```

