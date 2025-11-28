
package org.jeecg.modules.system.vo.tenant;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


public class TokenDto {
	
        //@Desc("token返回")
        public static class UploadTokenLogDto {
	
            @Data @ApiModel("token返回 上传参数")
            public static class UploadTokenParamDto {

                @ApiModelProperty(value ="token" )
                private String token;

            }
            @Data @ApiModel("token返回 上传参数")
            public static class UploadTokenParamsDto {

                @ApiModelProperty(value ="yhm" )
                private String yhm;
                @ApiModelProperty(value ="token" )
                private String mm;

            }

            @Data @ApiModel("token返回 返回参数")
            public static class UploadTokenLogsBackDto {
	

                         @ApiModelProperty(value ="token" )
                         private String token;


	
            }

            @Data @ApiModel("账号密码 返回参数")
            public static class UploadTokenLogsBacksDto {


                @ApiModelProperty(value ="name" )
                private String name;

                @ApiModelProperty(value ="qltxx" )
                private String qltxx;


            }
            @Data @ApiModel("全链条token查询数据返回 返回参数")
            public static class UploadTokenQltBackDto {

                @ApiModelProperty(value ="name" )
                private String name;
                @ApiModelProperty(value ="phone" )
                private String phone;
                @ApiModelProperty(value ="gender" )
                private String gender;
                @ApiModelProperty(value ="id" )
                private String id;
                @ApiModelProperty(value ="userName" )
                private String userName;
                @ApiModelProperty(value ="orgId" )
                private String orgId;
                @ApiModelProperty(value ="orgName" )
                private String orgName;
                @ApiModelProperty(value ="roles" )
                private String roles;
                @ApiModelProperty(value ="district" )
                private String district;
                @ApiModelProperty(value ="districtName" )
                private String districtName;



            }
        }	
	
	
	
	
	
}	

