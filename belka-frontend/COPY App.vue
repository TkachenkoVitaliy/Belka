<template>
    <!-- <app-login /> -->
    <data-table />
</template>

<script>
// import AppLogin from './views/AppLogin.vue'
import DataTable from './components/DataTable.vue'

export default {
    components: { DataTable },
}
</script>

<style>
body,
html {
    height: 100%;
    margin: 0px;
    font-family: Roboto, Helvetica Neue, Helvetica, Arial, PT Sans, sans-serif;
    font-size: 14px;
}
.alert {
    color: red;
}

.black_svg {
    fill: #141416;
}
</style>
