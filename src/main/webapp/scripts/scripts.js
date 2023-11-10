$('document').ready(function () {
    $.get('/hubs', function (response) {
        $('#hub').html(response)
    })

    $('#hub_button').on('click', function (response) {
       $('#data').html(response);
    });
});