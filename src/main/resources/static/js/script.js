$(document).ready(function () {
    var page = 0;
    var pageSize = 10;

    function loadMoreData() {
        $.ajax({
            url: "/cars?page=" + page,
            type: "GET",
            data: {
                pageSize: pageSize
            },
            success: function (data) {
                var table = $('#example').DataTable();
                table.rows.add(data).draw();

                page++;
                updatePaginationButtons(page);
            },
            error: function (xhr, status, error) {
                console.error(error);
            }
        });
    }

    function updatePaginationButtons(currentPage) {
        if (currentPage === 0) {
            $('#prevPageBtn').prop('disabled', true);
        } else {
            $('#prevPageBtn').prop('disabled', false);
        }

        if (currentPage === totalPages - 1) {
            $('#nextPageBtn').prop('disabled', true);
        } else {
            $('#nextPageBtn').prop('disabled', false);
        }

        $('#currentPage').text(currentPage + 1);
    }

    $('#prevPageBtn').click(function () {
        if (page > 0) {
            page--;
            loadMoreData();
        }
    });

    $('#nextPageBtn').click(function () {
        page++;
        loadMoreData();
    });

    loadMoreData();
});


