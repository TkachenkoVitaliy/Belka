<template>
    <div>
        <form>
            <button class="controll_btn add" @click.prevent="dispatchAddRows">
                Добавить строки
            </button>
            <input
                type="number"
                min="1"
                max="100"
                class="number_input"
                v-model.number="count"
            />
            <button
                class="controll_btn remove"
                @click.prevent="dispatchRemoveRows"
            >
                Удалить строки
            </button>
        </form>
    </div>
</template>

<script>
import EventBus from '@/services/EventBus'
export default {
    data() {
        return {
            count: 1,
        }
    },

    watch: {
        countNewRows(newValue) {
            if (newValue > 100) this.count = 100
            if (newValue <= 0) this.count = 1
        },
    },

    methods: {
        dispatchAddRows() {
            if (this.count > 0 && this.count < 100) {
                EventBus.dispatch('addRows', this.count)
            }
        },
        dispatchRemoveRows() {
            console.log('!!!', -this.count)
            if (this.count > 0 && this.count < 100) {
                EventBus.dispatch('addRows', -this.count)
            }
        },
    },
}
</script>

<style>
.controll_btn {
    cursor: pointer;

    border: 1px solid;
    margin: 0px 5px;
    height: 20px;
}

.add {
    background-color: rgb(162, 233, 197);
}

.remove {
    background-color: rgb(236, 178, 178);
}

.number_input {
    padding-left: 6px;
    width: 44px;
}
</style>
