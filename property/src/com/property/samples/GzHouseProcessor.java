package com.property.samples;

import com.property.util.JdbcHelper;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.JsonFilePipeline;
import us.codecraft.webmagic.pipeline.Pipeline;
import us.codecraft.webmagic.processor.PageProcessor;

public class GzHouseProcessor implements PageProcessor{

	public static final String URL_LIST = "http://gz\\.58\\.com/ershoufang/[pn\\d+/]*\\?PGTID=\\d+&ClickID=\\d+";
	public static final String URL_POST = "http://gz\\.58\\.com/ershoufang/\\d+x\\.shtml\\?psid=\\d+\\&entinfo=\\d+_0";
    private Site site = Site
            .me()
            .setDomain("gz.58.com")
            .setSleepTime(3000)
            .setUserAgent(
                    "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_7_2) AppleWebKit/537.31 (KHTML, like Gecko) Chrome/26.0.1410.65 Safari/537.31");

    @Override
    public void process(Page page) {
        //列表页
        if (page.getUrl().regex(URL_LIST).match()) {
            page.addTargetRequests(page.getHtml().xpath("//div[@id=\"infolist\"]").links().regex(URL_POST).all());
            page.addTargetRequests(page.getHtml().links().regex(URL_LIST).all());
            //文章页
        } else {
            page.putField("title", page.getHtml().xpath("//div[@class='bigtitle']/h1/text()"));
            page.putField("property", page.getHtml().xpath("//ul[@class='suUl']/li[5]/a[3]/text()"));
            page.putField("area", page.getHtml().xpath("//ul[@class='suUl']/li[5]/a[1]/text()"));
            page.putField("section", page.getHtml().xpath("//ul[@class='suUl']/li[5]/a[2]/text()"));
            page.putField("address", page.getHtml().xpath("//ul[@class='suUl']/li[6]/div[@class='su_con su_gbconwidth']/text()"));
            page.putField("layout", page.getHtml().xpath("//ul[@class='suUl']/li[4]/div[@class='su_con']/text()"));
            page.putField("price", page.getHtml().xpath("//ul[@class='suUl']/li[1]/div[@class='su_con']/span/text()"));
            page.putField("average_price", page.getHtml().xpath("//ul[@class='suUl']/li[1]/div[@class='su_con']/text()"));
            page.putField("contact", page.getHtml().xpath("//ul[@class='suUl']/li[8]/div[@class='su_con']/span/a/text()"));
            page.putField("identity", page.getHtml().xpath("//ul[@class='suUl']/li[8]/div[@class='su_con']/span/em/text()"));
            page.putField("phone", page.getHtml().xpath("//ul[@class='suUl']/li[9]//div[@class='su_phone']/span/text()"));
            page.putField("website", page.getUrl());
        }
    }

    @Override
    public Site getSite() {
        return site;
    }

    public static void main(String[] args) {
    	//http://gz.58.com/ershoufang/
        Spider.create(new GzHouseProcessor()).addUrl("http://gz.58.com/ershoufang/?PGTID=189845110189644868382575786&ClickID=3").addPipeline(new Pipeline() {
			@Override
			public void process(ResultItems items, Task arg1) {
				JdbcHelper.insertInfo(items);
			}
		})
        .thread(5).run();
    }

}
