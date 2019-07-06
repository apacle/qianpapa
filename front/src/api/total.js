import request from '@/utils/request'

export function getTotalAmount(name) {
  return request({
    url: '/total/amount',
    method: 'get'
    // params: { name }
  })
}

export function getTotalList(query) {
  return request({
    url: '/total/list',
    method: 'get',
    params: query
  })
}
