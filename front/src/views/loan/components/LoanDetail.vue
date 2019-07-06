<template>
  <div class="createPost-container">
    <el-form ref="postForm" :model="postForm" :rules="rules" class="form-container">
      <sticky :z-index="10" :class-name="'sub-navbar '+postForm.loanStatus">
        <!-- <Sex v-model="postForm.customerSex" /> -->
        <Status v-model="postForm.loanStatus" />
        <Type v-model="postForm.loanType" />
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
              <MDinput v-model="postForm.loanName" :maxlength="100" name="name" required>
                名字
              </MDinput>
            </el-form-item>
            <el-form-item prop="title">
              <MDinput v-model="postForm.customerId" :maxlength="100" name="name" type="number" required>
                贷款人编号
              </MDinput>
            </el-form-item>
            <el-form-item prop="title">
              <MDinput v-model="postForm.userId" :maxlength="100" name="name" type="number" required>
                经理人编号
              </MDinput>
            </el-form-item>
            <el-form-item prop="title">
              <MDinput v-model="postForm.loanFee" :maxlength="100" name="name" type="number" required>
                手续费
              </MDinput>
            </el-form-item>
            <el-form-item prop="title">
              <MDinput v-model="postForm.loanAmount" :maxlength="100" name="name" type="number" required>
                金额
              </MDinput>
            </el-form-item>
            <el-form-item prop="title">
              <MDinput v-model="postForm.loanTotalAmount" :maxlength="100" name="name" type="number" required>
                总金额
              </MDinput>
            </el-form-item>
            <el-form-item prop="title">
              <MDinput v-model="postForm.loanRepayAmount" :maxlength="100" name="name" type="number" required>
                已还金额
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

                <el-col :span="10">
                  <el-form-item label-width="120px" label="还款最后时间:" class="postInfo-container-item">
                    <el-date-picker v-model="postForm.loanEndDate" type="datetime" format="yyyy-MM-dd HH:mm:ss" placeholder="Select date and time" />
                  </el-form-item>
                </el-col>
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
import { fetchLoan, updateLoan } from '@/api/loan'
// import { searchUser } from '@/api/remote-search'
// import Warning from './Warning'
import { Status, Type } from './Dropdown'

const defaultForm = {
  loanId: undefined,
  customerName: '', // 文章题目
  userNickname: '', // 文章题目
  loanStatus: 1,
  loanType: 0,
  loanFee: '',
  loanAmount: '', // 图标地址
  loanTotalAmount: '', // 图标地址
  loanRepayAmount: '', // 文章题目
  loanEndDate: undefined // 贷款截止日期
  // createTime: undefined // 前台展示时间
}

export default {
  name: 'LoanDetail',
  components: { MDinput, Sticky, Status, Type },
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
    loanEndDate: {
      // set and get is useful when the data
      // returned by the back end api is different from the front end
      // back end return => "2013-06-25 06:59:25"
      // front end need timestamp => 1372114765000
      get() {
        return (+new Date(this.postForm.loanEndDate))
      },
      set(val) {
        this.postForm.loanEndDate = new Date(val)
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
      const loanId = this.$route.params && this.$route.params.loanId
      this.fetchData(loanId)
    } else {
      this.postForm = Object.assign({}, defaultForm)
    }

    // Why need to make a copy of this.$route here?
    // Because if you enter this page and quickly switch tag, may be in the execution of the setTagsViewTitle function, this.$route is no longer pointing to the current page
    // https://github.com/PanJiaChen/vue-element-admin/issues/1221
    this.tempRoute = Object.assign({}, this.$route)
  },
  methods: {
    fetchData(loanId) {
      fetchLoan(loanId).then(response => {
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
      const title = this.lang === 'zh' ? '编辑贷款' : 'Edit Loan'
      const route = Object.assign({}, this.tempRoute, { title: `${title}-${this.postForm.loanId}` })
      this.$store.dispatch('tagsView/updateVisitedView', route)
    },
    setPageTitle() {
      const title = 'Edit Loan'
      document.title = `${title} - ${this.postForm.loanName}`
    },
    dateFormat(time) {
      var date = new Date(time)
      var year = date.getFullYear()
      var month = date.getMonth() + 1 < 10 ? '0' + (date.getMonth() + 1) : date.getMonth() + 1
      var day = date.getDate() < 10 ? '0' + date.getDate() : date.getDate()
      var hours = date.getHours() < 10 ? '0' + date.getHours() : date.getHours()
      var minutes = date.getMinutes() < 10 ? '0' + date.getMinutes() : date.getMinutes()
      var seconds = date.getSeconds() < 10 ? '0' + date.getSeconds() : date.getSeconds()
      // 拼接
      return year + '-' + month + '-' + day + ' ' + hours + ':' + minutes + ':' + seconds
    },
    submitForm() {
      // console.log(this.postForm)
      this.$refs.postForm.validate(valid => {
        this.postForm.createTime = null
        this.postForm.modifyTime = null
        this.postForm.loanEndDate = this.dateFormat(this.loanEndDate)
        updateLoan(this.postForm).then(response => {
          console.log(response)
          this.postForm = response.data
          // this.postForm.marketingStatus = 1
          // this.loading = true
          this.$notify({
            title: '成功',
            message: '发布成功',
            type: 'success',
            duration: 2000
          })
          // this.loading = false
        }).catch(err => {
          console.log(err)
        })
      })
    }

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

