<template>
    <view>
        <!--标题和返回-->
		<cu-custom :bgColor="NavBarColor" isBack :backRouterName="backRouteName">
			<block slot="backText">返回</block>
			<block slot="content">企业抽查记录详情反馈</block>
		</cu-custom>
		 <!--表单区域-->
		<view>
			<form>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">抽查记录详情id：</text></view>
                  <input  placeholder="请输入抽查记录详情id" v-model="model.inspectCompanyId"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">反馈类型：</text></view>
                  <input  placeholder="请输入反馈类型" v-model="model.replyType"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">情况说明：</text></view>
                  <input  placeholder="请输入情况说明" v-model="model.situation"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">处置措施：</text></view>
                  <input  placeholder="请输入处置措施" v-model="model.measure"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">延期说明：</text></view>
                  <input  placeholder="请输入延期说明" v-model="model.delayInfo"/>
                </view>
              </view>
              <my-date label="延期完成时间：" fields="day" v-model="model.delayDate" placeholder="请输入延期完成时间"></my-date>
              <my-date label="计划完成时间：" fields="day" v-model="model.planDate" placeholder="请输入计划完成时间"></my-date>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">是否完成：</text></view>
                  <input  placeholder="请输入是否完成" v-model="model.isFinish"/>
                </view>
              </view>
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
        name: "TbHrmwBaseInspectCompanyReplyForm",
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
                  queryById: "/sptsjzx/zdwxyaqgl/xccc/ccqyjl/ccqyjl/tbHrmwBaseInspectCompanyReply/queryById",
                  add: "/sptsjzx/zdwxyaqgl/xccc/ccqyjl/ccqyjl/tbHrmwBaseInspectCompanyReply/add",
                  edit: "/sptsjzx/zdwxyaqgl/xccc/ccqyjl/ccqyjl/tbHrmwBaseInspectCompanyReply/edit",
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
