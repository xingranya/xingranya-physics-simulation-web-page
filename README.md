# PhySim Lab ---- 物理模拟实验室 | 直观、交互式的物理实验学习平台

PhySim Lab（物理模拟实验室）是一个基于 Spring Boot 的物理实验模拟系统，旨在帮助学生更好地理解物理概念和原理。系统采用 Material Design 3 设计规范，提供了直观、美观的用户界面。

## 功能特点

### 1. 动量守恒实验
- 模拟三种类型的碰撞：
  - 弹性碰撞 (e=1)：动能完全守恒
  - 非弹性碰撞 (0<e<1)：部分动能损失
  - 完全非弹性碰撞 (e=0)：最大动能损失
- 可调节参数：
  - 小球质量 (0.1-5.0 kg)
  - 初速度 (-5.0 到 5.0 m/s)
  - 恢复系数 (0-1)
- 实时计算和显示：
  - 碰撞前后的动量
  - 碰撞前后的动能
  - 动量守恒状态
  - 能量守恒状态
- 动画展示：
  - 球体大小随质量变化
  - 实时速度显示
  - 碰撞过程可视化
- 数据验证：
  - 动量守恒定律验证
  - 能量守恒定律验证
  - 误差分析

### 2. 简谐运动实验
- 模拟弹簧振子的简谐运动：
  - 无阻尼简谐运动
  - 有阻尼简谐运动
- 可调节参数：
  - 弹簧常数 (1-50 N/m)
  - 质量 (0.1-5.0 kg)
  - 振幅 (0.05-0.4 m)
  - 阻尼系数 (0-1)
- 实时显示：
  - 位移 x (m)
  - 速度 v (m/s)
  - 加速度 a (m/s²)
  - 总能量 E (J)
- 动画展示：
  - 速度矢量
  - 加速度矢量
  - 运动轨迹
  - 能量转换图表
- 数据验证：
  - 简谐运动方程验证
  - 能量守恒验证
  - 周期计算验证

### 3. 杠杆原理实验
- 模拟杠杆平衡条件：
  - 支点位置调节
  - 力臂长度调节
  - 作用力大小调节
- 计算功能：
  - 力矩计算
  - 机械优势计算
  - 平衡条件验证
- 可视化展示：
  - 力臂长度显示
  - 力矩方向指示
  - 平衡状态指示
- 实验验证：
  - 力矩平衡定律
  - 机械优势原理

### 4. 自由落体实验
- 模拟物体自由落体运动：
  - 初始高度调节
  - 空气阻力影响
  - 重力加速度计算
- 实时计算：
  - 下落时间
  - 瞬时速度
  - 位移距离
- 能量分析：
  - 重力势能变化
  - 动能变化
  - 总能量守恒
- 数据验证：
  - 自由落体运动方程
  - 能量守恒定律
  - 重力加速度值

## 技术栈

### 后端
- Spring Boot 2.x
  - 自动配置
  - 依赖注入
  - 事务管理
- Spring MVC
  - RESTful API
  - 请求处理
  - 响应封装
- Thymeleaf 模板引擎
  - 动态页面渲染
  - 模板继承
  - 国际化支持
- Java Physics Engine
  - 碰撞检测
  - 运动计算
  - 能量分析

### 前端
- HTML5 / CSS3
  - 语义化标签
  - 弹性布局
  - 网格布局
- JavaScript
  - ES6+ 特性
  - 异步编程
  - 事件处理
- Bootstrap 5
  - 响应式设计
  - 组件库
  - 工具类
- Material Design 3
  - 色彩系统
  - 组件设计
  - 动效规范
- p5.js
  - 2D 渲染
  - 动画控制
  - 交互处理
- KaTeX
  - 数学公式渲染
  - 符号支持
  - 排版优化

## 设计特点

### 1. Material Design 3 设计系统
- 色彩系统：
  - 主色调：#6750A4
  - 次要色：#625B71
  - 第三色：#7D5260
  - 表面色：#FFFBFE
- 组件样式：
  - 卡片设计
  - 按钮样式
  - 滑块控件
  - 复选框样式
- 间距和层级：
  - 8px 网格系统
  - 层级阴影
  - 内容间距
- 动效设计：
  - 过渡动画
  - 状态变化
  - 交互反馈
- 可访问性：
  - 颜色对比度
  - 键盘导航
  - 屏幕阅读器支持

### 2. 响应式布局
- 屏幕适配：
  - 桌面端 (≥1200px)
  - 平板端 (≥768px)
  - 移动端 (<768px)
