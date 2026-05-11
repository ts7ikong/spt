<template>
    <view>
        <!--标题和返回-->
		<cu-custom :bgColor="NavBarColor" isBack :backRouterName="backRouteName">
			<block slot="backText">返回</block>
			<block slot="content">视频智能分析报警数据</block>
		</cu-custom>
		 <!--表单区域-->
		<view>
			<form>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">视频编码：</text></view>
                  <input  placeholder="请输入视频编码" v-model="model.videoCode"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">视频类型：</text></view>
                  <input  placeholder="请输入视频类型" v-model="model.videoType"/>
                </view>
              </view>
              <my-date label="视频报警时间：" v-model="model.alarmTime" placeholder="请输入视频报警时间"></my-date>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">视频报警类型：</text></view>
                  <input  placeholder="请输入视频报警类型" v-model="model.alarmType"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">视频报警动作：</text></view>
                  <input  placeholder="请输入视频报警动作" v-model="model.alarmAction"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">视频报警脉冲频率：</text></view>
                  <input type="number" placeholder="请输入视频报警脉冲频率" v-model="model.alarmFrequency"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">报警截图保存路径：</text></view>
                  <input  placeholder="请输入报警截图保存路径" v-model="model.picUrl"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">图片存储唯一标识：</text></view>
                  <input  placeholder="请输入图片存储唯一标识" v-model="model.svrIndexCode"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">报警截图Base64编码：</text></view>
                  <input  placeholder="请输入报警截图Base64编码" v-model="model.picBase64"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">设备编码，不是视频编码：</text></view>
                  <input  placeholder="请输入设备编码，不是视频编码" v-model="model.deviceCode"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">报警图片文件的绝对路径（含文件名）：</text></view>
                  <input  placeholder="请输入报警图片文件的绝对路径（含文件名）" v-model="model.imgUri"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">报警视频文件的绝对路径（含文件名）：</text></view>
                  <input  placeholder="请输入报警视频文件的绝对路径（含文件名）" v-model="model.videoUri"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">是否销警：</text></view>
                  <input  placeholder="请输入是否销警" v-model="model.isDispel"/>
                </view>
              </view>
              <my-date label="销警时间：" v-model="model.dispelTime" placeholder="请输入销警时间"></my-date>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">是否删除：</text></view>
                  <input  placeholder="请输入是否删除" v-model="model.deleted"/>
                </view>
              </view>
				<view class="padding">
					<button class="cu-btn block bg-blue margin-tb-sm lg" @click="onSubmit">
						<text v-if="loading" class="cuIcon-loading2 cuIconfont-spin"></text>提交
					</button>
				</view>
			</form>
		</view>
    </view>
</template>

<script>
    import myDate from '@/components/my-componets/my-date.vue'

    export default {
        name: "TbHrmwMoniVideoAlarmForm",
        components:{ myDate },
        props:{
          formData:{
              type:Object,
              default:()=>{},
              required:false
          }
        },
        data(){
            return {
				CustomBar: this.CustomBar,
				NavBarColor: this.NavBarColor,
				loading:false,
                model: {},
                backRouteName:'index',
                url: {
                  queryById: "/sptsjzx/zdwxyaqgl/zxjc/spznfxbjsj/tbHrmwMoniVideoAlarm/queryById",
                  add: "/sptsjzx/zdwxyaqgl/zxjc/spznfxbjsj/tbHrmwMoniVideoAlarm/add",
                  edit: "/sptsjzx/zdwxyaqgl/zxjc/spznfxbjsj/tbHrmwMoniVideoAlarm/edit",
                },
            }
        },
        created(){
             this.initFormData();
        },
        methods:{
           initFormData(){
               if(this.formData){
                    let dataId = this.formData.dataId;
                    this.$http.get(this.url.queryById,{params:{id:dataId}}).then((res)=>{
                        if(res.data.success){
                            console.log("表单数据",res);
                            this.model = res.data.result;
                        }
                    })
                }
            },
            onSubmit() {
                let myForm = {...this.model};
                this.loading = true;
                let url = myForm.id?this.url.edit:this.url.add;
				this.$http.post(url,myForm).then(res=>{
				   console.log("res",res)
				   this.loading = false
				   this.$Router.push({name:this.backRouteName})
				}).catch(()=>{
					this.loading = false
				});
            }
        }
    }
</script>
