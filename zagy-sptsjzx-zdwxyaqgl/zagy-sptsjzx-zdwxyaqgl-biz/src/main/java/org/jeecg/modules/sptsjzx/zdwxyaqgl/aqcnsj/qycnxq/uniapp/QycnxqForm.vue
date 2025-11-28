<template>
    <view>
        <!--标题和返回-->
		<cu-custom :bgColor="NavBarColor" isBack :backRouterName="backRouteName">
			<block slot="backText">返回</block>
			<block slot="content">企业承诺详情表</block>
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
              <my-date label="承诺日期：" v-model="model.commitDate" placeholder="请输入承诺日期"></my-date>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">生产装置套数：</text></view>
                  <input type="number" placeholder="请输入生产装置套数" v-model="model.unitsNumber"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">运行套数：</text></view>
                  <input type="number" placeholder="请输入运行套数" v-model="model.runNumber"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">停车套数：</text></view>
                  <input type="number" placeholder="请输入停车套数" v-model="model.parkNumber"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">特级动火作业：</text></view>
                  <input type="number" placeholder="请输入特级动火作业" v-model="model.firesNumber"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">一级动火作业：</text></view>
                  <input type="number" placeholder="请输入一级动火作业" v-model="model.fire1Number"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">二级动火作业：</text></view>
                  <input type="number" placeholder="请输入二级动火作业" v-model="model.fire2Number"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">断路作业：</text></view>
                  <input type="number" placeholder="请输入断路作业" v-model="model.roadworkNumber"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">动土作业：</text></view>
                  <input type="number" placeholder="请输入动土作业" v-model="model.soilworkNumber"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">高处作业：</text></view>
                  <input type="number" placeholder="请输入高处作业" v-model="model.highworkNumber"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">临时用电作业：</text></view>
                  <input type="number" placeholder="请输入临时用电作业" v-model="model.electricityworkNumber"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">吊装作业：</text></view>
                  <input type="number" placeholder="请输入吊装作业" v-model="model.liftingworkNumber"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">盲板作业：</text></view>
                  <input type="number" placeholder="请输入盲板作业" v-model="model.blindplateNumber"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">受限空间作业：</text></view>
                  <input type="number" placeholder="请输入受限空间作业" v-model="model.spaceworkNumber"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">检维修作业：</text></view>
                  <input type="number" placeholder="请输入检维修作业" v-model="model.inspectionNumber"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">倒罐作业：</text></view>
                  <input type="number" placeholder="请输入倒罐作业" v-model="model.pourOutNumber"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">清罐作业：</text></view>
                  <input type="number" placeholder="请输入清罐作业" v-model="model.cleanTankNumber"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">切水作业：</text></view>
                  <input type="number" placeholder="请输入切水作业" v-model="model.drainingNumber"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">承包商作业：</text></view>
                  <input type="number" placeholder="请输入承包商作业" v-model="model.contractorNumber"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">变更作业：</text></view>
                  <input type="number" placeholder="请输入变更作业" v-model="model.changedTaskNumber"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">是否有承包商作业：</text></view>
                  <input  placeholder="请输入是否有承包商作业" v-model="model.contractor"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">是否处于试生产期：</text></view>
                  <input  placeholder="请输入是否处于试生产期" v-model="model.trialProduction"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">是否处于开停车状态：</text></view>
                  <input  placeholder="请输入是否处于开停车状态" v-model="model.openParking"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">正在开停车装置数：</text></view>
                  <input type="number" placeholder="请输入正在开停车装置数" v-model="model.openParkingNumber"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">开车装置数：</text></view>
                  <input type="number" placeholder="请输入开车装置数" v-model="model.workNumber"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">停车装置数：</text></view>
                  <input type="number" placeholder="请输入停车装置数" v-model="model.notWorkNumber"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">是否开展中（扩）试：</text></view>
                  <input  placeholder="请输入是否开展中（扩）试" v-model="model.test"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">试生产装置 数：</text></view>
                  <input type="number" placeholder="请输入试生产装置 数" v-model="model.testNumber"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">检维修套数：</text></view>
                  <input type="number" placeholder="请输入检维修套数" v-model="model.overhaulWorkNumber"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">重点监管危险工艺数量：</text></view>
                  <input type="number" placeholder="请输入重点监管危险工艺数量" v-model="model.dangerProcessNumber"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">有无重大隐 患：</text></view>
                  <input  placeholder="请输入有无重大隐 患" v-model="model.mmHazards"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">风险级别：</text></view>
                  <input  placeholder="请输入风险级别" v-model="model.riskGrade"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">承诺人：</text></view>
                  <input  placeholder="请输入承诺人" v-model="model.commitment"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">承诺内容：</text></view>
                  <input  placeholder="请输入承诺内容" v-model="model.commitContent"/>
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
        name: "QycnxqForm",
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
                  queryById: "/sptsjzx/zdwxyaqgl/aqcnsj/qycnxq/qycnxq/queryById",
                  add: "/sptsjzx/zdwxyaqgl/aqcnsj/qycnxq/qycnxq/add",
                  edit: "/sptsjzx/zdwxyaqgl/aqcnsj/qycnxq/qycnxq/edit",
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
