# Artemis
> 应用名字来源于月神Artemis,是女性纯洁的化身

## 开发进度
- [x] 环境与数据库配置
- [x] mybatis plus设置
- [x] 用户注册登录
- [x] 权限控制
- [x] 统一的返回封装
- [x] 统一的异常封装
- [x] Jenkins 相关操作
- [x] 性能测试相关接口开发
- [ ] 邮件通知
- [ ] 定时任务
- [ ] 细节优化（控制相同信息注册均成功（userid得unique），查询返回信息嵌套问题，未授权异常的友好提示）

## 部署
`mvn clean package -Dmaven.test.skip=true -P prod`

jar包deployed到服务器后：

```bash
[root@localhost /]# cd /opt/xl-test-platform-server-jar/target/
[root@localhost /]# netstat -anp | grep 8081
[root@localhost /]# kill 进程
[root@localhost target]# nohup java -jar artemis-1.0.0-SNAPSHOT.jar &
```

