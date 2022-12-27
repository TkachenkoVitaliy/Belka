class TokenService {
    getUser() {
        return JSON.parse(localStorage.getItem('user'))
    }

    setUser(user) {
        localStorage.setItem('user', JSON.stringify(user))
    }

    removeUser() {
        localStorage.removeItem('user')
    }

    getLocalRefreshToken() {
        const user = this.getUser()
        return user?.refreshToken
    }

    getLocalAccessToken() {
        const user = this.getUser()
        return user?.accessToken
    }

    updateLocalAcessToken(token) {
        let user = this.getUser()
        user.accessToken = token
        this.setUser(user)
    }
}

export default new TokenService()
