<template>
  <el-dropdown :show-timeout="100" trigger="click">
    <el-button plain>
      {{ marketingStatus ? '开启':'关闭' }}
      <i class="el-icon-caret-bottom el-icon--right" />
    </el-button>
    <el-dropdown-menu slot="dropdown" class="no-padding">
      <el-dropdown-item>
        <el-radio-group v-model="marketingStatus" style="padding: 10px;">
          <el-radio :label="0">
            关闭
          </el-radio>
          <el-radio :label="1">
            开启
          </el-radio>
        </el-radio-group>
      </el-dropdown-item>
    </el-dropdown-menu>
  </el-dropdown>
</template>

<script>
export default {
  props: {
    value: {
      type: Number,
      default: 1
    }
  },
  computed: {
    marketingStatus: {
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
