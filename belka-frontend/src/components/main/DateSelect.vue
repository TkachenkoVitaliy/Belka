<template>
    <div>
        <select class="date_select">
            <option v-for="month in months" :key="month.value">
                {{ month.text }}
            </option>
        </select>

        <select class="date_select">
            <option v-for="year in years" :key="year">
                {{ year }}
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

    beforeMount() {
        const date = new Date(Date.now())

        this.currentDate = date
        this.currentYear = date.getFullYear()
        this.currentMonth = date.getMonth()

        for (let i = 2020; i <= date.getFullYear(); i++) {
            this.years.push(i)
        }
    },
}
</script>

<style>
.date_select {
    margin: 0px 10px;
}
</style>
