import { createRouter, createWebHistory } from 'vue-router'
import { loadLayoutMiddleware } from './middleware/loadLayoutMiddleware'

const routes = [
    {
        path: '/auth',
        name: 'Auth',
        component: () => import('@/views/AppLogin.vue'),
        meta: {
            layout: 'LoginLayout',
        },
    },
    {
        path: '/',
        name: 'Home',
        component: () => import('@/views/MainPage.vue'),
        meta: {
            layout: 'MainLayout',
        },
    },
    {
        path: '/data',
        name: 'InsertData',
        component: () => import('@/views/InsertDataPage.vue'),
        meta: {
            layout: 'MainLayout',
            id: 1,
            actions: {
                datePicker: true,
                rowsControl: true,
                saveButton: true,
            },
        },
    },
    {
        path: '/reports',
        name: 'Reports',
        component: () => import('@/views/ReportPage.vue'),
        meta: {
            layout: 'MainLayout',
            id: 2,
            actions: {
                datePicker: true,
            },
        },
    },
]

const router = createRouter({
    history: createWebHistory(process.env.BASE_URL),
    routes,
})

router.beforeEach(loadLayoutMiddleware)

export default router
