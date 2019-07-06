import request from '@/utils/request'

export function fetchList(query) {
  return request({
    url: '/repay/list',
    method: 'get',
    params: query
  })
}

export function fetchRepay(repayId) {
  return request({
    url: '/repay/detail',
    method: 'get',
    params: { repayId }
  })
}

export function updateRepay(data) {
  return request({
    url: '/repay/update',
    method: 'post',
    data
  })
}

export function fetchPv(pv) {
  return request({
    url: '/article/pv',
    method: 'get',
    params: { pv }
  })
}

export function createArticle(data) {
  return request({
    url: '/article/create',
    method: 'post',
    data
  })
}

export function updateArticle(data) {
  return request({
    url: '/article/update',
    method: 'post',
    data
  })
}
