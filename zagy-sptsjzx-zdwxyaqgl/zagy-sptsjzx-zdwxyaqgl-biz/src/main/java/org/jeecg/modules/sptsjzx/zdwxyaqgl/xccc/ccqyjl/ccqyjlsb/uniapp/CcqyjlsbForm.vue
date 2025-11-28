<template>
    <view>
        <!--标题和返回-->
		<cu-custom :bgColor="NavBarColor" isBack :backRouterName="backRouteName">
			<block slot="backText">返回</block>
			<block slot="content">抽查企业记录上报</block>
		</cu-custom>
		 <!--表单区域-->
		<view>
			<form>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">uuid：</text></view>
                  <input  placeholder="请输入uuid" v-model="model.uuid"/>
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
                  <view class="title"><text space="ensp">生成巡查记录的行政区划：</text></view>
                  <input  placeholder="请输入生成巡查记录的行政区划" v-model="model.genAreaCode"/>
                </view>
              </view>
              <my-date label="抽查日期：" fields="day" v-model="model.patrolDate" placeholder="请输入抽查日期"></my-date>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">抽查记录状态：</text></view>
                  <input  placeholder="请输入抽查记录状态" v-model="model.inspectStatus"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">是否要求企业反馈离线的原因：</text></view>
                  <input  placeholder="请输入是否要求企业反馈离线的原因" v-model="model.needOnline"/>
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
                  <view class="title"><text space="ensp">是否要求企业反馈视频离线的原因：</text></view>
                  <input  placeholder="请输入是否要求企业反馈视频离线的原因" v-model="model.needVideoOnline"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">是否视频在线：</text></view>
                  <input  placeholder="请输入是否视频在线" v-model="model.videoOnline"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">是否要求企业反馈预警等级高的原因：</text></view>
                  <input  placeholder="请输入是否要求企业反馈预警等级高的原因" v-model="model.needWarnRank"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">预警等级：</text></view>
                  <input  placeholder="请输入预警等级" v-model="model.warnRank"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">是否要求企业反馈未上报安全承诺的原因：</text></view>
                  <input  placeholder="请输入是否要求企业反馈未上报安全承诺的原因" v-model="model.needCommitStatus"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">是否安全承诺：</text></view>
                  <input  placeholder="请输入是否安全承诺" v-model="model.commitStatus"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">是否要求企业反馈报警多的原因：</text></view>
                  <input  placeholder="请输入是否要求企业反馈报警多的原因" v-model="model.needAlarmCount"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">未销警数量：</text></view>
                  <input type="number" placeholder="请输入未销警数量" v-model="model.alarmCount"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">是否要求企业反馈最近一周预警等级高的原因：</text></view>
                  <input  placeholder="请输入是否要求企业反馈最近一周预警等级高的原因" v-model="model.needLastWeekWarnRank"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">最近一周最高的预警等级：</text></view>
                  <input  placeholder="请输入最近一周最高的预警等级" v-model="model.lastWeekWarnRank"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">其他异常情况：</text></view>
                  <input  placeholder="请输入其他异常情况" v-model="model.otherContent"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">抽查人：</text></view>
                  <input  placeholder="请输入抽查人" v-model="model.patrolledBy"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">抽查时间：</text></view>
                  <input  placeholder="请输入抽查时间" v-model="model.patrolledTime"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">删除标记：</text></view>
                  <input  placeholder="请输入删除标记" v-model="model.status"/>
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
        name: "CcqyjlsbForm",
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
                  queryById: "/sptsjzx/zdwxyaqgl/xccc/ccqyjl/ccqyjlsb/ccqyjlsb/queryById",
                  add: "/sptsjzx/zdwxyaqgl/xccc/ccqyjl/ccqyjlsb/ccqyjlsb/add",
                  edit: "/sptsjzx/zdwxyaqgl/xccc/ccqyjl/ccqyjlsb/ccqyjlsb/edit",
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
