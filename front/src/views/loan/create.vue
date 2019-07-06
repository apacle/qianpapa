<template>
  <loan-detail :is-edit="false" />
</template>

<script>
import LoanDetail from './components/LoanDetail'

export default {
  name: 'CreateForm',
  components: { LoanDetail }
}
</script>

