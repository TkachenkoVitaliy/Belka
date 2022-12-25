<template>
    <router-link :to="item.link" custom v-slot="{ navigate, isActive }">
        <div
            @click="navigate(route)"
            role="link"
            :style="{ height: item.height }"
            :class="{
                selected: isActive && !item.svgId,
                nav_item: !item.svgId,
                nav_header: item.svgId,
            }"
        >
            <div v-if="item.svgId" class="navbar_header">
                <div class>
                    <svg class="min_svg">
                        <use
                            :xlink:href="
                                require('@/assets/img/belka.svg') +
                                `#${item.svgId}`
                            "
                        ></use>
                    </svg>
                    <span>Belka Digital</span>
                </div>
            </div>
            <p v-if="!item.svgId" class="nav_item_title">{{ item.title }}</p>
        </div>
    </router-link>
</template>

<script>
export default {
    props: {
        item: {
            id: Number,
            title: String,
            link: String,
            isActive: Boolean,
            height: String,
            svgId: String,
        },
    },

    data() {
        return {
            isMouseover: false,
        }
    },
}
</script>

<style>
.nav_item {
    cursor: pointer;
    margin: 3px 10px;
    padding: 0px 5px;
    vertical-align: center;
    display: flex;
    border-radius: 5px;
}

.nav_item:hover {
    background-color: #e6e9ef;
}

.selected {
    font-weight: 600;
    background-color: #e6e9ef;
}

.nav_item_title {
    margin: auto 5px;
}

.navbar_header {
    cursor: pointer;
    padding: 10px 0px;
    text-align: center;
    background-color: #141416;
    color: #fff;
}

.navbar_header span {
    padding: 0px 15px;
    vertical-align: center;
    font-weight: 600;
}

.min_svg {
    vertical-align: middle;
    fill: #fff;
    height: 30px;
    width: 30px;
}
</style>
