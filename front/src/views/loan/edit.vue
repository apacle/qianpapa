<template>
  <loan-detail :is-edit="true" />
</template>

<script>
import LoanDetail from './components/LoanDetail'

export default {
  name: 'EditForm',
  components: { LoanDetail }
}
</script>

