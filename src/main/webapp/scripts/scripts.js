$('document').ready(function () {
    $.get('/hubs', (response) => {
        $('#hub').html(response)
    })

    $('#hub_btn').on('click', () => {
        clearInterval(intervalId);
        getData();
        startPolling();
    });

    let intervalId;

    const getData = () => {
        let selectedHubId = $('#hub').val();
        if (selectedHubId) {
            $.get('/device?id=' + selectedHubId, (response) => {
                $('#data').html(response);
            });
        }
    }

    const startPolling = () => {
        intervalId = setInterval(getData, 10000);
    }
});