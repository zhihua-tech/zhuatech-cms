/* Copyright 2026 Shanghai Rujing Zhihua Information Technology Co., Ltd. · https://www.zhuatech.cn/ */
package cn.zhuatech.cms.repository; import cn.zhuatech.cms.model.ReviewTask; import org.springframework.data.jpa.repository.JpaRepository; import java.util.List;
public interface ReviewTaskRepository extends JpaRepository<ReviewTask,Long>{List<ReviewTask> findTop10ByOrderByIdDesc();long countByResult(ReviewTask.Result result);}
