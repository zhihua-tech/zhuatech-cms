/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.cms.service;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class ContentPublicationGovernanceServiceTest {
    private final ContentPublicationGovernanceService service = new ContentPublicationGovernanceService();

    @Test void publishesApprovedAccessibleContent() {
        var result = service.assess(new ContentPublicationGovernanceService.Request(
            "NEWS-001", "portal", "author-a", "reviewer-b", true, true, 94, 88, 0, true, true));
        assertThat(result.decision()).isEqualTo(ContentPublicationGovernanceService.Decision.PUBLISH);
        assertThat(result.publishable()).isTrue();
    }

    @Test void blocksMissingSeparationAndLegalApproval() {
        var result = service.assess(new ContentPublicationGovernanceService.Request(
            "NEWS-002", "portal", "same", "same", true, false, 70, 90, 2, false, true));
        assertThat(result.decision()).isEqualTo(ContentPublicationGovernanceService.Decision.BLOCKED);
        assertThat(result.blockers()).hasSize(5);
    }

    @Test void reviewsWeakSeoBeforeScheduling() {
        var result = service.assess(new ContentPublicationGovernanceService.Request(
            "NEWS-003", "portal", "author-a", "reviewer-b", false, false, 90, 60, 0, true, false));
        assertThat(result.decision()).isEqualTo(ContentPublicationGovernanceService.Decision.REVIEW);
        assertThat(result.actions()).hasSize(2);
    }
}
