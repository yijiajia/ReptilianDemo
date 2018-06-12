
package com.netMusic.entity;

/**
 * Auto-generated: 2018-06-06 14:1:37
 */
public class Msg {

    private Result result;
    private int code;
    public void setResult(Result result) {
         this.result = result;
     }
     public Result getResult() {
         return result;
     }

    public void setCode(int code) {
         this.code = code;
     }
     public int getCode() {
         return code;
     }

    @Override
    public String toString() {
        return "Msg{" +
                "result=" + result +
                ", code=" + code +
                '}';
    }
}