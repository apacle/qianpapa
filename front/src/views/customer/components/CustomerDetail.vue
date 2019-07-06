<template>
  <div class="createPost-container">
    <el-form ref="postForm" :model="postForm" :rules="rules" class="form-container">
      <sticky :z-index="10" :class-name="'sub-navbar '+postForm.customerStatus">
        <Sex v-model="postForm.customerSex" />
        <Status v-model="postForm.customerStatus" />
        <!-- <PlatformDropdown v-model="postForm.platforms" /> -->
        <!-- <Icon v-model="postForm.customerIcon" /> -->
        <el-button v-loading="loading" style="margin-left: 10px;" type="success" @click="submitForm">
          编辑
        </el-button>
        <!-- <el-button v-loading="loading" type="warning" @click="draftForm">
          草稿
        </el-button> -->
      </sticky>

      <div class="createPost-main-container">
        <el-row>
          <!-- <Warning /> -->

          <el-col :span="24">
            <el-form-item prop="title">
              <MDinput v-model="postForm.customerName" :maxlength="100" name="name" required>
                名字
              </MDinput>
            </el-form-item>
            <el-form-item prop="title">
              <MDinput v-model="postForm.customerPhone" :minlength="5" :maxlength="11" name="name" type="number" required>
                手机
              </MDinput>
            </el-form-item>
            <el-form-item prop="title">
              <MDinput v-model="postForm.customerEmail" :maxlength="100" name="name" type="email" required>
                邮件
              </MDinput>
            </el-form-item>
            <el-form-item prop="title">
              <MDinput v-model="postForm.customerJob" :maxlength="100" name="name" required>
                工作
              </MDinput>
            </el-form-item>
            <el-form-item prop="title">
              <MDinput v-model="postForm.customerIncome" :maxlength="100" name="name" type="number" required>
                收入(元)
              </MDinput>
            </el-form-item>
            <el-form-item prop="title" class="address">
              <MDinput v-model="postForm.customerAddress" :maxlength="100" name="name" required>
                地址
              </MDinput>
            </el-form-item>
            <div style="clear:both" />
            <div class="postInfo-container">
              <el-row>
                <!-- <el-col :span="8">
                  <el-form-item label-width="60px" label="Author:" class="postInfo-container-item">
                    <el-select v-model="postForm.author" :remote-method="getRemoteUserList" filterable default-first-option remote placeholder="Search user">
                      <el-option v-for="(item,index) in userListOptions" :key="item+index" :label="item" :value="item" />
                    </el-select>
                  </el-form-item>
                </el-col> -->

                <!-- <el-col :span="10">
                  <el-form-item label-width="120px" label="发布时间:" class="postInfo-container-item">
                    <el-date-picker v-model="createTime" type="datetime" format="yyyy-MM-dd HH:mm:ss" placeholder="Select date and time" />
                  </el-form-item>
                </el-col> -->
              </el-row>
            </div>
          </el-col>
        </el-row>

        <!-- <el-form-item style="margin-bottom: 40px;" label-width="70px" label="Summary:">
          <el-input v-model="postForm.content_short" :rows="1" type="textarea" class="article-textarea" autosize placeholder="Please enter the content" />
          <span v-show="contentShortLength" class="word-counter">{{ contentShortLength }}words</span>
        </el-form-item> -->
        <!--
        <el-form-item prop="content" style="margin-bottom: 30px;">
          <Tinymce ref="editor" v-model="postForm.content" :height="400" />
        </el-form-item> -->

        <!-- <el-form-item prop="image_uri" style="margin-bottom: 30px;">
          <Upload v-model="postForm.image_uri" />
        </el-form-item> -->
      </div>
    </el-form>
  </div>
</template>

<script>
// import Tinymce from '@/components/Tinymce'
// import Upload from '@/components/Upload/SingleImage3'
import MDinput from '@/components/MDinput'
import Sticky from '@/components/Sticky' // 粘性header组件
// import { validURL } from '@/utils/validate'
import { fetchCustomer, updateCustomer } from '@/api/customer'
// import { searchUser } from '@/api/remote-search'
// import Warning from './Warning'
import { Status, Sex } from './Dropdown'

const defaultForm = {
  customerId: undefined,
  customerName: '', // 文章题目
  customerStatus: 1,
  customerSex: 1,
  customerPhone: '', // 图标地址
  customerAddress: '', // 图标地址
  customerJob: '' // 文章题目
  // createTime: undefined // 前台展示时间
}

