<template>
    <div class="auth_container">
        <slot />
    </div>
</template>

<script>
export default {
    mounted() {
        console.log('LoginLayout mounted')
    },

    beforeUmnount() {
        console.log('LoginLayout unmounted')
    },
}
</script>

<style>
.auth_container {
    background-color: #ebedf2;
}
</style>
