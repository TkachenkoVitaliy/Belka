<template>
    <div class="main_container">
        <div class="header">
            <svg class="black_svg">
                <use xlink:href="@/assets/img/belka.svg#logo"></use>
            </svg>

            <h1>BELKA DIGITAL</h1>
        </div>

        <div
            class="login_container"
            :class="{ 'login_container--failed': failedLogin }"
        >
            <div class="login_title">Авторизуйтесь в системе</div>
            <form name="login_form">
                <auth-input
                    v-model="login"
                    type="text"
                    label="Имя пользователя"
                />
                <auth-input v-model="password" type="password" label="Пароль" />
                <div class="btn_container">
                    <button
                        class="login_btn"
                        @click="sendRequest"
                        :disabled="buttonDisabled"
                    >
                        Войти
                    </button>
                </div>
                <div class="alert_container alert">
                    {{
                        invalidUser
                            ? 'Нет пользователя с такими именем и паролем'
                            : ''
                    }}
                </div>
            </form>
        </div>
    </div>
</template>

<script>
import AuthInput from '@/components/auth/AuthInput.vue'

export default {
    components: { AuthInput },

    data() {
        return {
            login: null,
            password: null,
            invalidUser: false,
            failedLogin: false,
        }
    },

    computed: {
        buttonDisabled() {
            console.log(!!this.login && !!this.password)
            return !this.login || !this.password
        },
    },

    methods: {
        sendRequest() {
            if (!this.buttonDisabled) {
                console.log(this.login)
                console.log(this.password)
                // TODO add auth request
                this.invalidUser = true
                this.password = ''
                this.shake()
            }
        },

        onChangeLogin(validateLogin) {
            this.validateLogin = validateLogin
            this.invalidUser = false
        },

        onChangePassword(validatePassword) {
            this.validatePassword = validatePassword
            this.invalidUser = false
        },

        shake() {
            this.failedLogin = true

            setTimeout(() => {
                this.failedLogin = false
            }, 250)
        },
    },
}
</script>

<style scoped>
.main_container {
    box-sizing: border-box;
    min-height: 100vh;
    padding: 100px;
    display: flex;
    flex-direction: column;
    align-items: center;
}

.header {
    text-align: center;
    padding-bottom: 50px;
}

.login_container {
    box-sizing: border-box;
    min-height: 420px;
    width: 420px;
    padding: 50px;
    background-color: #fff;
    border-radius: 15px;
}

.login_title {
    font-size: 24px;
    text-align: center;
    margin: 20px auto 40px;
}

.login_input_wrapper {
    margin-top: 20px;
    display: flex;
    flex-direction: column;
}

.login_input {
    padding: 10px 15px;
    border-radius: 5px;
    border-color: #e3e7ee;
    border-width: 2px;
    background-color: #f7f8f8;
    margin-top: 10px;
}

.btn_container {
    margin: 20px 5px;
}

.login_btn {
    cursor: pointer;
    box-sizing: border-box;
    font-weight: 500;
    color: #fff;
    width: 100%;
    height: 40px;
    font-size: 18px;
    background-color: #0252cc;
    border-radius: 5px;
    border-width: 0px;
}

.login_btn:disabled {
    cursor: default;
    background-color: #79797a;
}

.alert_container {
    height: 16px;
}

.login_container--failed {
    animation: shake 0.2s;
}

@keyframes shake {
    0%,
    50%,
    100% {
        transform: rotate(0deg);
    }
    10%,
    30%,
    60%,
    80% {
        transform: rotate(-0.5deg);
    }
    20%,
    40%,
    70%,
    90% {
        transform: rotate(0.5deg);
    }
}
</style>
