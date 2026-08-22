/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.cms.controller;
import cn.zhuatech.cms.common.ApiResponse;import cn.zhuatech.cms.service.ContentLifecycleService;import jakarta.validation.Valid;import org.springframework.web.bind.annotation.*;
@RestController @RequestMapping("/api/cms/insights/content-lifecycle") public class ContentLifecycleController {private final ContentLifecycleService service;public ContentLifecycleController(ContentLifecycleService service){this.service=service;}@PostMapping ApiResponse<ContentLifecycleService.Result> evaluate(@Valid @RequestBody ContentLifecycleService.Request request){return ApiResponse.ok(service.evaluate(request));}}
