window.addEventListener('load', () => {
    title.textContent = "Bienvenide"
    accion.textContent = ""
    contenido.innerHTML = "Selecciona una opcion del menu para iniciar"
})

let opcionSeleccionada = {titulo:'',accion:'', contenido:''}
function renderizarOpcion(opcion) {
    title.textContent = opcion.titulo
    accion.textContent = opcion.accion.textContent
    contenido.innerHTML = opcion.contenido
}

for (let item of menu) {
    item.accion.addEventListener('click', ()=>{
        renderizarOpcion(item)
    })
}