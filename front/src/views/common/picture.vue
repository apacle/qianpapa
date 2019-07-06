<template>
  <div class="app-container">
    <el-table v-loading="listLoading" :data="list" border fit highlight-current-row style="width: 100%">
      <el-table-column align="center" label="序号" width="80">
        <template slot-scope="scope">
          <span>{{ scope.row.marketingId }}</span>
        </template>
      </el-table-column>

      <!-- <el-table-column width="180px" align="center" label="Date">
        <template slot-scope="scope">
          <span>{{ scope.row.timestamp | parseTime('{y}-{m}-{d} {h}:{i}') }}</span>
        </template>
      </el-table-column> -->
      <el-table-column width="120px" label="标题">
        <template slot-scope="scope">
          <span>{{ scope.row.marketingName }}</span>
        </template>
      </el-table-column>

      <el-table-column min-width="300px" align="center" label="链接">
        <template slot-scope="scope">
          <a :href="scope.row.marketingUrl" target="_blank" class="link-type">
            <span>{{ scope.row.marketingUrl }}</span>
          </a>
        </template>
      </el-table-column>

      <!-- <el-table-column width="100px" label="Importance">
        <template slot-scope="scope">
          <svg-icon v-for="n in +scope.row.importance" :key="n" icon-class="star" class="meta-item__icon" />
        </template>
      </el-table-column> -->

      <el-table-column class-name="status-col" label="状态" width="110">
        <template slot-scope="scope">
          <el-tag :type="scope.row.marketingStatus | statusFilter">
            {{ scope.row.marketingStatus | statusFilter }}
          </el-tag>
        </template>
      </el-table-column>
      <el-table-column align="center" label="下载二维码" width="120">
        <template slot-scope="scope">
          <a :href="'http://localhost:8899/common/qrcode?url=' + scope.row.marketingUrl + '&icon=' + scope.row.marketingIcon" :download="scope.row.marketingName">
            <img class="img-circle" :src="'http://localhost:8899/common/qrcode?url=' + scope.row.marketingUrl + '&icon=' + scope.row.marketingIcon">
            <!-- <el-button type="primary" size="small" icon="document" @click="handleCopy(scope.row.marketingUrl,$event)">复制链接</el-button> -->
          </a>
        </template>
      </el-table-column>

      <el-table-column align="center" label="复制链接" width="120">
        <template slot-scope="scope">
          <el-button type="primary" size="small" icon="document" @click="handleCopy(scope.row.marketingUrl,$event)">复制链接</el-button>
        </template>
      </el-table-column>

      <el-table-column align="center" label="操作" width="100">
        <template slot-scope="scope">
          <router-link :to="'/marketing/edit/'+scope.row.marketingId">
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
import { fetchList } from '@/api/marketing'
import Pagination from '@/components/Pagination' // Secondary package based on el-pagination

import clip from '@/utils/clipboard' // use clipboard directly
import clipboard from '@/directive/clipboard/index.js' // use clipboard by v-directive

export default {
  name: 'MarketingList',
  components: { Pagination },
  directives: {
    clipboard
  },
  filters: {
    statusFilter(status) {
      const statusMap = {
        0: '无效',
        1: '有效'
      }
      return statusMap[status]
    }
  },
  data() {
    return {
      list: null,
      total: 0,
      listLoading: true,
      listQuery: {
        page: 1,
        limit: 20
      }
    }
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
    }
  }
}
</script>

<style scoped>
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

.el-tag--删除 {
    background-color: rgba(255, 73, 73, 0.1);
    border-color: rgba(255, 73, 73, 0.2);
    color: #ff4949;
}
.el-tag--无效 {
    background-color: rgba(144, 147, 153, 0.1);
    border-color: rgba(144, 147, 153, 0.2);
    color: #909399;
}
.el-tag--有效 {
    background-color: rgba(19, 206, 102, 0.1);
    border-color: rgba(19, 206, 102, 0.2);
    color: #13ce66;
}
</style>
