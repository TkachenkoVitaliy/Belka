<template>
    <app-layout>
        <router-view />
    </app-layout>
</template>

<script>
import AppLayout from './layouts/AppLayout.vue'
export default {
    components: { AppLayout },
}
</script>

<style>
body,
html {
    height: 100%;
    margin: 0px;
    font-family: Roboto, Helvetica Neue, Helvetica, Arial, PT Sans, sans-serif;
    font-size: 14px;
    overflow-x: hidden;
}
.alert {
    color: red;
}

.black_svg {
    fill: #141416;
}
</style>
