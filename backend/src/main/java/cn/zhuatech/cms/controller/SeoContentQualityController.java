/* Copyright 2026 上海如静知华信息科技有限公司 */
package cn.zhuatech.cms.controller;

import cn.zhuatech.cms.common.ApiResponse;
import cn.zhuatech.cms.service.SeoContentQualityService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cms/insights")
public class SeoContentQualityController {
    private final SeoContentQualityService service;
    public SeoContentQualityController(SeoContentQualityService service) { this.service = service; }

    @PostMapping("/seo-quality")
    public ApiResponse<SeoContentQualityService.Result> evaluate(
        @Valid @RequestBody SeoContentQualityService.Request request) {
        return ApiResponse.ok(service.evaluate(request));
    }
}