export default {
  name: 'CustomerDetail',
  components: { MDinput, Sticky, Status, Sex },
  props: {
    isEdit: {
      type: Boolean,
      default: false
    }
  },
  data() {
    // const validateRequire = (rule, value, callback) => {
    //   if (value === '') {
    //     this.$message({
    //       message: rule.field + '为必传项',
    //       type: 'error'
    //     })
    //     callback(new Error(rule.field + '为必传项'))
    //   } else {
    //     callback()
    //   }
    // }
    // const validateSourceUri = (rule, value, callback) => {
    //   if (value) {
    //     if (validURL(value)) {
    //       callback()
    //     } else {
    //       this.$message({
    //         message: '外链url填写不正确',
    //         type: 'error'
    //       })
    //       callback(new Error('外链url填写不正确'))
    //     }
    //   } else {
    //     callback()
    //   }
    // }
    return {
      postForm: Object.assign({}, defaultForm),
      loading: false,
      userListOptions: [],
      rules: {
        // image_uri: [{ validator: validateRequire }],
        // title: [{ validator: validateRequire }],
        // content: [{ validator: validateRequire }],
        // CustomerIcon: [{ validator: validateSourceUri, trigger: 'blur' }]
      },
      tempRoute: {}
    }
  },
  computed: {
    // contentShortLength() {
    //   return this.postForm.content_short.length
    // },
    lang() {
      return this.$store.getters.language
    },
    createTime: {
      // set and get is useful when the data
      // returned by the back end api is different from the front end
      // back end return => "2013-06-25 06:59:25"
      // front end need timestamp => 1372114765000
      get() {
        return (+new Date(this.postForm.createTime))
      },
      set(val) {
        this.postForm.createTime = new Date(val)
      }
    }

    // demo: {
    //   title: ''
    // },
    // demoRules: {
    //   title: [{ required: true, trigger: 'change' }]
    // }
  },
  created() {
    if (this.isEdit) {
      const customerId = this.$route.params && this.$route.params.customerId
      this.fetchData(customerId)
    } else {
      this.postForm = Object.assign({}, defaultForm)
    }

    // Why need to make a copy of this.$route here?
    // Because if you enter this page and quickly switch tag, may be in the execution of the setTagsViewTitle function, this.$route is no longer pointing to the current page
    // https://github.com/PanJiaChen/vue-element-admin/issues/1221
    this.tempRoute = Object.assign({}, this.$route)
  },
  methods: {
    fetchData(customerId) {
      fetchCustomer(customerId).then(response => {
        // console.log(response)

        this.postForm = response.data

        // just for test
        // this.postForm.title += `   Article Id:${this.postForm.customerId}`
        // this.postForm.content_short += `   Article Id:${this.postForm.customerId}`

        // set tagsview title
        this.setTagsViewTitle()

        // set page title
        this.setPageTitle()
      }).catch(err => {
        console.log(err)
      })
    },
    setTagsViewTitle() {
      const title = this.lang === 'zh' ? '编辑客户' : 'Edit Customer'
      const route = Object.assign({}, this.tempRoute, { title: `${title}-${this.postForm.customerId}` })
      this.$store.dispatch('tagsView/updateVisitedView', route)
    },
    setPageTitle() {
      const title = 'Edit Customer'
      document.title = `${title} - ${this.postForm.customerName}`
    },
    submitForm() {
      // console.log(this.postForm)
      this.$refs.postForm.validate(valid => {
        this.postForm.createTime = null
        this.postForm.modifyTime = null
        updateCustomer(this.postForm).then(response => {
          // console.log('发布结果' + response)
          this.postForm = response.data
          // this.postForm.marketingStatus = 1
          this.$notify({
            title: '成功',
            message: '发布成功',
            type: 'success',
            duration: 2000
          })
        }).catch(err => {
          console.log(err)
        })
        // if (valid) {
        //   this.loading = true
        //   this.$notify({
        //     title: '成功',
        //     message: '发布成功',
        //     type: 'success',
        //     duration: 2000
        //   })
        //   this.postForm.customerStatus = 1
        //   this.loading = false
        // } else {
        //   console.log('error submit!!')
        //   return false
        // }
      })
    }
    // draftForm() {
    //   // if (this.postForm.content.length === 0 || this.postForm.title.length === 0) {
    //   //   this.$message({
    //   //     message: '请填写必要的标题和内容',
    //   //     type: 'warning'
    //   //   })
    //   //   return
    //   // }
    //   this.$message({
    //     message: '保存成功',
    //     type: 'success',
    //     showClose: true,
    //     duration: 1000
    //   })
    //   this.postForm.customerStatus = 0
    // },
    // getRemoteUserList(query) {
    //   searchUser(query).then(response => {
    //     if (!response.data.items) return
    //     this.userListOptions = response.data.items.map(v => v.name)
    //   })
    // }
  }
}
</script>

<style lang="scss" scoped>
@import "~@/styles/mixin.scss";

.createPost-container {
  position: relative;

  .createPost-main-container {
    padding: 20px 10px;;

    .postInfo-container {
      position: relative;
      @include clearfix;
      margin-bottom: 10px;

      .postInfo-container-item {
        float: left;
      }
    }
  }
.el-col-24 {
    text-align: center;
}
 .el-form-item {
    margin-bottom: 22px;
    float: left;
    width: 25%;
    padding: 0 10px;
  }

   .el-form-item.address{
    width: 50%;
  }

  .word-counter {
    width: 40px;
    position: absolute;
    right: 10px;
    top: 0px;
  }
}

.article-textarea /deep/ {
  textarea {
    padding-right: 40px;
    resize: none;
    border: none;
    border-radius: 0px;
    border-bottom: 1px solid #bfcbd9;
  }
}

.material-input__component.material--raised .material-label[data-v-6bb35d14] {
    top: -36px;
}

.material-input__component .material-input{
  background: #eee;
  padding: 10px 10px;
}

.material-input__component .material-label{
    left: 10px;
    top:4px;
}

.el-form-item--medium .el-form-item__content {
    max-width: calc(100% - 20px);
}

</style>

<style>
  @media (max-width: 999px) {
  .el-form-item {
    width: 50% !important;
  }

  .el-form-item.address{
    width: 100%;
  }
}
</style>

