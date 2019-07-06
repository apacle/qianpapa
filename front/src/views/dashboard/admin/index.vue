<template>
  <div class="dashboard-editor-container">
    <!-- <github-corner class="github-corner" /> -->

    <panel-group :amount-data="amountData" @handleSetLineChartData="handleSetLineChartData" />

    <el-row style="background:#fff;padding:16px 16px 0;margin-bottom:32px;">
      <line-chart :chart-data="listData" />
    </el-row>

    <!-- <el-row :gutter="32">
      <el-col :xs="24" :sm="24" :lg="8">
        <div class="chart-wrapper">
          <raddar-chart />
        </div>
      </el-col>
      <el-col :xs="24" :sm="24" :lg="8">
        <div class="chart-wrapper">
          <pie-chart />
        </div>
      </el-col>
      <el-col :xs="24" :sm="24" :lg="8">
        <div class="chart-wrapper">
          <bar-chart />
        </div>
      </el-col>
    </el-row> -->

    <el-row :gutter="8">
      <el-col :xs="{span: 24}" :sm="{span: 24}" :md="{span: 24}" :lg="{span: 12}" :xl="{span: 12}" style="padding-right:8px;margin-bottom:30px;">
        <loan-table />
      </el-col>
      <el-col :xs="{span: 24}" :sm="{span: 24}" :md="{span: 24}" :lg="{span: 12}" :xl="{span: 12}" style="margin-bottom:30px;">
        <repay-table />
      </el-col>
      <!-- <el-col :xs="{span: 24}" :sm="{span: 12}" :md="{span: 12}" :lg="{span: 6}" :xl="{span: 6}" style="margin-bottom:30px;">
        <todo-list />
      </el-col>
      <el-col :xs="{span: 24}" :sm="{span: 12}" :md="{span: 12}" :lg="{span: 6}" :xl="{span: 6}" style="margin-bottom:30px;">
        <box-card />
      </el-col> -->
    </el-row>
  </div>
</template>

<script>
// import GithubCorner from '@/components/GithubCorner'
import PanelGroup from './components/PanelGroup'
import LineChart from './components/LineChart'
// import RaddarChart from './components/RaddarChart'
// import PieChart from './components/PieChart'
// import BarChart from './components/BarChart'
import LoanTable from './components/LoanTable'
import RepayTable from './components/RepayTable'
// import TodoList from './components/TodoList'
// import BoxCard from './components/BoxCard'
import { getTotalAmount, getTotalList } from '@/api/total'

const listData = {
  customer: [100, 50, 180, 200, 100, 100, 50],
  loan: [100, 150, 200, 100, 200, 150, 100],
  repay: [10, 50, 100, 70, 100, 150, 200]

  // customer: {
  //   customerData: [100, 50, 180, 200, 100, 100, 50],
  //   loanData: [100, 150, 200, 100, 200, 150, 100],
  //   repayData: [10, 50, 100, 70, 100, 150, 200]
  // }
  // user: {
  //   customerData: [100, 120, 161, 134, 105, 160, 165],
  //   loanData: [120, 82, 91, 154, 162, 140, 145],
  //   repayData: [150, 200, 100, 180, 500, 200, 100]
  // },
  // loan: {
  //   customerData: [100, 120, 161, 134, 105, 160, 165],
  //   loanData: [120, 82, 91, 154, 162, 140, 145],
  //   repayData: [150, 200, 100, 180, 500, 200, 100]
  // },
  // repay: {
  //   customerData: [100, 120, 161, 134, 105, 160, 165],
  //   loanData: [120, 82, 91, 154, 162, 140, 145],
  //   repayData: [150, 200, 100, 180, 500, 200, 100]
  // }
}

const amountData = {
  customer: 10,
  user: 20,
  loan: 100,
  repay: 20
}

export default {
  name: 'DashboardAdmin',
  components: {
    // GithubCorner,
    PanelGroup,
    LineChart,
    // RaddarChart,
    // PieChart,
    // BarChart,
    LoanTable,
    RepayTable
    // TodoList,
    // BoxCard
  },
  data() {
    return {
      listData: listData,
      amountData: amountData
    }
  },
  created() {
    this.getAmountData()
    this.getListData()
  },
  methods: {
    handleSetLineChartData(type) {
      // this.lineChartData = lineChartData[type]
    },
    getAmountData() {
      getTotalAmount().then(response => {
        this.amountData = response.data
      })
    },
    getListData() {
      getTotalList().then(response => {
        this.listData = response.data
      })
    }
  }
}
</script>

<style lang="scss" scoped>
.dashboard-editor-container {
  padding: 32px;
  background-color: rgb(240, 242, 245);
  position: relative;

  .github-corner {
    position: absolute;
    top: 0px;
    border: 0;
    right: 0;
  }

  .chart-wrapper {
    background: #fff;
    padding: 16px 16px 0;
    margin-bottom: 32px;
  }
}

</style>
