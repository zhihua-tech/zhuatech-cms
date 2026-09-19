/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.cms.controller;

import cn.zhuatech.cms.common.ApiResponse;
import cn.zhuatech.cms.service.SeoContentQualityService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
@RestController
@RequestMapping("/api/cms/insights")
public class SeoContentQualityController {
    private final SeoContentQualityService service;
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public SeoContentQualityController(SeoContentQualityService service) { this.service = service; }

    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    @PostMapping("/seo-quality")
    public ApiResponse<SeoContentQualityService.Result> evaluate(
        @Valid @RequestBody SeoContentQualityService.Request request) {
        return ApiResponse.ok(service.evaluate(request));
    }
}
