import axios from 'axios'
import authHeader from './auth-header'

const instance = axios.create({
    baseURL: 'http://localhost:8081',
    headers: authHeader(),
})

export default instance
