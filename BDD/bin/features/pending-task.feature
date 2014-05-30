
Feature:通知未完成任务
描述
In order to 保证项目的进度
As a Scrum Master
I want to 查询未完成任务

Scenario: 团队有未完成任务
Given 团队有任务 "TaskABC" 优先级 "无"
Given 团队有任务 "Task123" 优先级 "无"
When 团队完成"TaskABC"
Then 团队的未完成任务是"Task123"

Scenario: 团队没有未完成任务
Given 团队有任务 "TaskABC" 优先级 "无"
When 团队完成"TaskABC"
Then 团队的未完成任务是"无"

Scenario: 团队有一些高优先级任务没完成
Given 团队有任务 "TaskABC" 优先级 "高"
Given 团队有任务 "Task123" 优先级 "无"
When 团队完成"TaskABC"
Then 团队的未完成"高"优先级 任务是"无"

