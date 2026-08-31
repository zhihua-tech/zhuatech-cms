/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.cms.controller;

import cn.zhuatech.cms.common.ApiResponse;
import cn.zhuatech.cms.service.ContentPublicationGovernanceService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/enterprise/cms")
public class ContentPublicationGovernanceController {
    private final ContentPublicationGovernanceService service;
    public ContentPublicationGovernanceController(ContentPublicationGovernanceService service) { this.service = service; }

    @PostMapping("/publication-governance")
    public ApiResponse<ContentPublicationGovernanceService.Assessment> assess(
        @Valid @RequestBody ContentPublicationGovernanceService.Request request) {
        return ApiResponse.ok(service.assess(request));
    }
}
