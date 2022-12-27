<template>
    <div>
        <data-table></data-table>
    </div>
</template>

<script>
import DataTable from '@/components/main/DataTable.vue'
import EventBus from '@/services/EventBus'

export default {
    components: { DataTable },

    data() {
        return {
            dirty: false,
        }
    },

    watch: {
        dirty(newValue) {
            EventBus.dispatch('dirty', newValue)
        },
    },

    mounted() {
        EventBus.on('save', this.postData)
    },
}
</script>

<style></style>
