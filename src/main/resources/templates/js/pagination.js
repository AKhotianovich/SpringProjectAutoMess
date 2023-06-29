$(document).ready(function () {
    var page = 0;
    var pageSize = 10;

    function loadCars() {
        $.ajax({
            url: "/cars",
            type: "GET",
            data: {
                page: page,
                pageSize: pageSize
            },
            success: function (data) {
                // Очистить текущие записи в таблице
                $("#carTableBody").empty();

                // Добавить новые записи в таблицу
                for (var i = 0; i < data.length; i++) {
                    var personCar = data[i];
                    var row = "<tr>" +
                        "<td>" + personCar.carModel + "</td>" +
                        "<td>" + personCar.licensePlate + "</td>" +
                        "<td>" + personCar.personId.firstName + "</td>" +
                        "<td>" + personCar.personId.phone_number + "</td>" +
                        "<td>" + personCar.makeId.mark + "</td>" +
                        "</tr>";
                    $("#carTableBody").append(row);
                }

                // Если достигнут конец записей, скрыть кнопку "Показать еще"
                if (data.length < pageSize) {
                    $("#showMoreButton").hide();
                }
            }
        });
    }

    $("#showMoreButton").click(function () {
        page++;
        loadCars();
    });

    // Загрузите первоначальные данные
    loadCars();
});