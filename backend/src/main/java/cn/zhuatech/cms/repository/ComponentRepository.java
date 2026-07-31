/* Copyright 2026 Shanghai Rujing Zhihua Information Technology Co., Ltd. */
package cn.zhuatech.cms.repository; import cn.zhuatech.cms.model.Component; import org.springframework.data.jpa.repository.JpaRepository; import java.util.List;
public interface ComponentRepository extends JpaRepository<Component,Long>{List<Component> findAllByOrderByCodeAsc();long countByStatus(Component.Status status);}
