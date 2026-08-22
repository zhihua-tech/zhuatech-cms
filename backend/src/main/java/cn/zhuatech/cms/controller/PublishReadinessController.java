/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.cms.controller;
import cn.zhuatech.cms.common.ApiResponse; import cn.zhuatech.cms.service.PublishReadinessService; import jakarta.validation.Valid; import org.springframework.web.bind.annotation.*;
@RestController @RequestMapping("/api/admin") public class PublishReadinessController {private final PublishReadinessService service; public PublishReadinessController(PublishReadinessService service){this.service=service;} @PostMapping("/publish-readiness") public ApiResponse<PublishReadinessService.Result> evaluate(@Valid @RequestBody PublishReadinessService.Request request){return ApiResponse.ok(service.evaluate(request));}}

