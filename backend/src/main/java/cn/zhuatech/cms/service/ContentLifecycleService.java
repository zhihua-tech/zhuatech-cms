/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.cms.service;
import jakarta.validation.constraints.*;import org.springframework.stereotype.Service;import java.util.*;
@Service public class ContentLifecycleService {
 public Result evaluate(Request r){int overdue=Math.max(0,r.daysSinceReview()-r.reviewIntervalDays());int risk=overdue>0?30:0;risk+=Math.min(30,r.brokenLinks()*10);if(r.legalReviewRequired())risk+=25;if(!r.ownerAssigned())risk+=20;if(r.monthlyViews()==0)risk+=15;risk=Math.min(100,risk);String status=risk>=70?"RETIRE_OR_BLOCK":risk>=30?"REVIEW":"HEALTHY";List<String> actions=new ArrayList<>();if(overdue>0)actions.add("内容复审已逾期 "+overdue+" 天");if(r.brokenLinks()>0)actions.add("修复失效链接");if(r.legalReviewRequired())actions.add("完成法务复核后再发布");if(!r.ownerAssigned())actions.add("指定内容责任人");if(actions.isEmpty())actions.add("内容处于有效生命周期内");return new Result(overdue,risk,status,actions);}
 public record Request(@NotBlank String contentId,@Min(0) int daysSinceReview,@Min(1) int reviewIntervalDays,@Min(0) int monthlyViews,@Min(0) int brokenLinks,@NotNull Boolean legalReviewRequired,@NotNull Boolean ownerAssigned){}
 public record Result(int overdueDays,int lifecycleRisk,String status,List<String> actions){}
}
