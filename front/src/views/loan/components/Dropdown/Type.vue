<template>
  <el-dropdown :show-timeout="100" trigger="click">
    <el-button plain>
      {{ loanType==0 ? '未知':(loanType==1 ? '本额本息': (loanType==2 ? '本金本息': ( loanType==3 ? '先息后本':'等额本息'))) }}
      <i class="el-icon-caret-bottom el-icon--right" />
    </el-button>
    <el-dropdown-menu slot="dropdown" class="no-padding">
      <el-dropdown-item>
        <el-radio-group v-model="loanType" style="padding: 10px;">
          <el-radio :label="0">
            未知
          </el-radio>
          <el-radio :label="1">
            本额本息
          </el-radio>
          <el-radio :label="2">
            本金本息
          </el-radio>
          <el-radio :label="3">
            先息后本
          </el-radio>
          <el-radio :label="4">
            等额本息
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
    loanType: {
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
