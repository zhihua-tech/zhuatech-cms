/* Copyright 2026 上海如静知华信息科技有限公司 */
package cn.zhuatech.cms;

import cn.zhuatech.cms.service.SeoContentQualityService;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class SeoContentQualityServiceTests {
    private final SeoContentQualityService service = new SeoContentQualityService();

    @Test void blocksLowQualityPage() {
        var result = service.evaluate(new SeoContentQualityService.Request(
            10, 20, 3, 100, 0, 4, 5, 0, false, false, false));
        assertThat(result.status()).isEqualTo("BLOCK");
        assertThat(result.missingAltImages()).isEqualTo(5);
    }

    @Test void marksCompletePageReady() {
        var result = service.evaluate(new SeoContentQualityService.Request(
            42, 120, 1, 1200, 6, 0, 4, 4, true, true, true));
        assertThat(result.status()).isEqualTo("READY");
        assertThat(result.score()).isEqualTo(100);
    }
}
