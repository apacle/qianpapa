<template>
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
      <el-table-column align="center" label="编号" width="70">
        <template slot-scope="scope">
          {{ scope.row.loanId }}
        </template>
      </el-table-column>
      <el-table-column label="名字" width="80" align="center">
        <template slot-scope="scope">
          {{ scope.row.loanName }}
        </template>
      </el-table-column>
      <el-table-column label="贷款人" width="100" align="center">
        <template slot-scope="scope">
          <el-tag>{{ scope.row.customerName }}</el-tag>
        </template>
      </el-table-column>
      <el-table-column label="金额" align="center">
        <template slot-scope="scope">
          {{ scope.row.loanAmount }}
        </template>
      </el-table-column>
      <el-table-column label="总金额" align="center">
        <template slot-scope="scope">
          {{ scope.row.loanTotalAmount }}
        </template>
      </el-table-column>
      <el-table-column label="已还金额" align="center">
        <template slot-scope="scope">
          {{ scope.row.loanRepayAmount }}
        </template>
      </el-table-column>
      <el-table-column label="类型" width="80" align="center">
        <template slot-scope="scope">
          {{ scope.row.loanType | typeFilter }}
        </template>
      </el-table-column>
      <el-table-column class-name="status-col" label="状态" width="80" align="center">
        <template slot-scope="scope">
          <el-tag :type="scope.row.loanStatus | statusFilter">
            {{ scope.row.loanStatus | statusFilter }}
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
          <router-link :to="'/loan/edit/'+scope.row.loanId">
            <el-button type="primary" size="small" icon="el-icon-edit">
              编辑
            </el-button>
          </router-link>
        </template>
      </el-table-column>
    </el-table>

    <pagination v-show="total>0" :total="total" :page.sync="listQuery.page" :limit.sync="listQuery.limit" @pagination="getList" />
  </div>
</template>

<script>

import FilenameOption from './components/FilenameOption'
import BookTypeOption from './components/BookTypeOption'

import { fetchList } from '@/api/loan'
import Pagination from '@/components/Pagination' // Secondary package based on el-pagination
import { parseTime } from '@/utils'
import clip from '@/utils/clipboard' // use clipboard directly
import clipboard from '@/directive/clipboard/index.js' // use clipboard by v-directive

export default {
  name: 'LoanList',
  components: { FilenameOption, BookTypeOption, Pagination },
  directives: {
    clipboard
  },
  filters: {
    statusFilter(status) {
      const statusMap = {
        0: '未审核',
        1: '贷款中',
        2: '已还款',
        3: '逾期'
      }
      return statusMap[status]
    },
    typeFilter(type) {
      const typeMap = {
        0: '未知',
        1: '等额本息',
        2: '等额本金',
        3: '先息后本',
        4: '等本等息'
      }
      return typeMap[type]
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
  computed: {
    // createTime: {
    //   // set and get is useful when the data
    //   // returned by the back end api is different from the front end
    //   // back end return => "2013-06-25 06:59:25"
    //   // front end need timestamp => 1372114765000
    //   get() {
    //     return (+new Date(this.postForm.createTime))
    //   },
    //   set(val) {
    //     this.postForm.createTime = new Date(val)
    //   }
    // }
  },
  created() {
    this.getList()
  },
  methods: {
    getList() {
      this.listLoading = true
      fetchList(this.listQuery).then(response => {
        this.list = response.data.items
        this.total = response.data.total
        this.listLoading = false
      })
    },
    handleCopy(text, event) {
      clip(text, event)
    },
    clipboardSuccess() {
      this.$message({
        message: 'Copy successfully',
        type: 'success',
        duration: 1500
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

<style scoped>

.cell .el-tag {
    min-width: 58px;
}

.edit-input {
  padding-right: 100px;
}
.cancel-btn {
  position: absolute;
  right: 15px;
  top: 10px;
}

.el-table .cell img{
  display: block;
  width: 100%;
}
</style>
