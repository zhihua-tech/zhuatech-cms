/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.cms.service;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class ContentPublicationGovernanceService {
    public Assessment assess(Request request) {
        List<String> blockers = new ArrayList<>();
        List<String> actions = new ArrayList<>();
        if (request.authorId().equals(request.reviewerId())) blockers.add("作者与审核人必须职责分离");
        if (request.legalReviewRequired() && !request.legalApproved()) blockers.add("法务审核尚未通过");
        if (!request.personalDataApproved()) blockers.add("个人信息处理尚未批准");
        if (request.brokenLinks() > 0) blockers.add("页面存在失效链接");
        if (request.accessibilityScore() < 80) blockers.add("无障碍评分低于发布基线 80");
        if (!blockers.isEmpty()) {
            actions.add("退回编辑工作台，修复阻断项后重新送审");
            return new Assessment(Decision.BLOCKED, false, blockers, actions);
        }
        if (request.seoScore() < 70 || !request.scheduledAtInFuture()) {
            if (request.seoScore() < 70) actions.add("优化标题、摘要、结构化数据和站内链接");
            if (!request.scheduledAtInFuture()) actions.add("确认立即发布或重新设置未来发布时间");
            return new Assessment(Decision.REVIEW, false, blockers, actions);
        }
        actions.add("进入定时发布队列并固化审核快照");
        return new Assessment(Decision.PUBLISH, true, blockers, actions);
    }

    public record Request(@NotBlank String contentId, @NotBlank String channel,
                          @NotBlank String authorId, @NotBlank String reviewerId,
                          boolean legalReviewRequired, boolean legalApproved,
                          @Min(0) @Max(100) int accessibilityScore,
                          @Min(0) @Max(100) int seoScore, @Min(0) int brokenLinks,
                          boolean personalDataApproved, boolean scheduledAtInFuture) {}
    public record Assessment(Decision decision, boolean publishable, List<String> blockers,
                             List<String> actions) {}
    public enum Decision { PUBLISH, REVIEW, BLOCKED }
}
