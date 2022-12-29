<template>
    <div>
        <div class="table_container">
            <hot-table
                ref="hotTableComponent"
                v-model:data="dataset"
                :settings="settings"
                licenseKey="non-commercial-and-evaluation"
            ></hot-table>
        </div>
    </div>
</template>

<script>
import { HotTable } from '@handsontable/vue3'
import { registerAllModules } from 'handsontable/registry'
import 'handsontable/dist/handsontable.full.css'
import RestService from '@/services/rest.service'
import EventBus from '@/services/EventBus'

registerAllModules()

export default {
    components: { HotTable },

    data() {
        return {
            dataset: [
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
                colWidths: [0, 0, 0, 350, 230, 230, 230, 230, 230],
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

                hiddenColumns: {
                    columns: [0, 1, 2],
                },
            },
        }
    },

    methods: {
        addRows(count) {
            if (count > 0) {
                for (let i = 0; i < count; i++) {
                    this.dataset.push({
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
                }
            }

            if (count < 0) {
                const maxRowsToRemove =
                    this.dataset.length > count ? count : this.dataset.length
                for (let i = 0; i < maxRowsToRemove; i++) {
                    this.dataset.pop()
                }
            }
        },

        getData(month = 12, year = 2022) {
            RestService.getOrders(month, year).then((response) => {
                if (response.data && response.data.length != 0) {
                    response.data.forEach((e) => this.dataset.push(e))
                }
            })
        },
    },

    created() {
        this.getData()
    },

    mounted() {
        EventBus.on('addRows', this.addRows)
    },
}
</script>

<style></style>
