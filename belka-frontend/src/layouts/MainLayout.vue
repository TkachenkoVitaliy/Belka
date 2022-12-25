<template>
    <div class="page_container">
        <nav-bar class="navbar_container"></nav-bar>
        <div class="main_app_container">
            <slot />
        </div>
    </div>
</template>
<script>
import NavBar from '@/components/main/NavBar.vue'
export default {
    components: { NavBar },
    mounted() {
        console.log('MainLayout mounted')
    },

    beforeUmnount() {
        console.log('MainLayout unmounted')
    },
}
</script>

<style>
.page_container {
    display: flex;
}

.navbar_container {
    height: 100vh;
    position: sticky;
    position: -webkit-sticky;
    top: 0;
    background-color: #f5f6f9;
}

.main_app_container {
    padding: 20px 50px;
    display: flex;
    flex-direction: column;
}
</style>
