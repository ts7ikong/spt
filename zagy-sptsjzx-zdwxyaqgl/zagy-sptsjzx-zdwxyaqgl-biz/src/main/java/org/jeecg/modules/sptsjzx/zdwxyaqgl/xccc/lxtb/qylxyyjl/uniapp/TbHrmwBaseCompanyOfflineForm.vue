<template>
    <view>
        <!--标题和返回-->
		<cu-custom :bgColor="NavBarColor" isBack :backRouterName="backRouteName">
			<block slot="backText">返回</block>
			<block slot="content">企业离线原因记录</block>
		</cu-custom>
		 <!--表单区域-->
		<view>
			<form>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">企业编码：</text></view>
                  <input  placeholder="请输入企业编码" v-model="model.companyCode"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">离线类型：</text></view>
                  <input  placeholder="请输入离线类型" v-model="model.offlineType"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">离线原因：</text></view>
                  <input  placeholder="请输入离线原因" v-model="model.offlineReason"/>
                </view>
              </view>
              <my-date label="离线时间点：" v-model="model.offlineTime" placeholder="请输入离线时间点"></my-date>
              <my-date label="计划上线时间：" v-model="model.planOnlineTime" placeholder="请输入计划上线时间"></my-date>
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
              <my-date label="批次填写报备内容的时间戳：" v-model="model.batchTime" placeholder="请输入批次填写报备内容的时间戳"></my-date>
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
        name: "TbHrmwBaseCompanyOfflineForm",
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
                  queryById: "/sptsjzx/zdwxyaqgl/xccc/lxtb/qylxyyjl/tbHrmwBaseCompanyOffline/queryById",
                  add: "/sptsjzx/zdwxyaqgl/xccc/lxtb/qylxyyjl/tbHrmwBaseCompanyOffline/add",
                  edit: "/sptsjzx/zdwxyaqgl/xccc/lxtb/qylxyyjl/tbHrmwBaseCompanyOffline/edit",
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
