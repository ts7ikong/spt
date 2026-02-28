<template>
    <view>
        <!--标题和返回-->
		<cu-custom :bgColor="NavBarColor" isBack :backRouterName="backRouteName">
			<block slot="backText">返回</block>
			<block slot="content">人员定位接入情况</block>
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
                  <view class="title"><text space="ensp">实时数据：</text></view>
                  <input type="number" placeholder="请输入实时数据" v-model="model.realTimeSuccess"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">历史轨迹：</text></view>
                  <input type="number" placeholder="请输入历史轨迹" v-model="model.historyTrackSuccess"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">聚集报警：</text></view>
                  <input type="number" placeholder="请输入聚集报警" v-model="model.crowdAlarmMatch"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">区域报警：</text></view>
                  <input type="number" placeholder="请输入区域报警" v-model="model.areaAlarmMatch"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">人员报警：</text></view>
                  <input type="number" placeholder="请输入人员报警" v-model="model.personAlarmMatch"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">区域边界：</text></view>
                  <input type="number" placeholder="请输入区域边界" v-model="model.geoFormatValid"/>
                </view>
              </view>
              <my-date label="检查时间：" v-model="model.checkTime" placeholder="请输入检查时间"></my-date>
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
        name: "RydwDataQualityExportForm",
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
                  queryById: "/rydwsj/rydwjrqk/rydwDataQualityExport/queryById",
                  add: "/rydwsj/rydwjrqk/rydwDataQualityExport/add",
                  edit: "/rydwsj/rydwjrqk/rydwDataQualityExport/edit",
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
