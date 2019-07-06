<template>
  <el-dropdown :show-timeout="100" trigger="click">
    <el-button plain>
      图标地址
      <i class="el-icon-caret-bottom el-icon--right" />
    </el-button>
    <el-dropdown-menu slot="dropdown" class="no-padding no-border" style="width:400px;max-width:100%;max-width: calc(100% - 10px);">
      <el-form-item label-width="0px" style="margin-bottom: 0px" prop="marketingIcon">
        <el-input v-model="marketingIcon" placeholder="输入图标地址">
          <template slot="prepend">
            地址
          </template>
        </el-input>
      </el-form-item>
    </el-dropdown-menu>
  </el-dropdown>
</template>

<script>
export default {
  props: {
    value: {
      type: String,
      default: ''
    }
  },
  computed: {
    marketingIcon: {
      get() {
        return this.value
      },
      set(val) {
        this.$emit('input', val)
      }
    }
  }
}
</script>
