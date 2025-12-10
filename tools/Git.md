## 合作流程

>你怎么能直接 commit 到我的 main 分支啊？！
>
>GitHub 上不是这样！你应该先 fork 我的仓库，然后从 develop 分支 checkout 一个新的 feature 分支，比如叫 feature/confession。然后你把你的心意写成代码，并为它写好单元测试和集成测试，确保代码覆盖率达到95%以上。接着你要跑一下 Linter，通过所有的代码风格检查。
>
>然后你再 commit，commit message 要遵循 Conventional Commits 规范。之后你把这个分支 push 到你自己的远程仓库，然后给我提一个 Pull Request。
>
>在 PR 描述里，你要详细说明你的功能改动和实现思路，并且 @ 我和至少两个其他的评审。我们会 review 你的代码，可能会留下一些评论，你需要解决所有的 thread。
>
>等 CI/CD 流水线全部通过，并且拿到至少两个 LGTM 之后，我才会考虑把你的分支 squash and merge 到 develop 里，等待下一个版本发布。你怎么直接上来就想 force push 到 main？！
>
>GitHub 上根本不是这样！我拒绝合并！

![高松灯](https://i2.hdslb.com/bfs/archive/4c83534976e1d15db689da00bb712b6520ca7f0b.jpg@672w_378h_1c_!web-search-common-cover.avif)
## 命令

## git clone

```shell
git clone --depth 1 [remote url]

git clone --single-branch -branch [branch name] [remote url]
```
## git remote
```shell
git remote -v

git remote add [name] [url]

```
## git push

```shell
git push [remote name] [branch]
```
## git fetch

+ 从所有远程仓库（默认主要是 origin）下载最新的提交、分支和标签。
+ 不会自动合并到你的本地分支，只是更新本地“远程跟踪分支”。
```shell
git fetch [remote name] [branch]
```

## git checkout

```shell
# 修改分支名称
git checkout -m [new branch name]

# 若没有对应分支则创建
git checkout -b [new branch name] 
```
## git pull

+ 与 fetch 不同，会自动 merge 到当前 head 指向的分支
+ 如果存在冲突，需要进行处理
## git log

```shell
git log --graph --oneline [branch]

git log --name-status -- [filename/foldername]
```

## git commit 规范

```shell
<类型>([可选的作用域]): <描述> 

[可选的正文] 

[可选的脚注]
```

### 类型

- `feat:`: 类型为 `feat` 的提交表示在代码库中新增了一个功能（这和语义化版本中的 [`MINOR`](https://link.juejin.cn?target=https%3A%2F%2Fsemver.org%2Flang%2Fzh-CN%2F%23%25E6%2591%2598%25E8%25A6%2581 "https://semver.org/lang/zh-CN/#%E6%91%98%E8%A6%81") 相对应）。
- `fix:`：类型为 `fix` 的 提交表示在代码库中修复了一个 bug （这和语义化版本中的 [`PATCH`](https://link.juejin.cn?target=https%3A%2F%2Fsemver.org%2Flang%2Fzh-CN%2F%23%25E6%2591%2598%25E8%25A6%2581 "https://semver.org/lang/zh-CN/#%E6%91%98%E8%A6%81") 相对应）。
- `docs:`: 只是更改文档。
- `style:`: 不影响代码含义的变化（空白、格式化、缺少分号等）。
- `refactor:`: 代码重构，既不修复错误也不添加功能。
- `perf:`: 改进性能的代码更改。
- `test:`: 添加确实测试或更正现有的测试。
- `build:`: 影响构建系统或外部依赖关系的更改（示例范围：gulp、broccoli、NPM）。
- `ci:`: 更改持续集成文件和脚本（示例范围：Travis、Circle、BrowserStack、SauceLabs）。
- `chore:`: 其他不修改`src`或`test`文件。
- `revert:`: commit 回退。

### 作用域

可以为提交类型添加一个围在圆括号内的作用域，以为其提供额外的上下文信息。例如 `feat(parser): adds ability to parse arrays.`

### 例子

```shell
# 包含作用域
feat(lang): add polish language
# 包含正文
fix: correct minor typos in code 

see the issue for details on the typos fixed 

closes issue #12
```

