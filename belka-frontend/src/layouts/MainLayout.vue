<template>
    <div class="page_container">
        <nav-bar class="navbar_container"></nav-bar>
        <div class="main_app_container">
            <action-bar
                v-if="$route.meta.actions"
                class="actionbar_container"
            ></action-bar>
            <div class="content_container">
                <slot />
            </div>
        </div>
    </div>
</template>
<script>
import NavBar from '@/components/main/NavBar.vue'
import ActionBar from '@/components/main/ActionBar.vue'
import EventBus from '@/services/EventBus'

export default {
    components: { NavBar, ActionBar },

    data() {
        return {
            settings: null,
        }
    },

    methods: {
        test(val) {
            console.log(val)
        },
    },

    mounted() {
        EventBus.on('dirty', this.test)
    },

    beforeUmnount() {
        EventBus.remove('dirty', this.test)
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
    display: flex;
    flex-direction: column;
}

.actionbar_container {
    position: sticky;
    top: 0;
    height: 50px;
    background-color: #f5f6f9;
    min-width: calc(100vw - 200px);
}

.content_container {
    padding: 20px 50px;
}
</style>
