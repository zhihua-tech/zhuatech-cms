/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.cms.service;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
@Service
public class SeoContentQualityService {
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public record Request(
        @Min(0) int titleLength,
        @Min(0) int metaDescriptionLength,
        @Min(0) int h1Count,
        @Min(0) int wordCount,
        @Min(0) int internalLinks,
        @Min(0) int brokenLinks,
        @Min(0) int imageCount,
        @Min(0) int imagesWithAlt,
        @NotNull Boolean canonicalConfigured,
        @NotNull Boolean structuredDataConfigured,
        @NotNull Boolean mobileFriendly
    ) {}

    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public record Result(String status, int score, int missingAltImages, List<String> actions) {}

    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public Result evaluate(Request request) {
        int score = 100;
        List<String> actions = new ArrayList<>();
        if (request.titleLength() < 30 || request.titleLength() > 60) {
            score -= 12; actions.add("将页面标题控制在 30 至 60 个字符");
        }
        if (request.metaDescriptionLength() < 80 || request.metaDescriptionLength() > 160) {
            score -= 10; actions.add("补充 80 至 160 个字符的摘要描述");
        }
        if (request.h1Count() != 1) {
            score -= 15; actions.add("页面只保留一个清晰的 H1 主标题");
        }
        if (request.wordCount() < 500) {
            score -= 10; actions.add("扩充能够解决用户问题的原创正文");
        }
        if (request.internalLinks() < 2) {
            score -= 8; actions.add("增加相关业务页面的内部链接");
        }
        if (request.brokenLinks() > 0) {
            score -= Math.min(24, request.brokenLinks() * 6); actions.add("修复失效链接并设置正确跳转");
        }
        int missingAlt = Math.max(0, request.imageCount() - Math.min(request.imageCount(), request.imagesWithAlt()));
        if (missingAlt > 0) {
            score -= Math.min(15, missingAlt * 3); actions.add("为信息性图片补充准确的替代文本");
        }
        if (!Boolean.TRUE.equals(request.canonicalConfigured())) {
            score -= 8; actions.add("配置 canonical 地址避免重复收录");
        }
        if (!Boolean.TRUE.equals(request.structuredDataConfigured())) {
            score -= 5; actions.add("补充符合页面类型的结构化数据");
        }
        if (!Boolean.TRUE.equals(request.mobileFriendly())) {
            score -= 15; actions.add("修复移动端可读性和交互问题");
        }
        score = Math.max(0, score);
        String status = score >= 85 ? "READY" : score >= 60 ? "IMPROVE" : "BLOCK";
        return new Result(status, score, missingAlt, List.copyOf(actions));
    }
}
