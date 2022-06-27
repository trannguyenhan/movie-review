import request from '@/utils/request'

export function getListCategory(params) {
  return request({
    url: '/category/listing',
    method: 'get',
    params
  })
}

export function createCategory(params) {
  return request({
    url: '/category/store',
    method: 'post',
    data: params
  })
}

export function updateCategory(params) {
  return request({
    url: '/category/update',
    method: 'post',
    data: params
  })
}

export function deleteCategory(id) {
  console.log(id)
  return request({
    url: `/category/delete/${id}`,
    method: 'post'
  })
}
