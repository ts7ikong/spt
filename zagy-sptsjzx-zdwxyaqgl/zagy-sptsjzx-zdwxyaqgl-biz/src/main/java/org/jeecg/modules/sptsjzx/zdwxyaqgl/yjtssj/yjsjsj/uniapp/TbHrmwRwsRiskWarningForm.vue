<template>
    <view>
        <!--标题和返回-->
		<cu-custom :bgColor="NavBarColor" isBack :backRouterName="backRouteName">
			<block slot="backText">返回</block>
			<block slot="content">预警事件数据</block>
		</cu-custom>
		 <!--表单区域-->
		<view>
			<form>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">预警趋势：</text></view>
                  <input  placeholder="请输入预警趋势" v-model="model.riskType"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">当前的风险等级，新的动态风险值：</text></view>
                  <input  placeholder="请输入当前的风险等级，新的动态风险值" v-model="model.rank"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">旧的动态风险值：</text></view>
                  <input  placeholder="请输入旧的动态风险值" v-model="model.lastRank"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">若有对应的应急事故，则其应急事故id：</text></view>
                  <input  placeholder="请输入若有对应的应急事故，则其应急事故id" v-model="model.crashId"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">产生预警的企业编码：</text></view>
                  <input  placeholder="请输入产生预警的企业编码" v-model="model.companyCode"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">风险等级risk或预警等级 warn：</text></view>
                  <input  placeholder="请输入风险等级risk或预警等级 warn" v-model="model.type"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">第一次风险等级变更id：</text></view>
                  <input  placeholder="请输入第一次风险等级变更id" v-model="model.firstChangeRankRiskId"/>
                </view>
              </view>
              <my-date label="当前风险结束时间：" v-model="model.endTime" placeholder="请输入当前风险结束时间"></my-date>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">企业风险值：</text></view>
                  <input type="number" placeholder="请输入企业风险值" v-model="model.riskValue"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">重复报警点位数：</text></view>
                  <input type="number" placeholder="请输入重复报警点位数" v-model="model.duplicateAlarmTarget"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">平均报警次数：</text></view>
                  <input type="number" placeholder="请输入平均报警次数" v-model="model.avgAlarm"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">平均消警时长：</text></view>
                  <input type="number" placeholder="请输入平均消警时长" v-model="model.avgDispelTime"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">最长报警时间：</text></view>
                  <input type="number" placeholder="请输入最长报警时间" v-model="model.maxAlarmTime"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">重复报警次数：</text></view>
                  <input type="number" placeholder="请输入重复报警次数" v-model="model.duplicateAlarmCount"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">扰动率得分：</text></view>
                  <input type="number" placeholder="请输入扰动率得分" v-model="model.disturbanceRateScore"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">重复报警次数得分：</text></view>
                  <input type="number" placeholder="请输入重复报警次数得分" v-model="model.duplicateAlarmScore"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">平均报警次数得分：</text></view>
                  <input type="number" placeholder="请输入平均报警次数得分" v-model="model.avgAlarmScore"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">平均消警时长得分：</text></view>
                  <input type="number" placeholder="请输入平均消警时长得分" v-model="model.avgDispelTimeScore"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">最长报警时间得分：</text></view>
                  <input type="number" placeholder="请输入最长报警时间得分" v-model="model.maxAlarmTimeScore"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">动态风险经函数计算后的值：</text></view>
                  <input type="number" placeholder="请输入动态风险经函数计算后的值" v-model="model.riskValueF"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">动态风险详情json：</text></view>
                  <input  placeholder="请输入动态风险详情json" v-model="model.riskData"/>
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
        name: "TbHrmwRwsRiskWarningForm",
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
                  queryById: "/sptsjzx/zdwxyaqgl/yjtssj/yjsjsj/tbHrmwRwsRiskWarning/queryById",
                  add: "/sptsjzx/zdwxyaqgl/yjtssj/yjsjsj/tbHrmwRwsRiskWarning/add",
                  edit: "/sptsjzx/zdwxyaqgl/yjtssj/yjsjsj/tbHrmwRwsRiskWarning/edit",
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
