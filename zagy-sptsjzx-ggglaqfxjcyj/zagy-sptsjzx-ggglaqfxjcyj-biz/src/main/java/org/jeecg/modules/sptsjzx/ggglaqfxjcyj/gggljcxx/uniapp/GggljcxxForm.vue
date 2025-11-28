<template>
    <view>
        <!--标题和返回-->
		<cu-custom :bgColor="NavBarColor" isBack :backRouterName="backRouteName">
			<block slot="backText">返回</block>
			<block slot="content">公共管廊基础信息</block>
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
                  <view class="title"><text space="ensp">园区编码：</text></view>
                  <input  placeholder="请输入园区编码" v-model="model.parkCode"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">管理单位编码：</text></view>
                  <input  placeholder="请输入管理单位编码" v-model="model.companyCode"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">管理单位：</text></view>
                  <input  placeholder="请输入管理单位" v-model="model.companyName"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">管廊编号：</text></view>
                  <input  placeholder="请输入管廊编号" v-model="model.pipeCode"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">管廊名称：</text></view>
                  <input  placeholder="请输入管廊名称" v-model="model.pipeName"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">管廊分类：</text></view>
                  <input  placeholder="请输入管廊分类" v-model="model.pipeType"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">空间位置：</text></view>
                  <input type="number" placeholder="请输入空间位置" v-model="model.pipeSpaceaddress"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">管廊层数：</text></view>
                  <input type="number" placeholder="请输入管廊层数" v-model="model.pipePcs"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">管廊宽度（m）：</text></view>
                  <input type="number" placeholder="请输入管廊宽度（m）" v-model="model.pipeWidth"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">管廊长度（M）：</text></view>
                  <input type="number" placeholder="请输入管廊长度（M）" v-model="model.pipeLength"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">管控距离（m）：</text></view>
                  <input type="number" placeholder="请输入管控距离（m）" v-model="model.pipeDistance"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">建设单位：</text></view>
                  <input  placeholder="请输入建设单位" v-model="model.pipeJunit"/>
                </view>
              </view>
              <my-date label="投用日期：" fields="day" v-model="model.pipeUdate" placeholder="请输入投用日期"></my-date>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">地理位置信息：</text></view>
                  <input  placeholder="请输入地理位置信息" v-model="model.pipeGlocation"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">状态：</text></view>
                  <input  placeholder="请输入状态" v-model="model.pipeState"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">备注：</text></view>
                  <input  placeholder="请输入备注" v-model="model.pipeRemarks"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">资料附件：</text></view>
                  <input  placeholder="请输入资料附件" v-model="model.pipeInfomation"/>
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
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">删除标志：</text></view>
                  <input  placeholder="请输入删除标志" v-model="model.deleted"/>
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
        name: "GggljcxxForm",
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
                  queryById: "/sptsjzx/ggglaqfxjcyj/gggljcxx/gggljcxx/queryById",
                  add: "/sptsjzx/ggglaqfxjcyj/gggljcxx/gggljcxx/add",
                  edit: "/sptsjzx/ggglaqfxjcyj/gggljcxx/gggljcxx/edit",
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
