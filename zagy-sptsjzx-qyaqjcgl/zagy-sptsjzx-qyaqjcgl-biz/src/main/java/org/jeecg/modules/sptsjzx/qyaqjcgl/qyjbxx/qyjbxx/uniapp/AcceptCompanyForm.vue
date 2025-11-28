<template>
    <view>
        <!--标题和返回-->
		<cu-custom :bgColor="NavBarColor" isBack :backRouterName="backRouteName">
			<block slot="backText">返回</block>
			<block slot="content">企业基本信息</block>
		</cu-custom>
		 <!--表单区域-->
		<view>
			<form>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">公司名称：</text></view>
                  <input  placeholder="请输入公司名称" v-model="model.name"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">企业编码：</text></view>
                  <input  placeholder="请输入企业编码" v-model="model.code"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">区县名称：</text></view>
                  <input  placeholder="请输入区县名称" v-model="model.countryname"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">所属园区：</text></view>
                  <input type="number" placeholder="请输入所属园区" v-model="model.yqType"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">是否生产企业：</text></view>
                  <input type="number" placeholder="请输入是否生产企业" v-model="model.isScqy"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">是否重大危险源企业：</text></view>
                  <input type="number" placeholder="请输入是否重大危险源企业" v-model="model.isZdwxy"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">是否统建双控企业：</text></view>
                  <input type="number" placeholder="请输入是否统建双控企业" v-model="model.isTjsk"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">是否统建作业票企业：</text></view>
                  <input type="number" placeholder="请输入是否统建作业票企业" v-model="model.isTjzyp"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">企业类型：</text></view>
                  <input  placeholder="请输入企业类型" v-model="model.companyTypeName"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">企业作业票接入状态：</text></view>
                  <input type="number" placeholder="请输入企业作业票接入状态" v-model="model.isCompanyTicket"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">企业人员定位接入状态：</text></view>
                  <input type="number" placeholder="请输入企业人员定位接入状态" v-model="model.isCompanyAlarm"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">双控是否接入：</text></view>
                  <input type="number" placeholder="请输入双控是否接入" v-model="model.isbuild"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">化学品登记系统编码：</text></view>
                  <input  placeholder="请输入化学品登记系统编码" v-model="model.nrccCode"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">父级企业名称：</text></view>
                  <input  placeholder="请输入父级企业名称" v-model="model.parentname"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">父级企业编码：</text></view>
                  <input  placeholder="请输入父级企业编码" v-model="model.parent"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">所属区县省编码：</text></view>
                  <input  placeholder="请输入所属区县省编码" v-model="model.provincecode"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">省名称：</text></view>
                  <input  placeholder="请输入省名称" v-model="model.provincename"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">所属区县城市编码：</text></view>
                  <input  placeholder="请输入所属区县城市编码" v-model="model.citycode"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">城市名称：</text></view>
                  <input  placeholder="请输入城市名称" v-model="model.cityname"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">所属区县区县编码：</text></view>
                  <input  placeholder="请输入所属区县区县编码" v-model="model.countycode"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">所属区县镇编码：</text></view>
                  <input  placeholder="请输入所属区县镇编码" v-model="model.towncode"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">镇名称：</text></view>
                  <input  placeholder="请输入镇名称" v-model="model.townname"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">详细地址：</text></view>
                  <input  placeholder="请输入详细地址" v-model="model.detail"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">经度：</text></view>
                  <input type="number" placeholder="请输入经度" v-model="model.longitude"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">纬度：</text></view>
                  <input type="number" placeholder="请输入纬度" v-model="model.latitude"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">统一社会信用编码：</text></view>
                  <input  placeholder="请输入统一社会信用编码" v-model="model.creditcode"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">法定代表人：</text></view>
                  <input  placeholder="请输入法定代表人" v-model="model.legal"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">注册地址：</text></view>
                  <input  placeholder="请输入注册地址" v-model="model.address"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">企业秘钥：</text></view>
                  <input  placeholder="请输入企业秘钥" v-model="model.secretKey"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">成立日期：</text></view>
                  <input  placeholder="请输入成立日期" v-model="model.setupday"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">主要负责人：</text></view>
                  <input  placeholder="请输入主要负责人" v-model="model.safemainprincipal"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">主要负责人联系电话：</text></view>
                  <input  placeholder="请输入主要负责人联系电话" v-model="model.safemainprincipalphone"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">安全负责人：</text></view>
                  <input  placeholder="请输入安全负责人" v-model="model.safebranchedprincipal"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">安全负责人联系电话：</text></view>
                  <input  placeholder="请输入安全负责人联系电话" v-model="model.safebranchedprincipalphone"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">企业规模：</text></view>
                  <input type="number" placeholder="请输入企业规模" v-model="model.scale"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">企业状态：</text></view>
                  <input type="number" placeholder="请输入企业状态" v-model="model.companyState"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">企业注册所在地地址：</text></view>
                  <input  placeholder="请输入企业注册所在地地址" v-model="model.addressRegistry"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">企业负责人：</text></view>
                  <input  placeholder="请输入企业负责人" v-model="model.responsiblePerson"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">安全负责人电话：</text></view>
                  <input  placeholder="请输入安全负责人电话" v-model="model.safetyResponsiblePhone"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">安全值班室电话：</text></view>
                  <input  placeholder="请输入安全值班室电话" v-model="model.dutyPhone"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">邮政编码：</text></view>
                  <input  placeholder="请输入邮政编码" v-model="model.postCode"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">企业网址：</text></view>
                  <input  placeholder="请输入企业网址" v-model="model.webSite"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">企业类型：</text></view>
                  <input  placeholder="请输入企业类型" v-model="model.companyType"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">经营二级分类：</text></view>
                  <input  placeholder="请输入经营二级分类" v-model="model.businessType"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">进口二级分类：</text></view>
                  <input  placeholder="请输入进口二级分类" v-model="model.importType"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">涉及进口：</text></view>
                  <input  placeholder="请输入涉及进口" v-model="model.isImport"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">经济类型：</text></view>
                  <input  placeholder="请输入经济类型" v-model="model.economicType"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">所属行业门类：</text></view>
                  <input  placeholder="请输入所属行业门类" v-model="model.industryCategory"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">所属行业大类：</text></view>
                  <input  placeholder="请输入所属行业大类" v-model="model.industryClass"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">营业执照经营范围：</text></view>
                  <input  placeholder="请输入营业执照经营范围" v-model="model.businessScope"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">安全生产标准化等级：</text></view>
                  <input  placeholder="请输入安全生产标准化等级" v-model="model.safetyStandardGrad"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">安全生产许可证号：</text></view>
                  <input  placeholder="请输入安全生产许可证号" v-model="model.safetyLicenseNo"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">安全生产许可证有效期开始日期：</text></view>
                  <input  placeholder="请输入安全生产许可证有效期开始日期" v-model="model.safetyLicenseStart"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">安全生产许可证有效期结束日期：</text></view>
                  <input  placeholder="请输入安全生产许可证有效期结束日期" v-model="model.safetyLicenseEnd"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">职工人数：</text></view>
                  <input type="number" placeholder="请输入职工人数" v-model="model.peopleEmployee"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">从业人员人数：</text></view>
                  <input type="number" placeholder="请输入从业人员人数" v-model="model.peoplePractitioner"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">剧毒化学品作业人数：</text></view>
                  <input type="number" placeholder="请输入剧毒化学品作业人数" v-model="model.peopleToxic"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">危险化学品作业人数：</text></view>
                  <input type="number" placeholder="请输入危险化学品作业人数" v-model="model.peopleHazard"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">特种作业人数：</text></view>
                  <input type="number" placeholder="请输入特种作业人数" v-model="model.peopleOperation"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">是否在化工园区内：</text></view>
                  <input  placeholder="请输入是否在化工园区内" v-model="model.inIndustrialPark"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">企业状态：</text></view>
                  <input  placeholder="请输入企业状态" v-model="model.companyStatus"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">厂区面积：</text></view>
                  <input  placeholder="请输入厂区面积" v-model="model.factoryArea"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">边界地理信息：</text></view>
                  <input  placeholder="请输入边界地理信息" v-model="model.rangeGeometryData"/>
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
                  <view class="title"><text space="ensp">静默区域：</text></view>
                  <input  placeholder="请输入静默区域" v-model="model.personnelSlienceArea"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">是否取得安全生产许可证：</text></view>
                  <input  placeholder="请输入是否取得安全生产许可证" v-model="model.isSafetyLicense"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">是否取得危险化学品经营许可证 ：</text></view>
                  <input  placeholder="请输入是否取得危险化学品经营许可证 " v-model="model.isUseLicense"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">危险化学品使用许可证编号：</text></view>
                  <input  placeholder="请输入危险化学品使用许可证编号" v-model="model.useLicenseCode"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">危险化学品使用许可证开始日期：</text></view>
                  <input  placeholder="请输入危险化学品使用许可证开始日期" v-model="model.useLicenseBegin"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">危险化学品使用许可证结束日期：</text></view>
                  <input  placeholder="请输入危险化学品使用许可证结束日期" v-model="model.useLicenseEnd"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">危险化学品使用许可证初次申领日期：</text></view>
                  <input  placeholder="请输入危险化学品使用许可证初次申领日期" v-model="model.useLicenseFirstDate"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">危险化学品使用许可证发证机关：</text></view>
                  <input  placeholder="请输入危险化学品使用许可证发证机关" v-model="model.useLicenseGov"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">危险化学品生产许可证发证机关：</text></view>
                  <input  placeholder="请输入危险化学品生产许可证发证机关" v-model="model.safetyLicenseGov"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">安全生产标准化证书编号：</text></view>
                  <input  placeholder="请输入安全生产标准化证书编号" v-model="model.safetyStandardCode"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">安全标准化等级认证时间：</text></view>
                  <input  placeholder="请输入安全标准化等级认证时间" v-model="model.safetyStandardAuthDate"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">安全标准化等级认证机构：</text></view>
                  <input  placeholder="请输入安全标准化等级认证机构" v-model="model.safetyStandardAuthMachiner"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">危险化学品生产许可证初次申领日期：</text></view>
                  <input  placeholder="请输入危险化学品生产许可证初次申领日期" v-model="model.safetyLicenseFirstDate"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">生产许可范围：</text></view>
                  <input  placeholder="请输入生产许可范围" v-model="model.safetyLicenseRange"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">危险化学品经营许可证编号：</text></view>
                  <input  placeholder="请输入危险化学品经营许可证编号" v-model="model.businessLicenseCode"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">是否危险化学品经营许可证：</text></view>
                  <input  placeholder="请输入是否危险化学品经营许可证" v-model="model.isBusinessLicense"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">危险化学品经营许可证开始日期：</text></view>
                  <input  placeholder="请输入危险化学品经营许可证开始日期" v-model="model.businessLicenseBegin"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">危险化学品经营许可证结束日期：</text></view>
                  <input  placeholder="请输入危险化学品经营许可证结束日期" v-model="model.businessLicenseEnd"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">经营许可范围：</text></view>
                  <input  placeholder="请输入经营许可范围" v-model="model.businessLicenseRange"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">危险化学品许可证首次申领日期：</text></view>
                  <input  placeholder="请输入危险化学品许可证首次申领日期" v-model="model.businessLicenseFirstDate"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">危险化学品经营许可证发证机关：</text></view>
                  <input  placeholder="请输入危险化学品经营许可证发证机关" v-model="model.businessLicenseGov"/>
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
                  <view class="title"><text space="ensp">修改时间：</text></view>
                  <input  placeholder="请输入修改时间" v-model="model.updateDate"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">主键uuid：</text></view>
                  <input  placeholder="请输入主键uuid" v-model="model.uuid"/>
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
        name: "AcceptCompanyForm",
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
                  queryById: "/sptsjzx/qyaqjcgl/qyjbxx/qyjbxx/acceptCompany/queryById",
                  add: "/sptsjzx/qyaqjcgl/qyjbxx/qyjbxx/acceptCompany/add",
                  edit: "/sptsjzx/qyaqjcgl/qyjbxx/qyjbxx/acceptCompany/edit",
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
