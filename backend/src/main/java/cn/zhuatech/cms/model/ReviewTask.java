/* Copyright 2026 Shanghai Rujing Zhihua Information Technology Co., Ltd. · https://www.zhuatech.cn/ */
package cn.zhuatech.cms.model;
import jakarta.persistence.*; import java.time.LocalDateTime;
/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
@Entity @Table(name="cms_review_task") public class ReviewTask extends BaseEntity {
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public enum Result { PENDING, PASSED, FAILED }
    @Column(nullable=false,unique=true,length=32) private String reviewTaskNo; @ManyToOne(optional=false,fetch=FetchType.LAZY) private ContentItem contentItem;
    @Column(nullable=false,length=30) private String reviewTaskType; @Column(nullable=false) private int reviewTaskQty; @Column(nullable=false) private int defectQty; @Enumerated(EnumType.STRING) @Column(nullable=false,length=20) private Result result;
    @Column(length=50) private String inspector; @Column(nullable=false) private LocalDateTime createdAt;
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    protected ReviewTask(){} /**
                              * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                              */
public ReviewTask(String reviewTaskNo,ContentItem contentItem,String reviewTaskType,int reviewTaskQty,int defectQty,Result result,String inspector){this.reviewTaskNo=reviewTaskNo;this.contentItem=contentItem;this.reviewTaskType=reviewTaskType;this.reviewTaskQty=reviewTaskQty;this.defectQty=defectQty;this.result=result;this.inspector=inspector;this.createdAt=LocalDateTime.now();}
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public String getReviewTaskNo(){return reviewTaskNo;} /**
                                                           * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                           */
public ContentItem getContentItem(){return contentItem;} /**
                                                                                                                    * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                    */
public String getReviewTaskType(){return reviewTaskType;} /**
                                                                                                                                                                              * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                                                              */
public int getReviewTaskQty(){return reviewTaskQty;} /**
                                                                                                                                                                                                                                   * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                                                                                                                   */
public int getDefectQty(){return defectQty;} /**
                                                                                                                                                                                                                                                                                * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                                                                                                                                                                */
public Result getResult(){return result;} /**
                                                                                                                                                                                                                                                                                                                          * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                                                                                                                                                                                                          */
public String getInspector(){return inspector;}
}
