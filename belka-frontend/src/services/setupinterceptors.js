import axiosInstance from './api'
import TokenService from './token.service'
import EventBus from './EventBus'

const requestInterceptor = axiosInstance.interceptors.request.use(
    (config) => {
        const accessToken = TokenService.getLocalAccessToken()
        if (accessToken) {
            config.headers['Authorization'] = 'Bearer ' + accessToken
        }
        return config
    },
    (error) => {
        return Promise.reject(error)
    }
)

const responseInterceptor = axiosInstance.interceptors.response.use(
    (res) => {
        return res
    },
    async (err) => {
        const originalConfig = err.config

        if (originalConfig.url !== '/auth' && err.response) {
            if (err.response.status === 401 && !originalConfig._retry) {
                originalConfig._retry = true

                try {
                    const rs = await axiosInstance.post('/auth/refreshtoken', {
                        refreshToken: TokenService.getLocalRefreshToken(),
                    })

                    const { accessToken } = rs.data

                    TokenService.updateLocalAcessToken(accessToken)

                    return axiosInstance(originalConfig)
                } catch (_error) {
                    return Promise.reject(_error)
                }
            }

            if (err.response.status === 403 && originalConfig._retry) {
                EventBus.dispatch('logout')
            }
        }

        return Promise.reject(err)
    }
)

export default setup
