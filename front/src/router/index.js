import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router)

/* Layout */
import Layout from '@/layout'

/* Router Modules */
import componentsRouter from './modules/components'
import chartsRouter from './modules/charts'
import tableRouter from './modules/table'
import nestedRouter from './modules/nested'

/**
 * Note: sub-menu only appear when route children.length >= 1
 * Detail see: https://panjiachen.github.io/vue-element-admin-site/guide/essentials/router-and-nav.html
 *
 * hidden: true                   if set true, item will not show in the sidebar(default is false)
 * alwaysShow: true               if set true, will always show the root menu
 *                                if not set alwaysShow, when item has more than one children route,
 *                                it will becomes nested mode, otherwise not show the root menu
 * redirect: noRedirect           if set noRedirect will no redirect in the breadcrumb
 * name:'router-name'             the name is used by <keep-alive> (must set!!!)
 * meta : {
    roles: ['admin','editor']    control the page roles (you can set multiple roles)
    title: 'title'               the name show in sidebar and breadcrumb (recommend set)
    icon: 'svg-name'             the icon show in the sidebar
    noCache: true                if set true, the page will no be cached(default is false)
    affix: true                  if set true, the tag will affix in the tags-view
    breadcrumb: false            if set false, the item will hidden in breadcrumb(default is true)
    activeMenu: '/example/list'  if set path, the sidebar will highlight the path you set
  }
 */

/**
 * constantRoutes
 * a base page that does not have permission requirements
 * all roles can be accessed
 */
export const constantRoutes = [
  {
    path: '/redirect',
    component: Layout,
    hidden: true,
    children: [
      {
        path: '/redirect/:path*',
        component: () => import('@/views/redirect/index')
      }
    ]
  },
  {
    path: '/marketing',
    component: Layout,
    redirect: '/marketing/list',
    name: 'Marketing',
    meta: {
      title: '营销工具',
      icon: 'documentation'
    },
    children: [
      {
        path: 'create',
        component: () => import('@/views/marketing/create'),
        name: 'CreateMarketing',
        meta: { title: '创建模板', icon: 'edit' }
      },
      {
        path: 'edit/:marketingId(\\d+)',
        component: () => import('@/views/marketing/edit'),
        name: 'EditMarketing',
        meta: { title: '编辑模板', noCache: true, activeMenu: '/marketing/list' },
        hidden: true
      },
      {
        path: 'list',
        component: () => import('@/views/marketing/list'),
        name: 'Marketing List',
        meta: { title: '模板列表', icon: 'list' }
      }
    ]
  },
  {
    path: '/customer',
    component: Layout,
    redirect: '/customer/list',
    name: 'Marketing',
    meta: {
      title: '客户管理',
      icon: 'user'
    },
    children: [
      {
        path: 'create',
        component: () => import('@/views/customer/create'),
        name: 'CreateCustomer',
        meta: { title: '创建客户', icon: 'edit' }
      },
      {
        path: 'edit/:customerId(\\d+)',
        component: () => import('@/views/customer/edit'),
        name: 'EditCustomer',
        meta: { title: '编辑客户', noCache: true, activeMenu: '/customer/list' },
        hidden: true
      },
      {
        path: 'list',
        component: () => import('@/views/customer/list'),
        name: 'Customer List',
        meta: { title: '客户列表', icon: 'list' }
      }
    ]
  },
  {
    path: '/loan',
    component: Layout,
    redirect: '/loan/list',
    name: 'Laon',
    meta: {
      title: '贷款管理',
      icon: 'chart'
    },
    children: [
      {
        path: 'create',
        component: () => import('@/views/loan/create'),
        name: 'CreateLoan',
        meta: { title: '创建订单', icon: 'edit' }
      },
      {
        path: 'edit/:loanId(\\d+)',
        component: () => import('@/views/loan/edit'),
        name: 'EditLoan',
        meta: { title: '编辑订单', noCache: true, activeMenu: '/loan/list' },
        hidden: true
      },
      {
        path: 'list',
        component: () => import('@/views/loan/list'),
        name: 'Loan List',
        meta: { title: '贷款列表', icon: 'list' }
      }
    ]
  },
  {
    path: '/repay',
    component: Layout,
    redirect: '/repay/list',
    name: 'Repay',
    meta: {
      title: '还款管理',
      icon: 'theme'
    },
    children: [
      {
        path: 'create',
        component: () => import('@/views/repay/create'),
        name: 'Create Repay',
        meta: { title: '创建订单', icon: 'edit' }
      },
      {
        path: 'edit/:repayId(\\d+)',
        component: () => import('@/views/repay/edit'),
        name: 'Edit Repay',
        meta: { title: '编辑订单', noCache: true, activeMenu: '/repay/list' },
        hidden: true
      },
      {
        path: 'list',
        component: () => import('@/views/repay/list'),
        name: 'Repay List',
        meta: { title: '还款列表', icon: 'list' }
      }
    ]
  },
  {
    path: '/user',
    component: Layout,
    redirect: '/user/list',
    name: 'User',
    meta: {
      title: '用户管理',
      icon: 'lock'
    },
    children: [
      {
        path: 'create',
        component: () => import('@/views/user/create'),
        name: 'Create Users',
        meta: { title: '创建用户', icon: 'edit' }
      },
      {
        path: 'edit/:userId(\\d+)',
        component: () => import('@/views/user/edit'),
        name: 'Edit Users',
        meta: { title: '编辑用户', noCache: true, activeMenu: '/user/list' },
        hidden: true
      },
      {
        path: 'list',
        component: () => import('@/views/user/list'),
        name: 'User List',
        meta: { title: '用户列表', icon: 'list' }
      }
    ]
  },
  // {
  //   path: '/common',
  //   component: Layout,
  //   redirect: '/common/picture',
  //   name: 'Common',
  //   meta: {
  //     title: '公共管理',
  //     icon: 'example'
  //   },
  //   children: [
  //     {
  //       path: 'create',
  //       component: () => import('@/views/common/parameter'),
  //       name: 'CommonParams',
  //       meta: { title: '公共参数', icon: 'edit' }
  //     },
  //     {
  //       path: 'list',
  //       component: () => import('@/views/common/picture'),
  //       name: 'CommonPicture',
  //       meta: { title: '图片管理', icon: 'list' }
  //     }
  //   ]
  // },

  {
    path: '/login',
    component: () => import('@/views/login/index'),
    hidden: true
  },
  {
    path: '/auth-redirect',
    component: () => import('@/views/login/auth-redirect'),
    hidden: true
  },
  {
    path: '/404',
    component: () => import('@/views/error-page/404'),
    hidden: true
  },
  {
    path: '/401',
    component: () => import('@/views/error-page/401'),
    hidden: true
  },
  {
    path: '',
    component: Layout,
    redirect: 'dashboard',
    children: [
      {
        path: 'dashboard',
        component: () => import('@/views/dashboard/index'),
        name: 'Dashboard',
        meta: { title: 'dashboard', icon: 'dashboard', affix: true }
      }
    ]
  }
  // {
  //   path: '/documentation',
  //   component: Layout,
  //   children: [
  //     {
  //       path: 'index',
  //       component: () => import('@/views/documentation/index'),
  //       name: 'Documentation',
  //       meta: { title: 'documentation', icon: 'documentation', affix: true }
  //     }
  //   ]
  // },
  // {
  //   path: '/guide',
  //   component: Layout,
  //   redirect: '/guide/index',
  //   children: [
  //     {
  //       path: 'index',
  //       component: () => import('@/views/guide/index'),
  //       name: 'Guide',
  //       meta: { title: 'guide', icon: 'guide', noCache: true }
  //     }
  //   ]
  // },
  // {
  //   path: '/profile',
  //   component: Layout,
  //   redirect: '/profile/index',
  //   hidden: true,
  //   children: [
  //     {
  //       path: 'index',
  //       component: () => import('@/views/profile/index'),
  //       name: 'Profile',
  //       meta: { title: 'profile', icon: 'user', noCache: true }
  //     }
  //   ]
  // }
]

