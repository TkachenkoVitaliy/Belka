import api from './api'
import TokenService from './token.service'

class AuthService {
    async login(user) {
        const response = await api.post('/auth/signin', {
            username: user.username,
            password: user.password,
        })
        if (response.data.accessToken) {
            TokenService.setUser(response.data)
        }
        return response.data
    }

    logout() {
        TokenService.removeUser()
    }
}

export default new AuthService()
