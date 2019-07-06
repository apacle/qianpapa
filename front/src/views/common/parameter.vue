<template>
  <marketing-detail :is-edit="false" />
</template>

<script>
import MarketingDetail from './components/MarketingDetail'

export default {
  name: 'CreateForm',
  components: { MarketingDetail }
}
</script>

