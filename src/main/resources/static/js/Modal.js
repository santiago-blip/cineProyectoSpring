var btnAddPelicula = document.getElementById("addPelicula");
if (btnAddPelicula !== null) {
    btnAddPelicula.addEventListener("click", () => {
        let modalAdd = document.getElementById("modalAdd");
        let contenedorModalAdd = document.getElementById("container-modal");
        modalAdd.classList.toggle("modalAddVisible");
        contenedorModalAdd.classList.toggle("contenedorModalAddVisible");
    });
}
//MODAL SESION

var btnModalSesion = document.getElementById("modalIdSesion");
if(btnModalSesion !== null){
btnModalSesion.addEventListener("click", () => {
    let modalAdd = document.getElementById("modalSesion");
    let contenedorModalAdd = document.getElementById("containerModalSesion");
    let modalregistro = document.getElementById("modalRegistro");
    modalAdd.classList.toggle("modalSesionVisible");
    contenedorModalAdd.classList.toggle("containerModalSesionVisible");
});
}
var linkRegistro = document.querySelector("#linkRegistro");
linkRegistro.addEventListener("click", () => {
    let modalAdd = document.getElementById("modalSesion");
    let modalregistro = document.getElementById("modalRegistro");
//    modalAdd.style.display="none";
    modalAdd.classList.toggle("modalSesionVisible");
    modalregistro.classList.toggle("modalRegistroVisible");
});
var linkIniciar = document.querySelector("#linkIniciar");
linkIniciar.addEventListener("click", () => {
    let modalAdd = document.getElementById("modalSesion");
    let modalregistro = document.getElementById("modalRegistro");
//    modalAdd.style.display="none";
    modalAdd.classList.toggle("modalSesionVisible");
    modalregistro.classList.toggle("modalRegistroVisible");
});
//MODAL SESION

//CERRAR MODAL
window.addEventListener("click", function (e) {
    let modalAdd = document.getElementById("modalAdd");
    let contenedorModalAdd = document.getElementById("container-modal");
    //MODALSESION
    let modalSesion = document.getElementById("modalSesion");
    let modalregistro = document.getElementById("modalRegistro");
    let contenedorModalSesion = document.getElementById("containerModalSesion");
    //NOTIFICACION
    let containerNotificacion = document.querySelector("#container-notificacion");
    
    console.log(e.target);
    if (e.target === contenedorModalAdd) {
        modalAdd.classList.toggle("modalAddVisible");
        this.setTimeout(function () {
            contenedorModalAdd.classList.toggle("contenedorModalAddVisible");
        }, 500);
    }
    if (e.target === contenedorModalSesion) {
        if (modalregistro.classList.contains('modalRegistroVisible')) {
            modalregistro.classList.toggle("modalRegistroVisible");
        }
        if (modalSesion.classList.contains("modalSesionVisible")) {
            modalSesion.classList.toggle("modalSesionVisible");
        }
        this.setTimeout(function () {
            contenedorModalSesion.classList.toggle("containerModalSesionVisible");
        }, 500);
    }
    if(e.target === containerNotificacion){
        containerNotificacion.classList.toggle("container-notificacionVisible");
    }
});

//CERRAR NOTIFICACION
var cerrarNot = document.querySelector("#cerrarbtn");
cerrarNot.addEventListener("click", function () {
    let container = document.querySelector("#container-notificacion");
    container.classList.toggle("container-notificacionVisible");
});
