import request from '@/utils/request'

export function fetchList(query) {
  return request({
    url: '/loan/list',
    method: 'get',
    params: query
  })
}

export function fetchLoan(loanId) {
  return request({
    url: '/loan/detail',
    method: 'get',
    params: { loanId }
  })
}

export function updateLoan(data) {
  return request({
    url: '/loan/update',
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
