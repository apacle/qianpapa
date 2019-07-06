<template>
  <repay-detail :is-edit="true" />
</template>

<script>
import RepayDetail from './components/RepayDetail'

export default {
  name: 'EditForm',
  components: { RepayDetail }
}
</script>

