<template>
  <el-dropdown :show-timeout="100" trigger="click">
    <el-button plain>
      {{ repayStatus==0 ? '未审核':'已还款' }}
      <i class="el-icon-caret-bottom el-icon--right" />
    </el-button>
    <el-dropdown-menu slot="dropdown" class="no-padding">
      <el-dropdown-item>
        <el-radio-group v-model="repayStatus" style="padding: 10px;">
          <el-radio :label="0">
            未审核
          </el-radio>
          <el-radio :label="1">
            已还款
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
    repayStatus: {
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
