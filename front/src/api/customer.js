import request from '@/utils/request'

export function fetchList(query) {
  return request({
    url: '/customer/list',
    method: 'get',
    params: query
  })
}

export function fetchCustomer(customerId) {
  return request({
    url: '/customer/detail',
    method: 'get',
    params: { customerId }
  })
}

export function updateCustomer(data) {
  return request({
    url: '/customer/update',
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
