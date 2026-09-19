/* Copyright 2026 Shanghai Rujing Zhihua Information Technology Co., Ltd. · https://www.zhuatech.cn/ */
package cn.zhuatech.cms.repository; import cn.zhuatech.cms.model.Component; import org.springframework.data.jpa.repository.JpaRepository; import java.util.List;
/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
public interface ComponentRepository extends JpaRepository<Component,Long>{/**
                                                                            * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                            */
List<Component> findAllByOrderByCodeAsc();/**
                                                                                                                      * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                      */
long countByStatus(Component.Status status);}
