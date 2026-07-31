/* Copyright 2026 Shanghai Rujing Zhihua Information Technology Co., Ltd. */
package cn.zhuatech.cms.dto;
import jakarta.validation.constraints.*; import java.time.*; import java.util.List;
public final class CmsDto { private CmsDto(){}
    public record Metric(String label,String value,String hint,String tone){}
    public record ContentItemView(Long id,String orderNo,String productCode,String productName,String site,String workshop,int plannedQty,int completedQty,int defectQty,LocalDate dueDate,String status,String batchNo,int progress){}
    public record ComponentView(String code,String name,String site,String status,int oee,LocalDateTime lastHeartbeat){}
    public record ReviewTaskView(String reviewTaskNo,String orderNo,String productName,String reviewTaskType,int reviewTaskQty,int defectQty,String result,String inspector){}
    public record Dashboard(List<Metric> metrics,List<ContentItemView> contentItems,List<ComponentView> component,List<ReviewTaskView> reviewTasks){}
    public record ReportRequest(@NotBlank String operationName,@Positive int goodQty,@PositiveOrZero int defectQty,@Size(max=200) String remark){}
    public record ReportResult(String orderNo,int completedQty,int defectQty,int progress,String status){}
}
