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
                $('#data').empty();
                response.map((item) => {
                    $('#data').append(
                        "<div class=\"card__item\">\n" +
                        "                <span class=\"card__title\">" + item.name + "</span>\n" +
                        "                <hr>\n" +
                        "                <span class=\"card__props\">\n" +
                        "                    <span class=\"card__props__key\">Результат:</span>\n" +
                        "                    <span class=\"card__props__value\">" + item.result + "</span>\n" +
                        "                </span>\n" +
                        "                <span class=\"card__props\">\n" +
                        "                    <span class=\"card__props__key\">Тип датчика:</span>\n" +
                        "                    <span class=\"card__props__value\">" + item.typeName + "</span>\n" +
                        "                </span>\n" +
                        "                <span class=\"card__props\">\n" +
                        "                    <span class=\"card__props__key\">Обновлено:</span>\n" +
                        "                    <span class=\"card__props__value\">"+ item.dateOfEdit +"</span>\n" +
                        "                </span>\n" +
                        "                <span class=\"card__props\">\n" +
                        "                    <span class=\"card__props__key\">Введён в эксплуатацию:</span>\n" +
                        "                    <span class=\"card__props__value\">"+item.dateOfEntry+"</span>\n" +
                        "                </span>\n" +
                        "                <small>\n" +
                        "                    <span class=\"card__props\">\n" +
                        "                    <span class=\"card__props__key\">О датчике:</span>\n" +
                        "                    <span class=\"card__props__value\">"+item.typeDescription+"</span>\n" +
                        "                </span>\n" +
                        "                </small>\n" +
                        "            </div>"
                    );
                })
            });
        }
    }

    const startPolling = () => {
        intervalId = setInterval(getData, 10000);
    }
});