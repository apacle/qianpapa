<template>
  <div class="createPost-container">
    <el-form ref="postForm" :model="postForm" :rules="rules" class="form-container">
      <sticky :z-index="10" :class-name="'sub-navbar '+postForm.marketingStatus">
        <Status v-model="postForm.marketingStatus" />
        <!-- <PlatformDropdown v-model="postForm.platforms" /> -->
        <Icon v-model="postForm.marketingIcon" />
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
            <el-form-item style="margin-bottom: 40px;" prop="title">
              <MDinput v-model="postForm.marketingName" :maxlength="100" name="name" required>
                标题
              </MDinput>
            </el-form-item>

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
                  <el-form-item label-width="120px" label="发布时间:" class="postInfo-container-item">
                    <el-date-picker v-model="createTime" type="datetime" format="yyyy-MM-dd HH:mm:ss" placeholder="Select date and time" />
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
import { fetchMarketing, updateMarketing } from '@/api/marketing'
import { searchUser } from '@/api/remote-search'
// import Warning from './Warning'
import { Status, Icon } from './Dropdown'

const defaultForm = {
  marketingStatus: 1,
  marketingName: '', // 文章题目
  marketingId: undefined,
  // content: '', // 文章内容
  // content_short: '', // 文章摘要
  marketingIcon: '', // 图标地址
  // image_uri: '', // 文章图片
  createTime: undefined, // 前台展示时间
  // id: undefined,
  // platforms: ['a-platform'],
  // comment_disabled: false,
  importance: 0
}

export default {
  name: 'MarketingDetail',
  components: { MDinput, Sticky, Status, Icon },
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
    const validateSourceUri = (rule, value, callback) => {
      callback()
      // if (value) {
      //   if (validURL(value)) {
      //     callback()
      //   } else {
      //     this.$message({
      //       message: '外链url填写不正确',
      //       type: 'error'
      //     })
      //     callback(new Error('外链url填写不正确'))
      //   }
      // } else {
      //   callback()
      // }
    }
    return {
      postForm: Object.assign({}, defaultForm),
      loading: false,
      userListOptions: [],
      rules: {
        // image_uri: [{ validator: validateRequire }],
        // title: [{ validator: validateRequire }],
        // content: [{ validator: validateRequire }],
        marketingIcon: [{ validator: validateSourceUri, trigger: 'blur' }]
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
  },
  created() {
    if (this.isEdit) {
      const marketingId = this.$route.params && this.$route.params.marketingId
      this.fetchData(marketingId)
    } else {
      this.postForm = Object.assign({}, defaultForm)
    }

    // Why need to make a copy of this.$route here?
    // Because if you enter this page and quickly switch tag, may be in the execution of the setTagsViewTitle function, this.$route is no longer pointing to the current page
    // https://github.com/PanJiaChen/vue-element-admin/issues/1221
    this.tempRoute = Object.assign({}, this.$route)
  },
  methods: {
    fetchData(marketingId) {
      fetchMarketing(marketingId).then(response => {
        console.log(response)

        this.postForm = response.data

        // just for test
        // this.postForm.title += `   Article Id:${this.postForm.marketingId}`
        // this.postForm.content_short += `   Article Id:${this.postForm.marketingId}`

        // set tagsview title
        this.setTagsViewTitle()

        // set page title
        this.setPageTitle()
      }).catch(err => {
        console.log(err)
      })
    },
    setTagsViewTitle() {
      const title = this.lang === 'zh' ? '编辑模板' : 'Edit Marketing'
      const route = Object.assign({}, this.tempRoute, { title: `${title}-${this.postForm.id}` })
      this.$store.dispatch('tagsView/updateVisitedView', route)
    },
    setPageTitle() {
      const title = 'Edit Marketing'
      document.title = `${title} - ${this.postForm.marketingName}`
    },
    submitForm() {
      // console.log(this.postForm)
      this.postForm.createTime = null
      this.postForm.modifyTime = null

      this.$refs.postForm.validate(valid => {
        if (valid) {
          this.loading = true
          updateMarketing(this.postForm).then(response => {
            console.log('发布结果' + response)
            this.postForm = response.data
            // this.postForm.marketingStatus = 1

            this.$notify({
              title: '成功',
              message: '发布文章成功',
              type: 'success',
              duration: 2000
            })
          }).catch(err => {
            console.log(err)
          })

          this.loading = false
        } else {
          console.log('error submit!!')
          return false
        }
      })
    },
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
    //   this.postForm.marketingStatus = 0
    // },
    getRemoteUserList(query) {
      searchUser(query).then(response => {
        if (!response.data.items) return
        this.userListOptions = response.data.items.map(v => v.name)
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
    padding: 40px 45px 20px 45px;

    .postInfo-container {
      position: relative;
      @include clearfix;
      margin-bottom: 10px;

      .postInfo-container-item {
        float: left;
      }
    }
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
</style>
