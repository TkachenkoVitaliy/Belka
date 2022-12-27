<template>
    <div class="input_wrapper">
        <label v-if="label">{{ label }}</label>
        <input
            :type="type"
            class="input"
            v-model="value"
            @blur="onBlur"
            @input="onChangeInput"
        />
        <div class="alert_container alert" v-if="validator && invalidMessage">
            {{ invalidValue ? 'Введите коррректный логин' : '' }}
        </div>
    </div>
</template>

<script>
export default {
    props: {
        modelValue: String,
        type: String,
        label: String,
        validator: Function,
        invalidMessage: String,
    },

    emits: ['update:modelValue'],

    data() {
        return {
            dirty: false,
        }
    },

    computed: {
        value: {
            get() {
                console.log('computedGet')
                return this.modelValue
            },
            set(value) {
                console.log('computedSet')
                this.$emit('update:modelValue', value)
            },
        },

        invalidValue() {
            if (this.validator) {
                return this.dirty && !this.validator(this.value)
            }
            return false
        },
    },

    methods: {
        onBlur() {
            this.dirty = true
        },
    },
}
</script>

<style>
.input_wrapper {
    margin-top: 10px;
    margin-bottom: 10px;
    display: flex;
    flex-direction: column;
}

.input {
    padding: 10px 15px;
    border-radius: 5px;
    border-color: #e3e7ee;
    border-width: 2px;
    background-color: #f7f8f8;
    margin-top: 10px;
}

.alert_container {
    height: 16px;
}
</style>
