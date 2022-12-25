<template>
    <component :is="route.meta.layoutComponent">
        <slot />
    </component>
</template>

<script>
import { useRoute } from 'vue-router'
// eslint-disable-next-line no-unused-vars

export default {
    data() {
        return {
            route: useRoute(),
        }
    },
}
</script>

<style></style>
