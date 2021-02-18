/*SLIDER */
var Bnext = document.querySelector("#bnext");
var Bprev = document.getElementById("bprev");

var items = document.querySelectorAll(".container-slide .items");
var index = 0;
const total = items.length;

mostrarItem(index);

Bprev.addEventListener("click", function(e) {
    if (index > 0) {
        index--;
        ocultarItem();
        mostrarItem(index);
    }
});
Bnext.addEventListener("click", function(e) {
    if (index < total - 1) {
        index++;
        ocultarItem();
        mostrarItem(index);
    }
});

function mostrarItem(index) {

    items[index].classList.add("item-active");

}

function ocultarItem() {
    items.forEach(item => {
        item.classList.remove("item-active");
    });
}
/*SLIDER */

//window.addEventListener("mousemove",e=>{
//	const x = e.pageX; 
//	const y = e.pageY; 
//        console.log("eje x",x);
//});



