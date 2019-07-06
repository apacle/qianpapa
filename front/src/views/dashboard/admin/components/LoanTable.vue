<template>
  <el-table :data="list" style="width: 100%;padding-top: 15px;">
    <div style="border-left: 3px solid #2da1fa;text-indent: 3px;">近期贷款列表</div>
    <el-table-column label="编号" width="80">
      <template slot-scope="scope">
        {{ scope.row.loanId }}
      </template>
    </el-table-column>
    <el-table-column label="贷款人" width="80" align="center">
      <template slot-scope="scope">
        {{ scope.row.customerName }}
      </template>
    </el-table-column>
    <el-table-column label="金额" min-width="100" align="center">
      <template slot-scope="scope">
        ¥{{ scope.row.loanAmount | toThousandFilter }}
      </template>
    </el-table-column>
    <el-table-column label="状态" width="100" align="center">
      <template slot-scope="{row}">
        <el-tag :type="row.loanStatus | statusFilter">
          {{ row.loanStatus | statusFilter }}
        </el-tag>
      </template>
    </el-table-column>
  </el-table>
</template>

<script>
import { fetchList } from '@/api/loan'

export default {
  filters: {
    statusFilter(status) {
      const statusMap = {
        0: '未审核',
        1: '贷款中',
        2: '已还款',
        3: '逾期'
      }
      return statusMap[status]
    }
    // orderNoFilter(str) {
    //   return str.substring(0, 30)
    // }
  },
  data() {
    return {
      list: null,
      listQuery: {
        page: 1,
        limit: 8
      }
    }
  },
  created() {
    this.fetchData()
  },
  methods: {
    fetchData() {
      fetchList(this.listQuery).then(response => {
        this.list = response.data.items.slice(0, 8)
      })
    }
  }
}
</script>

<style>
/* .el-table .cell:nth-child(2){
padding-left: 0px;
padding-right: 0px;
} */
.el-table .hidden-columns{
    /* visibility: hidden; */
    /* position: absolute; */
    visibility:visible;
    z-index: 0;
    position: relative;
    padding: 0 10px;
    font-weight: bolder;
    font-size: 16px;
  }

.el-tag--未审核 {
    background-color: rgba(28, 78, 177, 0.1);
    border-color: rgba(144, 147, 153, 0.2);
    color: #909399;
}
.el-tag--贷款中 {
    background-color: rgba(19, 206, 102, 0.1);
    border-color: rgba(19, 206, 102, 0.2);
    color: #13ce66;
}

/* .el-tag--已还款 {
    background-color: rgba(19, 206, 102, 0.1);
    border-color: rgba(19, 206, 102, 0.2);
    color: #1890ff;
} */

.el-tag--逾期 {
    background-color: rgba(255, 73, 73, 0.1);
    border-color: rgba(255, 73, 73, 0.2);
    color: #ff4949;
}

.cell .el-tag {
    width: 58px;
}
</style>

