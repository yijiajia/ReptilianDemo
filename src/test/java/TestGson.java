import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.Map;

class Result{
    private String result;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "Result{" +
                "result='" + result + '\'' +
                '}';
    }
}

/**
 * 测试gson是否可以只转化特定的类
 */
public class TestGson {

    public static void main(String[] args){
        String json = "{'result':'success','code':200,'test':'test'}";
        Gson gson = new Gson();
        Type type = new TypeToken<Result>() {}.getType();
        Result result = gson.fromJson(json,type);
        System.out.println(result.getResult());
    }

}
