<template>
    <view>
        <!--标题和返回-->
		<cu-custom :bgColor="NavBarColor" isBack :backRouterName="backRouteName">
			<block slot="backText">返回</block>
			<block slot="content">指标监测实时数据</block>
		</cu-custom>
		 <!--表单区域-->
		<view>
			<form>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">指标编码：</text></view>
                  <input  placeholder="请输入指标编码" v-model="model.targetCode"/>
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
                  <view class="title"><text space="ensp">指标最新采集值：</text></view>
                  <input type="number" placeholder="请输入指标最新采集值" v-model="model.lastValue"/>
                </view>
              </view>
              <my-date label="指标最新采集时间：" v-model="model.lastCollectTime" placeholder="请输入指标最新采集时间"></my-date>
              <my-date label="指标最新值更新时间：" v-model="model.lastValueUpdateTime" placeholder="请输入指标最新值更新时间"></my-date>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">指标当前状态：</text></view>
                  <input  placeholder="请输入指标当前状态" v-model="model.targetStatus"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">最近报警销警值：</text></view>
                  <input type="number" placeholder="请输入最近报警销警值" v-model="model.lastAlarmValue"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">最近报警状态：</text></view>
                  <input  placeholder="请输入最近报警状态" v-model="model.lastAlarmStatus"/>
                </view>
              </view>
              <my-date label="最近报销警时间：" v-model="model.lastAlarmTime" placeholder="请输入最近报销警时间"></my-date>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">最近一次报警记录id：</text></view>
                  <input  placeholder="请输入最近一次报警记录id" v-model="model.lastAlarmId"/>
                </view>
              </view>
              <my-date label="指标当前状态更新时间：" v-model="model.targetStatusUpdateTime" placeholder="请输入指标当前状态更新时间"></my-date>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">指标数据质量状态（是否超量程）：</text></view>
                  <input  placeholder="请输入指标数据质量状态（是否超量程）" v-model="model.valueQualityStatus"/>
                </view>
              </view>
              <my-date label="最近报警起始时间：" v-model="model.lastAlarmStarted" placeholder="请输入最近报警起始时间"></my-date>
              <my-date label="最近报销警更新时间：" v-model="model.lastAlarmUpdateTime" placeholder="请输入最近报销警更新时间"></my-date>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">数据源编码：</text></view>
                  <input  placeholder="请输入数据源编码" v-model="model.dataSourceCode"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">是否漏报：</text></view>
                  <input  placeholder="请输入是否漏报" v-model="model.isUnderreporting"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">应触发报警状态：</text></view>
                  <input  placeholder="请输入应触发报警状态" v-model="model.shouldAlarmStatus"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">漏报判定时的指标实时值：</text></view>
                  <input type="number" placeholder="请输入漏报判定时的指标实时值" v-model="model.underreportingValue"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">漏报判定时的指标阈值：</text></view>
                  <input type="number" placeholder="请输入漏报判定时的指标阈值" v-model="model.underreportingBaseValue"/>
                </view>
              </view>
              <my-date label="漏报开始时间：" v-model="model.underreportingStartTime" placeholder="请输入漏报开始时间"></my-date>
              <my-date label="漏报结束时间：" v-model="model.underreportingEndTime" placeholder="请输入漏报结束时间"></my-date>
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
        name: "TbHrmwMoniTargetCurrentForm",
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
                  queryById: "/sptsjzx/zdwxyaqgl/zxjc/zbjcsssj/tbHrmwMoniTargetCurrent/queryById",
                  add: "/sptsjzx/zdwxyaqgl/zxjc/zbjcsssj/tbHrmwMoniTargetCurrent/add",
                  edit: "/sptsjzx/zdwxyaqgl/zxjc/zbjcsssj/tbHrmwMoniTargetCurrent/edit",
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
