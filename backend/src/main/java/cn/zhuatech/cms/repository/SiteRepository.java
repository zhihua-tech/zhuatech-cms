/* Copyright 2026 Shanghai Rujing Zhihua Information Technology Co., Ltd. */
package cn.zhuatech.cms.repository; import cn.zhuatech.cms.model.Site; import org.springframework.data.jpa.repository.JpaRepository; import java.util.Optional;
public interface SiteRepository extends JpaRepository<Site,Long>{Optional<Site> findByCode(String code);}