/**
 * asyncRoutes
 * the routes that need to be dynamically loaded based on user roles
 */
// export const asyncRoutes = [
//   {
//     path: '/permission',
//     component: Layout,
//     redirect: '/permission/page',
//     alwaysShow: true, // will always show the root menu
//     name: 'Permission',
//     meta: {
//       title: 'permission',
//       icon: 'lock',
//       roles: ['admin', 'editor'] // you can set roles in root nav
//     },
//     children: [
//       {
//         path: 'page',
//         component: () => import('@/views/permission/page'),
//         name: 'PagePermission',
//         meta: {
//           title: 'pagePermission',
//           roles: ['admin'] // or you can only set roles in sub nav
//         }
//       },
//       {
//         path: 'directive',
//         component: () => import('@/views/permission/directive'),
//         name: 'DirectivePermission',
//         meta: {
//           title: 'directivePermission'
//           // if do not set roles, means: this page does not require permission
//         }
//       },
//       {
//         path: 'role',
//         component: () => import('@/views/permission/role'),
//         name: 'RolePermission',
//         meta: {
//           title: 'rolePermission',
//           roles: ['admin']
//         }
//       }
//     ]
//   },

//   {
//     path: '/icon',
//     component: Layout,
//     children: [
//       {
//         path: 'index',
//         component: () => import('@/views/icons/index'),
//         name: 'Icons',
//         meta: { title: 'icons', icon: 'icon', noCache: true }
//       }
//     ]
//   },

//   /** when your routing map is too long, you can split it into small modules **/
//   componentsRouter,
//   chartsRouter,
//   nestedRouter,
//   tableRouter,

