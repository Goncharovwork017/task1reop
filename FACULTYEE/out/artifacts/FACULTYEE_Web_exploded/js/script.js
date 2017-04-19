$(function () {
    $("#js-register-form").validate({
        rules: {
            name: {
                required: true
            },
            surname: {
                required: true,
            },
            login: {
                required: true,
            },
            password: {
                required: true,
                minlength: 4
            },
            password2: {
                required: true,
                minlength: 4,
                equalTo: "#pass1"
            }
        },
        messages: {
            name: {
                required: "Поле Имя нужно заполнить."
            },
            surname: {
                required: "Поле Фамилия нужно заполнить.",
            },
            login: {
                required: "Поле Логин нужно заполнить."
            },
            password: {
                required: "Поле Пароль нужно заполнить."
            },
            password2: {
                required: "Повторите введенный пароль."
            }
        },
        focusCleanup: true,
        focusInvalid: false,
        invalidHandler: function (event, validator) {
            $(".js-form-message").text("Исправьте пожалуйста ошибки.");
        },
        onkeyup: function (element) {
            $(".js-form-message").text("");
        },
    });
});

$(function () {
    $("#js-add-form").validate({
        rules: {
            name: {
                required: true
            },
            id_teacher: {
                required: true,
            },
            description: {
                required: true,
            },
          //  status: {
            //    required: true,
          //  }

        },
        messages: {
            name: {
                required: "Поле Имя нужно заполнить."
            },
            id_teacher: {
                required: "Поле Учитель нужно заполнить.",
            },
            description: {
                required: "Поле описание нужно заполнить."
            },
            status: {
                required: "Поле статус нужно заполнить."
            },

        },
        focusCleanup: true,
        focusInvalid: false,
        invalidHandler: function (event, validator) {
            $(".js-form-message").text("Исправьте пожалуйста ошибки.");
        },
        onkeyup: function (element) {
            $(".js-form-message").text("");
        },
    });
});









$(function () {
$("#js-entrance-form").validate({
    rules: {
        login: {
            required: true,
        },
        password: {
            required: true,
            minlength: 4
        }
    },
    messages: {
        login: {
            required: "Поле Логин нужно заполнить."
        },
        password: {
            required: "Поле Пароль нужно заполнить."
        }
    },
    focusCleanup: true,
    focusInvalid: false,
    invalidHandler: function (event, validator) {
        $(".js-form-message").text("Исправьте пожалуйста ошибки.");
    },
    onkeyup: function (element) {
        $(".js-form-message").text("");
    },
});
});
