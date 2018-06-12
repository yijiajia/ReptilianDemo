package com.netMusic.Demo;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.WebRequest;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.net.URL;

/**
 * document 测试
 *
 */
public class HtmlUnitDemo {

    public static void main(String[] args){
        String url = "https://www.zhihu.com/explore/recommendations";
        String userAgent = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/61.0.3163.100 Safari/537.36";
        try {

            URL link = new URL(url);
    //        String url = "https://www.baidu.com";
            //拿到网页
            WebClient webClient = new WebClient();
            webClient.getOptions().setJavaScriptEnabled(false);
            webClient.getOptions().setCssEnabled(false);
            WebRequest webRequest = new WebRequest(link);
            webRequest.setAdditionalHeader("User-Agent",userAgent);

            final HtmlPage page = webClient.getPage(webRequest);
            Document document = Jsoup.parse(page.asXml());
            System.out.println(document);



        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
