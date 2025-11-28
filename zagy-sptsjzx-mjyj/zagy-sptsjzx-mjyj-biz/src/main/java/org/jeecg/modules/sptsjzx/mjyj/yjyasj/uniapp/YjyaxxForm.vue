<template>
    <view>
        <!--标题和返回-->
		<cu-custom :bgColor="NavBarColor" isBack :backRouterName="backRouteName">
			<block slot="backText">返回</block>
			<block slot="content">应急预案信息</block>
		</cu-custom>
		 <!--表单区域-->
		<view>
			<form>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">预案编码：</text></view>
                  <input  placeholder="请输入预案编码" v-model="model.emergencePlanId"/>
                </view>
              </view>
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
                  <view class="title"><text space="ensp">企业编码：</text></view>
                  <input  placeholder="请输入企业编码" v-model="model.companyCode"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">行政区划：</text></view>
                  <input  placeholder="请输入行政区划" v-model="model.areaCode"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">编制单位：</text></view>
                  <input  placeholder="请输入编制单位" v-model="model.preparationDeparetment"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">预案名称：</text></view>
                  <input  placeholder="请输入预案名称" v-model="model.emergencePlanName"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">预案类别：</text></view>
                  <input  placeholder="请输入预案类别" v-model="model.emergencePlanType"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">预案等级：</text></view>
                  <input  placeholder="请输入预案等级" v-model="model.emergencePlanLevel"/>
                </view>
              </view>
              <my-date label="预案评审日期：" fields="day" v-model="model.planReviewDate" placeholder="请输入预案评审日期"></my-date>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">预案评审意见：</text></view>
                  <input  placeholder="请输入预案评审意见" v-model="model.planReviewComments"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">风险是否告知周边单位：</text></view>
                  <input  placeholder="请输入风险是否告知周边单位" v-model="model.riskHasToldYesOrNo"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">风险告知周边的其他单位资料：</text></view>
                  <input  placeholder="请输入风险告知周边的其他单位资料" v-model="model.riskHasToldMaterial"/>
                </view>
              </view>
              <my-date label="初次发布日期：" fields="day" v-model="model.publishedFirstTimeDate" placeholder="请输入初次发布日期"></my-date>
              <my-date label="初次备案日期：" fields="day" v-model="model.recordFirstTimeDate" placeholder="请输入初次备案日期"></my-date>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">备案部门：</text></view>
                  <input  placeholder="请输入备案部门" v-model="model.recordDepart"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">备案部门性质：</text></view>
                  <input  placeholder="请输入备案部门性质" v-model="model.recordDepartNature"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">预案备案登记资料：</text></view>
                  <input  placeholder="请输入预案备案登记资料" v-model="model.planToRecordMaterial"/>
                </view>
              </view>
              <my-date label="最近发布日期：" fields="day" v-model="model.publishedRecentlyDate" placeholder="请输入最近发布日期"></my-date>
              <my-date label="最近定期评估日期：" fields="day" v-model="model.reviewedRecentlyDate" placeholder="请输入最近定期评估日期"></my-date>
              <my-date label="最近备案日期：" fields="day" v-model="model.recordedRecentlyDate" placeholder="请输入最近备案日期"></my-date>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">定期评估周期：</text></view>
                  <input type="number" placeholder="请输入定期评估周期" v-model="model.reviewedRecentlyCycle"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">预案评估状态：</text></view>
                  <input  placeholder="请输入预案评估状态" v-model="model.planReviewedState"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">评估意见：</text></view>
                  <input  placeholder="请输入评估意见" v-model="model.planReviewedComments"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">修订状态：</text></view>
                  <input  placeholder="请输入修订状态" v-model="model.reviseState"/>
                </view>
              </view>
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
        name: "YjyaxxForm",
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
                  queryById: "/sptsjzx/mjyj/yjyasj/yjyaxx/queryById",
                  add: "/sptsjzx/mjyj/yjyasj/yjyaxx/add",
                  edit: "/sptsjzx/mjyj/yjyasj/yjyaxx/edit",
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
