/* Copyright 2026 Shanghai Rujing Zhihua Information Technology Co., Ltd. */
package cn.zhuatech.cms.repository; import cn.zhuatech.cms.model.ContentItem; import org.springframework.data.jpa.repository.JpaRepository; import java.util.List;
public interface ContentItemRepository extends JpaRepository<ContentItem,Long>{List<ContentItem> findAllByOrderByDueDateAsc();List<ContentItem> findBySiteCodeOrderByDueDateAsc(String code);long countByStatus(ContentItem.Status status);}
