<template>
    <view>
        <!--标题和返回-->
		<cu-custom :bgColor="NavBarColor" isBack :backRouterName="backRouteName">
			<block slot="backText">返回</block>
			<block slot="content">企业事故事件</block>
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
                  <view class="title"><text space="ensp">企业名称：</text></view>
                  <input  placeholder="请输入企业名称" v-model="model.companyCode"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">事故编号：</text></view>
                  <input  placeholder="请输入事故编号" v-model="model.accidentId"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">事故名称：</text></view>
                  <input  placeholder="请输入事故名称" v-model="model.accidentName"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">事故来源：</text></view>
                  <input  placeholder="请输入事故来源" v-model="model.accidentSource"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">事故类型：</text></view>
                  <input  placeholder="请输入事故类型" v-model="model.typeOfAccident"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">事故等级：</text></view>
                  <input  placeholder="请输入事故等级" v-model="model.accidentLevel"/>
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
                  <view class="title"><text space="ensp">死亡人数：</text></view>
                  <input  placeholder="请输入死亡人数" v-model="model.deathToll"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">重伤人数：</text></view>
                  <input  placeholder="请输入重伤人数" v-model="model.seriouslyInjuredNumber"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">轻伤人数：</text></view>
                  <input  placeholder="请输入轻伤人数" v-model="model.minorInjuriesNumber"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">事故概况：</text></view>
                  <input  placeholder="请输入事故概况" v-model="model.accidentDescription"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">处置状态：</text></view>
                  <input  placeholder="请输入处置状态" v-model="model.dispositionStatus"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">上报状态：</text></view>
                  <input  placeholder="请输入上报状态" v-model="model.registrationStatus"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">上报时间：</text></view>
                  <input  placeholder="请输入上报时间" v-model="model.reportionTime"/>
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
                  <view class="title"><text space="ensp">创建人姓名：</text></view>
                  <input  placeholder="请输入创建人姓名" v-model="model.createBy"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">修改时间：</text></view>
                  <input  placeholder="请输入修改时间" v-model="model.updateDate"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">修改人姓名：</text></view>
                  <input  placeholder="请输入修改人姓名" v-model="model.updateBy"/>
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
        name: "QysgsjForm",
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
                  queryById: "/sptsjzx/qyaqjcgl/qyjbxx/qysgsj/qysgsj/queryById",
                  add: "/sptsjzx/qyaqjcgl/qyjbxx/qysgsj/qysgsj/add",
                  edit: "/sptsjzx/qyaqjcgl/qyjbxx/qysgsj/qysgsj/edit",
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