//   {
//     path: '/example',
//     component: Layout,
//     redirect: '/example/list',
//     name: 'Example',
//     meta: {
//       title: 'example',
//       icon: 'example'
//     },
//     children: [
//       {
//         path: 'create',
//         component: () => import('@/views/example/create'),
//         name: 'CreateArticle',
//         meta: { title: 'createArticle', icon: 'edit' }
//       },
//       {
//         path: 'edit/:id(\\d+)',
//         component: () => import('@/views/example/edit'),
//         name: 'EditArticle',
//         meta: { title: 'editArticle', noCache: true, activeMenu: '/example/list' },
//         hidden: true
//       },
//       {
//         path: 'list',
//         component: () => import('@/views/example/list'),
//         name: 'ArticleList',
//         meta: { title: 'articleList', icon: 'list' }
//       }
//     ]
//   },

//   {
//     path: '/tab',
//     component: Layout,
//     children: [
//       {
//         path: 'index',
//         component: () => import('@/views/tab/index'),
//         name: 'Tab',
//         meta: { title: 'tab', icon: 'tab' }
//       }
//     ]
//   },

//   {
//     path: '/error',
//     component: Layout,
//     redirect: 'noRedirect',
//     name: 'ErrorPages',
//     meta: {
//       title: 'errorPages',
//       icon: '404'
//     },
//     children: [
//       {
//         path: '401',
//         component: () => import('@/views/error-page/401'),
//         name: 'Page401',
//         meta: { title: 'page401', noCache: true }
//       },
//       {
//         path: '404',
//         component: () => import('@/views/error-page/404'),
//         name: 'Page404',
//         meta: { title: 'page404', noCache: true }
//       }
//     ]
//   },

//   {
//     path: '/error-log',
//     component: Layout,
//     children: [
//       {
//         path: 'log',
//         component: () => import('@/views/error-log/index'),
//         name: 'ErrorLog',
//         meta: { title: 'errorLog', icon: 'bug' }
//       }
//     ]
//   },

//   {
//     path: '/excel',
//     component: Layout,
//     redirect: '/excel/export-excel',
//     name: 'Excel',
//     meta: {
//       title: 'excel',
//       icon: 'excel'
//     },
//     children: [
//       {
//         path: 'export-excel',
//         component: () => import('@/views/excel/export-excel'),
//         name: 'ExportExcel',
//         meta: { title: 'exportExcel' }
//       },
//       {
//         path: 'export-selected-excel',
//         component: () => import('@/views/excel/select-excel'),
//         name: 'SelectExcel',
//         meta: { title: 'selectExcel' }
//       },
//       {
//         path: 'export-merge-header',
//         component: () => import('@/views/excel/merge-header'),
//         name: 'MergeHeader',
//         meta: { title: 'mergeHeader' }
//       },
//       {
//         path: 'upload-excel',
//         component: () => import('@/views/excel/upload-excel'),
//         name: 'UploadExcel',
//         meta: { title: 'uploadExcel' }
//       }
//     ]
//   },

//   {
//     path: '/zip',
//     component: Layout,
//     redirect: '/zip/download',
//     alwaysShow: true,
//     name: 'Zip',
//     meta: { title: 'zip', icon: 'zip' },
//     children: [
//       {
//         path: 'download',
//         component: () => import('@/views/zip/index'),
//         name: 'ExportZip',
//         meta: { title: 'exportZip' }
//       }
//     ]
//   },

//   {
//     path: '/pdf',
//     component: Layout,
//     redirect: '/pdf/index',
//     children: [
//       {
//         path: 'index',
//         component: () => import('@/views/pdf/index'),
//         name: 'PDF',
//         meta: { title: 'pdf', icon: 'pdf' }
//       }
//     ]
//   },
//   {
//     path: '/pdf/download',
//     component: () => import('@/views/pdf/download'),
//     hidden: true
//   },

//   {
//     path: '/theme',
//     component: Layout,
//     children: [
//       {
//         path: 'index',
//         component: () => import('@/views/theme/index'),
//         name: 'Theme',
//         meta: { title: 'theme', icon: 'theme' }
//       }
//     ]
//   },

//   {
//     path: '/clipboard',
//     component: Layout,
//     children: [
//       {
//         path: 'index',
//         component: () => import('@/views/clipboard/index'),
//         name: 'ClipboardDemo',
//         meta: { title: 'clipboardDemo', icon: 'clipboard' }
//       }
//     ]
//   },

//   {
//     path: '/i18n',
//     component: Layout,
//     children: [
//       {
//         path: 'index',
//         component: () => import('@/views/i18n-demo/index'),
//         name: 'I18n',
//         meta: { title: 'i18n', icon: 'international' }
//       }
//     ]
//   },

//   {
//     path: 'external-link',
//     component: Layout,
//     children: [
//       {
//         path: 'https://github.com/PanJiaChen/vue-element-admin',
//         meta: { title: 'externalLink', icon: 'link' }
//       }
//     ]
//   },

//   { path: '*', redirect: '/404', hidden: true }
// ]

const createRouter = () => new Router({
  mode: 'history', // require service support
  scrollBehavior: () => ({ y: 0 }),
  routes: constantRoutes
})

const router = createRouter()

// Detail see: https://github.com/vuejs/vue-router/issues/1234#issuecomment-357941465
export function resetRouter() {
  const newRouter = createRouter()
  router.matcher = newRouter.matcher // reset router
}

export default router
