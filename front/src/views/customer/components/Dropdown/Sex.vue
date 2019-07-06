<template>
  <el-dropdown :show-timeout="100" trigger="click">
    <el-button plain>
      {{ customerSex==0 ? '女士':'先生' }}
      <i class="el-icon-caret-bottom el-icon--right" />
    </el-button>
    <el-dropdown-menu slot="dropdown" class="no-padding">
      <el-dropdown-item>
        <el-radio-group v-model="customerSex" style="padding: 10px;">
          <el-radio :label="0">
            女士
          </el-radio>
          <el-radio :label="1">
            先生
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
    customerSex: {
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
