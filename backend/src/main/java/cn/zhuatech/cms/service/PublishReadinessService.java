/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.cms.service;
import jakarta.validation.constraints.*; import org.springframework.stereotype.Service; import java.util.ArrayList; import java.util.List;
/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
@Service public class PublishReadinessService {
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public Result evaluate(Request r){
        int completeness=(r.titleLength()>=10&&r.bodyWordCount()>=300)?100:(r.titleLength()>=5&&r.bodyWordCount()>=100?70:35);
        double score=r.seoScore()*.30+r.accessibilityScore()*.30+completeness*.20+20-r.brokenLinks()*5-r.unresolvedApprovals()*10-r.sensitiveTerms()*10;
        score=Math.max(0,Math.min(100,score));
        String decision=r.unresolvedApprovals()>0||r.sensitiveTerms()>0||r.brokenLinks()>2?"BLOCK":score<80||r.brokenLinks()>0?"REVIEW":"READY";
        List<String> reasons=new ArrayList<>(); if(r.seoScore()<75)reasons.add("SEO 信息不完整"); if(r.accessibilityScore()<80)reasons.add("无障碍检查未达标");
        if(r.brokenLinks()>0)reasons.add("存在失效链接"); if(r.unresolvedApprovals()>0)reasons.add("仍有未完成审批"); if(r.sensitiveTerms()>0)reasons.add("存在待复核敏感词");
        return new Result(completeness,Math.round(score*100)/100.0,decision,reasons);
    }
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public record Request(@NotBlank String contentId,@Min(1) @Max(200) int titleLength,@Min(0) int bodyWordCount,
        @Min(0) @Max(100) int seoScore,@Min(0) @Max(100) int accessibilityScore,@Min(0) int brokenLinks,
        @Min(0) int unresolvedApprovals,@Min(0) int sensitiveTerms){}
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public record Result(int completenessScore,double readinessScore,String decision,List<String> reasons){}
}

