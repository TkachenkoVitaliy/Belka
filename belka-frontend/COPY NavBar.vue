<template>
    <div class="navbar">
        <div class="navbar_header">
            <svg class="min_svg">
                <use xlink:href="@/assets/img/belka.svg#logo"></use>
            </svg>
            <span>Belka Digital</span>
        </div>

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
                    link: '/home',
                    isActive: false,
                    height: '30px',
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
                    link: '/report',
                    isActive: true,
                    height: '30px',
                },
                {
                    id: 3,
                    title: 'Выйти',
                    link: '/auth/logout',
                    isActive: false,
                    height: '30px',
                },
            ],
        }
    },
}
</script>

<style>
.navbar {
    padding: 0px;
    min-width: 10%;
    display: flex;
    flex-direction: column;
}

.navbar_header {
    padding: 20px 0px;
    text-align: center;
    height: auto;
    background-color: #141416;
    color: #fff;
}

.navbar_header span {
    padding-left: 15px;
    vertical-align: center;
}

.min_svg {
    vertical-align: middle;
    fill: #fff;
    height: 30px;
    width: 30px;
}

.navbar_list {
    margin: 0px;
    padding: 0px;
}
</style>
