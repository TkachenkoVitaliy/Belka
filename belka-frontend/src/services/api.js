import axios from 'axios'
import TokenService from './token.service'
import EventBus from './EventBus'

const instance = axios.create({
    baseURL: 'http://localhost:8081',
    headers: {
        'Content-Type': 'application/json',
    },
})

instance.interceptors.request.use(
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

instance.interceptors.response.use(
    (res) => {
        return res
    },
    async (err) => {
        const originalConfig = err.config

        if (originalConfig.url !== '/auth' && err.response) {
            if (err.response.status === 401 && !originalConfig._retry) {
                originalConfig._retry = true

                try {
                    const rs = await instance.post('/auth/refreshtoken', {
                        refreshToken: TokenService.getLocalRefreshToken(),
                    })

                    const { accessToken } = rs.data

                    TokenService.updateLocalAcessToken(accessToken)

                    return instance(originalConfig)
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

export default instance
