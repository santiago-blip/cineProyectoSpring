///*Eliminar pelicula*/
//$(function () {
//  var token = $("meta[name='_csrf']").attr("content");
//  var header = $("meta[name='_csrf_header']").attr("content");
//  $(document).ajaxSend(function(e, xhr, options) {
//    xhr.setRequestHeader(header, token);
//  });
//});

$(document).ready(function () {
    $(".btndelete").click(function () {
        var idMovie = $(this).parent().find(".idMovie").val();
        swal({
            title: "¿Seguro que quiere eliminar el producto?",
            text: "Se eliminará el producto del carrito de compras",
            icon: "warning",
            buttons: true,
            dangerMode: true,
        }).then((willDelete) => {
            if (willDelete) {
                eliminar(idMovie);
            } else {
                swal("No se ha eliminado ningun producto");
            }
        });
    });

    function eliminar(id) {
        var url = "ControllerCarrito?accion=EliminarCarrito";
        $.ajax({
            type: 'GET',
            url: "/eliminar/"+id,
//            data: "idC=" + id,
            success: function (data, textStatus, jqXHR) {
                swal("El producto ha sido eliminado", {
                    icon: "success",
                }).then(()=>{
//                    parent.location.href = "ControllerCarrito?accion=MostrarCarro";
                });
                
            }
        });
    }
});



/*Eliminar pelicula*/


