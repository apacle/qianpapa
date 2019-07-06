<template>
  <marketing-detail :is-edit="true" />
</template>

<script>
import MarketingDetail from './components/MarketingDetail'

export default {
  name: 'EditForm',
  components: { MarketingDetail }
}
</script>

