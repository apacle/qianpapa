<template>
  <div class="createPost-container">
    <el-form ref="postForm" :model="postForm" :rules="rules" class="form-container">
      <sticky :z-index="10" :class-name="'sub-navbar '+postForm.userStatus">
        <Sex v-model="postForm.userSex" />
        <Status v-model="postForm.userStatus" />
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
              <MDinput v-model="postForm.userName" :maxlength="100" name="name" required>
                登陆名(不要特殊字符)
              </MDinput>
            </el-form-item>
            <el-form-item prop="title">
              <MDinput v-model="postForm.userPassword" :maxlength="100" name="name" type="password" required>
                密码
              </MDinput>
            </el-form-item>
            <el-form-item prop="title">
              <MDinput v-model="postForm.userNickname" :maxlength="100" name="name" required>
                昵称
              </MDinput>
            </el-form-item>
            <el-form-item prop="title">
              <MDinput v-model="postForm.userPhone" :minlength="5" :maxlength="11" name="name" type="number" required>
                手机
              </MDinput>
            </el-form-item>
            <el-form-item prop="title">
              <MDinput v-model="postForm.userEmail" :maxlength="100" name="name" type="email" required>
                邮件
              </MDinput>
            </el-form-item>
            <el-form-item prop="title" class="address">
              <MDinput v-model="postForm.userAddress" :maxlength="100" name="name" required>
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
import { fetchUser, updateUser } from '@/api/user'
// import { searchUser } from '@/api/remote-search'
// import Warning from './Warning'
import { Status, Sex } from './Dropdown'

const defaultForm = {
  userId: undefined,
  userName: '', // 文章题目
  userPassword: '', // 图标地址
  userStatus: 1,
  userSex: 1,
  userPhone: '', // 图标地址
  userAddress: '' // 图标地址
  // createTime: undefined // 前台展示时间
}

export default {
  name: 'UserDetail',
  components: { MDinput, Sticky, Status, Sex },
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
      const userId = this.$route.params && this.$route.params.userId
      this.fetchData(userId)
    } else {
      this.postForm = Object.assign({}, defaultForm)
    }

    // Why need to make a copy of this.$route here?
    // Because if you enter this page and quickly switch tag, may be in the execution of the setTagsViewTitle function, this.$route is no longer pointing to the current page
    // https://github.com/PanJiaChen/vue-element-admin/issues/1221
    this.tempRoute = Object.assign({}, this.$route)
  },
  methods: {
    fetchData(userId) {
      fetchUser(userId).then(response => {
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
      const title = this.lang === 'zh' ? '编辑客户' : 'Edit User'
      const route = Object.assign({}, this.tempRoute, { title: `${title}-${this.postForm.userId}` })
      this.$store.dispatch('tagsView/updateVisitedView', route)
    },
    setPageTitle() {
      const title = 'Edit User'
      document.title = `${title} - ${this.postForm.userName}`
    },
    submitForm() {
      // console.log(this.postForm)
      this.$refs.postForm.validate(valid => {
        this.postForm.createTime = null
        this.postForm.modifyTime = null
        updateUser(this.postForm).then(response => {
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

