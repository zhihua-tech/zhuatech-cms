/* Copyright 2026 上海如静知华信息科技有限公司 */
package cn.zhuatech.cms.config;

import cn.zhuatech.cms.model.*;
import cn.zhuatech.cms.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class DataInitializer {
    @Bean
    CommandLineRunner seed(SiteRepository sites, ContentItemRepository orders,
                           ComponentRepository components, ReviewTaskRepository reviewTasks,
                           UserRepository users, PasswordEncoder encoder) {
        return args -> {
            if (sites.count() > 0) return;
            Site chemistry = sites.save(new Site("SITE-CHEM", "品牌官网", "内容治理中心", 180));
            Site micro = sites.save(new Site("SITE-MICRO", "帮助中心", "研发中心", 120));
            Site material = sites.save(new Site("SITE-MAT", "客户门户", "工程中心", 96));

            ContentItem t1 = orders.save(new ContentItem("CNT-260801-018", "GB-T-228", "官网产品解决方案页", material, 24, 16, 1, LocalDate.now().plusDays(1), ContentItem.Status.RUNNING, "S260801-A"));
            ContentItem t2 = orders.save(new ContentItem("CNT-260801-021", "HPLC-042", "帮助中心安装指南", chemistry, 18, 8, 0, LocalDate.now().plusDays(1), ContentItem.Status.RUNNING, "S260801-C"));
            ContentItem t3 = orders.save(new ContentItem("CNT-260802-006", "ISO-4833", "客户门户服务公告", micro, 12, 0, 0, LocalDate.now().plusDays(3), ContentItem.Status.RELEASED, "S260802-B"));
            ContentItem t4 = orders.save(new ContentItem("CNT-260731-015", "ICP-017", "年度行业大会专题页", chemistry, 20, 20, 1, LocalDate.now(), ContentItem.Status.COMPLETED, "S260731-D"));

            components.saveAll(List.of(
                new Component("CMP-HPLC-03", "产品卡片组件 03", chemistry, Component.Status.RUNNING, 88),
                new Component("CMP-ICP-02", "活动报名组件", chemistry, Component.Status.IDLE, 76),
                new Component("CMP-UTM-05", "帮助中心导航组件", material, Component.Status.RUNNING, 91),
                new Component("CMP-INC-08", "公告横幅组件 08", micro, Component.Status.ALARM, 62)
            ));
            reviewTasks.saveAll(List.of(
                new ReviewTask("REV-260801-032", t1, "留样审核", 6, 0, ReviewTask.Result.PASSED, "周妍"),
                new ReviewTask("REV-260801-011", t2, "前处理审核", 3, 0, ReviewTask.Result.PASSED, "陆承"),
                new ReviewTask("REV-260801-018", t4, "结果审核", 5, 1, ReviewTask.Result.FAILED, "周妍"),
                new ReviewTask("REV-260802-003", t3, "收样确认", 4, 0, ReviewTask.Result.PENDING, "陆承")
            ));
            String demo = encoder.encode("Demo@2026");
            users.saveAll(List.of(
                new UserAccount("operator", demo, "陆承", UserAccount.Role.EDITOR, "SITE-CHEM"),
                new UserAccount("planner", demo, "周妍", UserAccount.Role.CONTENT_MANAGER, null),
                new UserAccount("quality", demo, "顾清", UserAccount.Role.QUALITY, null),
                new UserAccount("admin", encoder.encode("ZhuaTech@2026"), "系统管理员", UserAccount.Role.ADMIN, null)
            ));
        };
    }
}
