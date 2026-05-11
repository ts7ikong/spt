<template>
    <view>
        <!--标题和返回-->
		<cu-custom :bgColor="NavBarColor" isBack :backRouterName="backRouteName">
			<block slot="backText">返回</block>
			<block slot="content">指标监测报警数据</block>
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
              <my-date label="指标报警时间：" v-model="model.alarmTime" placeholder="请输入指标报警时间"></my-date>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">当前报警值：</text></view>
                  <input type="number" placeholder="请输入当前报警值" v-model="model.alarmValue"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">当前报警状态对应的阈值：</text></view>
                  <input type="number" placeholder="请输入当前报警状态对应的阈值" v-model="model.threshold"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">最开始的状态：</text></view>
                  <input  placeholder="请输入最开始的状态" v-model="model.startStatus"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">最坏的状态：</text></view>
                  <input  placeholder="请输入最坏的状态" v-model="model.worstStatus"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">当前的状态：</text></view>
                  <input  placeholder="请输入当前的状态" v-model="model.currentStatus"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">销警类型：</text></view>
                  <input  placeholder="请输入销警类型" v-model="model.dispelType"/>
                </view>
              </view>
              <my-date label="最近的报警状态变更时间：" v-model="model.statusChangedTime" placeholder="请输入最近的报警状态变更时间"></my-date>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">是否销警：</text></view>
                  <input  placeholder="请输入是否销警" v-model="model.isDispel"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">云端阈值2：</text></view>
                  <input type="number" placeholder="请输入云端阈值2" v-model="model.thresholdBase2"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">云端阈值1：</text></view>
                  <input type="number" placeholder="请输入云端阈值1" v-model="model.thresholdBase"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">边缘端阈值1：</text></view>
                  <input type="number" placeholder="请输入边缘端阈值1" v-model="model.thresholdEdge"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">边缘端阈值2：</text></view>
                  <input type="number" placeholder="请输入边缘端阈值2" v-model="model.thresholdEdge2"/>
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
        name: "TbHrmwMoniAlarmForm",
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
                  queryById: "/sptsjzx/zdwxyaqgl/zxjc/zbjcbjsj/tbHrmwMoniAlarm/queryById",
                  add: "/sptsjzx/zdwxyaqgl/zxjc/zbjcbjsj/tbHrmwMoniAlarm/add",
                  edit: "/sptsjzx/zdwxyaqgl/zxjc/zbjcbjsj/tbHrmwMoniAlarm/edit",
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
