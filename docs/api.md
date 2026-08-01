# CMS API 摘要

版权所有 © 2026 上海如静知华信息科技有限公司。

| 内容模型 | 路径 | 说明 |
| --- | --- | --- |
| POST | `/api/auth/login` | 登录并获取 JWT |
| GET | `/api/admin/dashboard` | 内容站点运营数据 |
| GET | `/api/admin/work-orders` | 内容任务清单 |
| GET | `/api/shopfloor/dashboard` | 工程师任务工作台 |
| POST | `/api/shopfloor/work-orders/{id}/reports` | 提交内容结果 |
| POST | `/api/admin/publish-readiness` | 执行内容发布就绪度门禁 |
