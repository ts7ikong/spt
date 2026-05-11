<template>
    <view>
        <!--标题和返回-->
		<cu-custom :bgColor="NavBarColor" isBack :backRouterName="backRouteName">
			<block slot="backText">返回</block>
			<block slot="content">摄像头信息</block>
		</cu-custom>
		 <!--表单区域-->
		<view>
			<form>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">视频编码，是第三方的唯一约束：</text></view>
                  <input  placeholder="请输入视频编码，是第三方的唯一约束" v-model="model.videoCode"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">视频名称：</text></view>
                  <input  placeholder="请输入视频名称" v-model="model.videoName"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">所在企业编码：</text></view>
                  <input  placeholder="请输入所在企业编码" v-model="model.companyCode"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">视频所在位置的类型：</text></view>
                  <input  placeholder="请输入视频所在位置的类型" v-model="model.videoLocaleType"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">排序：</text></view>
                  <input type="number" placeholder="请输入排序" v-model="model.videoSort"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">传输协议：</text></view>
                  <input  placeholder="请输入传输协议" v-model="model.transMode"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">码流类型：</text></view>
                  <input  placeholder="请输入码流类型" v-model="model.streamMode"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">监控点录像存储位置：</text></view>
                  <input  placeholder="请输入监控点录像存储位置" v-model="model.recordLocation"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">是否在线：</text></view>
                  <input  placeholder="请输入是否在线" v-model="model.online"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">视频url：</text></view>
                  <input  placeholder="请输入视频url" v-model="model.url"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">描述：</text></view>
                  <input  placeholder="请输入描述" v-model="model.description"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">是否删除：</text></view>
                  <input  placeholder="请输入是否删除" v-model="model.deleted"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">提交到部里用的共享国标编码：</text></view>
                  <input  placeholder="请输入提交到部里用的共享国标编码" v-model="model.gbCode"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">视频数据来源：</text></view>
                  <input  placeholder="请输入视频数据来源" v-model="model.dataSource"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">第三方视频区域编码：</text></view>
                  <input  placeholder="请输入第三方视频区域编码" v-model="model.regionCode"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">录像计划启停用状态：</text></view>
                  <input  placeholder="请输入录像计划启停用状态" v-model="model.recordPlanStatus"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">关联的日常录像计划id：</text></view>
                  <input  placeholder="请输入关联的日常录像计划id" v-model="model.recordPlanId"/>
                </view>
              </view>
              <my-date label="最近在线更新时间：" v-model="model.onlineUpdateTime" placeholder="请输入最近在线更新时间"></my-date>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">最近一次填报的离线原因：</text></view>
                  <input  placeholder="请输入最近一次填报的离线原因" v-model="model.offlineReason"/>
                </view>
              </view>
              <my-date label="最近一次填报的计划上线时间：" v-model="model.planOnlineTime" placeholder="请输入最近一次填报的计划上线时间"></my-date>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">附件的文件路径：</text></view>
                  <input  placeholder="请输入附件的文件路径" v-model="model.attachFilePath"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">附件的文件名：</text></view>
                  <input  placeholder="请输入附件的文件名" v-model="model.attachFileName"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">附件的文件后缀：</text></view>
                  <input  placeholder="请输入附件的文件后缀" v-model="model.attachFileFormat"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">最近一次离线id：</text></view>
                  <input  placeholder="请输入最近一次离线id" v-model="model.offlineId"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">所属园区：</text></view>
                  <input  placeholder="请输入所属园区" v-model="model.parkCode"/>
                </view>
              </view>
              <my-date label="离线时间：" v-model="model.offlineTime" placeholder="请输入离线时间"></my-date>
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
        name: "TbHrmwBaseVideoForm",
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
                  queryById: "/sptsjzx/zdwxyaqgl/zxjc/sxtxx/tbHrmwBaseVideo/queryById",
                  add: "/sptsjzx/zdwxyaqgl/zxjc/sxtxx/tbHrmwBaseVideo/add",
                  edit: "/sptsjzx/zdwxyaqgl/zxjc/sxtxx/tbHrmwBaseVideo/edit",
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
