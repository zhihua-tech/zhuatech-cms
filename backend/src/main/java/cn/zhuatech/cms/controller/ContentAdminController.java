/* Copyright 2026 Shanghai Rujing Zhihua Information Technology Co., Ltd. · https://www.zhuatech.cn/ */
package cn.zhuatech.cms.controller; import cn.zhuatech.cms.common.ApiResponse; import cn.zhuatech.cms.dto.CmsDto.*; import cn.zhuatech.cms.service.CmsService; import org.springframework.security.access.prepost.PreAuthorize; import org.springframework.web.bind.annotation.*; import java.util.List;
/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
@RestController @RequestMapping("/api/admin") @PreAuthorize("hasAnyRole('CONTENT_MANAGER','QUALITY','ADMIN')") public class ContentAdminController {private final CmsService service;/**
                                                                                                                                                                                      * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                                                                      */
public ContentAdminController(CmsService service){this.service=service;}/**
                                                                                                                                                                                                                                                              * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                                                                                                                                              */
@GetMapping("/dashboard") public ApiResponse<Dashboard> dashboard(){return ApiResponse.ok(service.adminDashboard());}/**
                                                                                                                                                                                                                                                                                                                                                                                   * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                                                                                                                                                                                                                                                                   */
@GetMapping("/work-orders") public ApiResponse<List<ContentItemView>> orders(){return ApiResponse.ok(service.contentItems());}}
