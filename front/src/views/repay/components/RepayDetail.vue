<template>
  <div class="createPost-container">
    <el-form ref="postForm" :model="postForm" :rules="rules" class="form-container">
      <sticky :z-index="10" :class-name="'sub-navbar '+postForm.repayStatus">
        <!-- <Sex v-model="postForm.customerSex" /> -->
        <Status v-model="postForm.repayStatus" />
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
                还款人
              </MDinput>
            </el-form-item>
            <el-form-item prop="title">
              <MDinput v-model="postForm.userNickname" :maxlength="100" name="name" required>
                经理人
              </MDinput>
            </el-form-item>
            <el-form-item prop="title">
              <MDinput v-model="postForm.repayAmount" :maxlength="100" name="name" type="number" required>
                金额
              </MDinput>
            </el-form-item>
            <div style="clear:both" />
            <div class="postInfo-container">
              <el-row>
                <el-col :span="10">
                  <el-form-item label-width="120px" label="还款时间:" class="postInfo-container-item">
                    <el-date-picker v-model="postForm.createTime" type="datetime" format="yyyy-MM-dd HH:mm:ss" placeholder="Select date and time" />
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
import { fetchRepay, updateRepay } from '@/api/repay'
// import { searchUser } from '@/api/remote-search'
// import Warning from './Warning'
import { Status } from './Dropdown'

const defaultForm = {
  repayId: undefined,
  customerName: '', // 文章题目
  userNickname: '', // 文章题目
  repayStatus: 1,
  repayAmount: '', // 图标地址
  createTime: undefined // 贷款截止日期
}

export default {
  name: 'RepayDetail',
  components: { MDinput, Sticky, Status },
  props: {
    isEdit: {
      type: Boolean,
      default: false
    }
  },
  data() {
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
      const repayId = this.$route.params && this.$route.params.repayId
      this.fetchData(repayId)
    } else {
      this.postForm = Object.assign({}, defaultForm)
    }

    // Why need to make a copy of this.$route here?
    // Because if you enter this page and quickly switch tag, may be in the execution of the setTagsViewTitle function, this.$route is no longer pointing to the current page
    // https://github.com/PanJiaChen/vue-element-admin/issues/1221
    this.tempRoute = Object.assign({}, this.$route)
  },
  methods: {
    fetchData(repayId) {
      fetchRepay(repayId).then(response => {
        this.postForm = response.data
        // set tagsview title
        this.setTagsViewTitle()
        // set page title
        this.setPageTitle()
      }).catch(err => {
        console.log(err)
      })
    },
    setTagsViewTitle() {
      const title = this.lang === 'zh' ? '编辑还款' : 'Edit Repay'
      const route = Object.assign({}, this.tempRoute, { title: `${title}-${this.postForm.repayId}` })
      this.$store.dispatch('tagsView/updateVisitedView', route)
    },
    setPageTitle() {
      const title = 'Edit Repay'
      document.title = `${title} - ${this.postForm.customerName}`
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
        updateRepay(this.postForm).then(response => {
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

