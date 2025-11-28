<template>
    <view>
        <!--标题和返回-->
		<cu-custom :bgColor="NavBarColor" isBack :backRouterName="backRouteName">
			<block slot="backText">返回</block>
			<block slot="content">巡查记录上报</block>
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
              <my-date label="巡查记录日期：" v-model="model.inspectDate" placeholder="请输入巡查记录日期"></my-date>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">巡查记录编码：</text></view>
                  <input  placeholder="请输入巡查记录编码" v-model="model.inspectCode"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">巡查记录状态：</text></view>
                  <input  placeholder="请输入巡查记录状态" v-model="model.inspectStatus"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">生成巡查记录的行政区划：</text></view>
                  <input  placeholder="请输入生成巡查记录的行政区划" v-model="model.genAreaCode"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">接受巡查的行政区划：</text></view>
                  <input  placeholder="请输入接受巡查的行政区划" v-model="model.areaCode"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">是否需要下级单位反馈视频在线情况：</text></view>
                  <input  placeholder="请输入是否需要下级单位反馈视频在线情况" v-model="model.needOnline"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">在线率：</text></view>
                  <input type="number" placeholder="请输入在线率" v-model="model.onlineRate"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">在线率排名：</text></view>
                  <input type="number" placeholder="请输入在线率排名" v-model="model.onlineSort"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">是否需要下级单位反馈安全承诺情况：</text></view>
                  <input  placeholder="请输入是否需要下级单位反馈安全承诺情况" v-model="model.needVideoOnline"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">视频在线率：</text></view>
                  <input type="number" placeholder="请输入视频在线率" v-model="model.videoOnlineRate"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">视频在线率 排名：</text></view>
                  <input type="number" placeholder="请输入视频在线率 排名" v-model="model.videoOnlineSort"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">是否需要下级单位反馈 安全承诺情况：</text></view>
                  <input  placeholder="请输入是否需要下级单位反馈 安全承诺情况" v-model="model.needPromise"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">安全承诺率：</text></view>
                  <input type="number" placeholder="请输入安全承诺率" v-model="model.promiseRate"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">安全承诺排名：</text></view>
                  <input type="number" placeholder="请输入安全承诺排名" v-model="model.promiseSort"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">是否需要下级单位反馈未销警情况：</text></view>
                  <input  placeholder="请输入是否需要下级单位反馈未销警情况" v-model="model.needLatestAlarm"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">近24小时未销警指标 数：</text></view>
                  <input type="number" placeholder="请输入近24小时未销警指标 数" v-model="model.latestAlarmTargetCount"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">近24小时未销警时长：</text></view>
                  <input  placeholder="请输入近24小时未销警时长" v-model="model.latestAlarmTargetInterval"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">是否需要下级单位反馈预警情况：</text></view>
                  <input  placeholder="请输入是否需要下级单位反馈预警情况" v-model="model.needWarn"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">预警未销警数量：</text></view>
                  <input type="number" placeholder="请输入预警未销警数量" v-model="model.warnCount"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">预警未反馈数量：</text></view>
                  <input type="number" placeholder="请输入预警未反馈数量" v-model="model.warnNoRespCount"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">警示通报未反馈数量：</text></view>
                  <input type="number" placeholder="请输入警示通报未反馈数量" v-model="model.warnNoticeNoRespCount"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">其他巡查内容：</text></view>
                  <input  placeholder="请输入其他巡查内容" v-model="model.otherContent"/>
                </view>
              </view>
              <my-date label="反馈时间：" v-model="model.feedbackTime" placeholder="请输入反馈时间"></my-date>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">联系人：</text></view>
                  <input  placeholder="请输入联系人" v-model="model.contactor"/>
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
        name: "XcjlsbForm",
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
                  queryById: "/sptsjzx/zdwxyaqgl/xccc/xcjl/xcjlsb/xcjlsb/queryById",
                  add: "/sptsjzx/zdwxyaqgl/xccc/xcjl/xcjlsb/xcjlsb/add",
                  edit: "/sptsjzx/zdwxyaqgl/xccc/xcjl/xcjlsb/xcjlsb/edit",
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
