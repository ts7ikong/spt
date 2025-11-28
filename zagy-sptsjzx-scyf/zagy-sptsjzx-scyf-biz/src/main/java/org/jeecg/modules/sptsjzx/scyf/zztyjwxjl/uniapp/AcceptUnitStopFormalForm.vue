<template>
    <view>
        <!--标题和返回-->
		<cu-custom :bgColor="NavBarColor" isBack :backRouterName="backRouteName">
			<block slot="backText">返回</block>
			<block slot="content">装置停用/检维修记录</block>
		</cu-custom>
		 <!--表单区域-->
		<view>
			<form>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">企业名称：</text></view>
                  <input  placeholder="请输入企业名称" v-model="model.companyCode"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">风险分析对象：</text></view>
                  <input  placeholder="请输入风险分析对象" v-model="model.hazardCode"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">风险分析单元id：</text></view>
                  <input  placeholder="请输入风险分析单元id" v-model="model.riskUnitId"/>
                </view>
              </view>
              <my-date label="停用开始时间：" fields="day" v-model="model.stopStartTime" placeholder="请输入停用开始时间"></my-date>
              <my-date label="停用结束时间：" fields="day" v-model="model.stopEndTime" placeholder="请输入停用结束时间"></my-date>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">应用原因：</text></view>
                  <input  placeholder="请输入应用原因" v-model="model.stopReason"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">开停车类型：</text></view>
                  <input  placeholder="请输入开停车类型" v-model="model.startStopType"/>
                </view>
              </view>
              <my-date label="实际结束时间：" fields="day" v-model="model.expireTime" placeholder="请输入实际结束时间"></my-date>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">当前状态：</text></view>
                  <input  placeholder="请输入当前状态" v-model="model.operationStatus"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">开停车责任人：</text></view>
                  <input  placeholder="请输入开停车责任人" v-model="model.startPersonName"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">开停车责任人手机号：</text></view>
                  <input  placeholder="请输入开停车责任人手机号" v-model="model.startPersonMobile"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">创建人姓名：</text></view>
                  <input  placeholder="请输入创建人姓名" v-model="model.createBy"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">创建时间：</text></view>
                  <input  placeholder="请输入创建时间" v-model="model.createDate"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">修改人姓名：</text></view>
                  <input  placeholder="请输入修改人姓名" v-model="model.updateBy"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">修改时间：</text></view>
                  <input  placeholder="请输入修改时间" v-model="model.updateDate"/>
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
        name: "AcceptUnitStopFormalForm",
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
                  queryById: "/sptsjzx/scyf/zztyjwxjl/acceptUnitStopFormal/queryById",
                  add: "/sptsjzx/scyf/zztyjwxjl/acceptUnitStopFormal/add",
                  edit: "/sptsjzx/scyf/zztyjwxjl/acceptUnitStopFormal/edit",
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
