<template>
    <div>
        <form>
            <button class="controll_btn add">Добавить строки</button>
            <input
                type="number"
                min="1"
                max="100"
                class="number_input"
                v-model="countNewRows"
            />
            <button class="controll_btn remove">Удалить строки</button>
        </form>
    </div>
</template>

<script>
export default {
    data() {
        return {
            countNewRows: 1,
        }
    },

    watch: {
        countNewRows(newValue) {
            if (newValue > 100) this.countNewRows = 100
            if (newValue <= 0) this.countNewRows = 1
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
