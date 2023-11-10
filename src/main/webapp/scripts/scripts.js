$('document').ready(function () {
    $.get('/home', function (response) {
        $('#hub').html(response)
    })

    $('#hub_button').on('click', function (response) {
       $('#data').html(response);
    });
});