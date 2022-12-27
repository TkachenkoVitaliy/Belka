<template>
    <div>
        <div class="table_container">
            <hot-table
                v-model:data="tableData"
                :settings="settings"
                licenseKey="non-commercial-and-evaluation"
            ></hot-table>

            <div class="controls_container">
                <button @click="addRow" class="control_btn">
                    Добавить строку
                </button>
                <button class="control_btn">Удалить строку</button>
                <button class="control_btn">Сохранить</button>
            </div>
        </div>
    </div>
</template>

<script>
import { HotTable } from '@handsontable/vue3'
import { registerAllModules } from 'handsontable/registry'
import 'handsontable/dist/handsontable.full.css'
import RestService from '@/services/rest.service'

registerAllModules()

function numbersValidator(value, callback) {
    if ((value > 0 && value < 100) || value === '' || value == null) {
        callback(true)
    } else {
        callback(false)
    }
}

function requiredValidator(value, callback) {
    if (value && value.length > 0 && value !== '') {
        callback(true)
    } else {
        callback(false)
    }
}

export default {
    components: { HotTable },

    data() {
        return {
            windowWidth: window.innerWidth - 300,

            tableData: [
                {
                    id: null,
                    year: null,
                    month: null,
                    name: '',
                    ferrum: null,
                    silicium: null,
                    aluminium: null,
                    calcium: null,
                    sulfur: null,
                },
            ],

            settings: {
                width: '100%',
                colWidths: [0, 0, 0, 400, 100, 250, 250, 250, 250],
                maxCols: 9,
                colHeaders: [
                    'id',
                    'year',
                    'month',
                    'Наименование',
                    'Fe %',
                    'Si %',
                    'Al %',
                    'Ca %',
                    'S %',
                ],

                columns: [
                    { type: 'numeric' },
                    { type: 'numeric' },
                    { type: 'numeric' },
                    { type: 'text', requiredValidator },
                    { type: 'numeric', numbersValidator },
                    { type: 'numeric', numbersValidator },
                    { type: 'numeric', numbersValidator },
                    { type: 'numeric', numbersValidator },
                    { type: 'numeric', numbersValidator },
                ],

                hiddenColumns: {
                    columns: [0, 1, 2],
                },
            },
        }
    },

    methods: {
        addRow() {
            this.tableData.push({
                id: null,
                year: null,
                month: null,
                name: '',
                ferrum: null,
                silicium: null,
                aluminium: null,
                calcium: null,
                sulfur: null,
            })
        },
        postData() {
            RestService.postOrders(this.data).then((result) => {
                console.log('postData', result)
                this.tableData = result.data
            })
        },
        getData(month, year) {
            RestService.getOrders(month, year).then((result) => {
                console.log('getData', result)
                if (result.data && result.data.length != 0) {
                    // this.tableData = result.data
                    // console.log('rewriteTableData', this.tableData)
                    // console.log('rewriteTableData', this.tableData.get)
                    this.tableData.splice(0, this.tableData.length)
                    this.tableData.push(result.data)
                    console.log('rewrited', this.tableData)
                }
            })
        },
    },

    created() {
        const currentDate = new Date(Date.now())
        const month = currentDate.getMonth() + 1
        const year = currentDate.getFullYear()

        console.log(month, year)

        this.getData(month, year)
    },

    mounted() {
        this.$nextTick(() => {
            this.settings.colWidths = [
                0,
                0,
                0,
                this.windowWidth * 0.25,
                this.windowWidth * 0.15,
                this.windowWidth * 0.15,
                this.windowWidth * 0.15,
                this.windowWidth * 0.15,
                this.windowWidth * 0.15,
            ]
        })
    },
}
</script>

<style>
.table_container {
    margin: 20px 0px;
    align-items: center;
}

.controls_container {
    margin-top: 30px;
    display: flex;
    justify-content: space-between;
}

.control_btn {
    width: 120px;
}
</style>
