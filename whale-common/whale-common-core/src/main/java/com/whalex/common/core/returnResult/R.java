package com.whalex.common.core.returnResult;

import cn.hutool.core.util.ObjectUtil;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;
import com.whalex.common.core.constant.ResultStatus;

/**
 * Description: 控制层统一返回结果
 *
 * @author: 🐋鲸鱼
 * date: 2020/7/2 19:48
 */
@Builder
@ToString
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@ApiModel(value = "响应信息主体")
public class R<T> {

    @ApiModelProperty("状态码")
    private Integer code;

    @ApiModelProperty("返回信息")
    private String msg;

    @ApiModelProperty("返回数据")
    private T data;


    public static <T> R<T> ok(){
        return restResult(ResultStatus.SUCCESS,"请求成功",null);
    }

    public static <T> R<T> data(T o){
        if(ObjectUtil.isEmpty(o)) {
            return restResult(ResultStatus.SUCCESS,"无承载数据",o);
        }else{
            return restResult(ResultStatus.SUCCESS,"请求成功",o);
        }
    }

    public static R<Boolean> status(Boolean b){
        if (b){
            return restResult(ResultStatus.SUCCESS,"操作成功",null);
        }
        return restResult(ResultStatus.FAILE,"操作失败",null);
    }

    public static <T> R<T> success(T data){
        return restResult(ResultStatus.SUCCESS,"请求成功",data);
    }

    public static <T> R<T> success(String msg,T data){
        return restResult(ResultStatus.SUCCESS,msg,data);
    }

    public static <T> R<T> faile(T data){
        return restResult(ResultStatus.FAILE,"请求失败",data);
    }

    public static <T> R<T> faile(String msg){
        return restResult(ResultStatus.FAILE,msg,null);
    }

    public static <T> R<T> faile(T data,String msg){
        return restResult(ResultStatus.FAILE,msg,data);
    }

    public static  <T> R<T> restResult(Integer code, String msg, T data) {
       R<T> r = new R();
       r.setCode(code);
       r.setData(data);
       r.setMsg(msg);
       return r;
    }
}
