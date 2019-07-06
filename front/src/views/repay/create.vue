<template>
  <repay-detail :is-edit="false" />
</template>

<script>
import RepayDetail from './components/RepayDetail'

export default {
  name: 'CreateForm',
  components: { RepayDetail }
}
</script>

