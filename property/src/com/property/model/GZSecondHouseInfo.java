package com.property.model;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.model.AfterExtractor;
import us.codecraft.webmagic.model.annotation.ExtractBy;
import us.codecraft.webmagic.model.annotation.ExtractByUrl;
import us.codecraft.webmagic.model.annotation.HelpUrl;
import us.codecraft.webmagic.model.annotation.TargetUrl;

/**
 * 
 * @author Administrator
 *
 */
@TargetUrl("http://gz\\.58\\.com/ershoufang/\\d+x\\.shtml\\?psid=\\d+\\&entinfo=\\d+_0")
@HelpUrl("http://gz\\.58\\.com/ershoufang/[pn\\d+/]*\\?PGTID=\\d+&ClickID=\\d+")
public class GZSecondHouseInfo implements AfterExtractor {
//	page.putField("property", page.getHtml().xpath("//ul[@class='suUl']/li[5]/a[3]/text()"));
//    page.putField("area", page.getHtml().xpath("//ul[@class='suUl']/li[5]/a[1]/text()"));
//    page.putField("section", page.getHtml().xpath("//ul[@class='suUl']/li[5]/a[2]/text()"));
//    page.putField("address", page.getHtml().xpath("//ul[@class='suUl']/li[6]/div[@class='su_con su_gbconwidth']/text()"));
//    page.putField("layout", page.getHtml().xpath("//ul[@class='suUl']/li[4]/div[@class='su_con']/text()"));
//    page.putField("price", page.getHtml().xpath("//ul[@class='suUl']/li[1]/div[@class='su_con']/span/text()"));
//    page.putField("average_price", page.getHtml().xpath("//ul[@class='suUl']/li[1]/div[@class='su_con']/text()"));
//    page.putField("contact", page.getHtml().xpath("//ul[@class='suUl']/li[8]/div[@class='su_con']/span/a/text()"));
//    page.putField("identity", page.getHtml().xpath("//ul[@class='suUl']/li[8]/div[@class='su_con']/span/em/text()"));
//    page.putField("phone", page.getHtml().xpath("//ul[@class='suUl']/li[9]//div[@class='su_phone']/span/text()"));
//    page.putField("website", page.getUrl());
    @ExtractBy("//ul[@class='suUl']/li[5]/a[3]/text()")
    private String property="";
    
    @ExtractBy("//ul[@class='suUl']/li[5]/a[1]/text()")
    private String area="";
    
    @ExtractBy("//ul[@class='suUl']/li[5]/a[2]/text()")
    private String section="";

    @ExtractBy("//ul[@class='suUl']/li[6]/div[@class='su_con su_gbconwidth']/text()")
    private String address="";

    @ExtractBy("//ul[@class='suUl']/li[4]/div[@class='su_con']/text()")
    private String layout="";

    @ExtractBy("//ul[@class='suUl']/li[1]/div[@class='su_con']/span/text()")
    private String price="";

    @ExtractBy("//ul[@class='suUl']/li[1]/div[@class='su_con']/text()")
    private String average_price="";

    @ExtractBy("//ul[@class='suUl']/li[8]/div[@class='su_con']/span/a/text()")
    private String contact="";

    @ExtractBy("//ul[@class='suUl']/li[8]/div[@class='su_con']/span/em/text()")
    private String identity="";

    @ExtractBy("//ul[@class='suUl']/li[9]//div[@class='su_phone']/span/text()")
    private String phone="";

    @ExtractByUrl
    private String website="";
    
    public String getProperty() {
		return property;
	}



	public void setProperty(String property) {
		this.property = property;
	}



	public String getArea() {
		return area;
	}



	public void setArea(String area) {
		this.area = area;
	}



	public String getSection() {
		return section;
	}



	public void setSection(String section) {
		this.section = section;
	}



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	public String getLayout() {
		return layout;
	}



	public void setLayout(String layout) {
		this.layout = layout;
	}



	public String getPrice() {
		return price;
	}



	public void setPrice(String price) {
		this.price = price;
	}



	public String getAverage_price() {
		return average_price;
	}



	public void setAverage_price(String average_price) {
		this.average_price = average_price;
	}



	public String getContact() {
		return contact;
	}



	public void setContact(String contact) {
		this.contact = contact;
	}



	public String getIdentity() {
		return identity;
	}



	public void setIdentity(String identity) {
		this.identity = identity;
	}



	public String getPhone() {
		return phone;
	}



	public void setPhone(String phone) {
		this.phone = phone;
	}



	public String getWebsite() {
		return website;
	}



	public void setWebsite(String website) {
		this.website = website;
	}



	@Override
    public void afterProcess(Page page) {
    }
}
