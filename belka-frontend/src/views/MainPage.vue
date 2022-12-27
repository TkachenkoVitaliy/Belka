<template>
    <div>Main</div>
    <button @click="request">запрос</button>
    <div>{{ response }}</div>
</template>

<script>
import api from '@/services/api'

export default {
    data() {
        return {
            response: null,
        }
    },

    methods: {
        request() {
            api.get('/api/test').then((result) => {
                console.log('API RESULT', result)
                this.response = result
            })
        },
    },
}
</script>

<style></style>
