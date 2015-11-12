package com.property.pipeline;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.PageModelPipeline;

import com.property.dao.GZSecondHouseDAO;
import com.property.model.GZSecondHouseInfo;

/**
 * 
 * @author Administrator
 *
 */
@Component("GZSecondHouseDaoPipeline")
public class GZSecondHouseDaoPipeline implements PageModelPipeline<GZSecondHouseInfo> {

    @Resource
    private GZSecondHouseDAO gZSecondHouseDAO;

    @Override
    public void process(GZSecondHouseInfo gZSecondHouseInfo, Task task) {
    	gZSecondHouseDAO.add(gZSecondHouseInfo);
    }
}
