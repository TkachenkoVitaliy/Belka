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

registerAllModules()

function validator(value, callback) {
    if ((value > 0 && value < 100) || value === '' || value == null) {
        callback(true)
    } else {
        callback(false)
    }
}

export default {
    components: { HotTable },

    data() {
        return {
            windowWidth: window.innerWidth * -300,

            tableData: [['', null, null, null, null, null]],

            settings: {
                width: '100%',
                colWidths: [400, 100, 250, 250, 250, 250],
                maxCols: 6,
                colHeaders: [
                    'Наименование',
                    'Fe %',
                    'Si %',
                    'Al %',
                    'Ca %',
                    'S %',
                ],

                columns: [
                    { type: 'text' },
                    { type: 'numeric', validator },
                    { type: 'numeric', validator },
                    { type: 'numeric', validator },
                    { type: 'numeric', validator },
                    { type: 'numeric', validator },
                ],
            },
        }
    },

    methods: {
        addRow() {
            this.tableData.push(['', null, null, null, null, null])
        },
    },

    mounted() {
        this.$nextTick(() => {
            this.settings.colWidths = [
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
