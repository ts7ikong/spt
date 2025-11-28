<template>
    <view>
        <!--标题和返回-->
		<cu-custom :bgColor="NavBarColor" isBack :backRouterName="backRouteName">
			<block slot="backText">返回</block>
			<block slot="content">危险源化学品信息</block>
		</cu-custom>
		 <!--表单区域-->
		<view>
			<form>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">主键uuid：</text></view>
                  <input  placeholder="请输入主键uuid" v-model="model.uuid"/>
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
                  <view class="title"><text space="ensp">危险源名称：</text></view>
                  <input  placeholder="请输入危险源名称" v-model="model.hazardCode"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">中文名：</text></view>
                  <input  placeholder="请输入中文名" v-model="model.chemicalName"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">别名：</text></view>
                  <input  placeholder="请输入别名" v-model="model.chemicalAlias"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">化学品类型：</text></view>
                  <input type="number" placeholder="请输入化学品类型" v-model="model.chemicalType"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">cas号：</text></view>
                  <input  placeholder="请输入cas号" v-model="model.cas"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">产品生产能力（吨）：</text></view>
                  <input  placeholder="请输入产品生产能力（吨）" v-model="model.capacity"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">产品生产能力气体（方）：</text></view>
                  <input  placeholder="请输入产品生产能力气体（方）" v-model="model.capacityGas"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">产品最大储量（吨）：</text></view>
                  <input  placeholder="请输入产品最大储量（吨）" v-model="model.reserve"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">产品最大储量气体（方：</text></view>
                  <input  placeholder="请输入产品最大储量气体（方" v-model="model.reserveGas"/>
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
                  <view class="title"><text space="ensp">创建人姓名：</text></view>
                  <input  placeholder="请输入创建人姓名" v-model="model.createBy"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">修改时间：</text></view>
                  <input  placeholder="请输入修改时间" v-model="model.updateDate"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">修改人姓名：</text></view>
                  <input  placeholder="请输入修改人姓名" v-model="model.updateBy"/>
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
        name: "WxyhxpxxForm",
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
                  queryById: "/sptsjzx/qyaqjcgl/qyjbxx/wxyhxpxx/wxyhxpxx/queryById",
                  add: "/sptsjzx/qyaqjcgl/qyjbxx/wxyhxpxx/wxyhxpxx/add",
                  edit: "/sptsjzx/qyaqjcgl/qyjbxx/wxyhxpxx/wxyhxpxx/edit",
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