- 移动端优化：
  - 触摸交互
  - 手势支持
  - 自适应布局
- 用户体验：
  - 流畅滚动
  - 快速响应
  - 清晰导航
- 视觉层级：
  - 信息优先级
  - 视觉引导
  - 内容组织

### 3. 交互设计
- 实时反馈：
  - 操作提示
  - 状态更新
  - 错误提示
- 数据可视化：
  - 图表展示
  - 动画效果
  - 数据对比
- 操作指引：
  - 步骤提示
  - 参数说明
  - 结果解释
- 错误处理：
  - 友好提示
  - 恢复建议
  - 日志记录

### 4. 动画效果
- 物理模拟：
  - 碰撞动画
  - 运动轨迹
  - 能量转换
- 数据更新：
  - 实时数值
  - 图表刷新
  - 状态变化
- 视觉反馈：
  - 操作响应
  - 状态指示
  - 过渡效果
- 物理量展示：
  - 矢量显示
  - 标量变化
  - 能量分布

## 项目结构

```
physics-simulation/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── example/
│   │   │           ├── ProjectApplication.java
│   │   │           ├── controller/    # 控制器层
│   │   │           └── service/       # 业务逻辑层
│   │   └── resources/
│   │       ├── static/        # 静态资源
│   │       │   ├── css/       # 样式文件
│   │       │   └── favicon.svg
│   │       └── templates/     # 页面模板
│   │           ├── index.html
│   │           ├── momentum.html
│   │           ├── momentum-intro.html
│   │           ├── harmonic.html
│   │           ├── harmonic-intro.html
│   │           ├── shm.html
│   │           ├── shm-intro.html
│   │           ├── freefall.html
│   │           ├── freefall-intro.html
│   │           ├── ramp.html
│   │           ├── ramp-intro.html
│   │           ├── lever.html
│   │           ├── lever-intro.html
│   │           └── error.html
├── pom.xml                    # 项目依赖
├── settings.xml               # Maven 设置
├── LICENSE                    # 许可证文件
└── README.md                  # 项目文档
```

## 快速开始

1. 环境要求
   - JDK 11+
   - Maven 3.6+
   - 现代浏览器（Chrome、Firefox、Edge）

2. 克隆项目
```bash
git clone https://github.com/xingranya/xingranya-physics-simulation-web-page.git
cd physics-simulation
```

3. 安装依赖
```bash
mvn clean install
```

4. 运行项目
```bash
mvn spring-boot:run
```

5. 访问系统
打开浏览器访问 http://localhost:8080

## 实验说明

### 动量守恒实验
1. 选择碰撞类型：
   - 弹性碰撞：选择"弹性碰撞"选项
   - 非弹性碰撞：选择"非弹性碰撞"并调节恢复系数
   - 完全非弹性碰撞：选择"完全非弹性碰撞"

2. 调节参数：
   - 使用滑块调节小球质量
   - 使用滑块调节初速度
   - 观察球体大小随质量变化

3. 开始实验：
   - 点击"开始模拟"按钮
   - 观察碰撞过程
   - 查看实时数据更新

4. 数据分析：
   - 检查动量守恒状态
   - 检查能量守恒状态
   - 分析误差原因

### 简谐运动实验
1. 设置参数：
   - 调节弹簧常数
   - 设置质量大小
   - 选择振幅范围
   - 设置阻尼系数

2. 选择显示：
   - 勾选"显示速度矢量"
   - 勾选"显示加速度矢量"
   - 勾选"显示运动轨迹"
   - 勾选"显示能量图表"

3. 开始实验：
   - 点击"开始模拟"
   - 观察运动过程
   - 查看实时数据

4. 数据分析：
   - 观察位移变化
   - 分析速度变化
   - 研究能量转换
   - 验证运动规律

## 开发指南

### 代码规范
1. 命名规范：
   - 类名：大驼峰命名法
   - 方法名：小驼峰命名法
   - 变量名：小驼峰命名法
   - 常量名：全大写，下划线分隔

2. 注释规范：
   - 类注释：说明类的作用和功能
   - 方法注释：说明参数、返回值和功能
   - 关键代码注释：说明实现逻辑

3. 代码格式：
   - 使用 4 空格缩进
   - 行长度不超过 120 字符
   - 适当的空行分隔代码块

### 测试规范
1. 单元测试：
   - 测试覆盖率 > 80%
   - 边界条件测试
   - 异常情况测试

2. 集成测试：
   - 功能流程测试
   - 性能测试


## 许可证

MIT License

Copyright (c) 2024 PhySim Lab Team

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE. 