$(document).ready(function() {
    // Инициализация DataTables
    var table = $('#example').DataTable();

    // Обработчик события ввода в поле поиска
    $('#licensePlateSearch').on('input', function() {
        var searchValue = $(this).val().trim();

        // Фильтрация таблицы по значению введенной строки
        table.column(1).search(searchValue).draw();
    });
});