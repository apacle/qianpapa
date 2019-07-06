<template>
  <customer-detail :is-edit="false" />
</template>

<script>
import CustomerDetail from './components/CustomerDetail'

export default {
  name: 'CreateForm',
  components: { CustomerDetail }
}
</script>

