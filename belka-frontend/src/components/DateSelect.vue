<template>
    <div>
        <select>
            <option v-bind:key="month.value" v-for="month in months">
                {{ month.text }}
            </option>
        </select>
    </div>
</template>

<script>
export default {
    name: 'DateSelect',

    data() {
        return {
            currentDate: null,
            currentYear: null,
            currentMonth: null,

            years: [],
            months: [
                { value: 1, text: 'Январь' },
                { value: 2, text: 'Февраль' },
                { value: 3, text: 'Март' },
                { value: 4, text: 'Апрель' },
                { value: 5, text: 'Май' },
                { value: 6, text: 'Июнь' },
                { value: 7, text: 'Июль' },
                { value: 8, text: 'Август' },
                { value: 9, text: 'Сентябрь' },
                { value: 10, text: 'Октябрь' },
                { value: 11, text: 'Ноябрь' },
                { value: 12, text: 'Декабрь' },
            ],
        }
    },

    mounted() {
        const date = new Date(Date.now())

        this.currentDate = date
        this.currentYear = date.getMonth()
        this.currentMonth = date.getFullYear()
    },
}
</script>

<style></style>
