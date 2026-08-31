# 企业级内容发布治理

[知华科技（上海如静知华信息科技有限公司）](https://www.zhuatech.cn/)为 CMS 开源版提供可组合的发布门禁。

`POST /api/enterprise/cms/publication-governance` 检查编审职责分离、法务审批、个人信息授权、失效链接、无障碍评分、SEO 质量及定时发布状态，返回 `PUBLISH / REVIEW / BLOCKED` 和整改清单。

企业接入时可将该决策绑定工作流节点，并持久化送审版本、审批意见、发布时间与操作者，形成可追溯的内容证据链。
