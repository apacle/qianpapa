<template>
  <el-table :data="list" style="width: 100%;padding-top: 15px;">
    <div style="border-left: 3px solid #2da1fa;text-indent: 3px;">近期还款列表</div>
    <el-table-column label="编号" width="70">
      <template slot-scope="scope">
        {{ scope.row.repayId }}
      </template>
    </el-table-column>
    <el-table-column label="还款人" width="80" align="center">
      <template slot-scope="scope">
        {{ scope.row.customerName }}
      </template>
    </el-table-column>
    <el-table-column label="金额" min-width="100" align="center">
      <template slot-scope="scope">
        ¥{{ scope.row.repayAmount | toThousandFilter }}
      </template>
    </el-table-column>
    <el-table-column label="状态" width="80" align="center">
      <template slot-scope="{row}">
        <el-tag :type="row.repayStatus | statusFilter">
          {{ row.repayStatus | statusFilter }}
        </el-tag>
      </template>
    </el-table-column>
    <el-table-column align="center" label="操作" width="90">
      <template slot-scope="scope">
        <router-link :to="'/repay/edit/'+scope.row.repayId">
          <el-button type="primary" size="small" icon="el-icon-edit">
            编辑
          </el-button>
        </router-link>
      </template>
    </el-table-column>
  </el-table>
</template>

<script>
import { fetchList } from '@/api/repay'

export default {
  filters: {
    statusFilter(status) {
      const statusMap = {
        0: '未审核',
        1: '已还款'
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
.el-tag--未审核 {
    background-color: rgba(28, 78, 177, 0.1);
    border-color: rgba(144, 147, 153, 0.2);
    color: #909399;
}
.el-tag--已还款 {
    background-color: rgba(19, 206, 102, 0.1);
    border-color: rgba(19, 206, 102, 0.2);
    color: #13ce66;
}
</style>

