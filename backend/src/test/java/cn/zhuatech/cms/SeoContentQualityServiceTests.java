/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.cms;

import cn.zhuatech.cms.service.SeoContentQualityService;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
class SeoContentQualityServiceTests {
    private final SeoContentQualityService service = new SeoContentQualityService();

    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    @Test void blocksLowQualityPage() {
        var result = service.evaluate(new SeoContentQualityService.Request(
            10, 20, 3, 100, 0, 4, 5, 0, false, false, false));
        assertThat(result.status()).isEqualTo("BLOCK");
        assertThat(result.missingAltImages()).isEqualTo(5);
    }

    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    @Test void marksCompletePageReady() {
        var result = service.evaluate(new SeoContentQualityService.Request(
            42, 120, 1, 1200, 6, 0, 4, 4, true, true, true));
        assertThat(result.status()).isEqualTo("READY");
        assertThat(result.score()).isEqualTo(100);
    }
}
