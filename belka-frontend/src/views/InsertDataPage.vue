<template>
    <div>
        <date-select></date-select>
    </div>
    <div>
        <data-table></data-table>
    </div>
</template>

<script>
import DataTable from '@/components/DataTable.vue'
import DateSelect from '@/components/DateSelect.vue'
export default {
    components: { DataTable, DateSelect },
}
</script>

<style></style>
