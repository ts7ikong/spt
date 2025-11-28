<template>
    <view>
        <!--标题和返回-->
		<cu-custom :bgColor="NavBarColor" isBack :backRouterName="backRouteName">
			<block slot="backText">返回</block>
			<block slot="content">应急演练计划信息</block>
		</cu-custom>
		 <!--表单区域-->
		<view>
			<form>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">园区编码：</text></view>
                  <input  placeholder="请输入园区编码" v-model="model.parkCode"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">编制单位编码：</text></view>
                  <input  placeholder="请输入编制单位编码" v-model="model.companyCode"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">计划编码：</text></view>
                  <input  placeholder="请输入计划编码" v-model="model.planId"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">计划名称：</text></view>
                  <input  placeholder="请输入计划名称" v-model="model.planName"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">演练类型：</text></view>
                  <input  placeholder="请输入演练类型" v-model="model.drillType"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">预案编码：</text></view>
                  <input  placeholder="请输入预案编码" v-model="model.associatePlanId"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">演练级别：</text></view>
                  <input  placeholder="请输入演练级别" v-model="model.drillLevel"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">演练场景：</text></view>
                  <input  placeholder="请输入演练场景" v-model="model.drillScene"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">演练地点：</text></view>
                  <input  placeholder="请输入演练地点" v-model="model.drillPlace"/>
                </view>
              </view>
              <my-date label="预计完成日期：" fields="day" v-model="model.finishDate" placeholder="请输入预计完成日期"></my-date>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">参与人数：</text></view>
                  <input type="number" placeholder="请输入参与人数" v-model="model.particNum"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">附件：</text></view>
                  <input  placeholder="请输入附件" v-model="model.attach"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">计划状态：</text></view>
                  <input  placeholder="请输入计划状态" v-model="model.planState"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">编制人：</text></view>
                  <input  placeholder="请输入编制人" v-model="model.writerByName"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">审核人：</text></view>
                  <input  placeholder="请输入审核人" v-model="model.checkByName"/>
                </view>
              </view>
              <my-date label="批准时间：" fields="day" v-model="model.authorizeTime" placeholder="请输入批准时间"></my-date>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">删除标志：</text></view>
                  <input  placeholder="请输入删除标志" v-model="model.deleted"/>
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
        name: "YjyljhxxForm",
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
                  queryById: "/sptsjzx/mjyj/yjylsj/yjyljhxx/queryById",
                  add: "/sptsjzx/mjyj/yjylsj/yjyljhxx/add",
                  edit: "/sptsjzx/mjyj/yjylsj/yjyljhxx/edit",
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
