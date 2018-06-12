package com.netMusic.Demo;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Decument测试，利用Jsoup解析
 * 爬取知乎推荐Demo
 * 存在问题：
 * 1、拿到的页面不是完整的页面，只包含两个答案！！！
 *  （需要使用HttpUtil进行js响应）(或者通过抓包模拟请求拿到api)
 * 2、在遍历时未将回答用户和回答内容分开（已分）
 */
public class DocumentDemo {

    public static void main(String[] args){
        String url = "https://www.zhihu.com/explore/recommendations";
        Map<String,String> cookies = null;
        try {
            cookies = new HashMap<>();
            cookies.put("_xsrf","5f79c6ff-89f2-4a18-95bb-74b8d61045db");
            cookies.put("_zap","ca28f69f-0954-4d63-b64b-4584f55cc70f");
            cookies.put("capsion_ticket","2|1:0|10:1528194797|14:capsion_ticket|44:OTA4M2U1NmRkYjgzNGZiODllMmNjYjE0NTBmYWE3Njc=|523be751c42809bb43f6f6ff6da5bd5f478810abf7c7d61dafd4148f75d2286b");
            cookies.put("d_c0","AFCl2Sn0sw2PTi5LJlMvkdzRG-9gvoCLuJ0=|1528194792");
            cookies.put("q_c1","58d6c8c5b562461fa5ddb9aad2e4d2b5|1528194792000|1528194792000");
            cookies.put("z_c0","2|1:0|10:1528194799|4:z_c0|92:Mi4xRXhQeEFBQUFBQUFBVUtYWktmU3pEU1lBQUFCZ0FsVk43N1FEWEFDNEZXWERMNnNnV0c1cVNZaGY2ai1TNko0dkJn|0989639006f63d51d2082e7a4b065c2b126b003c17c36cb72b5007077e88746c");
            Document document = Jsoup.connect(url).timeout(10000)
                    //模拟火狐浏览器
                    .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/61.0.3163.100 Safari/537.36")
                    .get();

            Element main = document.getElementById("zh-recommend-list-full");
            Elements qUrl = main.select("div:nth-child(2)").select("h2")
                        .select("a[class=question_link]");
            for(Element question:qUrl){
                //abs:href表示拿到绝对路径
                String URL = question.attr("abs:href");
                //下载URL对应的页面,忽略知乎专栏
                if(URL.contains("zhuanlan") || "".equals(URL)){
                    //专栏的数据
                    System.out.println("知乎专栏。。");
                    continue;
                }else{
                    System.out.println("正在爬取数据。。。");
                    //爬知乎时注意选择浏览器的版本，过低的版本访问不了知乎
                    Document qDoc = Jsoup.connect(URL).timeout(10000)
                            .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/61.0.3163.100 Safari/537.36")
                            .get();
                    //可直接用选择器
                    Elements questionMain = qDoc.select("#root > div > main > div > div:nth-child(11) > div.QuestionHeader > div.QuestionHeader-content > div.QuestionHeader-main");
                    Elements title = questionMain.select("h1");
                    Elements detail = questionMain.select("div:nth-child(3)")
                                                    .select("div")
                                                    .select("div")
                                                    .select("div")
                                                    .select("span");


                    Elements qDocAllUrl = qDoc.select("#root > div > main > div > div.Question-main > div > div:nth-child(3) > a");
                    //拿到全部答案的url
                    String qAllUrl = qDocAllUrl.attr("abs:href");
                    //解析url
                    Document qDocAll = Jsoup.connect(qAllUrl)
                            .cookies(cookies)
                            .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/61.0.3163.100 Safari/537.36")
                            .get();
                    //拿到main回答
                    Elements ansMain = qDocAll.select("#QuestionAnswers-answers");
                    //拿到回答数
                    Elements ansNum = ansMain.select("div > div > div.List-header > h4 > span");

                    System.out.println("\n"+"链接："+URL
                            +"\n"+"标题："+title.text()
                            +"\n"+"问题描述："+detail.text());
                    System.out.println("\n"+"问题回答数："+ansNum.text());
                    //拿到回答列表
                    Elements ansList = qDocAll.select("#QuestionAnswers-answers > div > div > div:nth-child(2) > div > div.List-item");
                    //遍历列表
                    for(Element ans:ansList){
                        //回答内容
                        Elements content = ans.select("div.RichContent.RichContent--unescapable > div.RichContent-inner > span");
                       //回答者姓名
                        Elements username = ans.select("#null-toggle > a");
                        System.out.println("\n回答用户；" +username.text()+
                                "\n回答内容："+content.text());

                    }



                }


            }


        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
