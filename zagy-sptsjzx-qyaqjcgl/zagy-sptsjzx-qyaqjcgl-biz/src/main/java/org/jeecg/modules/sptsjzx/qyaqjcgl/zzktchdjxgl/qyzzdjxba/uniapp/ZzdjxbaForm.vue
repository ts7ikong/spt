<template>
    <view>
        <!--标题和返回-->
		<cu-custom :bgColor="NavBarColor" isBack :backRouterName="backRouteName">
			<block slot="backText">返回</block>
			<block slot="content">企业装置大检修备案</block>
		</cu-custom>
		 <!--表单区域-->
		<view>
			<form>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">UUID：</text></view>
                  <input  placeholder="请输入UUID" v-model="model.uuid"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">企业名称：</text></view>
                  <input  placeholder="请输入企业名称" v-model="model.companyCode"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">装置名称：</text></view>
                  <input  placeholder="请输入装置名称" v-model="model.deviceName"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">装置编号：</text></view>
                  <input  placeholder="请输入装置编号" v-model="model.deviceCode"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">装置负责人姓名：</text></view>
                  <input  placeholder="请输入装置负责人姓名" v-model="model.plantPrincipalPersonName"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">装置负责人手机号：</text></view>
                  <input  placeholder="请输入装置负责人手机号" v-model="model.plantPrincipalPersonMobile"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">检修名称：</text></view>
                  <input  placeholder="请输入检修名称" v-model="model.maintenanceName"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">检修内容：</text></view>
                  <input  placeholder="请输入检修内容" v-model="model.maintenanceContent"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">重大危险源编码：</text></view>
                  <input  placeholder="请输入重大危险源编码" v-model="model.hazardCode"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">大检修开始时间：</text></view>
                  <input  placeholder="请输入大检修开始时间" v-model="model.maintenanceStartTime"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">大检修计划结束时间：</text></view>
                  <input  placeholder="请输入大检修计划结束时间" v-model="model.maintenanceExpireTime"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">大检修实际结束时间：</text></view>
                  <input  placeholder="请输入大检修实际结束时间" v-model="model.maintenanceEndTime"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">大检修责任人：</text></view>
                  <input  placeholder="请输入大检修责任人" v-model="model.maintenancePersonName"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">大检修责任人手机号：</text></view>
                  <input  placeholder="请输入大检修责任人手机号" v-model="model.maintenancePersonMobile"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">当前状态：</text></view>
                  <input  placeholder="请输入当前状态" v-model="model.operationStatus"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">创建人：</text></view>
                  <input  placeholder="请输入创建人" v-model="model.createBy"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">创建日期：</text></view>
                  <input  placeholder="请输入创建日期" v-model="model.createTime"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">更新人：</text></view>
                  <input  placeholder="请输入更新人" v-model="model.updateBy"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">更新日期：</text></view>
                  <input  placeholder="请输入更新日期" v-model="model.updateTime"/>
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
        name: "ZzdjxbaForm",
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
                  queryById: "/sptsjzx/qyaqjcgl/zzktchdjxgl/qyzzdjxba/zzdjxba/queryById",
                  add: "/sptsjzx/qyaqjcgl/zzktchdjxgl/qyzzdjxba/zzdjxba/add",
                  edit: "/sptsjzx/qyaqjcgl/zzktchdjxgl/qyzzdjxba/zzdjxba/edit",
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
