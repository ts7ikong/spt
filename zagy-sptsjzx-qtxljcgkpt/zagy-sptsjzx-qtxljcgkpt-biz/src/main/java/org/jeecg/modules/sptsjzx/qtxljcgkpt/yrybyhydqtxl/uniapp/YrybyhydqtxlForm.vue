<template>
    <view>
        <!--标题和返回-->
		<cu-custom :bgColor="NavBarColor" isBack :backRouterName="backRouteName">
			<block slot="backText">返回</block>
			<block slot="content">易燃易爆有毒有害气体泄漏</block>
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
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">设备编号：</text></view>
                  <input  placeholder="请输入设备编号" v-model="model.equipCode"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">泄漏危化品名称：</text></view>
                  <input  placeholder="请输入泄漏危化品名称" v-model="model.chemName"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">计量单位：</text></view>
                  <input  placeholder="请输入计量单位" v-model="model.unit"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">最大实时值：</text></view>
                  <input type="number" placeholder="请输入最大实时值" v-model="model.concentration"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">气体扩散半径：</text></view>
                  <input type="number" placeholder="请输入气体扩散半径" v-model="model.radius"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">最大实时值的经度：</text></view>
                  <input type="number" placeholder="请输入最大实时值的经度" v-model="model.longitude"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">最大实时值纬度：</text></view>
                  <input type="number" placeholder="请输入最大实时值纬度" v-model="model.latitude"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">删除标记：</text></view>
                  <input  placeholder="请输入删除标记" v-model="model.deleted"/>
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
        name: "YrybyhydqtxlForm",
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
                  queryById: "/sptsjzx/qtxljcgkpt/yrybyhydqtxl/yrybyhydqtxl/queryById",
                  add: "/sptsjzx/qtxljcgkpt/yrybyhydqtxl/yrybyhydqtxl/add",
                  edit: "/sptsjzx/qtxljcgkpt/yrybyhydqtxl/yrybyhydqtxl/edit",
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
