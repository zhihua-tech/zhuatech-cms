/* Copyright 2026 上海如静知华信息科技有限公司 */
package cn.zhuatech.cms;
import cn.zhuatech.cms.service.ContentLifecycleService;import org.junit.jupiter.api.Test;import static org.junit.jupiter.api.Assertions.*;
class ContentLifecycleServiceTests {private final ContentLifecycleService service=new ContentLifecycleService();@Test void blocksHighRiskStaleContent(){var r=service.evaluate(new ContentLifecycleService.Request("A1",500,180,0,2,true,false));assertEquals("RETIRE_OR_BLOCK",r.status());}@Test void retainsFreshOwnedContent(){var r=service.evaluate(new ContentLifecycleService.Request("A2",30,180,1000,0,false,true));assertEquals("HEALTHY",r.status());}}
