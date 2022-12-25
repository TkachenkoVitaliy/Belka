<template>
    <div class="navbar">
        <ul class="navbar_list">
            <nav-bar-item
                v-for="navBarItem in navBarItems"
                :key="navBarItem.id"
                :item="navBarItem"
            ></nav-bar-item>
        </ul>
    </div>
</template>

<script>
import NavBarItem from '@/components/main/NavBarItem.vue'

export default {
    components: { NavBarItem },

    data() {
        return {
            navBarItems: [
                {
                    id: 0,
                    title: 'Belka Digital',
                    link: '/',
                    isActive: false,
                    height: '50px',
                    svgId: 'logo',
                },
                {
                    id: 1,
                    title: 'Внесение данных',
                    link: '/data',
                    isActive: false,
                    height: '30px',
                },
                {
                    id: 2,
                    title: 'Отчет',
                    link: '/reports',
                    isActive: false,
                    height: '30px',
                },
                {
                    id: 3,
                    title: 'Выйти',
                    link: '/auth',
                    isActive: false,
                    height: '30px',
                },
            ],
        }
    },

    methods: {
        changeActiveTab(id) {
            console.log(id)
            this.navBarItems.forEach((item) => {
                item.isActive = item.id === id
            })
        },
    },
}
</script>

<style>
.navbar {
    padding: 0px;
    min-width: 200px;
    max-width: 200px;
    display: flex;
    flex-direction: column;
}

.navbar_list {
    margin: 0px;
    padding: 0px;
}
</style>
