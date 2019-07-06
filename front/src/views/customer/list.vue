<template>
  <!-- $t is vue-i18n global function to translate lang -->
  <div class="app-container">
    <div>
      <FilenameOption v-model="filename" />
      <!-- <AutoWidthOption v-model="autoWidth" /> -->
      <BookTypeOption v-model="bookType" />
      <el-button :loading="downloadLoading" style="margin:0 0 20px 20px;" type="primary" icon="document" @click="handleDownload">
        {{ $t('excel.export') }} Excel
      </el-button>
    </div>

    <el-table v-loading="listLoading" :data="list" element-loading-text="拼命加载中" border fit highlight-current-row>
      <el-table-column align="center" label="ID" width="80">
        <template slot-scope="scope">
          {{ scope.row.customerId }}
        </template>
      </el-table-column>
      <el-table-column label="名字" width="100" align="center">
        <template slot-scope="scope">
          <el-tag>{{ scope.row.customerName }}</el-tag>
        </template>
      </el-table-column>
      <el-table-column label="电话" width="115" align="center">
        <template slot-scope="scope">
          <a :href="'tel: + scope.row.customerPhone + '">{{ scope.row.customerPhone }}</a>
        </template>
      </el-table-column>
      <el-table-column label="职业" width="80" align="center">
        <template slot-scope="scope">
          {{ scope.row.customerJob }}
        </template>
      </el-table-column>
      <el-table-column label="地址">
        <template slot-scope="scope">
          {{ scope.row.customerAddress }}
        </template>
      </el-table-column>
      <el-table-column class-name="status-col" label="状态" width="80" align="center">
        <template slot-scope="scope">
          <el-tag :type="scope.row.customerStatus | statusFilter">
            {{ scope.row.customerStatus | statusFilter }}
          </el-tag>
        </template>
      </el-table-column>
      <el-table-column label="业务员" width="90" align="center">
        <template slot-scope="scope">
          {{ scope.row.userNickname }}
        </template>
      </el-table-column>
      <el-table-column align="center" label="更新日期" width="180">
        <template slot-scope="scope">
          <i class="el-icon-time" />
          <span>{{ scope.row.createTime }}</span>
        </template>
      </el-table-column>

      <el-table-column align="center" label="操作" width="100">
        <template slot-scope="scope">
          <router-link :to="'/customer/edit/'+scope.row.customerId">
            <el-button type="primary" size="small" icon="el-icon-edit">
              编辑
            </el-button>
          </router-link>
        </template>
      </el-table-column>
    </el-table>

    <pagination v-show="total>0" :total="total" :page.sync="listQuery.page" :limit.sync="listQuery.limit" @pagination="fetchData" />
  </div>
</template>

<script>
import Pagination from '@/components/Pagination' // Secondary package based on el-pagination

import { fetchList } from '@/api/customer'
import { parseTime } from '@/utils'
// options components
import FilenameOption from './components/FilenameOption'
// import AutoWidthOption from './components/AutoWidthOption'
import BookTypeOption from './components/BookTypeOption'
export default {
  name: 'ExportExcel',
  components: { FilenameOption, BookTypeOption, Pagination },
  filters: {
    statusFilter(status) {
      const statusMap = {
        0: '黑名单',
        1: '正常',
        2: '贷款中',
        3: '逾期'
      }
      return statusMap[status]
    }
  },
  data() {
    return {
      list: null,
      total: 0,
      listLoading: true,
      downloadLoading: false,
      filename: '',
      autoWidth: true,
      bookType: 'xlsx',
      listQuery: {
        page: 1,
        limit: 20
      }
    }
  },
  created() {
    this.fetchData()
  },
  methods: {
    fetchData() {
      this.listLoading = true
      fetchList(this.listQuery).then(response => {
        this.list = response.data.items
        this.total = response.data.total
        this.listLoading = false
      })
    },
    handleDownload() {
      this.downloadLoading = true
      import('@/vendor/Export2Excel').then(excel => {
        const tHeader = ['ID', '名字', '电话', '职业', '地址', '业务员', '状态', '更新日期']
        const filterVal = ['customerId', 'customerName', 'customerPhone', 'customerJob', 'customerAddress', 'customerStatus', 'userName', 'createTime']
        const list = this.list
        const data = this.formatJson(filterVal, list)
        excel.export_json_to_excel({
          header: tHeader,
          data,
          filename: this.filename,
          autoWidth: this.autoWidth,
          bookType: this.bookType
        })
        this.downloadLoading = false
      })
    },
    formatJson(filterVal, jsonData) {
      return jsonData.map(v => filterVal.map(j => {
        if (j === 'timestamp') {
          return parseTime(v[j])
        } else {
          return v[j]
        }
      }))
    }
  }
}
</script>

<style>
.radio-label {
  font-size: 14px;
  color: #606266;
  line-height: 40px;
  padding: 0 12px 0 30px;
}
.cell .el-tag {
    min-width: 58px;
}

.el-tag--黑名单 {
    background-color: rgba(28, 78, 177, 0.1);
    border-color: rgba(144, 147, 153, 0.2);
    color: #909399;
}
/* .el-tag--普通 {
    background-color: rgba(19, 206, 102, 0.1);
    border-color: rgba(19, 206, 102, 0.2);
    color: #1890ff;
} */
.el-tag--贷款中 {
    background-color: rgba(19, 206, 102, 0.1);
    border-color: rgba(19, 206, 102, 0.2);
    color: #13ce66;
}
.el-tag--逾期 {
    background-color: rgba(255, 73, 73, 0.1);
    border-color: rgba(255, 73, 73, 0.2);
    color: #ff4949;
}
</style>
