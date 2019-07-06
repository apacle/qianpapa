import request from '@/utils/request'

export function fetchList(query) {
  return request({
    url: '/marketing/list',
    method: 'get',
    params: query
  })
}

export function fetchMarketing(marketingId) {
  return request({
    url: '/marketing/detail',
    method: 'get',
    params: { marketingId }
  })
}

export function updateMarketing(data) {
  return request({
    url: '/marketing/update',
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
