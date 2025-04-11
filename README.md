# 物理运动模拟网页

这是一个基于 Spring Boot 的物理运动模拟网页，提供了多个物理现象的交互式模拟和计算功能。

## 功能列表

1. **自由落体运动模拟**
   - 计算物体从指定高度自由落体所需时间
   - 考虑空气阻力的影响
   - 实时动画展示落体过程

2. **斜面滑动模拟**
   - 计算物体在斜面上的加速度
   - 考虑摩擦力的影响
   - 实时动画展示滑动过程

3. **杠杆原理模拟**
   - 计算杠杆的力矩
   - 考虑力臂长度和施加力的大小

## 技术栈

- 后端：Spring Boot 2.7.18
- 前端：HTML5, CSS3, JavaScript
- 模板引擎：Thymeleaf
- 构建工具：Maven

## 运行说明

1. 确保已安装 Java 8 或更高版本
2. 确保已安装 Maven
3. 克隆项目到本地
4. 在项目根目录执行：
   ```bash
   mvn spring-boot:run
   ```
5. 访问 http://localhost:8080 查看主页面

## 项目结构

```
src/
├── main/
│   ├── java/
│   │   └── com/example/
│   │       ├── controller/
│   │       │   └── PhysicsController.java
│   │       ├── service/
│   │       │   └── PhysicsService.java
│   │       └── ProjectApplication.java
│   └── resources/
│       ├── static/
│       │   └── css/
│       │       └── style.css
│       └── templates/
│           ├── freefall.html
│           └── ramp.html
```

## 贡献指南

欢迎提交 Issue 和 Pull Request 来改进这个项目。在提交代码之前，请确保：

1. 代码符合项目的编码规范
2. 添加了必要的测试
3. 更新了相关文档

## 许可证

MIT License 