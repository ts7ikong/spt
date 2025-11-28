<template>
    <view>
        <!--标题和返回-->
		<cu-custom :bgColor="NavBarColor" isBack :backRouterName="backRouteName">
			<block slot="backText">返回</block>
			<block slot="content">重大危险源信息</block>
		</cu-custom>
		 <!--表单区域-->
		<view>
			<form>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">企业名称：</text></view>
                  <input  placeholder="请输入企业名称" v-model="model.companyCode"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">危险源名称：</text></view>
                  <input  placeholder="请输入危险源名称" v-model="model.hazardName"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">危险源编码：</text></view>
                  <input  placeholder="请输入危险源编码" v-model="model.hazardCode"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">危险源等级：</text></view>
                  <input type="number" placeholder="请输入危险源等级" v-model="model.level"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">危险源简称：</text></view>
                  <input  placeholder="请输入危险源简称" v-model="model.hazardShortName"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">R值：</text></view>
                  <input  placeholder="请输入R值" v-model="model.rvalue"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">重大危险源分类：</text></view>
                  <input  placeholder="请输入重大危险源分类" v-model="model.hazardFactility"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">行政区域编码：</text></view>
                  <input  placeholder="请输入行政区域编码" v-model="model.areaCode"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">地址：</text></view>
                  <input  placeholder="请输入地址" v-model="model.address"/>
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
                  <view class="title"><text space="ensp">投用日期：</text></view>
                  <input  placeholder="请输入投用日期" v-model="model.establishDate"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">周边防护目标最近距离(米)重大危险源与周边重点防护目标最近距离为重大危险源的设备、装置、设施的边缘到周边重点防护目标边缘的最近距离。：</text></view>
                  <input  placeholder="请输入周边防护目标最近距离(米)重大危险源与周边重点防护目标最近距离为重大危险源的设备、装置、设施的边缘到周边重点防护目标边缘的最近距离。" v-model="model.protectionTargetDistance"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">外边界500米返回人数估算：</text></view>
                  <input  placeholder="请输入外边界500米返回人数估算" v-model="model.peoplem"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">是否在化工园区 ：</text></view>
                  <input  placeholder="请输入是否在化工园区 " v-model="model.inIndustrialPark"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">园区名称：</text></view>
                  <input  placeholder="请输入园区名称" v-model="model.industrialParkName"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">生产能力：</text></view>
                  <input  placeholder="请输入生产能力" v-model="model.produceAbility"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">是否涉及重点监管工艺：</text></view>
                  <input  placeholder="请输入是否涉及重点监管工艺" v-model="model.isHazardCrafts"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">装置去危险源关联的重点监管工艺 用逗号隔开：</text></view>
                  <input  placeholder="请输入装置去危险源关联的重点监管工艺 用逗号隔开" v-model="model.hazardCrafts"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">主要负责人：</text></view>
                  <input  placeholder="请输入主要负责人" v-model="model.responsible"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">主要负责人电话：</text></view>
                  <input  placeholder="请输入主要负责人电话" v-model="model.responsiblePhone"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">主要负责人职务：</text></view>
                  <input  placeholder="请输入主要负责人职务" v-model="model.responsiblePost"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">技术负责人：</text></view>
                  <input  placeholder="请输入技术负责人" v-model="model.technical"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">技术负责人电话：</text></view>
                  <input  placeholder="请输入技术负责人电话" v-model="model.technicalPhone"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">技术负责人职务：</text></view>
                  <input  placeholder="请输入技术负责人职务" v-model="model.technicalPost"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">操作负责人：</text></view>
                  <input  placeholder="请输入操作负责人" v-model="model.operation"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">操作负责人职务：</text></view>
                  <input  placeholder="请输入操作负责人职务" v-model="model.operationPost"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">操作负责人电话：</text></view>
                  <input  placeholder="请输入操作负责人电话" v-model="model.operationPhone"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">生产状态：</text></view>
                  <input  placeholder="请输入生产状态" v-model="model.productionStatus"/>
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
        name: "AcceptHazardCodeForm",
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
                  queryById: "/sptsjzx/qyaqjcgl/qyjbxx/zdwxyxx/acceptHazardCode/queryById",
                  add: "/sptsjzx/qyaqjcgl/qyjbxx/zdwxyxx/acceptHazardCode/add",
                  edit: "/sptsjzx/qyaqjcgl/qyjbxx/zdwxyxx/acceptHazardCode/edit",
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
