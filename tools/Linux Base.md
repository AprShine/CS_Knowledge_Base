# Linux Base

#linux #software #shell
## 什么是 Linux？

Linux 是一套免费、开源的类 Unix 操作系统。它最初Linus Torvalds 于 1991 年发布，经过全球开发者的共同维护，现已成为服务器、嵌入式系统和超级计算机领域的主流系统，同时也广泛应用于桌面和移动端（如 Android）。

不同的组织将内核、系统工具、图形界面和预装软件打包在一起，形成了**发行版**。常见的有：

- **Ubuntu**：最适合新手，社区支持强大。
- **CentOS/RHEL**：常用于企业级服务器，极其稳定。
- **Debian**：纯粹的开源精神，以稳定著称。
- **Arch Linux**：极简主义，由用户完全自定义（适合进阶玩家）。

这些发行版有 with GUI 的版本 or none GUI 的版本，可以按需选择，在 linux 中，最流行的用户接口（与 GUI 相对应）为 shell（**壳程序**，也就是我们常说的命令行）
## base framework

### 文件系统

与 Windows 不同（Windows 以磁盘分区为基础，如 C 盘、D 盘），**Linux 的一切皆文件**，且所有文件都组织在一个**单一的树状结构**中。根目录用斜杠 / 表示。主要目录的功能如下：

- `/bin (Binaries)`：存放所有用户都能使用的基本命令（如 ls, cd, cat）。
- `/sbin (System Binaries)`：存放系统管理员使用的管理命令（如 iptables, reboot）。
- `/etc (Etcetera)`：**极为重要**。存放系统所有的配置文件。如果你要修改网络设置或软件配置，通常都在这里。
- `/home`：普通用户的家目录。每个用户都有一个独立文件夹（如 `/home/alice`），存放个人数据。
- `/root`：系统管理员（超级用户）的 home 目录。
- `/usr (Unix System Resources)`：存放用户安装的应用程序和库文件，类似于 Windows 的 `C:\Program Files`。
    - `/usr/bin`：用户安装的大多数可执行程序，通常是系统包管理器所安装软件的安装位置。
    - `/usr/lib`：程序运行所需的库文件。
    - 
- `/var (Variable)`：存放经常变化的文件，如系统日志 (/var/log)、数据库文件或缓存。
- `/dev (Devices)`：存放硬件设备文件。在 Linux 中，访问硬盘、鼠标、U 盘都是通过操作这里的文件完成的。
- `/proc & /sys`：这是虚拟文件系统。它们不占用磁盘空间，而是内核在内存中生成的，反映了当前系统的运行状态（如进程信息、CPU 状态）。
- `/tmp (Temporary)`：存放临时文件，系统重启时通常会清空。
- `/boot`：存放启动 Linux 时所需的核心文件（如内核镜像、引导加载程序 GRUB）。
- `/mnt & /media`：用于挂载外部设备（如 U 盘、移动硬盘）。
+ `/opt`

> [! tip]
  在 Linux 系统中所有的行为几乎都可以通过修改纯文本文件进行更改，可以完全不依赖于图形界面。
## tools

### 用户管理

+ `getent`：用于获取环境变量

```shell
getent passwd <userid>

getent group <groupid>
```

### 系统监控

+ `watch`

```shell
# 最常用的命令，-n 代表 --interval，即指定执行的时间间隔
watch -n <second> [command]

watch -n 1 nvidia-smi

# -d --difference，高亮显示两次输出之间的变化内容
watch -d -n 1 free -m
```

+ `free`，用于监控系统内存

```shell
# 最常用命令，查看当前系统内存使用情况
free -h
```

+ `df`，用于查看系统磁盘使用情况

```shell
# 最常用命令，查看当前系统磁盘使用情况
df -h
```

+ `du`，用于查看文件夹/文件的磁盘使用情况

```shell
# 最常用命令，-s 表示 summary，即只显示资源占用总数；-h 即使用人类可看懂的单位
du -sh . 
```
### 文件操作

+ `touch`，多用于创建文件

```shell
# 创建文件（非目录） 
touch readme.md
```

+ `mkdir`，用于创建文件夹

```shell
mkdir folder_test
ls
```

+ `rm`，用于删除文件

```shell
rm readme.md

rm ~/readme.md

# -r 表示递归的删除，-f 表示强制删除，危险性很大的命令，切勿在 root 用户下乱用
rm -rf folder_test
```

+ `mv`，用于移动文件

```shell
# 将 folder 内的全部文件移动到当前目录
mv /folder/* .
```

+ `chmod`，用于修改文件权限
	linux 文件权限由用户：用户组：所有人，三个维度的访问权限构成，每个维度的访问权限涉及读、写、运行三类操作，即 rwx，各自用一个 bit 表示，每个维度可以用一个 3 位二进制数表示权限：

```shell
# 744，即代表文件 owner 拥有 rwx 权限，对应用户组和所有人只有读取权
chmod 744 readme.md

# 还可以使用运算符加/减权限
chmod +x a.py
```

+ `chown`，用于修改文件所有者

```shell
chown root:root readme.md
```

+ `find`，用于查找文件，是 linux 中最强大的文件搜索工具，可以与多种命令共同使用

```shell
find [起始目录] [匹配条件] [动作]

# 例子
find . -name "test.md"
## 使用通配符
find . -name "*.md"
## 忽略大小写
find . -iname "envs"
## 按照文件类型
find . -type f
find . -tyoe d
find . -type l
## 按照文件大小 (c byte,b block,k KB,M MB,G GB)
find . -size +100M
find . -size -10k
## 按照权限/用户
find . -perm 777
find . -user root
find . -group dev

## 多条件逻辑运算（默认为与）

### 与
find . -name "*.txt" -type f

### 或
find . -name "*.md" -o -name "*.jpg"

### 非
find . ! -name "*.txt"

## 可对搜索结果执行动作
### 其中 {} 代表搜到的文件名， \; 是 exec 结束标志 
find . -name "*.txt" -exec rm -f {} \;
### ok 可对搜到的文件进行逐一确认，更安全
find . -name "*.txt" -ok rm -f {} \;
### 可将 \; 换为 +，一次性将文件名传输给命令，否则每个文件都会开一个子进程
find . -name "*.txt" -ok rm -f {} +
```
