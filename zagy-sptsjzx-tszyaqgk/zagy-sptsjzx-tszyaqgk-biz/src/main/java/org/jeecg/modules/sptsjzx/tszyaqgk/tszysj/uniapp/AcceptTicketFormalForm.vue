<template>
    <view>
        <!--标题和返回-->
		<cu-custom :bgColor="NavBarColor" isBack :backRouterName="backRouteName">
			<block slot="backText">返回</block>
			<block slot="content">特殊作业数据</block>
		</cu-custom>
		 <!--表单区域-->
		<view>
			<form>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">企业编码：</text></view>
                  <input  placeholder="请输入企业编码" v-model="model.companyCode"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">作业类型：</text></view>
                  <input  placeholder="请输入作业类型" v-model="model.ticketType"/>
                </view>
              </view>
              <my-date label="作业开始时间：" fields="day" v-model="model.startTime" placeholder="请输入作业开始时间"></my-date>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">作业结束时间：</text></view>
                  <input  placeholder="请输入作业结束时间" v-model="model.endTime"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">作业地点：</text></view>
                  <input  placeholder="请输入作业地点" v-model="model.ticketPosition"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">作业内容：</text></view>
                  <input  placeholder="请输入作业内容" v-model="model.ticketContent"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">经度：</text></view>
                  <input  placeholder="请输入经度" v-model="model.longitude"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">纬度：</text></view>
                  <input  placeholder="请输入纬度" v-model="model.latitude"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">作业状态：</text></view>
                  <input  placeholder="请输入作业状态" v-model="model.ticketStatus"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">安全监管人员姓名：</text></view>
                  <input  placeholder="请输入安全监管人员姓名" v-model="model.supervisorName"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">施工人员姓名：</text></view>
                  <input  placeholder="请输入施工人员姓名" v-model="model.workerName"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">施工人员id：</text></view>
                  <input  placeholder="请输入施工人员id" v-model="model.personId"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">施工单位名称：</text></view>
                  <input  placeholder="请输入施工单位名称" v-model="model.workDepartment"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">施工单位统一社会信用代码：</text></view>
                  <input  placeholder="请输入施工单位统一社会信用代码" v-model="model.socialCreditCode"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">是否承包商作业：</text></view>
                  <input  placeholder="请输入是否承包商作业" v-model="model.isContractorWork"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">作业负责人：</text></view>
                  <input  placeholder="请输入作业负责人" v-model="model.ticketResponsName"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">负责人联系方式手机号：</text></view>
                  <input  placeholder="请输入负责人联系方式手机号" v-model="model.majorPersonMobile"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">作业是否变更过：</text></view>
                  <input  placeholder="请输入作业是否变更过" v-model="model.isChanged"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">作业变更原因：</text></view>
                  <input  placeholder="请输入作业变更原因" v-model="model.changedCause"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">作业是否取消：</text></view>
                  <input  placeholder="请输入作业是否取消" v-model="model.isCancelled"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">作业作废原因：</text></view>
                  <input  placeholder="请输入作业作废原因" v-model="model.cancelledCause"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">作业票唯一编码：</text></view>
                  <input  placeholder="请输入作业票唯一编码" v-model="model.ticketNum"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">票证地址：</text></view>
                  <input  placeholder="请输入票证地址" v-model="model.ticketPic"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">签发时间：</text></view>
                  <input  placeholder="请输入签发时间" v-model="model.issueTime"/>
                </view>
              </view>
              <my-date label="验收时间：" fields="day" v-model="model.acceptanceTime" placeholder="请输入验收时间"></my-date>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">活动id：</text></view>
                  <input  placeholder="请输入活动id" v-model="model.jobId"/>
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
                  <view class="title"><text space="ensp">创建时间：</text></view>
                  <input  placeholder="请输入创建时间" v-model="model.createDate"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">修改人姓名：</text></view>
                  <input  placeholder="请输入修改人姓名" v-model="model.updateBy"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">修改时间：</text></view>
                  <input  placeholder="请输入修改时间" v-model="model.updateDate"/>
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
        name: "AcceptTicketFormalForm",
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
                  queryById: "/sptsjzx/tszyaqgk/tszysj/acceptTicketFormal/queryById",
                  add: "/sptsjzx/tszyaqgk/tszysj/acceptTicketFormal/add",
                  edit: "/sptsjzx/tszyaqgk/tszysj/acceptTicketFormal/edit",
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
