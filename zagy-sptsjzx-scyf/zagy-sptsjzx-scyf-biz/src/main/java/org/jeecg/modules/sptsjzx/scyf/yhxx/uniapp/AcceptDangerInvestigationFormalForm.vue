<template>
    <view>
        <!--标题和返回-->
		<cu-custom :bgColor="NavBarColor" isBack :backRouterName="backRouteName">
			<block slot="backText">返回</block>
			<block slot="content">隐患信息</block>
		</cu-custom>
		 <!--表单区域-->
		<view>
			<form>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">隐患主键uuid：</text></view>
                  <input  placeholder="请输入隐患主键uuid" v-model="model.uuid"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">企业名称：</text></view>
                  <input  placeholder="请输入企业名称" v-model="model.companyCode"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">风险分析对象：</text></view>
                  <input  placeholder="请输入风险分析对象" v-model="model.hazardCode"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">管控措施ID：</text></view>
                  <input  placeholder="请输入管控措施ID" v-model="model.riskMeasureId"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">隐患排查记录ID：</text></view>
                  <input  placeholder="请输入隐患排查记录ID" v-model="model.checkRecordId"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">隐患名称：</text></view>
                  <input  placeholder="请输入隐患名称" v-model="model.dangerName"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">隐患等级：</text></view>
                  <input  placeholder="请输入隐患等级" v-model="model.dangerLevel"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">隐患来源：</text></view>
                  <input  placeholder="请输入隐患来源" v-model="model.dangerSrc"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">隐患治理类型：</text></view>
                  <input  placeholder="请输入隐患治理类型" v-model="model.dangerManageType"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">隐患描述：</text></view>
                  <input  placeholder="请输入隐患描述" v-model="model.dangerDesc"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">隐患产生原因：</text></view>
                  <input  placeholder="请输入隐患产生原因" v-model="model.dangerReason"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">控制措施：</text></view>
                  <input  placeholder="请输入控制措施" v-model="model.controlMeasures"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">资金：</text></view>
                  <input  placeholder="请输入资金" v-model="model.cost"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">隐患治理期限：</text></view>
                  <input  placeholder="请输入隐患治理期限" v-model="model.dangerManageDeadline"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">隐患状态：</text></view>
                  <input  placeholder="请输入隐患状态" v-model="model.dangerState"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">隐患类型：</text></view>
                  <input  placeholder="请输入隐患类型" v-model="model.hazardDangerType"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">隐患类别：</text></view>
                  <input type="number" placeholder="请输入隐患类别" v-model="model.hazardCategory"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">登记人姓名：</text></view>
                  <input  placeholder="请输入登记人姓名" v-model="model.registrant"/>
                </view>
              </view>
              <my-date label="登记时间：" fields="day" v-model="model.registTime" placeholder="请输入登记时间"></my-date>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">整改责任人姓名：</text></view>
                  <input  placeholder="请输入整改责任人姓名" v-model="model.liablePerson"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">验收人：</text></view>
                  <input  placeholder="请输入验收人" v-model="model.checkAcceptPerson"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">验收情况：</text></view>
                  <input  placeholder="请输入验收情况" v-model="model.checkAcceptComment"/>
                </view>
              </view>
              <my-date label="验收时间：" fields="day" v-model="model.checkAcceptTime" placeholder="请输入验收时间"></my-date>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">整改前图片：</text></view>
                  <input  placeholder="请输入整改前图片" v-model="model.pictureBefore"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">整改后图片：</text></view>
                  <input  placeholder="请输入整改后图片" v-model="model.pictureAfter"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">推送状态 ：</text></view>
                  <input type="number" placeholder="请输入推送状态 " v-model="model.pushState"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">推送次数：</text></view>
                  <input type="number" placeholder="请输入推送次数" v-model="model.pushNum"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">是否激活：</text></view>
                  <input type="number" placeholder="请输入是否激活" v-model="model.isActivation"/>
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
        name: "AcceptDangerInvestigationFormalForm",
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
                  queryById: "/sptsjzx/scyf/yhxx/acceptDangerInvestigationFormal/queryById",
                  add: "/sptsjzx/scyf/yhxx/acceptDangerInvestigationFormal/add",
                  edit: "/sptsjzx/scyf/yhxx/acceptDangerInvestigationFormal/edit",
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
