<template>
    <view>
        <!--标题和返回-->
		<cu-custom :bgColor="NavBarColor" isBack :backRouterName="backRouteName">
			<block slot="backText">返回</block>
			<block slot="content">“三同时”监管信息表</block>
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
                  <view class="title"><text space="ensp">园区编号：</text></view>
                  <input  placeholder="请输入园区编号" v-model="model.parkCode"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">企业编码：</text></view>
                  <input  placeholder="请输入企业编码" v-model="model.companyCode"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">装置编码：</text></view>
                  <input  placeholder="请输入装置编码" v-model="model.plantCode"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">装置名称：</text></view>
                  <input  placeholder="请输入装置名称" v-model="model.plantName"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">项目名称：</text></view>
                  <input  placeholder="请输入项目名称" v-model="model.projectName"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">项目类型：</text></view>
                  <input  placeholder="请输入项目类型" v-model="model.projectType"/>
                </view>
              </view>
              <my-date label="项目开始日期：" fields="day" v-model="model.projectBeginDate" placeholder="请输入项目开始日期"></my-date>
              <my-date label="项目结束日期：" fields="day" v-model="model.projectEndDate" placeholder="请输入项目结束日期"></my-date>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">项目描述：</text></view>
                  <input  placeholder="请输入项目描述" v-model="model.projectDesc"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">项目状态：</text></view>
                  <input  placeholder="请输入项目状态" v-model="model.projectStatus"/>
                </view>
              </view>
              <my-date label="立项申请日期：" fields="day" v-model="model.approvalApplyForDate" placeholder="请输入立项申请日期"></my-date>
              <my-date label="立项通过日期：" fields="day" v-model="model.approvalPassDate" placeholder="请输入立项通过日期"></my-date>
              <my-date label="设计开始日期：" fields="day" v-model="model.designBeginDate" placeholder="请输入设计开始日期"></my-date>
              <my-date label="设计结束日期：" fields="day" v-model="model.designEndDate" placeholder="请输入设计结束日期"></my-date>
              <my-date label="建设施工开始日期：" fields="day" v-model="model.buildBeginDate" placeholder="请输入建设施工开始日期"></my-date>
              <my-date label="建设施工结束日期：" fields="day" v-model="model.buildEndDate" placeholder="请输入建设施工结束日期"></my-date>
              <my-date label="试生产开始日期：" fields="day" v-model="model.testProductionBeginDate" placeholder="请输入试生产开始日期"></my-date>
              <my-date label="试生产结束日期：" fields="day" v-model="model.testProductionEndDate" placeholder="请输入试生产结束日期"></my-date>
              <my-date label="验收开始日期：" fields="day" v-model="model.acceptanceBeginDate" placeholder="请输入验收开始日期"></my-date>
              <my-date label="验收结束日期：" fields="day" v-model="model.acceptanceEndDate" placeholder="请输入验收结束日期"></my-date>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">立项审批状态：</text></view>
                  <input  placeholder="请输入立项审批状态" v-model="model.approvalStatus"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">设计审批状态：</text></view>
                  <input  placeholder="请输入设计审批状态" v-model="model.designStatus"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">建设施工审批状态：</text></view>
                  <input  placeholder="请输入建设施工审批状态" v-model="model.buildStatus"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">试生产审批状态：</text></view>
                  <input  placeholder="请输入试生产审批状态" v-model="model.testProductionStatus"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">验收审批状态：</text></view>
                  <input  placeholder="请输入验收审批状态" v-model="model.acceptanceStatus"/>
                </view>
              </view>
              <my-date label="总体项目开始时间：" fields="day" v-model="model.overallProjectStartTime" placeholder="请输入总体项目开始时间"></my-date>
              <my-date label="总体项目结束时间：" fields="day" v-model="model.overallProjectEndTime" placeholder="请输入总体项目结束时间"></my-date>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">当前阶段：</text></view>
                  <input  placeholder="请输入当前阶段" v-model="model.currentGeneration"/>
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
        name: "StsjgxxForm",
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
                  queryById: "/sptsjzx/aqjcgl/aqscxzxkgl/stsjgxx/stsjgxx/queryById",
                  add: "/sptsjzx/aqjcgl/aqscxzxkgl/stsjgxx/stsjgxx/add",
                  edit: "/sptsjzx/aqjcgl/aqscxzxkgl/stsjgxx/stsjgxx/edit",
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
