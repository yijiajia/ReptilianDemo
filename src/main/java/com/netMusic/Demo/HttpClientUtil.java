package com.netMusic.Demo;

import com.google.gson.Gson;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.FileWriter;
import java.util.*;

/**
 * 爬取知乎推荐
 */
public class HttpClientUtil {

    public static String doPost(String url, Map<String,Object> map, String charset){
        HttpClient httpClient = null;
        HttpPost httpPost = null;
        String result = null;
        try{
            httpClient = HttpClients.createDefault();
            httpPost = new HttpPost(url);
            //设置参数
            List<NameValuePair> list = new ArrayList<NameValuePair>();
            Iterator iterator = map.entrySet().iterator();
            while(iterator.hasNext()){
                Map.Entry<String,Object> elem = (Map.Entry<String, Object>) iterator.next();
                list.add(new BasicNameValuePair(elem.getKey(),(String) elem.getValue()));
            }
            if(list.size() > 0){
                UrlEncodedFormEntity entity = new UrlEncodedFormEntity(list,charset);
                httpPost.setEntity(entity);
            }
            HttpResponse response = httpClient.execute(httpPost);
            if(response != null){
                HttpEntity resEntity = response.getEntity();
                if(resEntity != null){
                    result = EntityUtils.toString(resEntity,charset);
                }
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return result;
    }


    public static void spiderZH2(String url,int offset){
        try {
            //String curl ="https://www.zhihu.com/node/ExploreRecommendListV2";
            Map<String,Object> createMap = new HashMap<String,Object>();
            String charset = "utf-8";
            // method 提交的参数
            createMap.put("method", "next");
            Map<String,Object> map = new HashMap<String, Object>();
            // 分页显示的数据
            map.put("limit", 20);
            map.put("offset", offset);
            createMap.put("method", "next");
            Gson gson = new Gson();
            String mapStr = gson.toJson(map);
            // 请求的参数
            createMap.put("params", mapStr);
            // 根据httpclient模仿post请求
            String httpOrgCreateTestRtn = HttpClientUtil.doPost(url,createMap,charset);
            Map maps = gson.fromJson(httpOrgCreateTestRtn, Map.class);
            String html = maps.get("msg").toString();
            Document doc = Jsoup.parse(html);
            Elements elements =
                    doc.select("div[class=zm-item]").select("h2").
                            select("a[class=question_link]");
            File file = new File("D:\\Code\\TemporaryCode\\zhihuwenda.txt");
            // 遍历每个问题节点
            for (Element question : elements) {
                // 获取连接地址
                String qUrl = question.attr("href");
                // 这里需要判断urlhttp格式
                if(!qUrl.contains("https://")){
                    qUrl = "https://www.zhihu.com"+qUrl;
                }
                Document document2=Jsoup.connect(qUrl)
                        .userAgent("Mozilla/5.0 "
                                + "(iPad; U; CPU OS 4_3_3 like Mac OS X; en-us) "
                                + "AppleWebKit/533.17.9"
                                + " (KHTML, like Gecko) Version/5.0.2 Mobile/8J2 Safari/6533.18.5")
                        .get();
                // 问题标题
                Elements title = document2.select("#root").select("div").select("main").
                        select("div").select("div:nth-child(11)").select("div.QuestionHeader").
                        select("div.QuestionHeader-content").select("div.QuestionHeader-main").
                        select("h1");
                // 回答问题的内容
                Elements content = document2.select("#root").select("div").select("main").
                        select("div").select("div.Question-main").select("div.Question-mainColumn").
                        select("div.Card.AnswerCard").select("div").select("div").
                        select("div.RichContent.RichContent--unescapable").
                        select("div.RichContent-inner");
                if (!file.getParentFile().exists()) {//判断路径是否存在，如果不存在，则创建上一级目录文件夹
                    file.getParentFile().mkdirs();
                }
                FileWriter fileWriter=new FileWriter(file, true);
                fileWriter.write("=============链接:"+qUrl+"\r\n");
                fileWriter.write("=============标题:"+title.get(0).text()+"\r\n");
                fileWriter.write("=============回答:"+content.get(0).text()+"\r\n");
                fileWriter.close();
            }

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void main(String [] args){
        // 这里采用循环的方式去除列表
        String url = "https://www.zhihu.com/node/ExploreRecommendListV2";
        for(int i=1;i<1000;i++){
            spiderZH2(url,59+i*20);
        }
    }




}
