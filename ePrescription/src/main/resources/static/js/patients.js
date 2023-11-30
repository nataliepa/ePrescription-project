function loadPatientsBasedOnAmka() {
    $("#amka").on("input",  function () {
        const amka = $("#amka").val();
        if (amka === "") {
            location.href = '/allPatients';
        } else {
            let url = "/allPatients/" + amka;
            $('#js-content').load(url);
        }
    })
}

$( document ).ready(function() {

    loadPatientsBasedOnAmka();

});