package com.property;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.model.OOSpider;
import us.codecraft.webmagic.pipeline.PageModelPipeline;

import com.property.model.GZSecondHouseInfo;

/**
 * 
 * @author Administrator
 *
 */
@Component
public class HouseCrawler {

    @Qualifier("GZSecondHouseDaoPipeline")
    @Autowired
    private PageModelPipeline gZSecondHouseDaoPipeline;

    public void crawl() {
        OOSpider.create(Site.me().setUserAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_8_5) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/31.0.1650.57 Safari/537.36"),gZSecondHouseDaoPipeline, GZSecondHouseInfo.class).addUrl("http://gz.58.com/ershoufang/?PGTID=189845110189644868382575786&ClickID=3").thread(5).run();
    }

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:/spring/applicationContext*.xml");
        final HouseCrawler houseCrawler = applicationContext.getBean(HouseCrawler.class);
        houseCrawler.crawl();
    }
}
