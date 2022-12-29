<template>
    <div>
        <div class="table_container">
            <hot-table
                ref="hotTableComponent"
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
import { defineComponent } from '@vue/runtime-core'
import HandsonService from '@/services/handson.service'

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

export default defineComponent({
    components: { HotTable },

    data() {
        return {
            windowWidth: window.innerWidth - 300,

            tableData: [
                [1, 2022, 12, '', 22, 22, 20, 18, 18],
                [1, 2022, 12, '', 22, 22, 20, 18, 18],
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
                    { data: 'id' },
                    { data: 'year' },
                    { data: 'month' },
                    { requiredValidator, data: 'Наименование' },
                    { numbersValidator, data: 'Fe %' },
                    { numbersValidator, data: 'Si %' },
                    { numbersValidator, data: 'Al %' },
                    { numbersValidator, data: 'Ca %' },
                    { numbersValidator, data: 'S %' },
                ],

                hiddenColumns: {
                    columns: [0, 1, 2],
                },
            },
        }
    },

    methods: {
        addRow() {
            const count = 1
            for (let i = 0; i < count; i++) {
                console.log('add')
                this.tableData.push([null, null, null, '', 5, 4, 3, 2, 1])
            }

            console.log(
                'ht-getData',
                this.$refs.hotTableComponent.hotInstance.getData()
            )
            console.log(
                'ht-getSourceData',
                this.$refs.hotTableComponent.hotInstance.getSourceData()
            )

            // this.$refs.hotTableComponent.hotInstance.loadData(this.tableData)
            // this.$refs.hotTableComponent.hotInstance.updateData(this.tableData)
            // this.$refs.hotTableComponent.hotInstance.render()
            // console.log(this.$refs.hotTableComponent.hotInstance)
            // console.log(this.$refs.hotTableComponent.hotInstance.getData())
            // console.log(
            //     this.$refs.hotTableComponent.hotInstance.getSourceData()
            // )
        },

        postData() {
            const orders = HandsonService.mapTableToOrders(this.tableData)

            RestService.postOrders(orders).then((result) => {
                this.tableData = HandsonService.mapOrdersToTable(result.data)

                // this.$refs.hotTableComponent.hotInstance.loadData(
                //     this.tableData
                // )
                // this.$refs.hotTableComponent.hotInstance.updateData(
                //     this.tableData
                // )
                // this.$refs.hotTableComponent.hotInstance.render()
                // console.log(this.$refs.hotTableComponent.hotInstance)
                // console.log(this.$refs.hotTableComponent.hotInstance.getData())
                // console.log(
                //     this.$refs.hotTableComponent.hotInstance.getSourceData()
                // )
            })
        },

        getData(month, year) {
            RestService.getOrders(month, year).then((result) => {
                console.log('getData', result)
                if (result.data && result.data.length != 0) {
                    // this.tableData = result.data
                    // console.log('rewriteTableData', this.tableData)
                    // console.log('rewriteTableData', this.tableData.get)
                    // const mapped = HandsonService.mapOrdersToTable(result.data)
                    // console.log('mapped', mapped)
                    // this.tableData.splice(0, this.tableData.length)
                    // this.tableData.push(mapped)
                    // this.$refs.hotTableComponent.hotInstance.loadData(
                    //     this.tableData
                    // )
                }
            })
        },
    },

    watch: {
        tableData(newVal) {
            console.log('newVal', newVal)
            this.$refs.hotTableComponent.hotInstance.loadData(newVal)
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
        const currentDate = new Date(Date.now())
        const month = currentDate.getMonth() + 1
        const year = currentDate.getFullYear()

        console.log(month, year)

        this.getData(month, year)

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
})
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
