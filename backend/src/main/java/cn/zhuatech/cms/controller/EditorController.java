/* Copyright 2026 Shanghai Rujing Zhihua Information Technology Co., Ltd. · https://www.zhuatech.cn/ */
package cn.zhuatech.cms.controller; import cn.zhuatech.cms.common.ApiResponse; import cn.zhuatech.cms.dto.CmsDto.*; import cn.zhuatech.cms.service.CmsService; import jakarta.validation.Valid; import org.springframework.security.access.prepost.PreAuthorize; import org.springframework.web.bind.annotation.*;
/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
@RestController @RequestMapping("/api/shopfloor") @PreAuthorize("hasAnyRole('EDITOR','ADMIN')") public class EditorController {private final CmsService service;/**
                                                                                                                                                                 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                                                 */
public EditorController(CmsService service){this.service=service;}/**
                                                                                                                                                                                                                                   * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                                                                                                                   */
@GetMapping("/dashboard") public ApiResponse<Dashboard> dashboard(){return ApiResponse.ok(service.shopfloorDashboard());}/**
                                                                                                                                                                                                                                                                                                                                                            * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                                                                                                                                                                                                                                            */
@PostMapping("/work-orders/{id}/reports") public ApiResponse<ReportResult> report(@PathVariable Long id,@Valid @RequestBody ReportRequest request){return ApiResponse.ok("反馈提交成功",service.report(id,request));}}
