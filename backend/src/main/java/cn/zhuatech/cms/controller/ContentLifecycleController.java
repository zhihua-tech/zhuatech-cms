/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.cms.controller;
import cn.zhuatech.cms.common.ApiResponse;import cn.zhuatech.cms.service.ContentLifecycleService;import jakarta.validation.Valid;import org.springframework.web.bind.annotation.*;
/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
@RestController @RequestMapping("/api/cms/insights/content-lifecycle") public class ContentLifecycleController {private final ContentLifecycleService service;/**
                                                                                                                                                               * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                                               */
public ContentLifecycleController(ContentLifecycleService service){this.service=service;}/**
                                                                                                                                                                                                                                                        * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                                                                                                                                        */
@PostMapping ApiResponse<ContentLifecycleService.Result> evaluate(@Valid @RequestBody ContentLifecycleService.Request request){return ApiResponse.ok(service.evaluate(request));}}
