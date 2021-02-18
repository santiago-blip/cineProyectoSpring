$(document).ready(function () {
    $(".deleteGaleria").click(function () {
        var idPelicula = $(this).parent().find(".valorIdP").val();
        swal({
            title: "¿Seguro que quiere eliminar la película?",
            text: "Se eliminará la película de \" ver más tarde\"",
            icon: "warning",
            buttons: true,
            dangerMode: true,
        }).then((willDelete) => {
            if (willDelete) {
                eliminar(idPelicula);
                swal("Se ha eliminado la película con exito");
            } else {
                swal("No se ha eliminado ningun producto");
            }
        });
    });
    function eliminar(id) {
        var url = "/eliminarVer";
        $.ajax({
            type: 'GET',
            url: url,
            data: "idPelicula=" + id,
            success: function (data, textStatus, jqXHR) {
//                parent.location.href = "url";
            }
        });
    }
});


