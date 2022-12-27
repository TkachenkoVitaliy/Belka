<template>
    <div class="actionbar">
        <date-select class="action"></date-select>
        <hr class="delimiter" />
        <rows-button class="action"></rows-button>
    </div>
</template>

<script>
import DateSelect from '@/components/main/DateSelect.vue'
import RowsButton from '@/components/main/RowsButton.vue'

export default {
    components: { DateSelect, RowsButton },
}
</script>

<style>
.actionbar {
    box-sizing: border-box;
    display: flex;
}

.action {
    margin: 15px 25px;
}

.delimiter {
    height: 48px;
    margin: 0px;
}
</style>
