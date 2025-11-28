<template>
    <view>
        <!--标题和返回-->
		<cu-custom :bgColor="NavBarColor" isBack :backRouterName="backRouteName">
			<block slot="backText">返回</block>
			<block slot="content">危化品车辆信息</block>
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
                  <view class="title"><text space="ensp">园区编码：</text></view>
                  <input  placeholder="请输入园区编码" v-model="model.parkCode"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">车牌号码：</text></view>
                  <input  placeholder="请输入车牌号码" v-model="model.licensePlate"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">车牌颜色：</text></view>
                  <input  placeholder="请输入车牌颜色" v-model="model.licensePlateColor"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">驾驶员姓名：</text></view>
                  <input  placeholder="请输入驾驶员姓名" v-model="model.driverName"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">证件号码：</text></view>
                  <input  placeholder="请输入证件号码" v-model="model.driverIdCard"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">押运员姓名：</text></view>
                  <input  placeholder="请输入押运员姓名" v-model="model.supercargoName"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">行驶证：</text></view>
                  <input  placeholder="请输入行驶证" v-model="model.vehicleLicense"/>
                </view>
              </view>
              <my-date label="行驶证有效期起：" fields="day" v-model="model.lenStartDate" placeholder="请输入行驶证有效期起"></my-date>
              <my-date label="行驶证有效期止：" fields="day" v-model="model.lenEndDate" placeholder="请输入行驶证有效期止"></my-date>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">是否有效：</text></view>
                  <input  placeholder="请输入是否有效" v-model="model.whetherLen"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">所属运输企业编码：</text></view>
                  <input  placeholder="请输入所属运输企业编码" v-model="model.companyCode"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">道路运输证号：</text></view>
                  <input  placeholder="请输入道路运输证号" v-model="model.roadTransportCode"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">删除标志：</text></view>
                  <input  placeholder="请输入删除标志" v-model="model.deleted"/>
                </view>
              </view>
              <my-date label="创建日期_企业：" v-model="model.createTimeCompany" placeholder="请输入创建日期_企业"></my-date>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">创建人_企业：</text></view>
                  <input  placeholder="请输入创建人_企业" v-model="model.createByCompany"/>
                </view>
              </view>
              <my-date label="更新日期_企业：" v-model="model.updateTimeCompany" placeholder="请输入更新日期_企业"></my-date>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">更新人_企业：</text></view>
                  <input  placeholder="请输入更新人_企业" v-model="model.updateByCompany"/>
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
        name: "WhpclxxForm",
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
                  queryById: "/sptsjzx/fbhgl/mjkkglxxjcxxgl/whpclxx/whpclxx/queryById",
                  add: "/sptsjzx/fbhgl/mjkkglxxjcxxgl/whpclxx/whpclxx/add",
                  edit: "/sptsjzx/fbhgl/mjkkglxxjcxxgl/whpclxx/whpclxx/edit",
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
