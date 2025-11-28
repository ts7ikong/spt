<template>
    <view>
        <!--标题和返回-->
		<cu-custom :bgColor="NavBarColor" isBack :backRouterName="backRouteName">
			<block slot="backText">返回</block>
			<block slot="content">续报记录表</block>
		</cu-custom>
		 <!--表单区域-->
		<view>
			<form>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">唯一uuid：</text></view>
                  <input  placeholder="请输入唯一uuid" v-model="model.uuid"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">园区编码：</text></view>
                  <input  placeholder="请输入园区编码" v-model="model.parkCode"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">接警编码：</text></view>
                  <input  placeholder="请输入接警编码" v-model="model.serialCode"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">事故现场图片：</text></view>
                  <input  placeholder="请输入事故现场图片" v-model="model.accidentSceneImg"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">事故最新情况：</text></view>
                  <input  placeholder="请输入事故最新情况" v-model="model.accidentLastSituation"/>
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
        name: "XbjlForm",
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
                  queryById: "/sptsjzx/mjyj/yjfzjc/xbjl/xbjl/queryById",
                  add: "/sptsjzx/mjyj/yjfzjc/xbjl/xbjl/add",
                  edit: "/sptsjzx/mjyj/yjfzjc/xbjl/xbjl/edit",
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
