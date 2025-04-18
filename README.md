# 物理实验模拟系统

这是一个基于 Spring Boot 的物理实验模拟系统，旨在帮助学生更好地理解物理概念和原理。系统采用 Material Design 3 设计规范，提供了直观、美观的用户界面。

## 功能特点

### 1. 动量守恒实验
- 模拟两个物体的弹性碰撞过程
- 可调节物体的质量和初速度
- 实时计算和显示碰撞前后的动量
- 动画展示碰撞过程
- 验证动量守恒定律

### 2. 杠杆原理实验
- 模拟杠杆平衡条件
- 计算力矩和机械优势
- 探索力臂长度、作用力大小和方向的影响
- 直观展示杠杆平衡原理
- 验证力矩平衡定律

### 3. 自由落体实验
- 模拟物体自由落体运动
- 计算下落时间、速度和位移
- 展示重力势能与动能的转换
- 验证自由落体运动规律
- 理解重力加速度概念

## 技术栈

### 后端
- Spring Boot 2.x
- Spring MVC
- Thymeleaf 模板引擎
- Java Physics Engine (自定义物理引擎)

### 前端
- HTML5 / CSS3
- JavaScript
- Bootstrap 5
- Material Design 3
- Canvas API (动画实现)

## 设计特点

### 1. Material Design 3 设计系统
- 现代化的色彩系统
- 统一的组件样式
- 合理的间距和层级
- 优雅的动效设计
- 良好的可访问性

### 2. 响应式布局
- 适配不同屏幕尺寸
- 移动端友好的交互
- 流畅的用户体验
- 清晰的视觉层级

### 3. 交互设计
- 实时反馈
- 直观的数据可视化
- 清晰的操作指引
- 友好的错误提示

## 项目结构

```
physics-simulation/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── controller/    # 控制器层
│   │   │   ├── service/       # 业务逻辑层
│   │   │   ├── model/         # 数据模型
│   │   │   └── utils/         # 工具类
│   │   └── resources/
│   │       ├── static/        # 静态资源
│   │       └── templates/     # 页面模板
│   └── test/                  # 测试代码
├── pom.xml                    # 项目依赖
└── README.md                  # 项目文档
```

## 快速开始

1. 克隆项目
```bash
git clone [项目地址]
```

2. 安装依赖
```bash
mvn install
```

3. 运行项目
```bash
mvn spring-boot:run
```

4. 访问系统
```
http://localhost:8080
```

## 使用说明

1. 动量守恒实验
   - 输入两个物体的质量和初速度
   - 点击"计算碰撞结果"
   - 观察动画演示和计算结果

2. 杠杆原理实验
   - 设置支点位置和作用力
   - 调节力臂长度
   - 观察杠杆平衡状态

3. 自由落体实验
   - 设置初始高度
   - 观察物体下落过程
   - 查看能量转换数据

## 开发团队

- 后端开发：[开发者姓名]
- 前端开发：[开发者姓名]
- 物理引擎：[开发者姓名]
- UI 设计：[设计师姓名]

## 版本历史

- v1.0.0 (2024-03)
  - 实现基础物理实验功能
  - 完成 Material Design 3 界面设计
  - 优化用户交互体验

## 后续计划

1. 添加更多物理实验
   - 弹簧振动
   - 电磁感应
   - 光的折射

2. 功能优化
   - 增加实验数据导出
   - 添加实验报告生成
   - 支持多语言界面

3. 技术改进
   - 优化物理引擎性能
   - 增强移动端适配
   - 添加用户系统

## 许可证

本项目采用 MIT 许可证。详见 [LICENSE](LICENSE) 文件。 